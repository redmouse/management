package beans;


public class SearchBean {
	private Wk001Bean wk001Bean;
	private LinkageBean linkageBean;
	
	public SearchBean(){
		wk001Bean = new Wk001Bean();
		linkageBean = new LinkageBean();
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

	
}
