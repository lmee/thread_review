
public class ThreadGroupList implements Runnable{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadGroup tg =new ThreadGroup("PrintGroup");
		Thread t1 = new Thread(tg,new ThreadGroupList(),"T1");
		Thread t2 = new Thread(tg,new ThreadGroupList(),"T2");
		t1.start();
		t2.start();
		System.out.println(tg.activeCount());
		tg.list();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String groupAndName = Thread.currentThread().getThreadGroup().getName()+"-"+Thread.currentThread().getName();
		while(true){
			System.out.println("I am "+groupAndName);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
