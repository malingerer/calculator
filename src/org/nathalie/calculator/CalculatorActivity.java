package org.nathalie.calculator;

import org.nathalie.calculator.core.Calculator;
import org.nathalie.calculator.model.Calc;
import org.nathalie.calculator.model.CalcCommand;
import org.nathalie.calculator.model.CalcListener;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class CalculatorActivity extends Activity {
	private static final String LOG_TAG = CalculatorActivity.class.getSimpleName();

	private Calc c;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test);
		new Calculator();

		c = new Calc();
		c.setCalcListener(new CalcListener() {

			public void onResultChanged(Calc calc) {
				((TextView) findViewById(R.id.entry)).setText(String.valueOf((int) calc.getResult()));
			}

			public void onErrorOccured(Calc calc) {
				((TextView) findViewById(R.id.entry)).setText("ERROR");
			}

			public void onErrorCleaned(Calc calc) {
				// TODO Auto-generated method stub

			}
		});
	}

	public void onPress(View v) {
		switch (v.getId()) {
		case R.id.btn_ce:
			c.input(CalcCommand.CLEAN);
			break;
		case R.id.btn_0:
			c.input(CalcCommand.DIGIT_ZERO);
			break;
		case R.id.btn_1:
			c.input(CalcCommand.DIGIT_ONE);
			break;
		case R.id.btn_2:
			c.input(CalcCommand.DIGIT_TWO);
			break;
		case R.id.btn_3:
			c.input(CalcCommand.DIGIT_THREE);
			break;
		case R.id.btn_4:
			c.input(CalcCommand.DIGIT_FOUR);
			break;
		case R.id.btn_5:
			c.input(CalcCommand.DIGIT_FIVE);
			break;
		case R.id.btn_6:
			c.input(CalcCommand.DIGIT_SIX);
			break;
		case R.id.btn_7:
			c.input(CalcCommand.DIGIT_SEVEN);
			break;
		case R.id.btn_8:
			c.input(CalcCommand.DIGIT_EIGHT);
			break;
		case R.id.btn_9:
			c.input(CalcCommand.DIGIT_NINE);
			break;
		case R.id.btn_minus:
			c.input(CalcCommand.SUBSTRACTION);
			break;
		case R.id.btn_plus:
			c.input(CalcCommand.ADDITION);
			break;
		case R.id.btn_mult:
			c.input(CalcCommand.MULTIPLICATION);
			break;
		case R.id.btn_div:
			c.input(CalcCommand.DIVISION);
			break;
		case R.id.btn_equal:
			c.input(CalcCommand.EQUAL);
			break;
		}

		Log.d(LOG_TAG, "button " + v + " clicked");
	}
}
