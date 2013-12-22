package beans;

import java.sql.Date;


public class Wk006Bean {
	private int infoId;
	private int tradeId;
	private Date receptionDay;
	private String quantity;
	public String occupation;
	public String workLocation;
	public String period;
	public String wage;
	public String conditions;
	public String place;
	public String recruitmentFrom;
	public String recruitmentOwn;
	public int mainId;
	public int getInfoId() {
		return infoId;
	}
	public void setInfoId(int infoId) {
		this.infoId = infoId;
	}
	public int getTradeId() {
		return tradeId;
	}
	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}
	public Date getReceptionDay() {
		return receptionDay;
	}
	public void setReceptionDay(Date receptionDay) {
		this.receptionDay = receptionDay;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getWorkLocation() {
		return workLocation;
	}
	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getWage() {
		return wage;
	}
	public void setWage(String wage) {
		this.wage = wage;
	}
	public String getConditions() {
		return conditions;
	}
	public void setConditions(String conditions) {
		this.conditions = conditions;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getRecruitmentFrom() {
		return recruitmentFrom;
	}
	public void setRecruitmentFrom(String recruitmentFrom) {
		this.recruitmentFrom = recruitmentFrom;
	}
	public String getRecruitmentOwn() {
		return recruitmentOwn;
	}
	public void setRecruitmentOwn(String recruitmentOwn) {
		this.recruitmentOwn = recruitmentOwn;
	}
	public int getMainId() {
		return mainId;
	}
	public void setMainId(int mainId) {
		this.mainId = mainId;
	}
	
}