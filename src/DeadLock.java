import java.util.concurrent.locks.ReentrantLock;

public class DeadLock extends Thread {
	protected Object tool;
	static ReentrantLock lock1 = new ReentrantLock();
	static ReentrantLock lock2 = new ReentrantLock();
	static Object fork1 = new Object();
	static Object fork2 = new Object();

	public DeadLock(Object obj) {
		this.tool = obj;
		if (tool == fork1) {
			this.setName("哲学家A");
		}
		if (tool == fork2) {
			this.setName("哲学家B");
		}
	}

	@Override
	public void run() {
		if (tool == fork1) {
			while (true) {
				if (lock1.tryLock()) {
					try {
						// synchronized(fork1){
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if (lock2.tryLock()) {
							try {
								// synchronized (fork2) {
								System.out.println("哲学家A开始吃饭");
								break;
								// }
								// }
							} finally {
								lock2.unlock();
							}
						}
					} finally {
						lock1.unlock();
					}
				}
			}
		}
		if (tool == fork2) {
			while (true) {
				if (lock2.tryLock()) {
					try {
						// synchronized(fork2){
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if (lock1.tryLock()) {
							try {
								// synchronized (fork1) {
								System.out.println("哲学家B开始吃饭");
								break;
							} finally {
								lock1.unlock();
							}
						}
					} finally {
						lock2.unlock();
					}
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		DeadLock 哲学家A = new DeadLock(fork1);
		DeadLock 哲学家B = new DeadLock(fork2);
		哲学家A.start();
		哲学家B.start();
		Thread.sleep(1000);
	}
}
