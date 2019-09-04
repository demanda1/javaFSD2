package ObjectIO;

import java.io.*;

public class ObjectInputOutputStream {

	public static void main(String[] args) {
		Employee employee = new Employee("10", "sachin", 20000, "mumbai");
		Student student =new Student(10, "John");
		System.out.println("Employee and Student to write is: "+employee);
		
		try {
			FileOutputStream out =new FileOutputStream("employee.out");
			ObjectOutputStream oos=new ObjectOutputStream(out);
			oos.writeObject(student);
			oos.writeObject(employee);
			oos.flush();
		}
		catch (Exception e){
			System.out.println("Problem serializiig: "+e);
		}
		
		try {
			FileInputStream in =new FileInputStream("employee.out");
			ObjectInputStream ois= new ObjectInputStream(in);
			
			Object o= ois.readObject();
			if(o instanceof Employee) {
				Employee e=(Employee)o;
				System.out.println("hi");
			}
			if(o instanceof Student) {
				System.out.println("hello");
			}
		} catch(Exception e) {
			System.out.println("Problem serializing : " +e);
		}
		
		System.out.println("Employee read is:"+ employee);
		
	}
	
}
