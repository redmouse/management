package beans;

import java.util.ArrayList;
import java.util.List;

public class Disp002Bean {
	private Wk005Bean wk005Bean;
	private List<Wk006Bean> wk006List;
	
	public Disp002Bean(){
		wk005Bean = new Wk005Bean();
		wk006List = new ArrayList<Wk006Bean>();
	}

	public Wk005Bean getWk005Bean() {
		return wk005Bean;
	}

	public void setWk005Bean(Wk005Bean wk005Bean) {
		this.wk005Bean = wk005Bean;
	}

	public List<Wk006Bean> getWk006List() {
		return wk006List;
	}

	public void setWk006List(List<Wk006Bean> wk006List) {
		this.wk006List = wk006List;
	}

	
	

	
}
