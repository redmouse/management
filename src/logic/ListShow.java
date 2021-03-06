package logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Disp001Bean;
import beans.Wk001Bean;
import beans.Wk004Bean;
import dao.Wk001Dao;
import dao.Wk004Dao;

/**
 * Servlet implementation class List
 */
@WebServlet("/ListShow")
public class ListShow extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListShow() {
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
		/**
		 * List<Disp001Bean> disp001List Disp001Bean wk001Bean List<Wk004Bean>
		 * Wk004Bean
		 */
		List<Disp001Bean> disp001List = new ArrayList<Disp001Bean>();
		Wk001Dao wk001Dao = new Wk001Dao();
		Wk004Dao wk004Dao = new Wk004Dao();

		Util util = new Util();
		try {
			// ----- 会計年度表示 ------
			String yearBackCount = request.getParameter("yearBackCount");
			if (yearBackCount == null) {
				yearBackCount = "0";
			}
			int yearBack = new Integer(yearBackCount).intValue();
			Date date = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) - yearBack);
			cal.set(Calendar.DAY_OF_MONTH, 1); // 1日

			String startDay = util.getYearBegin(cal).toString();
			String endDay = util.getYearEnd(cal).toString();
			request.setAttribute("startDay", startDay);
			request.setAttribute("endDay", endDay);
			request.setAttribute("yearBackCount", yearBackCount);
			// ----- ---------- ------

			// wk001の該当会計年度のデータを取得し、データごとのmainIdによって，wk004Listを取得する
			List<Wk001Bean> wk001List = wk001Dao.SelectByReceptionDay(cal);
			Iterator itr = wk001List.iterator();
			while (itr.hasNext()) {
				Wk001Bean wk001Bean = (Wk001Bean) itr.next();
				wk001Bean.setDispMainId(util.convertDispId(wk001Bean
						.getMainId()));
				wk001Bean.setDispPlace(util.convertDispPlace(wk001Bean
						.getPlace()));

				List<Wk004Bean> wk004List = wk004Dao.SelectByMainId(wk001Bean
						.getMainId());
				// 画面手数料表示用、0の場合は、空で表示しません。
				for (Iterator<Wk004Bean> iterator = wk004List.iterator(); iterator
						.hasNext();) {
					Wk004Bean wk004Bean = (Wk004Bean) iterator.next();
					int fee = wk004Bean.getFee();
					if (fee > 0) {
						wk004Bean.setDispFee(String.valueOf(fee));
					}
				}
				Disp001Bean disp001Bean = new Disp001Bean();
				disp001Bean.setWk001Bean(wk001Bean);
				disp001Bean.setWk004List(wk004List);
				disp001List.add(disp001Bean);
			}

			request.setAttribute("disp001List", disp001List);
		} catch (Exception e) {
			throw new ServletException(e);
		} finally {
			wk001Dao.closeConnection();
			wk004Dao.closeConnection();
		}
		request.getRequestDispatcher("/listShow.jsp")
				.forward(request, response);
	}

}
