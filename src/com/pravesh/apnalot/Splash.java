 package com.pravesh.apnalot;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;



public class Splash extends Activity  {
    
	@Override
	protected void onCreate(Bundle pravesh) {
		// TODO Auto-generated method stub
		super.onCreate(pravesh);
		
		
		
		
		//fullscreen	
				requestWindowFeature(Window.FEATURE_NO_TITLE);
				getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.splash);
		
		
		
		
		
		
		Thread timer=new Thread(){
			public void run(){
				try{
				sleep(5000);
			} catch (InterruptedException e){
				e.printStackTrace();
				
			}finally{
				Intent openMainActivity= new Intent("com.pravesh.apnalot.HOMEPAGE1");
				startActivity(openMainActivity);
			}
		}
	};
	timer.start();

}

	
 
}
