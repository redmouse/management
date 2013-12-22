package logic;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDelete
 */
@WebServlet("/FileDelete")
public class FileDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileDelete() {
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

		String mainId = request.getParameter("mainId");
		String aFileName = request.getParameter("fileName");
		String dirPath = util.uploadPath + util.fileSeprator + mainId;
		try {
			String filePath = dirPath + util.fileSeprator + aFileName;
			File delFile = new File(filePath);
			if(delFile.exists() && delFile.isFile()){
				delFile.delete();
			}
			
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			
		}
		//もし削除できたら、ファイルを探してきて、画面に表示する
		response.setCharacterEncoding("utf-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		PrintWriter out = response.getWriter();
		StringBuffer sb = util.reCreateFileList(dirPath);
		out.print("<script>parent.recreateFileList(\"" + sb.toString() + "\")</script>");
		out.flush();
		out.close();
		
	}

}
