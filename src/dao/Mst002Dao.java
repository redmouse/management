package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Mst002Bean;

public class Mst002Dao extends MysqlDao {
	
//	public List<Mst002Bean> SelectAll() throws Exception {
//		List<Mst002Bean> returnList = new ArrayList<Mst002Bean>();
//		String sql = " SELECT level2Id,level1Id,name FROM mst002";
//		PreparedStatement statement = getConnection().prepareStatement(sql);
//		ResultSet rs = statement.executeQuery();
//
//		while (rs.next()) {
//			Mst002Bean item = new Mst002Bean();
//			item.setLevel2Id(rs.getInt("level2Id"));
//			item.setLevel1Id(rs.getInt("level1Id"));
//			item.setName(rs.getString("name"));
//			returnList.add(item);
//		}
//		return returnList;
//	}
	
	public List<Mst002Bean> Select(int level1Id) throws Exception {
		List<Mst002Bean> returnList = new ArrayList<Mst002Bean>();
		String sql = " SELECT level2Id,level1Id,name FROM mst002 where level1Id = ? ";
		PreparedStatement statement = getConnection().prepareStatement(sql);
		statement.setInt(1, level1Id);
		ResultSet rs = statement.executeQuery();
		
		while (rs.next()) {
			Mst002Bean item = new Mst002Bean();
			item.setLevel2Id(rs.getInt("level2Id"));
			item.setLevel1Id(rs.getInt("level1Id"));
			item.setName(rs.getString("name"));
			returnList.add(item);
		}
		return returnList;
	}
	

}