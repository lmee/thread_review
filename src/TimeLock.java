import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TimeLock implements Runnable {

	public static ReentrantLock lock = new ReentrantLock();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			if(lock.tryLock(5,TimeUnit.SECONDS)){
				System.out.println(Thread.currentThread().getName()+":I got it");
				Thread.sleep(6000);
			}else{
				System.out.println("get lock failed"+Thread.currentThread().getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(lock.isHeldByCurrentThread()){
				lock.unlock();
			}
		}
	}
	public static void main(String[] args){
		TimeLock tl = new TimeLock();
		Thread t1 = new Thread(tl);
		Thread t2 = new Thread(tl);
		t1.start();
		t2.start();
	}
}
