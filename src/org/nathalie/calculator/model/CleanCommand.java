package org.nathalie.calculator.model;

public class CleanCommand extends CalcCommand {

	@Override
	void exec(Calc calc) {
		calc.clean();
	}

}
