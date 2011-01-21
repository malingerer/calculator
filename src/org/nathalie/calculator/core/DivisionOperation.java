package org.nathalie.calculator.core;


public class DivisionOperation implements Operation {
	
	public double perform(double a, double b)  {
		if (b == 0) {
				System.out.println("Division by zero");
			}
			return a / b;
	}
}