package example3;

public class ArrayDemo {
	
	private char arr[];
	public ArrayDemo() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public char[] getArr() {
		return arr;
	}



	public void setArr(char[] arr) {
		this.arr = arr;
	}


  ///Dynamic array length
	public void createArray(int length) {
		arr= new char[length];
		for(int i=0;i<arr.length;i++) {
			arr[i]=(char)('A'+i);
		}
	}
	

}
