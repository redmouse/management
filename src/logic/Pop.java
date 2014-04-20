package logic;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Wk005Bean;
import beans.Wk006Bean;
import dao.Wk005Dao;
import dao.Wk006Dao;

/**
 * Servlet implementation class Pop
 */
@WebServlet("/Pop")
public class Pop extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pop() {
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
		Wk006Dao wk006Dao=new Wk006Dao();
    	try{
    		int infoId = new Integer(request.getParameter("popInfoId")).intValue();
    		String columnName = request.getParameter("popColumn");
    		Wk006Bean wk006Bean = wk006Dao.Select(infoId);
    		String popTitle = "";
    		String content = "";
    		if(columnName.equals("recruitmentFrom")){
    			content = wk006Bean.getRecruitmentFrom();
    			popTitle = "求人事業者からの求人票";
    		}
    		else if(columnName.equals("recruitmentOwn")){
    			content = wk006Bean.getRecruitmentOwn();
    			popTitle = "自社の求人票";
    		}
    		request.setAttribute("dispContent", content);
    		request.setAttribute("popTitle", popTitle);
    	}catch(Exception e){
    		throw new ServletException(e);
    	}finally{
    		wk006Dao.closeConnection();
    	}
    	request.getRequestDispatcher("/popShow.jsp").forward(request,response);
	}

}
