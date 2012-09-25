package de.ags.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AGSApplicationActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button vplanBtn = (Button) findViewById(R.id.button1);
        vplanBtn.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View view) {
				// TODO Auto-generated method stub
				
				Intent myIntent = new Intent(view.getContext(), vplan.class);
				startActivityForResult(myIntent, 0);
			}
		});
    }
}