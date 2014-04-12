package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import logic.Util;
import beans.Wk006Bean;

public class Wk006Dao extends MysqlDao {

	String wk006Colums = " infoId,tradeId,receptionDay,quantity,occupation,workLocation, "
			+ "period,wage,conditions,place,recruitmentFrom,recruitmentOwn,secondMainId ";

	private void setBean(Wk006Bean item, ResultSet rs) throws Exception{
		item.setInfoId(rs.getInt("infoId"));
		item.setTradeId(rs.getInt("tradeId"));
		item.setReceptionDay(rs.getDate("receptionDay"));
		item.setQuantity(rs.getString("quantity"));
		item.setOccupation(rs.getString("occupation"));
		item.setWorkLocation(rs.getString("workLocation"));
		item.setPeriod(rs.getString("period"));
		item.setWage(rs.getString("wage"));
		item.setConditions(rs.getString("conditions"));
		item.setPlace(rs.getString("place"));
		item.setRecruitmentFrom(rs.getString("recruitmentFrom"));
		item.setRecruitmentOwn(rs.getString("recruitmentOwn"));
		item.setSecondMainId(rs.getString("secondMainId"));
	}


	public List<Wk006Bean> SelectByTradeId(int tradeId) throws Exception {
		List<Wk006Bean> returnList = new ArrayList<Wk006Bean>();
		String sql = " SELECT " + wk006Colums + " FROM wk006 where tradeId=? ";
		PreparedStatement statement = getConnection().prepareStatement(sql);
		statement.setInt(1, tradeId);
		ResultSet rs = statement.executeQuery();

		while (rs.next()) {
			Wk006Bean item = new Wk006Bean();
			setBean(item, rs);
			returnList.add(item);
		}
		return returnList;
	}

	public List<Wk006Bean> SelectByTradeIdAndDeceptionDay(int tradeId, Calendar cal) throws Exception {
		Util util = new Util();
		List<Wk006Bean> returnList = new ArrayList<Wk006Bean>();
		String sql = " SELECT " + wk006Colums + " FROM wk006 where tradeId=? and ReceptionDay between ? and ?";
		PreparedStatement statement = getConnection().prepareStatement(sql);
		int pos = 1;
		statement.setInt(pos++, tradeId);
		statement.setDate(pos++, util.getYearBegin(cal));
		statement.setDate(pos++, util.getYearEnd(cal));
		ResultSet rs = statement.executeQuery();

		while (rs.next()) {
			Wk006Bean item = new Wk006Bean();
			setBean(item, rs);
			returnList.add(item);
		}
		return returnList;
	}
	public List<Integer> SelectByReceptionDay(Calendar cal) throws Exception {
		Util util = new Util();
		List<Integer> returnList = new ArrayList<Integer>();
		String sql = " SELECT distinct tradeId FROM wk006 where ReceptionDay between ? and ? ORDER BY tradeId DESC";
		PreparedStatement statement = getConnection().prepareStatement(sql);
		int pos = 1;
		statement.setDate(pos++, util.getYearBegin(cal));
		statement.setDate(pos++, util.getYearEnd(cal));
		ResultSet rs = statement.executeQuery();

		while (rs.next()) {
			Wk006Bean item = new Wk006Bean();
			returnList.add(rs.getInt("tradeId"));
		}
		return returnList;
	}

	public void Insert(Wk006Bean item) throws Exception {
		String sql = " INSERT INTO wk006 SET "
				+ " tradeId = ?, "
				+ " receptionDay = ?, "
				+ " quantity = ?, "
				+ " occupation = ?, "
				+ " workLocation = ?, "
				+ " period = ?, "
				+ " wage = ?, "
				+ " conditions = ?, "
				+ " place = ?, "
				+ " recruitmentFrom = ?, "
				+ " recruitmentOwn = ?, "
				+ " secondMainId = ? ";
		PreparedStatement statement = getConnection().prepareStatement(sql);
		int pos = 1;
		statement.setInt(pos++, item.getTradeId());
		statement.setDate(pos++, item.getReceptionDay());
		statement.setString(pos++, item.getQuantity());
		statement.setString(pos++, item.getOccupation());
		statement.setString(pos++, item.getWorkLocation());
		statement.setString(pos++, item.getPeriod());
		statement.setString(pos++, item.getWage());
		statement.setString(pos++, item.getConditions());
		statement.setString(pos++, item.getPlace());
		statement.setString(pos++, item.getRecruitmentFrom());
		statement.setString(pos++, item.getRecruitmentOwn());
		statement.setString(pos++, item.getSecondMainId());
		statement.executeUpdate();
	}

	public void Delete(int infoId) throws Exception {
		String sql = " DELETE FROM Wk006 where infoId=? ";
		PreparedStatement statement = getConnection().prepareStatement(sql);
		statement.setInt(1, infoId);
		statement.executeUpdate();
	}

	public void DeleteByTradeId(int tradeId) throws Exception {
		String sql = " DELETE FROM Wk006 where tradeId=? ";
		PreparedStatement statement = getConnection().prepareStatement(sql);
		statement.setInt(1, tradeId);
		statement.executeUpdate();
	}
}