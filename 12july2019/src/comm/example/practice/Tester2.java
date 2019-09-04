package comm.example.practice;

public class Tester2 {
	public static void main(String args[]) {
		Employee pemp=new PermanentEmployee();
		Employee cemp=new ContractualEmployee();
		System.out.println(pemp.getDetails());
		System.out.println(cemp.getDetails());
	}
}
