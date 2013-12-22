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

import beans.Disp002Bean;
import beans.Wk005Bean;
import beans.Wk006Bean;
import dao.Wk005Dao;
import dao.Wk006Dao;

/**
 * Servlet implementation class List
 */
@WebServlet("/ListShowSecond")
public class ListShowSecond extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListShowSecond() {
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
		 * List<Disp002Bean> disp002List 
		 * 	  Disp002Bean
		 * 		wk005Bean
		 * 		List<Wk006Bean>
		 * 			Wk006Bean
		 */
		List<Disp002Bean> disp002List = new ArrayList<Disp002Bean>();
		Wk005Dao wk005Dao=new Wk005Dao();
		Wk006Dao wk006Dao=new Wk006Dao();
		
		Util util = new Util();
		try{
			// wk005の全部データを取得し、データごとのmainIdによって，wk006Listを取得する
			List<Wk005Bean> wk005List = wk005Dao.SelectAll();
			Iterator itr = wk005List.iterator();
			while (itr.hasNext()) {
				Wk005Bean wk005Bean = (Wk005Bean)itr.next();
				
				List<Wk006Bean> wk006List = wk006Dao.SelectByTradeId(wk005Bean.getTradeId());
				
				Disp002Bean disp002Bean = new Disp002Bean();
				disp002Bean.setWk005Bean(wk005Bean);
				disp002Bean.setWk006List(wk006List);
				disp002List.add(disp002Bean);
			}
	
    		request.setAttribute("disp002List", disp002List);
    	}catch(Exception e){
    		throw new ServletException(e);
    	}finally{
    		wk005Dao.closeConnection();
    		wk006Dao.closeConnection();
    	}
    	request.getRequestDispatcher("/listShowSecond.jsp").forward(request,response);
	}
	
}
