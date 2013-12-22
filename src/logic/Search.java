package logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Disp001Bean;
import beans.Mst001Bean;
import beans.Mst002Bean;
import beans.Mst003Bean;
import beans.SearchBean;
import beans.Wk001Bean;
import beans.Wk004Bean;
import dao.Mst001Dao;
import dao.Mst002Dao;
import dao.Mst003Dao;
import dao.Wk001Dao;
import dao.Wk004Dao;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * List<Disp001Bean> disp001List 
		 * 	  Disp001Bean
		 * 		wk001Bean
		 * 		List<Wk004Bean>
		 * 			Wk004Bean
		 */
		List<Disp001Bean> disp001List = new ArrayList<Disp001Bean>();
		Wk001Dao wk001Dao=new Wk001Dao();
		Wk004Dao wk004Dao=new Wk004Dao();
		Mst001Dao mst001Dao = new Mst001Dao();
		Mst002Dao mst002Dao = new Mst002Dao();
		Mst003Dao mst003Dao = new Mst003Dao();
		
		SearchBean searchBean = new SearchBean();
		Util util = new Util();
		try{
			// ============= 検索条件の設定 ================
			Wk001Bean wk001Bean = new Wk001Bean();
			util.setWk001BeanFromRequest(request, wk001Bean); // 主に三つの检索条件の設定。他には空にする。もし検索条件追加するとき用
			searchBean.setWk001Bean(wk001Bean);
			
			// -------- linkage ---------
    		// mst001全部
    		List<Mst001Bean> mst001List = mst001Dao.SelectAll();
    		searchBean.getLinkageBean().setMst001List(mst001List);
    		
    		// mst002を取得
    		int level1Id = wk001Bean.getLevel1Id();
    		if(level1Id>0){
    			List<Mst002Bean> mst002List = mst002Dao.Select(level1Id);
    			searchBean.getLinkageBean().setMst002List(mst002List);
    		}
    		
    		// mst003を取得
    		int level2Id = wk001Bean.getLevel2Id();
    		if(level2Id>0){
    			List<Mst003Bean> mst003List = mst003Dao.Select(level2Id);
    			searchBean.getLinkageBean().setMst003List(mst003List);
    		}
    		searchBean.getLinkageBean().setSelectedLevel1Id(wk001Bean.getLevel1Id());
    		searchBean.getLinkageBean().setSelectedLevel2Id(wk001Bean.getLevel2Id());
    		searchBean.getLinkageBean().setSelectedLevel3Id(wk001Bean.getLevel3Id());
    		request.setAttribute("searchBean", searchBean);
    		
    		// ============= 检索结果の設定================
			// wk001の全部データを取得し、データごとのmainIdによって，wk004Listを取得する
			List<Wk001Bean> wk001List = wk001Dao.SelectByCondition(wk001Bean);
			
			Iterator itr = wk001List.iterator();
			while (itr.hasNext()) {
				Wk001Bean wk001Bean2 = (Wk001Bean)itr.next();
				wk001Bean2.setDispMainId(util.convertDispMainId(wk001Bean2.getMainId()));
				wk001Bean2.setDispPlace(util.convertDispPlace(wk001Bean2.getPlace()));
				
				List<Wk004Bean> wk004List = wk004Dao.SelectByMainId(wk001Bean2.getMainId());
				
				Disp001Bean disp001Bean = new Disp001Bean();
				disp001Bean.setWk001Bean(wk001Bean2);
				disp001Bean.setWk004List(wk004List);
				disp001List.add(disp001Bean);
			}
	
    		request.setAttribute("disp001List", disp001List);
    	}catch(Exception e){
    		throw new ServletException(e);
    	}finally{
    		wk001Dao.closeConnection();
    		wk004Dao.closeConnection();
    	}
    	request.getRequestDispatcher("/search.jsp").forward(request,response);
	}

}
