package logic;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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
			if (util.getDirFileNamesByMainId(intMainId).size() >= 3) {
				errMsg = "アップロードファイル数は3個まで。";
			} else {
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
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			errMsg = "ファイルアップロード失敗しました！ご確認ください。";
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
