package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Mst003Bean;

public class Mst003Dao extends MysqlDao {
	
	public List<Mst003Bean> Select(int level2Id) throws Exception {
		List<Mst003Bean> returnList = new ArrayList<Mst003Bean>();
		String sql = " SELECT level3Id,level2Id,name FROM mst003 where level2Id=?";
		PreparedStatement statement = getConnection().prepareStatement(sql);
		statement.setInt(1, level2Id);
		ResultSet rs = statement.executeQuery();

		while (rs.next()) {
			Mst003Bean item = new Mst003Bean();
			item.setLevel3Id(rs.getInt("level3Id"));
			item.setLevel2Id(rs.getInt("level2Id"));
			item.setName(rs.getString("name"));
			returnList.add(item);
		}
		return returnList;
	}
	

}