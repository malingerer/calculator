package org.nathalie.calculator;

import org.nathalie.calculator.core.Calculator;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class CalculatorActivity extends Activity {
	private static final String LOG_TAG = CalculatorActivity.class
			.getSimpleName();

	private Calculator calc;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test);
		calc = new Calculator();
	}


	public void onPress(View v) {
		TextView etext = (TextView) this.findViewById(R.id.entry);
		
		calc.init(v, etext);
		calc.input();
		
		
	/*	switch (v.getId()) {
		case R.id.btn_ce:
			CleanInput(etext);
			break;
		case R.id.btn_0:
			etext.setText(etext.getText() + "0");
			str += "0";
			break;
		case R.id.btn_1:
			etext.setText(etext.getText() + "1");
			str += "1";
			break;
		case R.id.btn_2:
			etext.setText(etext.getText() + "2");
			str += "2";
			break;
		case R.id.btn_3:
			etext.setText(etext.getText() + "3");
			str += "3";
			break;
		case R.id.btn_4:
			etext.setText(etext.getText() + "4");
			str += "4";
			break;
		case R.id.btn_5:
			etext.setText(etext.getText() + "5");
			str += "5";
			break;
		case R.id.btn_6:
			etext.setText(etext.getText() + "6");
			str += "6";
			break;
		case R.id.btn_7:
			etext.setText(etext.getText() + "7");
			str += "7";
			break;
		case R.id.btn_8:
			etext.setText(etext.getText() + "8");
			str += "8";
			break;
		case R.id.btn_9:
			etext.setText(etext.getText() + "9");
			str += "9";
			break;
		case R.id.btn_minus:
			result = Calc(str, '-');
			str = "";	
			break;
		case R.id.btn_plus:
			result = Calc(str, '+');
			str = "";
			etext.setText("");
			System.out.println(result);
			break;
		case R.id.btn_mult:
			result = Calc(str, '*');	
			str = "";
			break;
		case R.id.btn_div:
			result = Calc(str, '/');
			str = "";
			break;
		case R.id.btn_equal:
			etext.setText("");
			result = Calc(str, '=');	
			etext.setText(String.valueOf(result));	
			break;
		}*/ 

		Log.d(LOG_TAG, "button " + v + " clicked");

	}
	/*public void CleanInput(TextView tv){
		tv.setText("");
	}
	
	public void saveNumber(String number)
	{
		this.number = Double.parseDouble(number);
	}
	
	
	public void InnerCalc()
	{
		if (plus)
		{
			AdditionOperation add = new AdditionOperation();
			if (this.tmp != 0)
			{
				this.result = add.perform(this.tmp, this.number); 
			}
		}
		
		if (minus)
		{
			SubtractionOperation sub = new SubtractionOperation();
			if (this.tmp != 0)
			{
				this.result = sub.perform(this.tmp, this.number);
			}
		}
		
		if (mult)
		{
			MultiplicationOperation multip = new MultiplicationOperation();
			if (this.tmp != 0)
			{
				this.result = multip.perform(this.tmp, this.number);
			}
		}
		
		if (div)
		{
			try
			{
				DivisionOperation division = new DivisionOperation();
				if (this.tmp != 0)
				{
					this.result = division.perform(this.tmp, this.number);
				}
			}
			catch (IncorectOperationException ex)
			{
				System.out.println("Division by zero");
			}
		}
	}
	public double Calc (String number, char operation)
	{
		if (this.number != 0)
		{
			this.tmp = this.number;
			saveNumber(number);
			saveOpearation(operation);
		}
		else
		{
			saveNumber(number);
			saveOpearation(operation);
		}
		
		
		
		//InnerCalc();
		
		if (equal)
		{
			this.result = 0;
			InnerCalc();
			return this.result;
		}
		else
		{
			return this.result;
		}
		
		
	}*/
}