package example4;

public enum Level {
	HIGH(3),
	MEDIUM(2),
	LOW(1);
	
	public int LevelCode;
	private Level(int LevelCode) {
		System.out.println(LevelCode);
		this.LevelCode=LevelCode;
		System.out.println();
	}
	public int getLevelCode() {
		return LevelCode;
	}
}
