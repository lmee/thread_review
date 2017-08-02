import java.util.ArrayList;
import java.util.List;

public class FuncDeclare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] iArr = {1,3,5,7,9,9,4,5,6};
//		Arrays.stream(iArr).map((x)->x=x+1).forEach(System.out::print);
//		System.out.println();
//		Arrays.stream(iArr).map(x->(x%2==0?x:x+1)).forEach(System.out::print);
//		System.out.println();
//		Arrays.stream(iArr).forEach(System.out::print);
//		List<Integer>numbers =  Arrays.stream( iArr ).boxed().collect(Collectors.toList());
//		System.out.println();
//		numbers.forEach((Integer value)->System.out.print(value));
//		List<User> users = new ArrayList<User>();
//		for(int i=1;i<10;i++){
//			users.add(new User(i,"billy"+Integer.toString(i)));
//		}
//		users.stream().map(User::getName).forEach(System.out::println);
		List<Double>numbers = new ArrayList<Double>();
		for(int i=1;i<10;i++){
			numbers.add(Double.valueOf(i));
		}
		//numbers.stream().map(Double::toString).forEach(System.out::println);
	}

}
