
public class PCData {
	private final int intData;
	public PCData(int incrementAndGet) {
		intData = incrementAndGet;
	}
	public PCData(String d){
		intData = Integer.valueOf(d);
	}
	
	public int getData(){
		return intData;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "data"+intData;
	}
}
