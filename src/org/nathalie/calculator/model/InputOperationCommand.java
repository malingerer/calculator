package org.nathalie.calculator.model;

class InputOperationCommand extends CalcCommand {

	private final Operation operation;

	public InputOperationCommand(Operation operation) {
		if (operation == null) throw new NullPointerException();
		this.operation = operation;
	}

	@Override
	void exec(Calc calc) {
		calc.setOperation(operation);
	}

}
