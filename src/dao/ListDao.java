package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Wk001Bean;

public class ListDao extends MysqlDao {
	public void addList(Wk001Bean item) throws Exception{
		String sql="INSERT INTO wk001 SET"
				+ " receptionDay = ?,"
				+ " mst001Bean.name= ?,"
				+ " mst002Bean.name= ?,"
				+ " mst003Bean.name= ?,"
				+ " place= ?,"
				+ " name = ?,"
				+ " hurigana= ?,"
				+ " age = ?,"
				+ " birthDay = ?,"
				+ " sex = ?,"
				+ " marriage = ?,"
				+ " foreigner = ?,"
				+ " postcode = ?,"
				+ " address = ?,"
				+ " family = ?,"
				+ " homePhone = ?,"
				+ " mobilePhone = ?,"
				+ " contactMethod = ?,"
				+ " email = ?,"
				+ " lastDegree = ?,"
				+ " specialty = ?,"
				+ " department = ?,"
				+ " graduationDay = ?,"
				+ " schoolOther = ?,"
				+ " wk002Bean.companyName = ?,"
				+ " wk002Bean.phone = ?,"
				+ " wk002Bean.overview = ?,"
				+ " wk002Bean.position = ?,"
				+ " wk003Bean.experience = ?,"
				+ " wk003Bean.occupation = ?,"
				+ " wk003Bean.qualification = ?,"
				+ " wk003Bean.product = ?,"
				+ " wk003Bean.special = ?,"
				+ " englishLevel = ?,"
				+ " selfAssessment = ?,"
				+ " toeic = ?,"
				+ " toefl = ?,"
				+ " etest = ?,"
				+ " requirements = ?,"
				+ " annualIncomeNow = ?,"
				+ " annualIncomeHope = ?,"
				+ " workLocation = ?,"
				+ " bachelor = ?,"
				+ " inaugurationDay = ?,"
				+ " turnoverDay = ?, "
				+ " fee = ?, "
				+ " dataBean.hopePosition = ?,"
				+ " dataBean.forBusiness = ?,"
				+ " dataBean.introductionDay = ?,"
				+ " dataBean.interviewDay = ?,"
				+ " file = ?";
		PreparedStatement statement = getConnection().prepareStatement(sql);
		int pos = 1;
		statement.setDate(pos++, item.getReceptionDay());
		statement.setString(pos++, item.lev1Bean.getName());
		statement.setString(pos++, item.lev2Bean.getName());
		statement.setString(pos++, item.lev3Bean.getName());
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
		statement.setString(pos++, item.getLastSchool());
		statement.setString(pos++, item.getSpecialty());
		statement.setInt(pos++, item.getDepartment());
		statement.setDate(pos++, item.getGraduationDay());
		statement.setString(pos++, item.getOther());
		statement.setString(pos++, item.cmpBean.getCompanyName());
		statement.setString(pos++, item.cmpBean.getPhone());
		statement.setString(pos++, item.cmpBean.getOverview());
		statement.setString(pos++, item.cmpBean.getPosition());
		statement.setString(pos++, item.wkBean.getExperience());
		statement.setString(pos++, item.wkBean.getOccupation());
		statement.setString(pos++, item.wkBean.getQualification());
		statement.setString(pos++, item.wkBean.getProduct());
		statement.setString(pos++, item.wkBean.getSpecial());
		statement.setInt(pos++, item.getEnglishLevel());
		statement.setString(pos++, item.getSelfAssessment());
		statement.setString(pos++, item.getToeic());
		statement.setString(pos++, item.getToefl());
		statement.setString(pos++, item.getEtest());
		statement.setString(pos++, item.getRequirements());
		statement.setString(pos++, item.getAnnualIncome_now());
		statement.setString(pos++, item.getAnnualIncome_hope());
		statement.setString(pos++, item.getWorkLocation());
		statement.setInt(pos++, item.getBachelor());
		statement.setDate(pos++, item.getInaugurationDay());
		statement.setDate(pos++, item.getTurnoverDay());
		statement.setString(pos++, item.getFee());
		statement.setString(pos++, item.dataBean.getHopePosition());
		statement.setString(pos++, item.dataBean.getForBusiness());
		statement.setDate(pos++, item.dataBean.getIntroductionDay());
		statement.setDate(pos++, item.dataBean.getInterviewDay());
		statement.setBlob(pos++, item.getFile());
		
		statement.executeUpdate();
		getConnection().commit();
	}
	/*public void modifyList(Wk001Bean item) throws Exception{
		String sql="UPDATE wk001 SET  receptionDay = ?,lev1Bean.name= ?,lev2Bean.name= ?,lev3Bean.name= ?,place= ?,"
				+ "name = ?,hurigana= ?,age = ?,birthDay = ?,sex = ?, marriage = ?,foreigner = ?, postcode = ?,address = ?,"
				+ "family = ?,homePhone = ?,mobilePhone = ?,contactMethod = ?,email = ?,lastSchool = ?,specialty = ?,department = ?,"
				+ "graduationDay = ?,other = ?,cmpBean.companyName = ?,cmpBean.phone = ?,cmpBean.overview = ?,cmpBean.position = ?,"
				+ "wkBean.experience = ?,wkBean.occupation = ?,wkBean.qualification = ?,wkBean.product = ?,wkBean.special = ?,"
				+ "englishLevel = ?,selfAssessment = ?, toeic = ?,toefl = ?,etest = ?,requirements = ?,annualIncome_now = ?,"
				+ "annualIncome_hope = ?,workLocation = ?,bachelor = ?,inaugurationDay = ?, turnoverDay = ?, fee= = ?,"
				+ "dataBean.hopePosition = ?,dataBean.forBusiness = ?,dataBean.introductionDay = ?,dataBean.interviewDay = ?,file = ?,"
				+ "WHERE id=?";
		PreparedStatement statement = getConnection().prepareStatement(sql);
		int pos = 1;
		statement.setDate(pos++, item.getReceptionDay());
		statement.setString(pos++, item.lev1Bean.getName());
		statement.setString(pos++, item.lev2Bean.getName());
		statement.setString(pos++, item.lev3Bean.getName());
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
		statement.setString(pos++, item.getLastSchool());
		statement.setString(pos++, item.getSpecialty());
		statement.setInt(pos++, item.getDepartment());
		statement.setDate(pos++, item.getGraduationDay());
		statement.setString(pos++, item.getOther());
		statement.setString(pos++, item.cmpBean.getCompanyName());
		statement.setString(pos++, item.cmpBean.getPhone());
		statement.setString(pos++, item.cmpBean.getOverview());
		statement.setString(pos++, item.cmpBean.getPosition());
		statement.setString(pos++, item.wkBean.getExperience());
		statement.setString(pos++, item.wkBean.getOccupation());
		statement.setString(pos++, item.wkBean.getQualification());
		statement.setString(pos++, item.wkBean.getProduct());
		statement.setString(pos++, item.wkBean.getSpecial());
		statement.setInt(pos++, item.getEnglishLevel());
		statement.setString(pos++, item.getSelfAssessment());
		statement.setString(pos++, item.getToeic());
		statement.setString(pos++, item.getToefl());
		statement.setString(pos++, item.getEtest());
		statement.setString(pos++, item.getRequirements());
		statement.setString(pos++, item.getAnnualIncome_now());
		statement.setString(pos++, item.getAnnualIncome_hope());
		statement.setString(pos++, item.getWorkLocation());
		statement.setInt(pos++, item.getBachelor());
		statement.setDate(pos++, item.getInaugurationDay());
		statement.setDate(pos++, item.getTurnoverDay());
		statement.setString(pos++, item.getFee());
		statement.setString(pos++, item.dataBean.getHopePosition());
		statement.setString(pos++, item.dataBean.getForBusiness());
		statement.setDate(pos++, item.dataBean.getIntroductionDay());
		statement.setDate(pos++, item.dataBean.getInterviewDay());
		statement.setBlob(pos++, item.getFile());
		statement.setInt(pos++, item.getMainId());

		statement.executeUpdate();
		getConnection().commit();

	}
	public void deleteList(String sqlDelIds) throws Exception{
		String sql="DELETE FROM wk001 WHERE mainId IN("+sqlDelIds+")";
		PreparedStatement statement = getConnection().prepareStatement(sql);
		
		statement.executeUpdate();
		getConnection().commit();
		
	}
	
}*/