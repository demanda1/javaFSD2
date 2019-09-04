package example6;

public class OuterClass {

	private int x;
	private int y;
	
	public OuterClass() {
		// TODO Auto-generated constructor stub
	}

	public OuterClass(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public void outerMethod(int i) {
		System.out.println("calling method from inner class "+ i);
	}
	
	public class InnerClass {
		public void innerMethod() {
			x=10;
			y=20;
			outerMethod(1);
		}
		public class InnerClass2{
			public void innerMethod() {
				x=10;
				y=20;
				outerMethod(2);
			}
		}
	}

}
