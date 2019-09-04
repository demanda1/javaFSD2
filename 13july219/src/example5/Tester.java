package example5;

public class Tester {

 	public static void main(String args[]) {
 		Tester t=new Tester();
		int myArray[][]=new int[4][];
		myArray[0]=new int[4];  //jagged array
		myArray[1]=new int[10];
		
		System.out.println(t.add(1,2,3,4,5,6,7,8));
	}
 	
 	//method overloading
// 	public int add() {
// 		
// 		return 0;
// 	}
// 	
// 	public int add(int a, int b) {
// 		
// 		return a+b;
// 	}
 	
 	public int add(int... var) {
 		int result=0;
 		for(int i:var) {
 			result+=i;
 		}
 		return result;
 	}
 	

}
