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
	
	private String str = "";
	
	private boolean plus = false;
	private boolean minus = false;
	private boolean mult = false;
	private boolean div = false;
	private boolean equal = false;
	
	private double number = 0;
	private double tmp = 0;
	private double result;

	public void onPress(View v) {
		TextView etext = (TextView) this.findViewById(R.id.entry);
		//String number = "";
		double result = 0.0;
		switch (v.getId()) {
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
		}

		Log.d(LOG_TAG, "button " + v + " clicked");

	}
	
	public void CleanInput(TextView tv){
		tv.setText("");
	}
	
	public void saveNumber(String number)
	{
		this.number = Double.parseDouble(number);
	}
	
	public void saveOpearation(char operation)
	{
		switch (operation)
		{
		case '+':
			plus = true;
			break;
		case '-':
			minus = true;
			break;
		case '*':
			mult = true;
			break;
		case '/':
			div = true;
			break;
		case '=':
			equal = true;
			break;
		}
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
		
		
	}
}