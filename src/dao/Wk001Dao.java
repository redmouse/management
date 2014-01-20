package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Wk001Bean;

public class Wk001Dao extends MysqlDao {
	
	String wk001Colums = " mainId,receptionDay,level1Id,level2Id,level3Id,place,name,hurigana,"
			+ " age,birthDay,sex,marriage,foreigner,postcode,address,family,homePhone,"
			+ " mobilePhone,contactMethod,email,lastDegree,specialty,department,graduationDay,"
			+ " schoolOther,englishLevel,selfAssessment,toeic,toefl,etest,requirements,"
			+ " annualIncomeNow,annualIncomeHope,workLocation,bachelor,inaugurationDay,"
			+ " turnoverDay,fee,companyInfo,workContents";
	
	private void setBean(Wk001Bean item, ResultSet rs) throws Exception{
		item.setMainId(rs.getInt("mainId"));
		item.setReceptionDay(rs.getDate("receptionDay"));
		item.setLevel1Id(rs.getInt("level1Id"));
		item.setLevel2Id(rs.getInt("level2Id"));
		item.setLevel3Id(rs.getInt("level3Id"));
		item.setPlace(rs.getInt("place"));
		item.setName(rs.getString("name"));
		item.setHurigana(rs.getString("hurigana"));
		item.setAge(rs.getInt("age"));
		item.setBirthDay(rs.getDate("birthDay"));
		item.setSex(rs.getInt("sex"));
		item.setMarriage(rs.getInt("marriage"));
		item.setForeigner(rs.getInt("foreigner"));
		item.setPostcode(rs.getString("postcode"));
		item.setAddress(rs.getString("address"));
		item.setFamily(rs.getString("family"));
		item.setHomePhone(rs.getString("homePhone"));
		item.setMobilePhone(rs.getString("mobilePhone"));
		item.setContactMethod(rs.getString("contactMethod"));
		item.setEmail(rs.getString("email"));
		item.setLastDegree(rs.getString("lastDegree"));
		item.setSpecialty(rs.getString("specialty"));
		item.setDepartment(rs.getInt("department"));
		item.setGraduationDay(rs.getDate("graduationDay"));
		item.setSchoolOther(rs.getString("schoolOther"));
		item.setEnglishLevel(rs.getInt("englishLevel"));
		item.setSelfAssessment(rs.getString("selfAssessment"));
		item.setToeic(rs.getString("toeic"));
		item.setToefl(rs.getString("toefl"));
		item.setEtest(rs.getString("etest"));
		item.setRequirements(rs.getString("requirements"));
		item.setAnnualIncomeNow(rs.getString("annualIncomeNow"));
		item.setAnnualIncomeHope(rs.getString("annualIncomeHope"));
		item.setWorkLocation(rs.getString("workLocation"));
		item.setBachelor(rs.getInt("bachelor"));
		item.setInaugurationDay(rs.getDate("inaugurationDay"));
		item.setTurnoverDay(rs.getDate("turnoverDay"));
		item.setFee(rs.getString("fee"));
		item.setCompanyInfo(rs.getString("companyInfo"));
		item.setWorkContents(rs.getString("workContents"));
	}
	
	
	public List<Wk001Bean> SelectAll() throws Exception {
		List<Wk001Bean> returnList = new ArrayList<Wk001Bean>();
		String sql = " SELECT " + wk001Colums + " FROM wk001 ORDER BY receptionDay desc,mainId desc";
		PreparedStatement statement = getConnection().prepareStatement(sql);
		ResultSet rs = statement.executeQuery();

		while (rs.next()) {
			Wk001Bean item = new Wk001Bean();
			setBean(item, rs);
			returnList.add(item);
		}
		return returnList;
	}
	public Wk001Bean Select(int mainId) throws Exception {
		String sql = " SELECT " + wk001Colums + " FROM wk001 where mainId=? ";
		PreparedStatement statement = getConnection().prepareStatement(sql);
		statement.setInt(1, mainId);
		ResultSet rs = statement.executeQuery();
		Wk001Bean item = new Wk001Bean();
		if (rs.next()) {
			setBean(item, rs);
		}
		return item;
	}
	public String GetUserNameById(int mainId) throws Exception {
		String sql = " SELECT name FROM wk001 where mainId=? ";
		PreparedStatement statement = getConnection().prepareStatement(sql);
		statement.setInt(1, mainId);
		ResultSet rs = statement.executeQuery();
		if (rs.next()) {
			return rs.getString("name");
		}
		return "";
	}
	public int SelectMaxMainId() throws Exception {
		String sql = " SELECT max(mainId) maxMainId FROM wk001";
		PreparedStatement statement = getConnection().prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		if (rs.next()) {
			return rs.getInt("maxMainId");
		}
		return 0;
	}
	public void Delete(int mainId) throws Exception {
		String sql = " DELETE FROM wk001 where mainId=? ";
		PreparedStatement statement = getConnection().prepareStatement(sql);
		statement.setInt(1, mainId);
		statement.executeUpdate();
	}
	
	public void DeleteByIds(String ids) throws Exception {
		String sql = " DELETE FROM wk001 where mainId in (?) ";
		PreparedStatement statement = getConnection().prepareStatement(sql);
		statement.setString(1, ids);
		statement.executeUpdate();
	}

	public void Update(Wk001Bean item) throws Exception {
		String sql = " UPDATE wk001 SET "
				+ " receptionDay = ?, "
				+ " level1Id = ?, "
				+ " level2Id = ?, "
				+ " level3Id = ?, "
				+ " place = ?, "
				+ " name = ?, "
				+ " hurigana = ?, "
				+ " age = ?, "
				+ " birthDay = ?, "
				+ " sex = ?, "
				+ " marriage = ?, "
				+ " foreigner = ?, "
				+ " postcode = ?, "
				+ " address = ?, "
				+ " family = ?, "
				+ " homePhone = ?, "
				+ " mobilePhone = ?, "
				+ " contactMethod = ?, "
				+ " email = ?, "
				+ " lastDegree = ?, "
				+ " specialty = ?, "
				+ " department = ?, "
				+ " graduationDay = ?, "
				+ " schoolOther = ?, "
				+ " englishLevel = ?, "
				+ " selfAssessment = ?, "
				+ " toeic = ?, "
				+ " toefl = ?, "
				+ " etest = ?, "
				+ " requirements = ?, "
				+ " annualIncomeNow = ?, "
				+ " annualIncomeHope = ?, "
				+ " workLocation = ?, "
				+ " bachelor = ?, "
				+ " inaugurationDay = ?, "
				+ " turnoverDay = ?, "
				+ " fee = ?, "
				+ " companyInfo = ?, "
				+ " workContents = ? "
				+ " where mainId=? ";
		PreparedStatement statement = getConnection().prepareStatement(sql);
		int pos = 1;
		statement.setDate(pos++, item.getReceptionDay());
		statement.setInt(pos++, item.getLevel1Id());
		statement.setInt(pos++, item.getLevel2Id());
		statement.setInt(pos++, item.getLevel3Id());
		statement.setInt(pos++, item.getPlace());
		statement.setString(pos++, item.getName());
		statement.setString(pos++, item.getHurigana());
		statement.setInt(pos++, item.getAge());
		statement.setDate(pos++, item.getBirthDay());
		statement.setInt(pos++, item.getSex());
		statement.setInt(pos++, item.getMarriage());
		statement.setInt(pos++, item.getForeigner());
		statement.setString(pos++, item.getPostcode());
		statement.setString(pos++, item.getAddress());
		statement.setString(pos++, item.getFamily());
		statement.setString(pos++, item.getHomePhone());
		statement.setString(pos++, item.getMobilePhone());
		statement.setString(pos++, item.getContactMethod());
		statement.setString(pos++, item.getEmail());
		statement.setString(pos++, item.getLastDegree());
		statement.setString(pos++, item.getSpecialty());
		statement.setInt(pos++, item.getDepartment());
		statement.setDate(pos++, item.getGraduationDay());
		statement.setString(pos++, item.getSchoolOther());
		statement.setInt(pos++, item.getEnglishLevel());
		statement.setString(pos++, item.getSelfAssessment());
		statement.setString(pos++, item.getToeic());
		statement.setString(pos++, item.getToefl());
		statement.setString(pos++, item.getEtest());
		statement.setString(pos++, item.getRequirements());
		statement.setString(pos++, item.getAnnualIncomeNow());
		statement.setString(pos++, item.getAnnualIncomeHope());
		statement.setString(pos++, item.getWorkLocation());
		statement.setInt(pos++, item.getBachelor());
		statement.setDate(pos++, item.getInaugurationDay());
		statement.setDate(pos++, item.getTurnoverDay());
		statement.setString(pos++, item.getFee());
		statement.setString(pos++, item.getCompanyInfo());
		statement.setString(pos++, item.getWorkContents());
		statement.setInt(pos++, item.getMainId());
		statement.executeUpdate();
	}
	public void Insert(Wk001Bean item) throws Exception {
		String sql = " INSERT INTO wk001 SET "
				+ " receptionDay = ?, "
				+ " level1Id = ?, "
				+ " level2Id = ?, "
				+ " level3Id = ?, "
				+ " place = ?, "
				+ " name = ?, "
				+ " hurigana = ?, "
				+ " age = ?, "
				+ " birthDay = ?, "
				+ " sex = ?, "
				+ " marriage = ?, "
				+ " foreigner = ?, "
				+ " postcode = ?, "
				+ " address = ?, "
				+ " family = ?, "
				+ " homePhone = ?, "
				+ " mobilePhone = ?, "
				+ " contactMethod = ?, "
				+ " email = ?, "
				+ " lastDegree = ?, "
				+ " specialty = ?, "
				+ " department = ?, "
				+ " graduationDay = ?, "
				+ " schoolOther = ?, "
				+ " englishLevel = ?, "
				+ " selfAssessment = ?, "
				+ " toeic = ?, "
				+ " toefl = ?, "
				+ " etest = ?, "
				+ " requirements = ?, "
				+ " annualIncomeNow = ?, "
				+ " annualIncomeHope = ?, "
				+ " workLocation = ?, "
				+ " bachelor = ?, "
				+ " inaugurationDay = ?, "
				+ " turnoverDay = ?, "
				+ " fee = ?, "
				+ " companyInfo = ?, "
				+ " workContents = ? ";
		PreparedStatement statement = getConnection().prepareStatement(sql);
		int pos = 1;
		statement.setDate(pos++, item.getReceptionDay());
		statement.setInt(pos++, item.getLevel1Id());
		statement.setInt(pos++, item.getLevel2Id());
		statement.setInt(pos++, item.getLevel3Id());
		statement.setInt(pos++, item.getPlace());
		statement.setString(pos++, item.getName());
		statement.setString(pos++, item.getHurigana());
		statement.setInt(pos++, item.getAge());
		statement.setDate(pos++, item.getBirthDay());
		statement.setInt(pos++, item.getSex());
		statement.setInt(pos++, item.getMarriage());
		statement.setInt(pos++, item.getForeigner());
		statement.setString(pos++, item.getPostcode());
		statement.setString(pos++, item.getAddress());
		statement.setString(pos++, item.getFamily());
		statement.setString(pos++, item.getHomePhone());
		statement.setString(pos++, item.getMobilePhone());
		statement.setString(pos++, item.getContactMethod());
		statement.setString(pos++, item.getEmail());
		statement.setString(pos++, item.getLastDegree());
		statement.setString(pos++, item.getSpecialty());
		statement.setInt(pos++, item.getDepartment());
		statement.setDate(pos++, item.getGraduationDay());
		statement.setString(pos++, item.getSchoolOther());
		statement.setInt(pos++, item.getEnglishLevel());
		statement.setString(pos++, item.getSelfAssessment());
		statement.setString(pos++, item.getToeic());
		statement.setString(pos++, item.getToefl());
		statement.setString(pos++, item.getEtest());
		statement.setString(pos++, item.getRequirements());
		statement.setString(pos++, item.getAnnualIncomeNow());
		statement.setString(pos++, item.getAnnualIncomeHope());
		statement.setString(pos++, item.getWorkLocation());
		statement.setInt(pos++, item.getBachelor());
		statement.setDate(pos++, item.getInaugurationDay());
		statement.setDate(pos++, item.getTurnoverDay());
		statement.setString(pos++, item.getFee());
		statement.setString(pos++, item.getCompanyInfo());
		statement.setString(pos++, item.getWorkContents());
		statement.executeUpdate();
	}
	
	// 検索画面に使う
	public List<Wk001Bean> SelectByCondition(Wk001Bean wk001Bean) throws Exception {
		List<Wk001Bean> returnList = new ArrayList<Wk001Bean>();
		String sql = " SELECT " + wk001Colums + " FROM wk001 WHERE 1=1 ";
		
		// 英語レベル
		if(wk001Bean.getEnglishLevel()>0){
			sql += " AND englishLevel = " + wk001Bean.getEnglishLevel();
		}
		// 業務分類
		if(wk001Bean.getLevel1Id()>0){
			sql += " AND level1Id = " + wk001Bean.getLevel1Id();
		}
		if(wk001Bean.getLevel2Id()>0){
			sql += " AND level2Id = " + wk001Bean.getLevel2Id();
		}
		if(wk001Bean.getLevel3Id()>0){
			sql += " AND level3Id = " + wk001Bean.getLevel3Id();
		}
		// 氏名
		if(wk001Bean.getName()!=null && !wk001Bean.getName().equals("")){
			sql += " AND name like '%" + wk001Bean.getName() + "%' ";
		}
		
		sql += " ORDER BY mainId desc";
		PreparedStatement statement = getConnection().prepareStatement(sql);
		ResultSet rs = statement.executeQuery();

		while (rs.next()) {
			Wk001Bean item = new Wk001Bean();
			setBean(item, rs);
			returnList.add(item);
		}
		return returnList;
	}
}