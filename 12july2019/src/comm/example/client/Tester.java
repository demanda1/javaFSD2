package comm.example.client;
import comm.example.MyDate;
public class Tester {

	public static void main(String args[]) {
	comm.example.MyDate myDate=new MyDate();
	comm.example.client.MyDate mD1=new comm.example.client.MyDate();
	System.out.println(myDate.getDetails());
	System.out.println(mD1.getDay());
	
        comm.example.MyDate d=new MyDate();
		comm.example.client.MyDate myD =new comm.example.client.MyDate();
		d.createDate(108, 10, 1998);
		System.out.println(d.getDetails());       
		System.out.println(myD.setDay(myD.getDay()+1));
		System.out.println(myD.setMonth(13));
		System.out.println(myD.getDay());
		System.out.println(myD.getMonth());
		System.out.println(myD.getYear());
//		
//		
	}
}
