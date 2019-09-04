package example1;

public class AddArgs {

	//for arguments goto properties>run-debug>new> arguments
	public static void main(String args[]) {
		int sum=0;
		for(String arg:args) {
			try {
				System.out.println(args[1]);
				sum+=Integer.parseInt(arg);
				//nested try
				try {
					
				}catch(Exception e) {
					
				}
			}
			catch(NumberFormatException nfe) {
				//nfe is the object of the number format exception
				System.err.println("Number format Exception occured");
				//nfe.printStackTrace();
				//System.out.println("get cause--> "+nfe.getCause().toString());
				System.out.println("get message--> "+nfe.getMessage());
				//System.exit(0);
			}
			catch(ArrayIndexOutOfBoundsException ae) {
				System.err.println("array index out of bound exception");
			}
			/*catch(Exception e) {
				System.err.println("exception occured");
			}*/
			finally {
				System.out.println("finally block called");
			}
		}
		System.out.println(sum);
		
		//only try and finally
		try {
			
		}
		finally {
			
		}
	}

}
