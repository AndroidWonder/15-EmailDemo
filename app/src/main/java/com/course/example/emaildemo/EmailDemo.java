package com.course.example.emaildemo;
//Be sure email is set up on your emulator!
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
        		//create implicit intent to use email
            	Intent msg = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"));

            	//set attributes for email
            	msg.putExtra(Intent.EXTRA_EMAIL, new String[] {"JoeDeploy@bentley.edu", "JohnDeploy@gmail.com"});
            	msg.putExtra(Intent.EXTRA_CC, new String[] {"HarryBentley@bentley.edu", "HenryBentley@gmail.com"});
            	msg.putExtra(Intent.EXTRA_BCC, new String[] {"HarrietBentley@bentley.edu", "MegBentley@gmail.com"});
            	msg.putExtra(Intent.EXTRA_TEXT, "Hope you're still enjoying class.");
            	msg.putExtra(Intent.EXTRA_SUBJECT, "Email Demo");

				startActivity(msg);
        		
        	}
        });
        
    }
}