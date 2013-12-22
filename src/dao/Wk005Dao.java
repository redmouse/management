package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Wk005Bean;

public class Wk005Dao extends MysqlDao {
	
	
	String wk005Colums = " tradeId,forBusiness,address,representative,charger,remarks";
	
	private void setBean(Wk005Bean item, ResultSet rs) throws Exception{
		item.setTradeId(rs.getInt("tradeId"));
		item.setForBusiness(rs.getString("forBusiness"));
		item.setAddress(rs.getString("address"));
		item.setRepresentative(rs.getString("representative"));
		item.setCharger(rs.getString("charger"));
		item.setRemarks(rs.getString("remarks"));
		
	}
	
	
	public int SelectMaxTradeId() throws Exception {
		String sql = " SELECT max(tradeId) maxTradeId FROM wk005";
		PreparedStatement statement = getConnection().prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		if (rs.next()) {
			return rs.getInt("maxTradeId");
		}
		return 0;
	}
	public List<Wk005Bean> SelectAll() throws Exception {
		List<Wk005Bean> returnList = new ArrayList<Wk005Bean>();
		String sql = " SELECT " + wk005Colums + " FROM wk005 ORDER BY tradeId DESC";
		PreparedStatement statement = getConnection().prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		
		while (rs.next()) {
			Wk005Bean item = new Wk005Bean();
			setBean(item, rs);
			returnList.add(item);
		}
		return returnList;
	}
	public Wk005Bean Select(int tradeId) throws Exception {
		String sql = " SELECT " + wk005Colums + " FROM wk005 where tradeId=? ";
		PreparedStatement statement = getConnection().prepareStatement(sql);
		statement.setInt(1, tradeId);
		ResultSet rs = statement.executeQuery();
		Wk005Bean item = new Wk005Bean();
		if (rs.next()) {
			setBean(item, rs);
		}
		return item;
	}

	public void Update(Wk005Bean item) throws Exception {
		String sql = " UPDATE wk005 SET "
				+ " forBusiness = ?, "
				+ " address = ?, "
				+ " representative = ?, "
				+ " charger = ?, "
				+ " remarks = ? "
				+ " where tradeId=? ";
		PreparedStatement statement = getConnection().prepareStatement(sql);
		int pos = 1;
		statement.setString(pos++, item.getForBusiness());
		statement.setString(pos++, item.getAddress());
		statement.setString(pos++, item.getRepresentative());
		statement.setString(pos++, item.getCharger());
		statement.setString(pos++, item.getRemarks());
		statement.setInt(pos++, item.getTradeId());
		statement.executeUpdate();
	}
	public void Insert(Wk005Bean item) throws Exception {
		String sql = " INSERT INTO wk005 SET "
				+ " forBusiness = ?, "
				+ " address = ?, "
				+ " representative = ?, "
				+ " charger = ?, "
				+ " remarks = ? ";
		PreparedStatement statement = getConnection().prepareStatement(sql);
		int pos = 1;
		statement.setString(pos++, item.getForBusiness());
		statement.setString(pos++, item.getAddress());
		statement.setString(pos++, item.getRepresentative());
		statement.setString(pos++, item.getCharger());
		statement.setString(pos++, item.getRemarks());
		statement.executeUpdate();
	}
	
}