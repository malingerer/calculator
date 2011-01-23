package org.nathalie.calculator.model;

import org.nathalie.calculator.model.InputDigitCommand.Digit;

public abstract class CalcCommand {

	public static final CalcCommand CLEAN = new CleanCommand();

	public static final CalcCommand DIGIT_ZERO = new InputDigitCommand(Digit.ZERO);
	public static final CalcCommand DIGIT_ONE = new InputDigitCommand(Digit.ONE);
	public static final CalcCommand DIGIT_TWO = new InputDigitCommand(Digit.TWO);
	public static final CalcCommand DIGIT_THREE = new InputDigitCommand(Digit.THREE);
	public static final CalcCommand DIGIT_FOUR = new InputDigitCommand(Digit.FOUR);
	public static final CalcCommand DIGIT_FIVE = new InputDigitCommand(Digit.FIVE);
	public static final CalcCommand DIGIT_SIX = new InputDigitCommand(Digit.SIX);
	public static final CalcCommand DIGIT_SEVEN = new InputDigitCommand(Digit.SEVEN);
	public static final CalcCommand DIGIT_EIGHT = new InputDigitCommand(Digit.EIGHT);
	public static final CalcCommand DIGIT_NINE = new InputDigitCommand(Digit.NINE);

	public static final CalcCommand ADDITION = new InputOperationCommand(Operation.ADD);
	public static final CalcCommand SUBSTRACTION = new InputOperationCommand(Operation.SUB);
	public static final CalcCommand MULTIPLICATION = new InputOperationCommand(Operation.MUL);
	public static final CalcCommand DIVISION = new InputOperationCommand(Operation.DIV);

	public static final CalcCommand EQUAL = new EqualCommand();

	abstract void exec(Calc calc);

}
