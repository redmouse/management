package beans;

import java.util.ArrayList;
import java.util.List;

public class LinkageBean {
	List<Mst001Bean> mst001List;
	List<Mst002Bean> mst002List;
	List<Mst003Bean> mst003List;
	int selectedLevel1Id;
	int selectedLevel2Id;
	int selectedLevel3Id;
	
	public LinkageBean(){
		mst001List = new ArrayList<Mst001Bean>();
		mst002List = new ArrayList<Mst002Bean>();
		mst003List = new ArrayList<Mst003Bean>();
		selectedLevel1Id = 0;
		selectedLevel2Id = 0;
		selectedLevel3Id = 0;
	}

	public List<Mst001Bean> getMst001List() {
		return mst001List;
	}

	public void setMst001List(List<Mst001Bean> mst001List) {
		this.mst001List = mst001List;
	}

	public List<Mst002Bean> getMst002List() {
		return mst002List;
	}

	public void setMst002List(List<Mst002Bean> mst002List) {
		this.mst002List = mst002List;
	}

	public List<Mst003Bean> getMst003List() {
		return mst003List;
	}

	public void setMst003List(List<Mst003Bean> mst003List) {
		this.mst003List = mst003List;
	}

	public int getSelectedLevel1Id() {
		return selectedLevel1Id;
	}

	public void setSelectedLevel1Id(int selectedLevel1Id) {
		this.selectedLevel1Id = selectedLevel1Id;
	}

	public int getSelectedLevel2Id() {
		return selectedLevel2Id;
	}

	public void setSelectedLevel2Id(int selectedLevel2Id) {
		this.selectedLevel2Id = selectedLevel2Id;
	}

	public int getSelectedLevel3Id() {
		return selectedLevel3Id;
	}

	public void setSelectedLevel3Id(int selectedLevel3Id) {
		this.selectedLevel3Id = selectedLevel3Id;
	}

	
	
}
