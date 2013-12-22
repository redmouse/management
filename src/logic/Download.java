package logic;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Download
 */
@WebServlet("/Download")
public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Download() {
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
		Util util = new Util();
		String aFileName = null; // downloadするファイル名
		FileInputStream in = null; 
		ServletOutputStream out = null; 

		try {
			String mainId = request.getParameter("mainId");
			aFileName = request.getParameter("fileName");
			response.setContentType("application/vnd.ms-excel;charset=UTF-8");
			response.setHeader("Content-disposition", "attachment; filename="
					+ aFileName);
			String filePath = util.uploadPath + util.fileSeprator + mainId + util.fileSeprator + aFileName;
			in = new FileInputStream(filePath); //ファイルを読み込み
			out = response.getOutputStream();
			out.flush();
			int aRead = 0;
			while ((aRead = in.read()) != -1 & in != null) {
				out.write(aRead);
			}
			out.flush();
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

}
