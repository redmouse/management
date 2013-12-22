package beans;

import java.util.ArrayList;
import java.util.List;

public class DetailBean {
	private Wk001Bean wk001Bean;
	private LinkageBean linkageBean;
	private List<Wk002Bean> wk002List;
	private List<Wk003Bean> wk003List;
	private List<Wk004Bean> wk004List;
	private List<String> fileNameList;
	String optType;  // add, modify
	
	public DetailBean(){
		wk001Bean = new Wk001Bean();
		linkageBean = new LinkageBean();
		wk002List = new ArrayList<Wk002Bean>();
		wk003List = new ArrayList<Wk003Bean>();
		wk004List = new ArrayList<Wk004Bean>();
		fileNameList = new ArrayList<String>();
		optType = "add";
	}

	
	
	public String getOptType() {
		return optType;
	}



	public void setOptType(String optType) {
		this.optType = optType;
	}



	public List<String> getFileNameList() {
		return fileNameList;
	}



	public void setFileNameList(List<String> fileNameList) {
		this.fileNameList = fileNameList;
	}



	public Wk001Bean getWk001Bean() {
		return wk001Bean;
	}

	public void setWk001Bean(Wk001Bean wk001Bean) {
		this.wk001Bean = wk001Bean;
	}

	public LinkageBean getLinkageBean() {
		return linkageBean;
	}

	public void setLinkageBean(LinkageBean linkageBean) {
		this.linkageBean = linkageBean;
	}

	public List<Wk002Bean> getWk002List() {
		return wk002List;
	}

	public void setWk002List(List<Wk002Bean> wk002List) {
		this.wk002List = wk002List;
	}

	public List<Wk003Bean> getWk003List() {
		return wk003List;
	}

	public void setWk003List(List<Wk003Bean> wk003List) {
		this.wk003List = wk003List;
	}

	public List<Wk004Bean> getWk004List() {
		return wk004List;
	}

	public void setWk004List(List<Wk004Bean> wk004List) {
		this.wk004List = wk004List;
	}

	
	
}
