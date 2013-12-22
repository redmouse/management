package logic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Mst002Dao;
import dao.Mst003Dao;
import beans.LinkageBean;
import beans.Mst001Bean;
import beans.Mst002Bean;
import beans.Mst003Bean;

/**
 * Servlet implementation class Linkage
 */
@WebServlet("/Linkage")
public class Linkage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Linkage() {
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
		response.setContentType("text/xml; charset=UTF-8");
		//  cacheを取り消す
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		PrintWriter out = response.getWriter();
		String level1Id = request.getParameter("level1Id");
		String level2Id = request.getParameter("level2Id");
		
		Util util = new Util();
		Mst002Dao mst002Dao = new Mst002Dao();
		Mst003Dao mst003Dao = new Mst003Dao();
		try {
			if (level1Id != null && !level1Id.equals("")) {
				int intLevel1Id = new Integer(level1Id).intValue();
				List<Mst002Bean> mst002List = mst002Dao.Select(intLevel1Id);
				String outputLevel2Area = util.rebuiledLevel2Area(mst002List)
						.toString();
				out.write(outputLevel2Area);//search画面に出力する
			} else if (level2Id != null && !level2Id.equals("")) {
				int intLevel2Id = new Integer(level2Id).intValue();

				List<Mst003Bean> mst003List = mst003Dao.Select(intLevel2Id);
				String outputLevel3Area = util.rebuiledLevel3Area(mst003List)
						.toString();
				out.write(outputLevel3Area);
			}
			out.flush();
			out.close();
		} catch (Exception e) {
			throw new ServletException(e);
		} finally {
			mst002Dao.closeConnection();
			mst003Dao.closeConnection();
			out.flush();
			out.close();
		}
	}

}
