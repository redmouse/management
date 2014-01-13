package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Wk004Bean;

public class Wk004Dao extends MysqlDao {
	
	String wk004Colums = " dataId,mainId,hopePosition,forBusiness,introductionDay,interviewDay,inaugurationDay,turnoverDay,fee ";
	
	private void setBean(Wk004Bean item, ResultSet rs) throws Exception{
		item.setDataId(rs.getInt("dataId"));
		item.setMainId(rs.getInt("mainId"));
		item.setHopePosition(rs.getString("hopePosition"));
		item.setForBusiness(rs.getString("forBusiness"));
		item.setIntroductionDay(rs.getDate("introductionDay"));
		item.setInterviewDay(rs.getDate("interviewDay"));
		item.setInaugurationDay(rs.getDate("inaugurationDay"));
		item.setTurnoverDay(rs.getDate("turnoverDay"));
		item.setFee(rs.getString("fee"));
	}
	
	
	public List<Wk004Bean> SelectByMainId(int mainId) throws Exception {
		List<Wk004Bean> returnList = new ArrayList<Wk004Bean>();
		String sql = " SELECT " + wk004Colums + " FROM wk004 where mainId=? ";
		PreparedStatement statement = getConnection().prepareStatement(sql);
		statement.setInt(1, mainId);
		ResultSet rs = statement.executeQuery();
		
		while (rs.next()) {
			Wk004Bean item = new Wk004Bean();
			setBean(item, rs);
			returnList.add(item);
		}
		return returnList;
	}

	public void Delete(int dataId) throws Exception {
		String sql = " DELETE FROM Wk004 where dataId=? ";
		PreparedStatement statement = getConnection().prepareStatement(sql);
		statement.setInt(1, dataId);
		statement.executeUpdate();
	}
	public void Insert(Wk004Bean item) throws Exception {
		String sql = " INSERT INTO wk004 SET "
				+ " mainId = ?, "
				+ " hopePosition = ?, "
				+ " forBusiness = ?, "
				+ " introductionDay = ?, "
				+ " interviewDay = ?, "
				+ " inaugurationDay = ?, "
				+ " turnoverDay = ?, "
				+ " fee = ? "
				;
		PreparedStatement statement = getConnection().prepareStatement(sql);
		int pos = 1;
		statement.setInt(pos++, item.getMainId());
		statement.setString(pos++, item.getHopePosition());
		statement.setString(pos++, item.getForBusiness());
		statement.setDate(pos++, item.getIntroductionDay());
		statement.setDate(pos++, item.getInterviewDay());
		statement.setDate(pos++, item.getInaugurationDay());
		statement.setDate(pos++, item.getTurnoverDay());
		statement.setString(pos++, item.getFee());
		statement.executeUpdate();
	}

	
	public void DeleteByMainId(int mainId) throws Exception {
		String sql = " DELETE FROM Wk004 where mainId=? ";
		PreparedStatement statement = getConnection().prepareStatement(sql);
		statement.setInt(1, mainId);
		statement.executeUpdate();
	}
}