package logic;

import java.io.IOException;
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

/**
 * Servlet implementation class PopMainIdSelect
 */
@WebServlet("/PopMainIdSelect")
public class PopMainIdSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PopMainIdSelect() {
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
		Util util = new Util();
		Wk001Dao wk001Dao = new Wk001Dao();
		try{
			List<Wk001Bean> wk001List = wk001Dao.SelectAll();
			Iterator itr = wk001List.iterator();
			while (itr.hasNext()) {
				Wk001Bean wk001Bean = (Wk001Bean)itr.next();
				wk001Bean.setDispMainId(util.convertDispId(wk001Bean.getMainId()));
				wk001Bean.setDispPlace(util.convertDispPlace(wk001Bean.getPlace()));
			}
    		request.setAttribute("wk001List", wk001List);
    	}catch(Exception e){
    		throw new ServletException(e);
    	}finally{
    		wk001Dao.closeConnection();
    	}
    	request.getRequestDispatcher("/popMainIdSelect.jsp").forward(request,response);
		
	}

}
