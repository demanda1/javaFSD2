package example;

public class Monkey implements LivingThings{

	private String name;
	
	public Monkey(String name) {
		this.name=name;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void walk() {
		// TODO Auto-generated method stub
		System.out.println("MOnkey"+getName()+"Can Also walk");
	}

	
}
