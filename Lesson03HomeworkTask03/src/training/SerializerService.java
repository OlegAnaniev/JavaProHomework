package training;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import training.annotations.Save;

/**
 * Class providing serializing/deserializing functionality 
 * 
 * @version 0.1 21.08.2019
 * @author Oleg
 */
public class SerializerService {	
	
	/**
	 * Serializes object to a given path
	 * 
	 * @param object <code>Object</code>
	 * @param path <code>String</code>
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws IOException
	 */
	public static void serialize(Object object, String path) 
			throws IllegalArgumentException, IllegalAccessException, 
			IOException {
		serialize(object, new File(path));
	}
	
	/**
	 * Serializes object to a given file
	 * 
	 * @param object <code>Object</code>
	 * @param file <code>File</code>
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws IOException
	 */
	public static void serialize(Object object, File file) 
			throws IllegalArgumentException, IllegalAccessException, 
			IOException {		
		try (PrintWriter writer = new PrintWriter(file)) {
			serializeClass(object, writer);
		}
	}
	
	/**
	 * Serializes fields of a class
	 * 
	 * @param object <code>Object</code>
	 * @param writer <code>PrintWriter</code>
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	private static void serializeClass(Object object, PrintWriter writer) 
			throws IllegalArgumentException, IllegalAccessException {
		Class<?> cls = object.getClass();		
		Field[] fields = cls.getDeclaredFields();
		
		for (Field field : fields) {
			if (field.isAnnotationPresent(Save.class)) {
				if (!field.isAccessible()) {
					field.setAccessible(true);
				}				
				
				if (field.getType() == int.class
						|| field.getType() == double.class
						|| field.getType() == String.class) {
					writer.println(field.get(object));
				} else {
					serializeClass(field.get(object), writer);
				}				
			}
		}
	}
	
	/**
	 * Deserializes object of a given class from given path
	 * 
	 * @param cls <code>Class&lt;?&gt;</code>
	 * @param path <code>String</code>
	 * @return <code>Object</code>
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws FileNotFoundException
	 */
	public static Object deserialize(Class<?> cls, String path) 
			throws NoSuchMethodException, SecurityException, 
			InstantiationException, IllegalAccessException, 
			IllegalArgumentException, InvocationTargetException, 
			FileNotFoundException {		
		return deserialize(cls, new File(path));
	}
	
	/**
	 * Deserializes object of a given class from given file
	 * 
	 * @param cls <code>Class&lt;?&gt;</code>
	 * @param file <code>File</code>
	 * @return <code>Object</code>
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws FileNotFoundException
	 */
	public static Object deserialize(Class<?> cls, File file) 
			throws NoSuchMethodException, SecurityException, 
			InstantiationException, IllegalAccessException, 
			IllegalArgumentException, InvocationTargetException, 
			FileNotFoundException {
		try (Scanner scanner = new Scanner(file)) {
			return deserializeClass(cls, scanner);
		}		
	}
	
	/**
	 * Deserializes fields of a class
	 * 
	 * @param cls <code>Class&lt;?&gt;</code>
	 * @param scanner <code>Scanner</code>
	 * @return <code>Object</code>
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	private static Object deserializeClass(Class<?> cls, Scanner scanner) 
			throws NoSuchMethodException, SecurityException, 
			InstantiationException, IllegalAccessException, 
			IllegalArgumentException, InvocationTargetException {
		Constructor<?> constructor = cls.getConstructor();		
		Object object = constructor.newInstance();		
		Field[] fields = cls.getDeclaredFields();
		
		for (Field field : fields) {
			if (field.isAnnotationPresent(Save.class)) {
				if (!field.isAccessible()) {
					field.setAccessible(true);
				}				
				
				if (field.getType() == int.class) {
					field.set(object, Integer.parseInt(scanner.nextLine()));
				} else if (field.getType() == double.class) {
					field.set(object, Double.parseDouble(scanner.nextLine()));
				} else if (field.getType() == String.class) {
					field.set(object, scanner.nextLine());
				} else {
					field.set(object, deserializeClass(field.getType(), 
							scanner));
				}		
			}
		}		
		
		return object;
	}
}