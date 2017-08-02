import java.util.concurrent.locks.ReentrantLock;

public class IntLock implements Runnable {
	public static ReentrantLock lock1 = new ReentrantLock();
	public static ReentrantLock lock2 = new ReentrantLock();
	int lock;
	
	public IntLock(int lock){
		this.lock = lock;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			if(lock == 1){
				lock1.lockInterruptibly();//获得锁，但优先响应中断
				Thread.sleep(500);
				lock2.lockInterruptibly();
			}else{
				lock2.lockInterruptibly();
				Thread.sleep(500);
				lock1.lockInterruptibly();
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			if(lock1.isHeldByCurrentThread())
				lock1.unlock();
			if(lock2.isHeldByCurrentThread())
				lock2.unlock();
			System.out.println(Thread.currentThread().getId()+"线程退出");
		}
	}
	public static void main(String[] args) throws Exception{
		IntLock r1 = new IntLock(1);
		IntLock r2 = new IntLock(2);
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();t2.start();
		Thread.sleep(1000);
		t2.interrupt();
	}
}
