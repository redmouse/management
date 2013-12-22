package logic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.SearchBean;
import beans.Wk001Bean;
import dao.Mst001Dao;

/**
 * Servlet implementation class SearchPre
 */
@WebServlet("/SearchPre")
public class SearchPre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPre() {
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
		Mst001Dao mst001Dao = new Mst001Dao();
		Util util = new Util();
		try {
			SearchBean searchBean = new SearchBean();
			
			// 検索条件の初期値
			Wk001Bean wk001Bean = new Wk001Bean();
			wk001Bean.setEnglishLevel(0);
			searchBean.setWk001Bean(wk001Bean);
			
			// mst001すべての値を取り、searchBean.linkageBean.mst001Beanに置く。
			searchBean.getLinkageBean().setMst001List(mst001Dao.SelectAll());
			
			request.setAttribute("searchBean", searchBean);
			
		} catch (Exception e) {
			throw new ServletException(e);
		} finally {
			mst001Dao.closeConnection();
		}
		request.getRequestDispatcher("/search.jsp").forward(request,
				response);
	}

}
