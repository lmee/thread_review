import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalDemo {
	static ThreadLocal<SimpleDateFormat> tl = new ThreadLocal<SimpleDateFormat>();
	//private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static class ParseDate implements Runnable{
		int i =0;
		public ParseDate(int i){this.i = i;}
		@Override
		public void run() {
			
			try {
				if(tl.get() == null){
					tl.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
					System.out.println("我被调用了");
				}
				Date t = tl.get().parse("2016-02-29 19:29:"+i%60);
				System.out.println(i+":"+t+"-->"+tl.toString());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(10);
		for(int i =0;i<1000;i++){
			es.execute(new ParseDate(i));
		}
		tl.remove();
	}
}
