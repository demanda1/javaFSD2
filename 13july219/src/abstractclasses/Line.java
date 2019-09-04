package abstractclasses;

public class Line extends Model{
	private int start;
	private int endpoint;
	
	public Line(int start, int endpoint) {
		this.start=start;
		this.endpoint=endpoint;
	}
	
	
	
	public int getStart() {
		return this.start;
	}



	public void setStart(int start) {
		this.start = start;
	}



	public int getEndpoint() {
		return this.endpoint;
	}



	public void setEndpoint(int endpoint) {
		this.endpoint = endpoint;
	}

	public int calculateLength() {
		return this.getEndpoint()-this.getStart();
	}

	@Override
	public boolean isGreater(Object obj1, Object obj2) {
		// TODO Auto-generated method stub
		Line L1=(Line)obj1;
		Line L2=(Line)obj2;
		
		return L1.calculateLength()>L2.calculateLength();
	}

	@Override
	public boolean isLesser(Object obj1, Object obj2) {
		// TODO Auto-generated method stub
		Line L1=(Line)obj1;
		Line L2=(Line)obj2;
		
		return L1.calculateLength()>L2.calculateLength();
	}

	@Override
	public boolean isequals(Object obj1, Object obj2) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
