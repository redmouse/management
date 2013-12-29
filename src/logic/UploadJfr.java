package logic;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import beans.Wk007Bean;
import dao.Wk007Dao;

/**
 * Servlet implementation class UploadJfr
 */
@WebServlet("/UploadJfr")
public class UploadJfr extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadJfr() {
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
		Wk007Dao wk007Dao=new Wk007Dao();

		// －－－－－－－ファイル操作－－－－－－－－－－－－－－
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(util.sizeMax * 1024 * 1024); // 最大の臨時サイズ
		factory.setRepository(new File(util.tempPath));// 臨時ファイルの場所

		ServletFileUpload upload = new ServletFileUpload(factory);
		String dir = "";
		String errMsg = "";
		try {
			List<FileItem> items = upload.parseRequest(request);
			Iterator it = items.iterator();
			Map<String, String> paramMap = new HashMap<String, String>();
			List<FileItem> fileList = new ArrayList<FileItem>();
			while (it.hasNext()) {
				FileItem item = (FileItem) it.next();
				if (item.isFormField()) {
					paramMap.put(item.getFieldName(), item.getString("UTF-8"));
				} else {
					fileList.add(item);
				}
			}

			// get mainId
			String mainId = paramMap.get("mainId");
			// String mainId = util.getParameterEnctypeMultipart("mainId",
			// request);
			// http://soomy-com.iteye.com/blog/998406
			// (enctype="multipart/form-data"中Form値の取得)

			dir = util.uploadPath + util.fileSeprator + mainId;
			if (!new File(dir).isDirectory()) {
				new File(dir).mkdirs();
			}
			if (!new File(util.tempPath).isDirectory()) {
				new File(util.tempPath).mkdirs();
			}

			// ------------ 最大アップロードファイル数は3個 -------------
			int intMainId = new Integer(mainId).intValue();
			
			if (wk007Dao.GetValidFileCountByMainId(intMainId) >= 3) {
				errMsg = "アップロードファイル数は3個まで。";
			} else {
				// ----- File upload ------
				upload.setHeaderEncoding("UTF-8");
				upload.setSizeMax(util.sizeMax * 1024 * 1024);// ファイル最大サイズ

				String filePath = null;
				if(fileList.size()==0){
					errMsg = "ファイルを選択してください！";
				}
				else{
					for (FileItem file : fileList) {
						filePath = dir + util.fileSeprator + file.getName();
						file.write(new File(filePath));
						// ----- DB start ------
						// 同名ファイルがあれば、削除
						wk007Dao.Delete(intMainId, file.getName());
						// ファイルのデータをInsert
						Wk007Bean wk007Bean = new Wk007Bean();
						wk007Bean.setMainId(intMainId);
						wk007Bean.setFileName(file.getName());
						wk007Bean.setFilePath(filePath);
						wk007Dao.Insert(wk007Bean);
						wk007Dao.getConnection().commit();
						// ----- DB end ------
					}
				}
				
			}
		} catch (Exception e) {
			try {
				wk007Dao.getConnection().rollback();
			} catch (SQLException e1) {
				throw new ServletException(e1);
			}
			errMsg = "ファイルアップロード失敗しました！もう一回やり直してください。";
			request.setAttribute("errMsg", errMsg);
			request.getRequestDispatcher("/error.jsp").forward(request,response);
			return;
		} finally {
			wk007Dao.closeConnection();
		}

//		response.setContentType("text/html"); これを追加すると、戻り値が返ってこない
		response.setCharacterEncoding("utf-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		PrintWriter out = response.getWriter();
		
		
		// エラーだったら、アラートを出す
		if(!errMsg.equals("")){
			out.print("<script>alert(\"" + errMsg + "\")</script>");
			out.flush();
			out.close();
			return;
		}
		
		// もしアップロードができたら、ファイルを探してきて、画面に表示する
		StringBuffer sb = util.reCreateFileList(dir);
		
		out.print("<script>parent.recreateFileList(\"" + sb.toString() + "\")</script>");
		out.flush();
		out.close();
	}

}
