
public class ThreadMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Thread.State.BLOCKED);
		
		Thread t =new Thread(){

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				testSwitch("a");
			}
			
		};
		t.start();
		System.out.println(Thread.currentThread().getName());
	}
	
	private static void testSwitch(String test){
		switch(test){
			case "a":
				System.out.println("a");
				break;
			case "b":
				System.out.println("b");
				break;
			case "c":
				System.out.println("c");
				break;
			default:
					break;
			}
	}

}
