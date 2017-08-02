
public class AccountingVol implements Runnable {
	static AccountingVol instance = new  AccountingVol();
	static volatile int i =0;
	
	//静态方法使用synchronized关键字将会获得当前类的锁
	public static synchronized void increase(){
		i++;
	}
	//非静态方法使用synchronized关键字将会获得当前类实例的锁
//	public synchronized void increase(){
//		i++;
//	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int j =0;j<1000000;j++){
			//synchronized(instance){//synchronize代码块必须在线程内使用才会生效，起到同步作用
				increase();
			//}
			
		}
	}
	public static void main(String[] args) throws InterruptedException{
		//Thread t1 = new Thread(instance);
		//Thread t2 = new Thread(instance);
		Thread t1 = new Thread(new  AccountingVol());
		Thread t2 = new Thread(new  AccountingVol());
		t1.start();t2.start();
		t1.join();t2.join();
		System.out.println(i);
	}

}
