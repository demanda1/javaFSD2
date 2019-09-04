package example4;

public class test2 {
	private Level level;
	public static void main(String args[]) {
		test2 t=new test2();
		t.calls();
	}
	public void calls() {
		System.out.println(Level.MEDIUM);
		System.out.println(Level.HIGH);
		level=Level.HIGH;
	}
}
