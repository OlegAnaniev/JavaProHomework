package training;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;

public class Main {

	public static void main(String[] args) {
		C c = new C(10, 11.5, "C");
		B b = new B(20, 21.5, "B", c);
		A a = new A(30, 31.5, "A", b);
		
		System.out.println(a);
		
		try {
			A loaded = (A) SerializerService.deserialize(A.class, "text.csv");
			System.out.println(loaded);
		} catch (NoSuchMethodException | SecurityException 
				| InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException 
				| FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}