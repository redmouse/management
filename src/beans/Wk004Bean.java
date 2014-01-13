package beans;

import java.sql.Date;

public class Wk004Bean {
	private int dataId;
	private int mainId;
	public String hopePosition;
	private String forBusiness;
	private Date introductionDay;
	private Date interviewDay;
	private Date inaugurationDay;
	private Date turnoverDay;
	private int fee;
	
	// テーブル以外の項目
	// 手数料画面のため、氏名をこのＢｅａｎに格納する。
	// 本来、Disp003Beanのように、Wk004Bean.* + Wk001Bean.nameにする。
	private String name;
	
	// 画面表示用
	private String dispFee;
	
	public String getDispFee() {
		return dispFee;
	}
	public void setDispFee(String dispFee) {
		this.dispFee = dispFee;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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


	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
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