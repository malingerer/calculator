package org.nathalie.calculator.model;

public interface CalcListener {

	void onResultChanged(Calc calc);

	void onErrorOccured(Calc calc);

	void onErrorCleaned(Calc calc);

}
