
public class VolatileThread {
	static volatile int i=0;
	
	public static class PlusTask implements Runnable{

		@Override
		public void run() {
			for(int k =0;k<10000;k++){
				i++;
			}
			
		}
		
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread[]threads = new Thread[10];
		for(int i=0;i<10;i++){
			threads[i]=new Thread(new PlusTask());
			threads[i].start();
			//threads[i].join();//如果是在这个地方添加,主线程会一直等第一个线程执行完才会去执行第二个线程。
		}
		
		for(int i =0;i<10;i++){
			threads[i].join();
		}
		System.out.println(i);
	}

}
