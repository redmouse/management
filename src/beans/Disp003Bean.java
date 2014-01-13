package beans;


public class Disp003Bean {
	private Wk004Bean wk004Bean;
	private Wk001Bean wk001Bean;
	
	public Disp003Bean(){
		wk004Bean = new Wk004Bean();
		wk001Bean = new Wk001Bean();
	}

	public Wk004Bean getWk004Bean() {
		return wk004Bean;
	}

	public void setWk004Bean(Wk004Bean wk004Bean) {
		this.wk004Bean = wk004Bean;
	}

	public Wk001Bean getWk001Bean() {
		return wk001Bean;
	}

	public void setWk001Bean(Wk001Bean wk001Bean) {
		this.wk001Bean = wk001Bean;
	}
	
	
	
}
