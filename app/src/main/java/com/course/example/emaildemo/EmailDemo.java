package com.course.example.emaildemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;


public class EmailDemo extends Activity {
    
    private Button button;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        button = (Button) findViewById(R.id.button);
        
        button.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		
            	Intent msg = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"));
            	msg.putExtra(Intent.EXTRA_EMAIL, new String[] {"JoeDeploy@bentley.edu", "JohnDeploy@gmail.com"});
            	msg.putExtra(Intent.EXTRA_CC, new String[] {"HarryBentley@bentley.edu", "HenryBentley@gmail.com"});
            	msg.putExtra(Intent.EXTRA_BCC, new String[] {"HarrietBentley@bentley.edu", "MegBentley@gmail.com"});
            	msg.putExtra(Intent.EXTRA_TEXT, "Hope you're enjoying class tonight.");
            	msg.putExtra(Intent.EXTRA_SUBJECT, "Email Demo");            	
        	    
            	//check to be sure email is installed on handset
            	if (msg.resolveActivity(getPackageManager()) != null) {
        	        startActivity(msg);
        	    }
        	    
        		
        	}
        });
        
    }
}