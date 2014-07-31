package com.pravesh.apnalot;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class HomePage1 extends MainActivity {
	
	LinearLayout asthmaActionPlan, controlledMedication, asNeededMedication,
    rescueMedication, yourSymtoms, yourTriggers, wheezeRate;
LayoutParams params;
LinearLayout next, prev;
int viewWidth;
GestureDetector gestureDetector = null;
HorizontalScrollView horizontalScrollView;
ArrayList<LinearLayout> layouts;
int parentLeft, parentRight;
int mWidth;
int currPosition, prevPosition;
	
	

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_page_new);
		
		
	
	   
	    horizontalScrollView = (HorizontalScrollView) findViewById(R.id.hsv);
	    gestureDetector = new GestureDetector(new MyGestureDetector());
	    asthmaActionPlan = (LinearLayout) findViewById(R.id.asthma_action_plan);
	    controlledMedication = (LinearLayout) findViewById(R.id.controlled_medication);
	    asNeededMedication = (LinearLayout) findViewById(R.id.as_needed_medication);
	    rescueMedication = (LinearLayout) findViewById(R.id.rescue_medication);
	    yourSymtoms = (LinearLayout) findViewById(R.id.your_symptoms);
	    yourTriggers = (LinearLayout) findViewById(R.id.your_triggers);
	    wheezeRate = (LinearLayout) findViewById(R.id.wheeze_rate);
	    
	    Display display = getWindowManager().getDefaultDisplay();
	    mWidth = display.getWidth(); // deprecated
	    viewWidth = mWidth / 3;
	    layouts = new ArrayList<LinearLayout>();
	    params = new LayoutParams(viewWidth, LayoutParams.WRAP_CONTENT);
	    asthmaActionPlan.setLayoutParams(params);
	    controlledMedication.setLayoutParams(params);
	    asNeededMedication.setLayoutParams(params);
	    rescueMedication.setLayoutParams(params);
	    yourSymtoms.setLayoutParams(params);
	    yourTriggers.setLayoutParams(params);
	    wheezeRate.setLayoutParams(params);
	    
	    layouts.add(asthmaActionPlan);
	    layouts.add(controlledMedication);
	    layouts.add(asNeededMedication);
	    layouts.add(rescueMedication);
	    layouts.add(yourSymtoms);
	    layouts.add(yourTriggers);
	    layouts.add(wheezeRate);
	   
	
	  
	    horizontalScrollView.setOnTouchListener(new OnTouchListener() {
	        @Override
	        public boolean onTouch(View v, MotionEvent event) {
	            if (gestureDetector.onTouchEvent(event)) {
	                return true;
	            }
	            return false;
	        }
	    });
	}
	class MyGestureDetector extends SimpleOnGestureListener {
	    @Override
	    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
	            float velocityY) {
	        if (e1.getX() < e2.getX()) {
	            currPosition = getVisibleViews("left");
	        } else {
	            currPosition = getVisibleViews("right");
	        }

	        horizontalScrollView.smoothScrollTo(layouts.get(currPosition)
	                .getLeft(), 0);
	        return true;
	    }
	}
	public int getVisibleViews(String direction) {
	    Rect hitRect = new Rect();
	    int position = 0;
	    int rightCounter = 0;
	    for (int i = 0; i < layouts.size(); i++) {
	        if (layouts.get(i).getLocalVisibleRect(hitRect)) {
	            if (direction.equals("left")) {
	                position = i;
	                break;
	            } else if (direction.equals("right")) {
	                rightCounter++;
	                position = i;
	                if (rightCounter == 2)
	                    break;
	            }
	        }
	    }
	    return position;
	}
	
	
	 @Override
	    public void onBackPressed() {
	        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
	                .setMessage("Are you sure you want to exit?")
	                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
	                    @Override
	                    public void onClick(DialogInterface dialog, int which) {

	                        Intent intent = new Intent(Intent.ACTION_MAIN);
	                        intent.addCategory(Intent.CATEGORY_HOME);
	                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	                        startActivity(intent);
	                        finish();
	                    }
	                }).setNegativeButton("No", null).show();
	    } 
	
	
	

}
