package org.nathalie.calculator.model;

import org.nathalie.calculator.model.Operation.OperationErrorException;

public final class Calc {

	private double prevResult;
	private double currentResult;
	private Operation operation;
	private CalcListener listener;

	public double getResult() {
		return currentResult;
	}

	double getPrevResult() {
		return prevResult;
	}

	void setPrevResult(double prevResult) {
		this.prevResult = prevResult;
	}

	double getCurrentResult() {
		return currentResult;
	}

	void setCurrentResult(double currentResult) {
		boolean changed = this.currentResult != currentResult;

		this.currentResult = currentResult;

		if (changed) {
			resultChanged();
		}
	}

	Operation getOperation() {
		return operation;
	}

	void setOperation(Operation operation) {	
		if (this.operation == null)
		{
			prevResult = currentResult;
			currentResult = 0d;
		}
		this.operation = operation;
	}

	public void input(CalcCommand command) {
		command.exec(this);
	}

	public void setCalcListener(CalcListener listener) {
		this.listener = listener;
	}

	private void resultChanged() {
		if (listener != null) listener.onResultChanged(this);
	}

	private void errorOccured() {
		if (listener != null) listener.onErrorOccured(this);
	}

	void calcEqual() {
		try {
			if (operation != null) operation.perform(this);
		} catch (OperationErrorException ex) {
			errorOccured();
		}
	}

	void clean() {
		currentResult = 0d;
		prevResult = 0d;
		operation = null;
		
		resultChanged();
	}
}
