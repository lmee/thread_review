
public class Daemondemo {

	public static class DaemonT extends Thread{
		@Override
		public void run() {
			System.out.println("I am alive");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print("I already alive");
		}
	}
	
	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		Thread t = new DaemonT();
		t.setDaemon(true);
		t.start();
		
		Thread.sleep(2000);
	}

}
