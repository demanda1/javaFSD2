package example4;

import java.util.*;
public class Tester5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer arr[]= { 100,1,-20,30,0};
		MyArray m=new MyArray();
		m.sortArray(arr);
		
		Stack<Integer> myStack = new Stack<Integer>();
		int size=5;
		m.fixSize(size);
		
		Scanner s= new Scanner(System.in);
		for(int i=0;i<5;i++) {
		int num= s.nextInt();
		m.pushStack(myStack, num);
		}
		for(int i=0;i<7;i++) {
		System.out.println(m.popStack(myStack));	
		}
		
		
	}

}
