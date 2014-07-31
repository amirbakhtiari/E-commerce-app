package com.pravesh.apnalot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.pravesh.apnalot.adapter.ExpandableListAdapter;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;
 
public class Policies extends MainActivity {
 
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expan_listview);
        
        ActionBar actionBar = getActionBar();
        
        // Enabling Up / Back navigation
        actionBar.setDisplayHomeAsUpEnabled(true);
 
        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);
 
        // preparing list data
        prepareListData();
 
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
 
        // setting list adapter
        expListView.setAdapter(listAdapter);
    }
 
    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
 
        // Adding child data
        listDataHeader.add("Privacy Policy");
        listDataHeader.add("Shipping Policy");
        listDataHeader.add("Terms $ Conditions");
        
        
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
    
}
