
public class LazySingleton {
	private static int i =0;
	private LazySingleton(){
		System.out.println("LazySingleton is create");
	}
	
	//private static LazySingleton instance = null;
	
	private static class SingletonHold{
		private static final LazySingleton ls = new LazySingleton();
	}
	
	public static  LazySingleton getInstance(){
//		if(instance == null){
//			instance = new LazySingleton();
//		}
		return SingletonHold.ls;
		//return instance;
	}
}
