package beans;

public class Mst003Bean {
	private int level2Id;
	private int level3Id;
	private String name;

	public Mst003Bean(){
	}
	public Mst003Bean(int Level3Id, int Level2Id, String name){
		setLevel3Id(Level3Id);
		setLevel2Id(Level2Id);
		setName(name);
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}