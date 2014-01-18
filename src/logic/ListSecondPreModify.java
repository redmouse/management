package logic;

import java.io.IOException;
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
 * Servlet implementation class ListSecondPreModify
 */
@WebServlet("/ListSecondPreModify")
public class ListSecondPreModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListSecondPreModify() {
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
		Disp002Bean disp002Bean = new Disp002Bean();

		Wk005Dao wk005Dao = new Wk005Dao();
		Wk006Dao wk006Dao = new Wk006Dao();
    	try{
    		int tradeId = new Integer(request.getParameter("radioForBusiness")).intValue();
    		
    		// -------- wk005 ---------
    		Wk005Bean wk005Bean = wk005Dao.Select(tradeId);
    		disp002Bean.setWk005Bean(wk005Bean);

    		// -------- wk006 ---------
    		List<Wk006Bean> wk006List = wk006Dao.SelectByTradeId(tradeId);
    		for (Iterator iterator = wk006List.iterator(); iterator.hasNext();) {
				Wk006Bean wk006Bean = (Wk006Bean) iterator.next();
				List<IdPairBean> idPairList = util.convertUserInputMainId(wk006Bean.getSecondMainId());
				StringBuffer sb = new StringBuffer();
				StringBuffer sbName = new StringBuffer();
				for (Iterator iterator2 = idPairList.iterator(); iterator2.hasNext();) {
					IdPairBean idPairBean = (IdPairBean) iterator2.next();
					sb.append(idPairBean.getDispMainId());
					sb.append(",");
					sbName.append(idPairBean.getName());
					sbName.append(",");
				}
				sb.deleteCharAt(sb.length() - 1);	// 最後の,を削除
				sbName.deleteCharAt(sbName.length() - 1);	// 最後の,を削除
				wk006Bean.setSecondMainId(sb.toString());
				wk006Bean.setDispSecondName(sbName.toString());
			}
    		disp002Bean.setWk006List(wk006List);
    		
    		// -------- output ---------
    		request.setAttribute("disp002Bean", disp002Bean);
    	}catch(Exception e){
    		throw new ServletException(e);
    	}finally{
    		wk005Dao.closeConnection();
    		wk006Dao.closeConnection();
    	}
    	request.getRequestDispatcher("/listSecond_detail.jsp").forward(request,response);
	
	}

}
