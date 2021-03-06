package logic;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Wk001Bean;
import beans.Wk004Bean;
import dao.Wk001Dao;
import dao.Wk004Dao;

/**
 * Servlet implementation class ListAdd
 */
@WebServlet("/ListAdd")
public class ListAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAdd() {
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
		Wk001Dao wk001Dao=new Wk001Dao();
		Wk004Dao wk004Dao=new Wk004Dao();
		wk004Dao.setConnection(wk001Dao.getConnection()); 
		Wk001Bean wk001Bean= new Wk001Bean();
		Util util = new Util(); 
		
		// validation 	確認
		String errMsg = util.validDetail(request);
		if(!errMsg.equals("")){
			request.setAttribute("errMsg", errMsg);
			request.getRequestDispatcher("/error.jsp").forward(request,response);
			return;
		}
		
    	try{
    		   		
    		// 詳細画面からの値をwk001Beanに，，dao中のInsert時のmainIdはインクリメント
    		util.setWk001BeanFromRequest(request, wk001Bean);
    		wk001Dao.Insert(wk001Bean);
    		
    		// 詳細画面からの値をwk004Listに
			int mainId = wk001Dao.SelectMaxMainId(); // 新规のとき、mainID
			String[] hopePositionValues = request.getParameterValues("hopePosition");
			String[] forBusinessValues = request.getParameterValues("forBusiness");
			String[] introductionDayValues = request.getParameterValues("introductionDay");
			String[] interviewDayValues = request.getParameterValues("interviewDay");
			String[] inaugurationDayValues = request.getParameterValues("inaugurationDay");
			String[] turnoverDayValues = request.getParameterValues("turnoverDay");
			String[] feeValues = request.getParameterValues("fee");
			int sizeWk004 = hopePositionValues.length;
			List<Wk004Bean> wk004List = new ArrayList<Wk004Bean>();
			for (int i = 0; i < sizeWk004; i++) {
				// 面談データを一件取り出す
				String hopePosition = hopePositionValues[i];
				String forBusiness = forBusinessValues[i];
				String introductionDay = introductionDayValues[i];
				String interviewDay = interviewDayValues[i];
				String inaugurationDay = inaugurationDayValues[i];
				String turnoverDay = turnoverDayValues[i];
				String fee = feeValues[i];
				//　面談データは空だったら、無効とみなして、wk004Beanを生成しない
				if (hopePosition.trim().equals("")
						&& forBusiness.trim().equals("")
						&& introductionDay.trim().equals("")
						&& interviewDay.trim().equals("")
						&& inaugurationDay.trim().equals("")
						&& turnoverDay.trim().equals("")
						&& fee.trim().equals("")
					) {
					continue;
				}
				// 有效データ、生成Bean、Listに記入する
				Wk004Bean wk004Bean = new Wk004Bean();
				wk004Bean.setMainId(mainId);
				wk004Bean.setHopePosition(hopePosition);
				wk004Bean.setForBusiness(forBusiness);
				wk004Bean.setIntroductionDay(util.convertDate(introductionDay));
				wk004Bean.setInterviewDay(util.convertDate(interviewDay));
				wk004Bean.setInaugurationDay(util.convertDate(inaugurationDay));
				wk004Bean.setTurnoverDay(util.convertDate(turnoverDay));
				wk004Bean.setFee(util.convertNullInt(fee));
				wk004List.add(wk004Bean);
			}
			//wk004の中のmainIdの全部データ削除
			wk004Dao.DeleteByMainId(mainId);
			// 上に新たに生成した值全部insert、データベースに
			for (Iterator<Wk004Bean> iterator = wk004List.iterator(); iterator.hasNext();) {
				Wk004Bean wk004Bean = (Wk004Bean) iterator.next();
				wk004Dao.Insert(wk004Bean);
			}
			wk001Dao.getConnection().commit();
    	}catch(Exception e){
    			try {
					wk001Dao.getConnection().rollback();
				} catch (SQLException e1) {
					throw new ServletException(e1);
				}
    		throw new ServletException(e);
    	}finally{
    		wk001Dao.closeConnection();
    	}
    	request.getRequestDispatcher("/ListShow").forward(request,response);
	}
	
	
	

}
