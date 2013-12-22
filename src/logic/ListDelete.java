package logic;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Wk001Dao;
import dao.Wk004Dao;

/**
 * Servlet implementation class ListDelete
 */
@WebServlet("/ListDelete")
public class ListDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListDelete() {
		super();
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
		String[] delIds = request.getParameterValues("del");
		//もし何もチェックされてなかったら、何もしない。（アラートを出してもいい）
		if (delIds.length == 0) {
			request.getRequestDispatcher("/ListShow").forward(request, response);
			return;
		}
		Wk001Dao wk001Dao=new Wk001Dao();
		Wk004Dao wk004Dao=new Wk004Dao();
		wk004Dao.setConnection(wk001Dao.getConnection());
		try {
			
			for (int i = 0; i < delIds.length; i++) {
				// delete Wk001
				int mainId = new Integer(delIds[i]).intValue();
				wk001Dao.Delete(mainId);
				// delete Wk004
				wk004Dao.Delete(mainId);
			}
			wk001Dao.getConnection().commit();
		} catch (Exception e) {
			try {
				wk001Dao.getConnection().rollback();
			} catch (SQLException e1) {
				throw new ServletException(e1);
			}
			throw new ServletException(e);
		} finally {
			wk001Dao.closeConnection();
		}
		request.getRequestDispatcher("/ListShow").forward(request, response);
	}
	

//		// where id in ( string )中のstring
//		String sqlDelIds = "";
//		for (int i = 0; i < delIds.length; i++) {
//			sqlDelIds += delIds[i] + ",";
//		}
//		sqlDelIds = sqlDelIds.substring(0, sqlDelIds.length() - 1);
//		ListDao dao=new ListDao();
//		try {
//			
//			dao.deleteList(sqlDelIds);
//		} catch (Exception e) {
//			throw new ServletException(e);
//		} finally {
//			dao.closeConnection();
//		}
//		request.getRequestDispatcher("/ListShow").forward(request, response);
//	}

}
