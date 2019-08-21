package training;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import training.annotations.Test;

public class Main {

	public static void main(String[] args) {
		Class<?> cls = Main.class;
		Method[] methods = cls.getDeclaredMethods();
		Test annotation;
		
		for (Method method : methods) {			
			if (method.isAnnotationPresent(Test.class)) {
				annotation = method.getAnnotation(Test.class);
				try {
					method.invoke(null, annotation.a(), annotation.b());
				} catch (IllegalAccessException | IllegalArgumentException 
						| InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Test(a = 5, b = 10)
	private static void test(int a, int b) {
		System.out.println(a);
		System.out.println(b);
	}
}