package logic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Disp002Bean;

/**
 * Servlet implementation class ListSecondPreAdd
 */
@WebServlet("/ListSecondPreAdd")
public class ListSecondPreAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListSecondPreAdd() {
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
		try {
			Disp002Bean disp002Bean = new Disp002Bean();
			request.setAttribute("disp002Bean", disp002Bean);
			
		} catch (Exception e) {
			throw new ServletException(e);
		} finally {
			
		}
		request.getRequestDispatcher("/listSecond_detail.jsp").forward(request,
				response);
	}
	

}
