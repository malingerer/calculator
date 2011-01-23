package org.nathalie.calculator.model;

class EqualCommand extends CalcCommand {

	@Override
	void exec(Calc calc) {
		calc.calcEqual();
	}

}
