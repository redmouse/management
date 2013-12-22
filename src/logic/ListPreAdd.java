package logic;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.DetailBean;
import dao.Mst001Dao;
import dao.Wk001Dao;

/**
 * Servlet implementation class ListPreAdd
 */
@WebServlet("/ListPreAdd")
public class ListPreAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListPreAdd() {
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
		Mst001Dao mst001Dao = new Mst001Dao();
		Wk001Dao wk001Dao=new Wk001Dao();
		Util util = new Util();
		/*Wk004Dao wk004Dao=new Wk004Dao();*/
		try {
			DetailBean detailBean = new DetailBean();
	    /*	int mainId = new Integer(request.getParameter("wk001Bean.mainId")).intValue();*/

			// mst001すべての値を取り、detailBean.mst001Beanに置く。
			detailBean.getLinkageBean().setMst001List(mst001Dao.SelectAll());
			/*detailBean.setWk004List(wk004Dao.SelectByMainId(mainId));*/
			
			int mainId = wk001Dao.SelectMaxMainId()+1;
			detailBean.getWk001Bean().setMainId(mainId);
			detailBean.getWk001Bean().setDispMainId(util.convertDispId(mainId));
			
			request.setAttribute("detailBean", detailBean);
			
			// --------- もしＬｉｓｔＰｒｅＡｄｄ新規のときmainIdのアップロードフォルダが存在すれば，フォルダごとを削除する------------ 
			
			String dirPath = util.uploadPath + util.fileSeprator + mainId;
			File dir = new File(dirPath);
			if(dir.exists() && dir.isDirectory()){
				File files[] = dir.listFiles();
				// 先にファイルうを削除する
				for (int i = 0; i < files.length; i++) {
					files[i].delete();
				}
				// フォルダを削除
				dir.delete();
			}
    		
		} catch (Exception e) {
			throw new ServletException(e);
		} finally {
			mst001Dao.closeConnection();
			wk001Dao.closeConnection();
			/*wk004Dao.closeConnection();*/
		}
		request.getRequestDispatcher("/list_detail.jsp").forward(request,
				response);
	}
}
