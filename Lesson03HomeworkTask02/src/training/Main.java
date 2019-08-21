package training;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import training.annotations.SaveTo;
import training.annotations.Saver;

public class Main {

	public static void main(String[] args) {
		TextContainer container = new TextContainer("test");
		Class<?> cls = container.getClass();		
		String path;		
		
		if (cls.isAnnotationPresent(SaveTo.class)) {
			path = cls.getAnnotation(SaveTo.class).path();
			
			Method[] methods = cls.getDeclaredMethods();
			
			for (Method method : methods) {
				if (method.isAnnotationPresent(Saver.class)) {
					try {
						method.invoke(container, path);
					} catch (IllegalAccessException | IllegalArgumentException 
							| InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}			
		}
	}
}