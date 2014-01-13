package logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Disp003Bean;
import beans.Wk004Bean;
import dao.JoinDao;

/**
 * Servlet implementation class List
 */
@WebServlet("/ListShowFee")
public class ListShowFee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListShowFee() {
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
		
		List<Disp003Bean> disp003List = new ArrayList<Disp003Bean>();
		JoinDao joinDao=new JoinDao();
		
		Util util = new Util();
		try{
			// 手数料明細
			disp003List = joinDao.SelectFeeList();
			for (Iterator<Disp003Bean> iterator = disp003List.iterator(); iterator.hasNext();) {
				Disp003Bean disp003Bean = (Disp003Bean) iterator.next();
				// set display main id
				disp003Bean.getWk001Bean().setDispMainId(util.convertDispId(disp003Bean.getWk001Bean().getMainId()));
				// set display fee
				disp003Bean.getWk004Bean().setDispFee(String.valueOf(disp003Bean.getWk004Bean().getFee()));
			}
			// 合計
			int total = joinDao.SelectFeeTotal();
			// 会計年度表示
			String startDay = util.getYearBegin().toString();
			String endDay = util.getYearEnd().toString();
			// 画面へ出力
    		request.setAttribute("disp003List", disp003List);
    		request.setAttribute("total", total);
    		request.setAttribute("startDay", startDay);
    		request.setAttribute("endDay", endDay);
    		
    	}catch(Exception e){
    		throw new ServletException(e);
    	}finally{
    		joinDao.closeConnection();
    	}
    	request.getRequestDispatcher("/listShowFee.jsp").forward(request,response);
	}
	
}
