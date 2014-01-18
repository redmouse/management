package logic;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Wk009Dao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Login() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Wk009Dao wk009Dao = new Wk009Dao();
		String loginId = request.getParameter("loginId");
		String loginPd = request.getParameter("loginPd");
		try {
			if (!wk009Dao.SelectExist(loginId, loginPd)) {
				request.setAttribute("errMsg", "IDまたはパスワードを正しく入力してください！");
				request.getRequestDispatcher("/error.jsp").forward(request,response);
				return;
			}
		} catch (Exception e) {
			throw new ServletException(e);
		} finally {
			wk009Dao.closeConnection();
		}
		request.getRequestDispatcher("/select.jsp").forward(request, response);
	}

}
