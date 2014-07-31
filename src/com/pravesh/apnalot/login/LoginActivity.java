package com.pravesh.apnalot.login;


import com.pravesh.apnalot.MainActivity;
import com.pravesh.apnalot.R;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.ActionBar;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends MainActivity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
	 
       ActionBar actionBar = getActionBar();
        
        // Enabling Up / Back navigation
        actionBar.setDisplayHomeAsUpEnabled(true);
        
	        TextView registerScreen = (TextView) findViewById(R.id.link_to_register);
	        EditText loginEmail = (EditText) findViewById(R.id.login_email);
	        EditText loginPass = (EditText) findViewById(R.id.login_pass);
	        
	        
	        
	        
	 
	        // Listening to register new account link
	        registerScreen.setOnClickListener(new View.OnClickListener() {
	 
	            public void onClick(View v) {
	                // Switching to Register screen
	                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
	                startActivity(i);
	            }
	        });
	    }
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    // Respond to the action bar's Up/Home button
	    case android.R.id.home:
	        NavUtils.navigateUpFromSameTask(this);
	        return true;
	    }
	    return super.onOptionsItemSelected(item);
	}
	
	
	/**
	 * Hides the soft keyboard
	 */
	public void hideSoftKeyboard() {
	    if(getCurrentFocus()!=null) {
	        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
	        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
	    }
	}


}
