package example4;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class MyArray {

	private static int size;
	
	public void sortArray(Integer[] arr) {
		Arrays.sort(arr);
		for(int i:arr) {
			System.out.print(i+" ");
		}
		
		Scanner s=new Scanner(System.in);
		int num=s.nextInt();
		if(Arrays.binarySearch(arr, num)<0) {
			System.out.println("not found");
		}
		else
		System.out.println("found at index: "+Arrays.binarySearch(arr, num));
	}
	
	public void fixSize(int size) {
		this.size=size;
	}
	public void pushStack(Stack<Integer> st, int a){
		if(size>0) {
		st.push(a);
		size--;
		System.out.println("Element pushed into stack"+size);
		}
		else {
			System.out.println("stack is full");
			System.exit(0);
		}
		
	}
	
	public String  popStack(Stack<Integer> st) {
		if(size<5) {
			size++;
			return st.pop().toString();
		}
		else {
			return "Stack Underflow";
		}
	}
	

}
