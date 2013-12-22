package logic;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.DetailBean;
import beans.Mst001Bean;
import beans.Mst002Bean;
import beans.Mst003Bean;
import beans.Wk001Bean;
import beans.Wk004Bean;
import dao.Mst001Dao;
import dao.Mst002Dao;
import dao.Mst003Dao;
import dao.Wk001Dao;
import dao.Wk004Dao;

/**
 * Servlet implementation class ListPreModify
 */
@WebServlet("/ListPreModify")
public class ListPreModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListPreModify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Util util = new Util();
		DetailBean detailBean = new DetailBean();
		Mst001Dao mst001Dao = new Mst001Dao();
		Mst002Dao mst002Dao = new Mst002Dao();
		Mst003Dao mst003Dao = new Mst003Dao();
		Wk001Dao wk001Dao = new Wk001Dao();
		Wk004Dao wk004Dao = new Wk004Dao();
		
		// 错误处理
		String errMsg = "";

    	try{
    		int mainId = new Integer(request.getParameter("mainId")).intValue();
    		
    		// -------- optType ---------
    		detailBean.setOptType("modify");
    		
    		// -------- wk001 ---------
    		Wk001Bean wk001Bean = wk001Dao.Select(mainId);
    		wk001Bean.setDispMainId(util.convertDispId(mainId));
    		detailBean.setWk001Bean(wk001Bean);
    		
    		// 如果mainId不存在。如：从求人那边链接过来。跳到出错页面。
    		if(wk001Bean.getMainId() <= 0){ // 没找到数据，所以wk001Bean为空，mainId也应该为空。
    			errMsg = String.format("登録番号[%s]は存在していません！", util.convertDispId(mainId));
				request.setAttribute("errMsg", errMsg);
				request.getRequestDispatcher("/error.jsp").forward(request,response);
    			return;	// 跳出 try
    		}
    		
    		// -------- linkage ---------
    		// mst001全部
    		List<Mst001Bean> mst001List = mst001Dao.SelectAll();
    		detailBean.getLinkageBean().setMst001List(mst001List);
    		
    		// mst002を取得
    		int level1Id = wk001Bean.getLevel1Id();
    		if(level1Id>0){
    			List<Mst002Bean> mst002List = mst002Dao.Select(level1Id);
    			detailBean.getLinkageBean().setMst002List(mst002List);
    		}
    		
    		// mst003を取得
    		int level2Id = wk001Bean.getLevel2Id();
    		if(level2Id>0){
    			List<Mst003Bean> mst003List = mst003Dao.Select(level2Id);
    			detailBean.getLinkageBean().setMst003List(mst003List);
    		}
    		detailBean.getLinkageBean().setSelectedLevel1Id(wk001Bean.getLevel1Id());
    		detailBean.getLinkageBean().setSelectedLevel2Id(wk001Bean.getLevel2Id());
    		detailBean.getLinkageBean().setSelectedLevel3Id(wk001Bean.getLevel3Id());
    		
    		// -------- wk004 ---------
    		List<Wk004Bean> wk004List = wk004Dao.SelectByMainId(mainId);
    		detailBean.setWk004List(wk004List);
    		
    		// --------- file list------------ 
    		List<String> fileNameList = util.getDirFileNamesByMainId(mainId);
    		detailBean.setFileNameList(fileNameList);
    		
    		// -------- output ---------
    		request.setAttribute("detailBean", detailBean);
    	}catch(Exception e){
    		throw new ServletException(e);
    	}finally{
    		mst001Dao.closeConnection();
    		mst002Dao.closeConnection();
    		mst003Dao.closeConnection();
    		wk001Dao.closeConnection();
    		wk004Dao.closeConnection();
    	}
    	
    	request.getRequestDispatcher("/list_detail.jsp").forward(request,response);
	
	}

}
