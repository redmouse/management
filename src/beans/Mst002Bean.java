package beans;

public class Mst002Bean {
	private int level1Id;
	private int level2Id;
	private String name;

	public Mst002Bean(){
	}
	public Mst002Bean(int Level2Id, int Level1Id, String name){
		setLevel2Id(Level2Id);
		setLevel1Id(Level1Id);
		setName(name);
	}
	
	public int getLevel1Id() {
		return level1Id;
	}
	public void setLevel1Id(int level1Id) {
		this.level1Id = level1Id;
	}
	public int getLevel2Id() {
		return level2Id;
	}
	public void setLevel2Id(int level2Id) {
		this.level2Id = level2Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}