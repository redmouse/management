package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Mst001Bean;

public class Mst001Dao extends MysqlDao {
	
	public List<Mst001Bean> SelectAll() throws Exception {
		List<Mst001Bean> returnList = new ArrayList<Mst001Bean>();
		String sql = " SELECT level1Id,name FROM mst001";
		PreparedStatement statement = getConnection().prepareStatement(sql);
		ResultSet rs = statement.executeQuery();

		while (rs.next()) {
			Mst001Bean item = new Mst001Bean();
			item.setLevel1Id(rs.getInt("level1Id"));
			item.setName(rs.getString("name"));
			returnList.add(item);
		}
		return returnList;
	}
	

}