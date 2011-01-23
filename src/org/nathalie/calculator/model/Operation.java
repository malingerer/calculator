package org.nathalie.calculator.model;

abstract class Operation {

	static class OperationErrorException extends Exception {

		/**
		 * 
		 */
		private static final long serialVersionUID = -1721235222111134474L;

	}

	static final Operation ADD = new OperationAdd();
	static final Operation SUB = new OperationSub();
	static final Operation MUL = new OperationMul();
	static final Operation DIV = new OperationDiv();

	final void perform(Calc calc) throws OperationErrorException {
		double currentResult = calc.getCurrentResult();
		double newResult = onPerform(calc.getPrevResult(), currentResult);
		calc.setPrevResult(currentResult);
		calc.setCurrentResult(newResult);
	}

	abstract double onPerform(double first, double second) throws OperationErrorException;

	private static class OperationAdd extends Operation {

		@Override
		double onPerform(double first, double second) throws OperationErrorException {
			return first + second;
		}

	}

	private static class OperationSub extends Operation {

		@Override
		double onPerform(double first, double second) throws OperationErrorException {
			return first - second;
		}

	}

	private static class OperationMul extends Operation {

		@Override
		double onPerform(double first, double second) throws OperationErrorException {
			return first * second;
		}

	}

	private static class OperationDiv extends Operation {

		@Override
		double onPerform(double first, double second) throws OperationErrorException {
			if (second == 0d) throw new OperationErrorException();
			return first / second;
		}

	}

}
