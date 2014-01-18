package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import logic.Util;
import beans.Disp003Bean;
import beans.Wk001Bean;
import beans.Wk004Bean;

public class JoinDao extends MysqlDao {
	
	// 手数料画面、Wk004(行情報)とWk001(氏名、表示用mainId)連携
	public List<Disp003Bean> SelectFeeList(Calendar cal) throws Exception {
		Util util = new Util();
		
		List<Disp003Bean> returnList = new ArrayList<Disp003Bean>();
		String sql = 
				" SELECT wk001.name, wk004.forBusiness, wk004.inaugurationDay, wk004.turnoverDay, wk004.fee, wk001.mainId "
				+ " FROM wk004 LEFT JOIN wk001 ON wk004.mainId=wk001.mainId "
				+ " where wk004.fee>0 and wk004.inaugurationDay between ? and ?";
		PreparedStatement statement = getConnection().prepareStatement(sql);
		int pos = 1;
		statement.setDate(pos++, util.getYearBegin(cal));
		statement.setDate(pos++, util.getYearEnd(cal));
		ResultSet rs = statement.executeQuery();
		
		while (rs.next()) {
			Wk001Bean wk001Bean = new Wk001Bean();
			Wk004Bean wk004Bean = new Wk004Bean();
			wk001Bean.setName(rs.getString("name"));
			wk001Bean.setMainId(rs.getInt("mainId"));
			
			wk004Bean.setForBusiness(rs.getString("forBusiness"));
			wk004Bean.setInaugurationDay(rs.getDate("inaugurationDay"));
			wk004Bean.setTurnoverDay(rs.getDate("turnoverDay"));
			wk004Bean.setFee(rs.getInt("fee"));
			
			Disp003Bean disp003Bean = new Disp003Bean();
			disp003Bean.setWk001Bean(wk001Bean);
			disp003Bean.setWk004Bean(wk004Bean);
			returnList.add(disp003Bean);
		}
		return returnList;
	}
	
	// 手数料画面、合計情報
	public int SelectFeeTotal(Calendar cal) throws Exception {
		Util util = new Util();
		
		String sql = 
				" SELECT sum(fee) total"
						+ " FROM wk004 "
						+ " where wk004.fee>0 and wk004.inaugurationDay between ? and ?";
		PreparedStatement statement = getConnection().prepareStatement(sql);
		int pos = 1;
		statement.setDate(pos++, util.getYearBegin(cal));
		statement.setDate(pos++, util.getYearEnd(cal));
		ResultSet rs = statement.executeQuery();
		int total = 0;
		if(rs.next()){
			total = rs.getInt("total");
		}
		return total;
	}
}