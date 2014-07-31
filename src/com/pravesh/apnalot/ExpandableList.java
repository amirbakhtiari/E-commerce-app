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
 
public class ExpandableList extends MainActivity {
 
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
        listDataHeader.add("Education & Professionalism");
        listDataHeader.add("Engineering");
        listDataHeader.add("Entrance Exam Preparation");
        listDataHeader.add("Humanities and Social Sciences");
        listDataHeader.add("Business and Management");
        listDataHeader.add("Biographies and Autobiographies");
        listDataHeader.add("Personality Development");
        listDataHeader.add("Featured Books");
        listDataHeader.add("General Exams");
        listDataHeader.add("General Books");
        listDataHeader.add("Law Books");
        listDataHeader.add("Humanities and Social Sciences");
        listDataHeader.add("Classics");
        listDataHeader.add("IIT JEE");
        listDataHeader.add("Medical");
        listDataHeader.add("Children Story");
        listDataHeader.add("Deal of the Day");
        listDataHeader.add("New Releases");
        listDataHeader.add("Publication");
        listDataHeader.add("Season's Special");
        listDataHeader.add("Sports");
        listDataHeader.add("Trending");
        listDataHeader.add("University Guide");
        
        
 
        // Adding child data
        List<String> engg = new ArrayList<String>();
        engg.add("Civil");
        engg.add("Computer Science & Information Technology");
        engg.add("Electrical");
        engg.add("Mechanical Engineering");
        
 
        List<String> eep = new ArrayList<String>();
        eep.add("CAT");
        eep.add("GATE");
        eep.add("IES");
        eep.add("IIT JEE");
        eep.add("MPPSC");
        eep.add("SBI PO");
        eep.add("SSC");
        eep.add("UPSC");
 
        List<String> publication = new ArrayList<String>();
        publication.add("Arihant");
        publication.add("Bharati Bhawan");
        publication.add("Brown Book Group");
        publication.add("Kiran Prakashan");
        publication.add("Little");
        publication.add("Mc Graw Hill Education");
        publication.add("Westland");
       
        
        List<String> sports = new ArrayList<String>();
        sports.add("Football");
        
        List<String> uniGuide = new ArrayList<String>();
        uniGuide.add("Barkatullah University");
 
        listDataChild.put(listDataHeader.get(1), engg); // Header, Child data
        listDataChild.put(listDataHeader.get(2), eep);
        listDataChild.put(listDataHeader.get(18), publication);
        listDataChild.put(listDataHeader.get(20), sports);
        listDataChild.put(listDataHeader.get(22), uniGuide);
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
