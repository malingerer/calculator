package org.nathalie;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalculatorActivity extends Activity {
	private static final String LOG_TAG = CalculatorActivity.class.getSimpleName();
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
    }
    public void onPress(View v){
    	EditText etext  = (EditText) this.findViewById(R.id.entry);
    	Button btn = (Button) v.findViewById(R.id.btn_ce);
    	etext.setText(btn.getText().toString());
       Log.d(LOG_TAG, "button " + v + " clicked");

    }
}