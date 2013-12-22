package beans;

public class Mst001Bean {
	private int level1Id;
	private String name;

	
	public Mst001Bean(){
	}
	public Mst001Bean(int Level1Id, String name){
		setLevel1Id(Level1Id);
		setName(name);
	}
	
	public int getLevel1Id() {
		return level1Id;
	}
	public void setLevel1Id(int level1Id) {
		this.level1Id = level1Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}