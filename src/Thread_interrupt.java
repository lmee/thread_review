
public class Thread_interrupt {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		Thread t = new Thread(){
//			public void run() {
//				while(true){
//					System.out.println("executing...");
//					//线程内部需要对中断指令做处理
//					if(Thread.currentThread().isInterrupted()){
//						System.out.println("Interrupted by someone!");
//						break;
//					}
//					Thread.yield();
//				}
//			};
//		};
//		t.start();
//		Thread.sleep(2000);
//		t.interrupt();//外部发出终端指令
		Thread t1 = new Thread(){
			public void run() {
				while(true){
					if(Thread.currentThread().isInterrupted()){
						System.out.println("Interrupted");
						break;
					}
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						System.out.println("Interrupted when thread in sleep!");
						Thread.currentThread().interrupt();
					}
				}
			};
		};
		t1.start();
		Thread.sleep(2000);
		t1.interrupt();
	}

}
