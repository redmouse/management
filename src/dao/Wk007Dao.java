package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Wk007Bean;

public class Wk007Dao extends MysqlDao {
	
	String wk007Colums = " fileId,mainId,fileName,filePath,uploadedDate,deleteFlag,deleteDate ";
	
	private void setBean(Wk007Bean item, ResultSet rs) throws Exception{
		item.setFileId(rs.getInt("fileId"));
		item.setMainId(rs.getInt("mainId"));
		item.setFileName(rs.getString("fileName"));
		item.setFilePath(rs.getString("filePath"));
		item.setUploadedDate(rs.getDate("uploadedDate"));
		item.setDeleteFlag(rs.getInt("deleteFlag"));
		item.setDeleteDate(rs.getDate("deleteDate"));
	}
	
	
	public List<Wk007Bean> SelectByFileId(int fileId) throws Exception {
		List<Wk007Bean> returnList = new ArrayList<Wk007Bean>();
		String sql = " SELECT " + wk007Colums + " FROM wk007 where fileId=? ";
		PreparedStatement statement = getConnection().prepareStatement(sql);
		statement.setInt(1, fileId);
		ResultSet rs = statement.executeQuery();
		
		while (rs.next()) {
			Wk007Bean item = new Wk007Bean();
			setBean(item, rs);
			returnList.add(item);
		}
		return returnList;
	}
	
	public int GetValidFileCountByMainId(int mainId) throws Exception {
		String sql = " SELECT count(1) cnt FROM wk007 where mainId=? and deleteFlag=0 ";
		PreparedStatement statement = getConnection().prepareStatement(sql);
		statement.setInt(1, mainId);
		ResultSet rs = statement.executeQuery();
		int count = 0;
		while (rs.next()) {
			count = rs.getInt("cnt");
		}
		return count;
	}

	public void Insert(Wk007Bean item) throws Exception {
		String sql = " INSERT INTO wk007 SET "
				+ " mainId = ?, "
				+ " fileName = ?, "
				+ " filePath = ?, "
				+ " uploadedDate = NOW(), "
				+ " deleteFlag = 0, "
				+ " deleteDate = null ";
		PreparedStatement statement = getConnection().prepareStatement(sql);
		int pos = 1;
		statement.setInt(pos++, item.getMainId());
		statement.setString(pos++, item.getFileName());
		statement.setString(pos++, item.getFilePath());
		statement.executeUpdate();
	}

	public void Delete(int mainId, String fileName) throws Exception {
		String sql = " UPDATE wk007 SET "
				+ " deleteFlag = 1, "
				+ " deleteDate = NOW() "
				+ " WHERE deleteFlag=0 and mainId = ? and fileName = ?";
		PreparedStatement statement = getConnection().prepareStatement(sql);
		statement.setInt(1, mainId);
		statement.setString(2, fileName);
		statement.executeUpdate();
	}
	
	public void Delete(int mainId) throws Exception {
		String sql = " UPDATE wk007 SET "
				+ " deleteFlag = 1, "
				+ " deleteDate = NOW() "
				+ " WHERE deleteFlag=0 and mainId = ? ";
		PreparedStatement statement = getConnection().prepareStatement(sql);
		statement.setInt(1, mainId);
		statement.executeUpdate();
	}
}