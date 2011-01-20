package org.nathalie.calculator;

class DivisionOperation implements Operation {
	
	public double perform(double a, double b) throws IncorectOperationException {
		if (b == 0) {
				throw new IncorectOperationException("Division by zero");
			}
			return a / b;
	}
}