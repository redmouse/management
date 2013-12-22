package beans;

import java.util.ArrayList;
import java.util.List;

public class Disp001Bean {
	Wk001Bean wk001Bean;
	List<Wk004Bean> wk004List;
	public Disp001Bean(){
		wk001Bean = new Wk001Bean();
		wk004List = new ArrayList<Wk004Bean>();
	}
	public Wk001Bean getWk001Bean() {
		return wk001Bean;
	}
	public void setWk001Bean(Wk001Bean wk001Bean) {
		this.wk001Bean = wk001Bean;
	}
	public List<Wk004Bean> getWk004List() {
		return wk004List;
	}
	public void setWk004List(List<Wk004Bean> wk004List) {
		this.wk004List = wk004List;
	}
	
}
