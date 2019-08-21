package training;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import training.annotations.SaveTo;
import training.annotations.Saver;

/**
 * Class containing some text
 * 
 * @version 0.1 21.08.2019
 * @author Oleg
 */
@SaveTo(path = "test.txt")
public class TextContainer {
	private String text;

	/**
	 * Default constructor
	 */
	public TextContainer() {
		super();
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param text <code>String</code>
	 */
	public TextContainer(String text) {
		super();
		this.text = text;
	}

	/**
	 * Gets text
	 * 
	 * @return <code>String</code>
	 */
	public String getText() {
		return text;
	}

	
	/**
	 * Sets text
	 * 
	 * @param text <code>String</code>
	 */
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "TextContainer [text=" + text + "]";
	}
	
	/**
	 * Method saving text to given path
	 * 
	 * @param path <code>String</code>
	 * @throws FileNotFoundException
	 */
	@Saver
	public void save(String path) throws FileNotFoundException {
		try(PrintWriter writer = new PrintWriter(new File(path))) {
			writer.println(text);
		}		
	}
}