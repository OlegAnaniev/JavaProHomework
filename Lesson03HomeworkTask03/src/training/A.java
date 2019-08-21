package training;

import training.annotations.Save;

/**
 * Sample class
 * 
 * @version 0.1 21.08.2019
 * @author Oleg
 */
public class A {
	@Save
	private int a;
	private double b;
	@Save
	private String c;
	@Save
	private B d;
	
	/**
	 * Default constructor
	 */
	public A() {
		super();
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param a <code>int</code>
	 * @param b <code>double</code>
	 * @param c <code>String</code>
	 * @param d <code>B</code>
	 */
	public A(int a, double b, String c, B d) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	/**
	 * Gets a
	 * 
	 * @return <code>int</code>
	 */
	public int getA() {
		return a;
	}
	
	/**
	 * Sets a
	 * 
	 * @param a <code>int</code>
	 */
	public void setA(int a) {
		this.a = a;
	}

	/**
	 * Gets b
	 *  
	 * @return <code>double</code>
	 */
	public double getB() {
		return b;
	}

	/**
	 * Sets b
	 * 
	 * @param b <code>double</code>
	 */
	public void setB(double b) {
		this.b = b;
	}

	/**
	 * Gets c
	 * 
	 * @return <code>String</code>
	 */
	public String getC() {
		return c;
	}

	/**
	 * Sets c
	 * 
	 * @param c <code>String</code>
	 */
	public void setC(String c) {
		this.c = c;
	}

	/**
	 * Gets d
	 * 
	 * @return <code>B</code>
	 */
	public B getD() {
		return d;
	}

	/**
	 * Sets d
	 * 
	 * @param d <code>B</code>
	 */
	public void setD(B d) {
		this.d = d;
	}

	@Override
	public String toString() {
		return "A [a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + "]";
	}	
}