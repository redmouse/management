package dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import logic.Util;

public class MysqlDao extends Util{      //DAO
	protected Connection connection=null;
	public Connection getConnection(){
		try{
			if(connection==null ||connection.isClosed()){
				InitialContext initCtx= new InitialContext();
				DataSource ds=(DataSource)initCtx.lookup("java:comp/env/jdbc/localDB");
				connection =ds.getConnection();
				connection.setAutoCommit(false);
				System.out.println("success to connecting DB!");
			}
		}catch(Exception e){
			e.printStackTrace();
			connection=null;
		}
		return connection;
		
	}
	public MysqlDao(){
		this.connection = this.getConnection();
	}
	public MysqlDao(Connection conn){
		this.connection = conn;
	}
	public void setConnection(Connection conn){
		this.connection = conn;
	}
	public void closeConnection(){
		if(connection==null){
			return;
		}
		try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			connection=null;
		
		}
		
	}

}
