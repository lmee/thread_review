import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TraceThreadPoolExecutor extends ThreadPoolExecutor {

	public TraceThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
		// TODO Auto-generated constructor stub
	}
	
		@Override
		public void execute(Runnable command) {
			// TODO Auto-generated method stub
			super.execute(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						command.run();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						clientTrace().printStackTrace();
						throw e;
					}
				}
				
			});
		}
		
		@Override
		public <T> Future<T> submit(Callable<T> task) {
			
			return super.submit(() -> {
				try {
					return task.call();
				} catch (Exception e) {
					clientTrace().printStackTrace();
					throw e;
				}
			});
		}
		
		private Exception clientTrace(){
			return new Exception("Client stack trace");
		}
		
	static class DivTask implements Runnable{
		int a,b;
		public DivTask(int a,int b){
			this.a = a;
			this.b = b;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			double re = a/b;
			System.out.println(re);
		}
		
	}
		
		public static void main(String[] args) {
			//ThreadPoolExecutor pools = new TraceThreadPoolExecutor(0,Integer.MAX_VALUE,0L,TimeUnit.SECONDS,new SynchronousQueue<Runnable>());
			ThreadPoolExecutor pools = new ThreadPoolExecutor(0,Integer.MAX_VALUE,0L,TimeUnit.SECONDS,new SynchronousQueue<Runnable>());
			for(int i=0;i<5;i++){
				pools.execute(new DivTask(100,i));
			}
		}
}
