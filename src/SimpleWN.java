
public class SimpleWN {

		final static Object object = new Object();
		public static class T1 extends Thread{
			@Override
			public void run() {
				synchronized(object){
					System.out.println(System.currentTimeMillis()+"->T1 Start!");
					try {
						object.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(System.currentTimeMillis()+"->T1 End!");;
				}
			}
		}
		
		public static class T2 extends Thread{
			@Override
			public void run() {
				synchronized(object){
					System.out.println(System.currentTimeMillis()+"->T2 Start");
					object.notify();
					System.out.println(System.currentTimeMillis()+"->T2 End");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		public static void main(String[] args) {
			Thread t1 =new T1();
			Thread t2 =new T2();
			t1.start();
			t2.start();
		}
}
