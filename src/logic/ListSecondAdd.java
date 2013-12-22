package logic;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Wk005Bean;
import beans.Wk006Bean;
import dao.Wk005Dao;
import dao.Wk006Dao;

/**
 * Servlet implementation class ListAdd
 */
@WebServlet("/ListSecondAdd")
public class ListSecondAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListSecondAdd() {
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
		Wk005Dao wk005Dao=new Wk005Dao();
		Wk006Dao wk006Dao=new Wk006Dao();
		wk006Dao.setConnection(wk005Dao.getConnection());
		Wk005Bean wk005Bean= new Wk005Bean();
		/*Wk006Bean wk006Bean= new Wk006Bean();*/
		Util util = new Util();
		
		
    	try{
    		// 求人詳細画面からの値をwk005Beanに，，dao中のInsert時のtradeIdはインクリメント
    		util.setWk005BeanFromRequest(request, wk005Bean);
    		wk005Dao.Insert(wk005Bean);
    		
    		// 取新生成的tradeId
    		int tradeId = wk005Dao.SelectMaxTradeId();
    		
    		// 求人詳細画面からの値をwk006Listに
			String[] receptionDayValues = request.getParameterValues("receptionDay");
			String[] quantityValues = request.getParameterValues("quantity");
			String[] occupationValues = request.getParameterValues("occupation");
			String[] workLocationValues = request.getParameterValues("workLocation");
			String[] periodValues = request.getParameterValues("period");
			String[] wageValues = request.getParameterValues("wage");
			String[] conditionsValues = request.getParameterValues("conditions");
			String[] placeValues = request.getParameterValues("place");
			String[] recruitmentFromValues = request.getParameterValues("recruitmentFrom");
			String[] recruitmentOwnValues = request.getParameterValues("recruitmentOwn");
			String[] secondMainIdValues = request.getParameterValues("secondMainId");
			int sizeWk006 = 0;
			if(receptionDayValues!=null){
				sizeWk006 = receptionDayValues.length;
			}
			List<Wk006Bean> wk006List = new ArrayList<Wk006Bean>();
			for (int i = 0; i < sizeWk006; i++) {
				// 求人データを一件つづ取り出す
				String receptionDay = receptionDayValues[i];
				String quantity = quantityValues[i];
				String occupation = occupationValues[i];
				String workLocation = workLocationValues[i];
				String period = periodValues[i];
				String wage = wageValues[i];
				String conditions = conditionsValues[i];
				String place = placeValues[i];
				String recruitmentFrom = recruitmentFromValues[i];
				String recruitmentOwn = recruitmentOwnValues[i];
				String secondMainId = secondMainIdValues[i];
				//　求人詳細データは空だったら、無効とみなして、wk006Beanを生成しない
				if (receptionDay.trim().equals("")
						&& quantity.trim().equals("")
						&& occupation.trim().equals("")
						&& workLocation.trim().equals("")
						&& period.trim().equals("")
						&& wage.trim().equals("")
						&& conditions.trim().equals("")
						&& place.trim().equals("")
						&& recruitmentFrom.trim().equals("")
						&& recruitmentOwn.trim().equals("")
						&& secondMainId.trim().equals("")) {
					continue;
				}
				// 有效データだったら、生成Bean、Listに記入する
				Wk006Bean wk006Bean = new Wk006Bean();
				wk006Bean.setTradeId(tradeId);
				wk006Bean.setReceptionDay(util.convertDate(receptionDay));
				wk006Bean.setQuantity(quantity);
				wk006Bean.setOccupation(occupation);
				wk006Bean.setWorkLocation(workLocation);
				wk006Bean.setPeriod(period);
				wk006Bean.setWage(wage);
				wk006Bean.setConditions(conditions);
				wk006Bean.setPlace(place);
				wk006Bean.setRecruitmentFrom(recruitmentFrom);
				wk006Bean.setRecruitmentOwn(recruitmentOwn);
				wk006Bean.setSecondMainId(secondMainId);
				wk006List.add(wk006Bean);
			}
			
			//wk006の中のsecondMainIdの全部データ削除
			wk006Dao.DeleteByTradeId(tradeId);
			// 上に新たに生成した值全部insert、データベースに
			for (Iterator iterator = wk006List.iterator(); iterator.hasNext();) {
				Wk006Bean wk006Bean = (Wk006Bean) iterator.next();
				wk006Dao.Insert(wk006Bean);
			}
			wk005Dao.getConnection().commit();
    	}catch(Exception e){
    		try {
				wk005Dao.getConnection().rollback();
			} catch (SQLException e1) {
				throw new ServletException(e1);
			}
    		throw new ServletException(e);
    	}finally{
    		wk005Dao.closeConnection();
    	}
    	request.getRequestDispatcher("/ListShowSecond").forward(request,response);
	}
	
	
	

}
