package beans;

import java.sql.Date;

public class Wk001Bean {
	private int mainId;
	private Date receptionDay;
	private int level1Id;
	private int level2Id;
	private int level3Id;
	private int place;
	private String name;
	private String hurigana;
	private int age;
	private Date birthDay;
	private int sex;
	private int marriage;
	private int foreigner;
	private String postcode;
	private String address;
	private String family;
	private String homePhone;
	private String mobilePhone;
	private String contactMethod;
	private String email;
	private String lastDegree;
	private String specialty;
	private int department;
	private Date graduationDay;
	private String schoolOther;
	private int englishLevel;
	private String selfAssessment;
	private String toeic;
	private String toefl;
	private String etest;
	private String requirements;
	private String annualIncomeNow;
	private String annualIncomeHope;
	private String workLocation;
	private int bachelor;
	private Date inaugurationDay;
	private Date turnoverDay;
	private String fee;
	private String companyInfo;
	private String workContents;
	

	// for display
	private String dispMainId;
	private String dispPlace;
	
	public Wk001Bean() {
		super();
		
		this.companyInfo = "①会社名：\n②勤務先TEL：\n③会社概要：\n④職位：\n";
		this.workContents="①業務経験：\n②職種・業種：\n③資格：\n④業界製品：\n⑤スベシャリティ：\n";
		// TODO Auto-generated constructor stub
	}

	public String getDispMainId() {
		return dispMainId;
	}
	public void setDispMainId(String dispMainId) {
		this.dispMainId = dispMainId;
	}
	public String getDispPlace() {
		return dispPlace;
	}
	public void setDispPlace(String dispPlace) {
		this.dispPlace = dispPlace;
	}
	public int getMainId() {
		return mainId;
	}
	public void setMainId(int mainId) {
		this.mainId = mainId;
	}

	public String getCompanyInfo() {
		return companyInfo;
	}
	public void setCompanyInfo(String companyInfo) {
		this.companyInfo = companyInfo;
	}
	public String getWorkContents() {
		return workContents;
	}
	public void setWorkContents(String workContents) {
		this.workContents = workContents;
	}
	public Date getReceptionDay() {
		return receptionDay;
	}
	public void setReceptionDay(Date receptionDay) {
		this.receptionDay = receptionDay;
	}
	public int getLevel1Id() {
		return level1Id;
	}
	public void setLevel1Id(int level1Id) {
		this.level1Id = level1Id;
	}
	public int getLevel2Id() {
		return level2Id;
	}
	public void setLevel2Id(int level2Id) {
		this.level2Id = level2Id;
	}
	public int getLevel3Id() {
		return level3Id;
	}
	public void setLevel3Id(int level3Id) {
		this.level3Id = level3Id;
	}
	public int getPlace() {
		return place;
	}
	public void setPlace(int place) {
		this.place = place;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHurigana() {
		return hurigana;
	}
	public void setHurigana(String hurigana) {
		this.hurigana = hurigana;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getMarriage() {
		return marriage;
	}
	public void setMarriage(int marriage) {
		this.marriage = marriage;
	}
	public int getForeigner() {
		return foreigner;
	}
	public void setForeigner(int foreigner) {
		this.foreigner = foreigner;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getContactMethod() {
		return contactMethod;
	}
	public void setContactMethod(String contactMethod) {
		this.contactMethod = contactMethod;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastDegree() {
		return lastDegree;
	}
	public void setLastDegree(String lastDegree) {
		this.lastDegree = lastDegree;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public int getDepartment() {
		return department;
	}
	public void setDepartment(int department) {
		this.department = department;
	}
	public Date getGraduationDay() {
		return graduationDay;
	}
	public void setGraduationDay(Date graduationDay) {
		this.graduationDay = graduationDay;
	}
	public String getSchoolOther() {
		return schoolOther;
	}
	public void setSchoolOther(String schoolOther) {
		this.schoolOther = schoolOther;
	}
	public int getEnglishLevel() {
		return englishLevel;
	}
	public void setEnglishLevel(int englishLevel) {
		this.englishLevel = englishLevel;
	}
	public String getSelfAssessment() {
		return selfAssessment;
	}
	public void setSelfAssessment(String selfAssessment) {
		this.selfAssessment = selfAssessment;
	}
	public String getToeic() {
		return toeic;
	}
	public void setToeic(String toeic) {
		this.toeic = toeic;
	}
	public String getToefl() {
		return toefl;
	}
	public void setToefl(String toefl) {
		this.toefl = toefl;
	}
	public String getEtest() {
		return etest;
	}
	public void setEtest(String etest) {
		this.etest = etest;
	}
	public String getRequirements() {
		return requirements;
	}
	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}
	public String getAnnualIncomeNow() {
		return annualIncomeNow;
	}
	public void setAnnualIncomeNow(String annualIncomeNow) {
		this.annualIncomeNow = annualIncomeNow;
	}
	public String getAnnualIncomeHope() {
		return annualIncomeHope;
	}
	public void setAnnualIncomeHope(String annualIncomeHope) {
		this.annualIncomeHope = annualIncomeHope;
	}
	public String getWorkLocation() {
		return workLocation;
	}
	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}
	public int getBachelor() {
		return bachelor;
	}
	public void setBachelor(int bachelor) {
		this.bachelor = bachelor;
	}
	public Date getInaugurationDay() {
		return inaugurationDay;
	}
	public void setInaugurationDay(Date inaugurationDay) {
		this.inaugurationDay = inaugurationDay;
	}
	public Date getTurnoverDay() {
		return turnoverDay;
	}
	public void setTurnoverDay(Date turnoverDay) {
		this.turnoverDay = turnoverDay;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	
	
}