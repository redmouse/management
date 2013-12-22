package beans;

import java.sql.Date;

public class Wk004Bean {
	private int dataId;
	private int mainId;
	public String hopePosition;
	private String forBusiness;
	private Date introductionDay;
	private Date interviewDay;
	public int getMainId() {
		return mainId;
	}
	public void setMainId(int mainId) {
		this.mainId = mainId;
	}
	public int getDataId() {
		return dataId;
	}
	public void setDataId(int dataId) {
		this.dataId = dataId;
	}
	public String getHopePosition() {
		return hopePosition;
	}
	public void setHopePosition(String hopePosition) {
		this.hopePosition = hopePosition;
	}
	public String getForBusiness() {
		return forBusiness;
	}
	public void setForBusiness(String forBusiness) {
		this.forBusiness = forBusiness;
	}
	public Date getIntroductionDay() {
		return introductionDay;
	}
	public void setIntroductionDay(Date introductionDay) {
		this.introductionDay = introductionDay;
	}
	public Date getInterviewDay() {
		return interviewDay;
	}
	public void setInterviewDay(Date interviewDay) {
		this.interviewDay = interviewDay;
	}
	
	
}