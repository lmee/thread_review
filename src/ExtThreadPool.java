import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExtThreadPool {
	public static class MyTask implements Runnable{
		public String name;
		public MyTask(String name) {
			this.name = name;
		}
		@Override
		public void run() {
			System.out.println("正在执行"+":Thread ID:"+Thread.currentThread().getId()+",Task Name="+name);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService es = new ThreadPoolExecutor(5,5,0L,TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>()){
			@Override
			protected void beforeExecute(Thread t, Runnable r) {
				System.out.println("准备执行："+((MyTask)r).name);
			}
			@Override
			protected void afterExecute(Runnable r, Throwable t) {
				System.out.println("执行完成："+((MyTask)r).name);
			}
			@Override
			protected void terminated() {
				// TODO Auto-generated method stub
				System.out.println("线程池退出");
			}
		};
		
		for(int i =0;i<5;i++){
			MyTask task = new MyTask("Task-Geym-"+i);
			es.execute(task);
			Thread.sleep(10);
		}
		es.shutdown();
	}
}
