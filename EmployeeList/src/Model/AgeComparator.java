package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;

public class AgeComparator implements Comparator{

	public AgeComparator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Object o1, Object o2)  {
		// TODO Auto-generated method stub
		Employee emp1=(Employee)o1;
		Employee emp2=(Employee)o2;
		SimpleDateFormat  sdfo = new SimpleDateFormat("yyyy-MM-dd"); 
		
		if(emp1.getAge()==emp2.getAge()) {
			try {
				if(emp1.getDateOfJoining().before(emp2.getDateOfJoining()))
					return -1;
				
			    else if(emp1.getDateOfJoining().after(emp2.getDateOfJoining()))
					return 1;
			    else
			    	return 0;
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return 0;
			
		}
		else if(emp1.getAge()>emp2.getAge()) {
			return 1;
		}
		else {
			return-1;
		}
	}

	

}
