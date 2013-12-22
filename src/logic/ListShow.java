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
import beans.Wk001Bean;
import beans.Wk004Bean;
import dao.Wk001Dao;
import dao.Wk004Dao;

/**
 * Servlet implementation class List
 */
@WebServlet("/ListShow")
public class ListShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListShow() {
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
		
		Util util = new Util();
		try{
			// wk001の全部データを取得し、データごとのmainIdによって，wk004Listを取得する
			List<Wk001Bean> wk001List = wk001Dao.SelectAll();
			Iterator itr = wk001List.iterator();
			while (itr.hasNext()) {
				Wk001Bean wk001Bean = (Wk001Bean)itr.next();
				wk001Bean.setDispMainId(util.convertDispMainId(wk001Bean.getMainId()));
				wk001Bean.setDispPlace(util.convertDispPlace(wk001Bean.getPlace()));
				
				List<Wk004Bean> wk004List = wk004Dao.SelectByMainId(wk001Bean.getMainId());
				
				Disp001Bean disp001Bean = new Disp001Bean();
				disp001Bean.setWk001Bean(wk001Bean);
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
    	request.getRequestDispatcher("/listShow.jsp").forward(request,response);
	}
	
}
