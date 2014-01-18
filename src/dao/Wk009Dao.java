package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Wk009Dao extends MysqlDao {
	
	public boolean SelectExist(String loginId, String loginPd) throws Exception {
		String sql = " SELECT 1 FROM wk009 where loginId=? and loginPassword=?";
		PreparedStatement statement = getConnection().prepareStatement(sql);
		statement.setString(1, loginId);
		statement.setString(2, loginPd);
		ResultSet rs = statement.executeQuery();
		
		if (rs.next()) {
			return true;
		}
		return false;
	}
	
}