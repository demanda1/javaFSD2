package example6;

import example6.OuterClass.InnerClass;

public class Tester {

	public static void main(String args[]) {
		// TODO Auto-generated constructor stub
		OuterClass oc=new OuterClass();
		oc.outerMethod(100);
		OuterClass.InnerClass ic =oc.new InnerClass();
		ic.innerMethod();
		OuterClass.InnerClass.InnerClass2 ic2=ic.new InnerClass2();
		ic2.innerMethod();
	}

}
