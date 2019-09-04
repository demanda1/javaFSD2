package comm.example.client;

public class MyDate {
	private int day;
	private int month;
	private int year;
	
	public MyDate() {
		this(10);  //constructor chaining
	}
	
	public MyDate(int day) {
		this(day,20); //constructor chaining
	}
	
	public MyDate (int day, int month) {
		this(day, month,30);  //constructor chaining 
	}
	
	public MyDate(int day, int month, int year) {
		this.day=day;             //constructor chaining
		this.month=month;
		this.year=year;
	}
	
	public int getDay() {
		return day;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}
	
	public boolean setDay(int d) {
		if(d>31) {
			return false;
		}
		return true;
	}
	
	public boolean setMonth(int m) {
		if(m==2 && day>28) {
			return false;
		}
		else if(m>12) {
			return false;
		}
		return true;
	}
	
	public boolean setYear(int y) {
		return true;
	}

}
