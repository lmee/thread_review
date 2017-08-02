
public class PriorityDemo {
	public static class HightPriorityThread extends Thread{
		static int count=0;
		@Override
		public void run() {
			while(true){
				synchronized(PriorityDemo.class){
					count++;
					if(count>10000000){
						System.out.println("HighPriority is complete");
						break;
					}
				}
			}
		}
	}
	
	public static class LowPriorityThread extends Thread{
		static int count =0;
		@Override
		public void run() {
			while(true){
			synchronized(PriorityDemo.class){
				count++;
				if(count>10000000){
					System.out.println("LowPriority is complete");
					break;
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		Thread high = new HightPriorityThread();
		LowPriorityThread low = new LowPriorityThread();
		high.setPriority(Thread.MAX_PRIORITY);
		low.setPriority(Thread.MIN_PRIORITY);
		low.start();
		high.start();
	}
}
