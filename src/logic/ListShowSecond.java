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

import beans.Disp002Bean;
import beans.IdPairBean;
import beans.Wk005Bean;
import beans.Wk006Bean;
import dao.Wk005Dao;
import dao.Wk006Dao;

/**
 * Servlet implementation class List
 */
@WebServlet("/ListShowSecond")
public class ListShowSecond extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListShowSecond() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * List<Disp002Bean> disp002List
		 * 	  Disp002Bean
		 * 		wk005Bean
		 * 		List<Wk006Bean>
		 * 			Wk006Bean
		 */
		List<Disp002Bean> disp002List = new ArrayList<Disp002Bean>();
		Wk005Dao wk005Dao=new Wk005Dao();
		Wk006Dao wk006Dao=new Wk006Dao();

		Util util = new Util();
		try{
			// ----- 会計年度表示 ------
			String yearBackCount = request.getParameter("yearBackCount");
			if(yearBackCount==null){
				yearBackCount = "0";
			}
			int yearBack = new Integer(yearBackCount).intValue();
			 Date date = new Date();
			 Calendar cal = Calendar.getInstance();
			 cal.setTime(date);
			 cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) - yearBack);
			 cal.set(Calendar.DAY_OF_MONTH, 1);  // 1日

			String startDay = util.getYearBegin(cal).toString();
			String endDay = util.getYearEnd(cal).toString();
			request.setAttribute("startDay", startDay);
    		request.setAttribute("endDay", endDay);
    		request.setAttribute("yearBackCount", yearBackCount);
			// ----- ---------- ------

    		// wk006の受付年月日より、当会計年度に、求人データがある事業所(wk006.tradeId)を取得。
    		List<Integer> tradeList = wk006Dao.SelectByReceptionDay(cal);

    		// 表示対象の事業所ごとにwk005とwk006のデータを合弁する。
    		Iterator itr = tradeList.iterator();
    		List<Wk005Bean> wk005List = new ArrayList<Wk005Bean>();
    		while (itr.hasNext()) {
    			int tradeId = (Integer)itr.next();
    			// wk005データ取得
    			Wk005Bean wk005Bean = wk005Dao.Select(tradeId);
    			wk005List.add(wk005Bean);

    			// wk006データ取得
				List<Wk006Bean> wk006List = wk006Dao.SelectByTradeIdAndDeceptionDay(tradeId,cal);
				for (Wk006Bean wk006Bean : wk006List) {
					// creat dispMainId list
					wk006Bean.setDispMainIdList(util.convertUserInputMainId(wk006Bean.getSecondMainId()));

					//　求人票のディフォルト値
					wk006Bean.setDispRecruitmentFrom(wk006Bean.getRecruitmentFrom());
					wk006Bean.setDispRecruitmentOwn(wk006Bean.getRecruitmentOwn());
					// 求人票...
					if(wk006Bean.getRecruitmentFrom().length()>5){
						wk006Bean.setDispRecruitmentFrom(util.convertDispShortCut(wk006Bean.getRecruitmentFrom()));
					}
					if(wk006Bean.getRecruitmentOwn().length()>5){
						wk006Bean.setDispRecruitmentOwn(util.convertDispShortCut(wk006Bean.getRecruitmentOwn()));
					}
				}

				Disp002Bean disp002Bean = new Disp002Bean();
				disp002Bean.setWk005Bean(wk005Bean);
				disp002Bean.setWk006List(wk006List);
				disp002List.add(disp002Bean);
			}

    		request.setAttribute("disp002List", disp002List);
    	}catch(Exception e){
    		throw new ServletException(e);
    	}finally{
    		wk005Dao.closeConnection();
    		wk006Dao.closeConnection();
    	}
    	request.getRequestDispatcher("/listShowSecond.jsp").forward(request,response);
	}

}
