import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadFactoryDemo implements Runnable {
	public static void main(String[] args) throws InterruptedException {
		ThreadFactoryDemo task = new ThreadFactoryDemo();
		ExecutorService es = new ThreadPoolExecutor(5, 5, 0L,TimeUnit.MICROSECONDS, new SynchronousQueue<Runnable>(), new ThreadFactory() {
			@Override
			public Thread newThread(Runnable r) {
				// TODO Auto-generated method stub
				Thread t = new Thread(r);
				t.setDaemon(true);
				System.out.println("create "+t);
				return t;
			}
		});
		for(int i=0;i<5;i++){
			es.submit(task);
		}
		Thread.sleep(2000);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getId());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
