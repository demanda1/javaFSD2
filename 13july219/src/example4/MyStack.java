package example4;

import java.util.Stack;

public class MyStack {

	private Stack stack;
	
	public MyStack(int size) {
		stack=new Stack();
		stack.setSize(10);
	}
	
	public void myStackPush(int item) {
		if(stack.size()==10) {
			System.out.println("Stack is full");
		}
		else {
			stack.push(item);
		}
	}

}
