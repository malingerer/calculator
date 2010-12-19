package org.nathalie.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class CalculatorActivity extends Activity {
	private static final String LOG_TAG = CalculatorActivity.class
			.getSimpleName();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test);
	}

	public void onPress(View v) {
		TextView etext = (TextView) this.findViewById(R.id.entry);
		switch (v.getId()) {
		case R.id.btn_ce:
			etext.setText(etext.getText() + "CE");
			break;
		case R.id.btn_0:
			etext.setText(etext.getText() + "0");
			break;
		case R.id.btn_1:
			etext.setText(etext.getText() + "1");
			break;
		case R.id.btn_2:
			etext.setText(etext.getText() + "2");
			break;
		case R.id.btn_3:
			etext.setText(etext.getText() + "3");
			break;
		case R.id.btn_4:
			etext.setText(etext.getText() + "4");
			break;
		case R.id.btn_5:
			etext.setText(etext.getText() + "5");
			break;
		case R.id.btn_6:
			etext.setText(etext.getText() + "6");
			break;
		case R.id.btn_7:
			etext.setText(etext.getText() + "7");
			break;
		case R.id.btn_8:
			etext.setText(etext.getText() + "8");
			break;
		case R.id.btn_9:
			etext.setText(etext.getText() + "9");
			break;
		case R.id.btn_minus:
			etext.setText(etext.getText() + "-");
			break;
		case R.id.btn_plus:
			etext.setText(etext.getText() + "+");
			break;
		case R.id.btn_mult:
			etext.setText(etext.getText() + "*");
			break;
		case R.id.btn_div:
			etext.setText(etext.getText() + "/");
			break;
		case R.id.btn_equal:
			etext.setText(etext.getText() + "=");
			break;
		}

		Log.d(LOG_TAG, "button " + v + " clicked");

	}
}