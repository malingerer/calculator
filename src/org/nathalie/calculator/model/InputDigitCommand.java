package org.nathalie.calculator.model;

class InputDigitCommand extends CalcCommand {

	enum Digit {
		ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN;
	}

	private final Digit digit;

	InputDigitCommand(Digit digit) {
		if (digit == null) throw new NullPointerException();
		this.digit = digit;
	}

	@Override
	void exec(Calc calc) {
		double currentResult = calc.getCurrentResult();
		double newResult = currentResult * 10d + digit.ordinal();

		calc.setCurrentResult(newResult);
	}

}
