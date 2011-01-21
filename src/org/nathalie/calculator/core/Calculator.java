package org.nathalie.calculator.core;

import java.text.DecimalFormat;

import org.nathalie.calculator.CalculatorActivity;
import org.nathalie.calculator.R;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Calculator {
	
	private static final String LOG_TAG = CalculatorActivity.class
			.getSimpleName();
	
	private View v;
	private TextView etext;
	
	private StringBuffer number;
	private Double tmp;
	
	private double result;
	
	private boolean plus = false;
	private boolean minus = false;
	private boolean mult = false;
	private boolean div = false;
	private boolean equal = false;
	
	
	
	public Calculator() {
		number = new StringBuffer();
	}
	
	public void init(View v, TextView etext){
		this.v = v;
		this.etext = etext;
	}
	
	public void saveOpearation()
	{
		switch (v.getId())
		{
		case R.id.btn_plus:
			plus = true;
			break;
		case R.id.btn_minus:
			minus = true;
			break;
		case R.id.btn_mult:
			mult = true;
			break;
		case R.id.btn_div:
			div = true;
			break;
		case R.id.btn_equal:
			equal = true;
			break;
		}
		
		if (tmp == null) 
		{
			tmp = Double.parseDouble(number.toString());
		}
	}
	
	public void input()
	{
		
		switch (v.getId())
		{
			case R.id.btn_ce:
				clear();
				break;
			case R.id.btn_0:
				checkOneMoreZero();
				break;
			case R.id.btn_1:
				setOutputText("1");	
				break;
			case R.id.btn_2:
				setOutputText("2");	
				break;
			case R.id.btn_3:
				setOutputText("3");	
				break;
			case R.id.btn_4:
				setOutputText("4");	
				break;
			case R.id.btn_5: 
				setOutputText("5");	
				break;
			case R.id.btn_6:
				setOutputText("6");	
				break;
			case R.id.btn_7:
				setOutputText("7");	
				break;
			case R.id.btn_8:
				setOutputText("8");	
				break;
			case R.id.btn_9:
				setOutputText("9");			
				break;
			case R.id.btn_minus:
				checkCorrectOperationPress();
				break;
			case R.id.btn_plus:
				checkCorrectOperationPress();	
				break;
			case R.id.btn_mult:
				checkCorrectOperationPress();
				break;
			case R.id.btn_div:
				checkCorrectOperationPress();
				break;
			case R.id.btn_equal:
				checkCorrectEqualPress();
				
				break;
		}
	}
	
	public double calc()
	{
		if (equal)
		{
			double y = Double.parseDouble(number.toString());
			double x = tmp;
			
			result = 0;
			logicCalc(x, y);
		}	
		
		return result;
	}
	
	
	public void clear(){
		etext.setText("");	
	}
	
	public void update()
	{
		clear();
		
		etext.setText(number.toString());
		number.delete(0, number.length());
		
	}
	
	public void clearResult()
	{
		result = 0;
		tmp = null;
		number.delete(0, number.length());
		plus = false;
		minus = false;
		mult = false;
		div = false;
		equal = false;
	}
	private void checkCorrectEqualPress()
	{
		if (number.length() == 0 )
		{
			clear();
		}
		else
		{
			saveOpearation();
			double res = calc();
			DecimalFormat outRes = new DecimalFormat("0");
			etext.setText(outRes.format(res));
			clearResult();
		}
	}
	private void checkCorrectOperationPress()
	{
		if (number.length() != 0)
		{
			saveOpearation();
			update();
		}
		else
		{
			update();
		}
		
	}
	private void setOutputText(String text)
	{
		if (tmp != null)
		{
			etext.setText(text);
			number.append(text);
		}
		else
		{
			etext.setText(etext.getText() + text);
			number.append(text);
		}
		
	}
	
	private void checkOneMoreZero()
	{
		if (number.length() != 0 && Double.parseDouble(number.toString()) == 0)
		{
			etext.setText("0");
		}
		else{
			etext.setText(etext.getText() + "0");
			number.append("0");
		}
	}
	
	private void logicCalc(double x, double y)	
	{
		if (plus)
		{
			AdditionOperation add = new AdditionOperation();
			
				result = add.perform(x, y); 
		}
		
		if (minus)
		{
			SubtractionOperation sub = new SubtractionOperation();

			result = sub.perform(x, y);
		}
		
		if (mult)
		{
			MultiplicationOperation multip = new MultiplicationOperation();

				result = multip.perform(x, y);
		}
		
		if (div) 
		{
				DivisionOperation division = new DivisionOperation();
					if (y != 0)
					{
						result = division.perform(x, y);
					}
					else{
						Log.d(LOG_TAG, "Division by zero");
					}
		}
	}

}
