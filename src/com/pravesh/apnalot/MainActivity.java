package com.pravesh.apnalot;

import android.support.v7.app.ActionBarActivity;
import android.app.ActionBar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

import com.pravesh.apnalot.adapter.FeedListAdapter;
import com.pravesh.apnalot.adapter.TitleNavigationAdapter;
import com.pravesh.apnalot.app.AppController;
import com.pravesh.apnalot.data.FeedItem;
import com.pravesh.apnalot.login.LoginActivity;
import com.pravesh.apnalot.model.SpinnerNavItem;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
 
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
 
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import android.widget.ListView;
import android.widget.SearchView;
 
import com.android.volley.Cache;
import com.android.volley.Cache.Entry;
import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
 

public class MainActivity extends Activity implements ActionBar.OnNavigationListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private ListView listView;
    private FeedListAdapter listAdapter;
    private List<FeedItem> feedItems;
    private String URL_FEED = "https://gist.githubusercontent.com/anonymous/ed3512846158f8a1a98b/raw/272111c81d52059a184b16404b09da833699e5a2/blob.json";
 //int position;
    
    //-------------
    // action bar
    private ActionBar actionBar;
 
    // Title navigation Spinner data
    private ArrayList<SpinnerNavItem> navSpinner;
     
    // Navigation adapter
    private TitleNavigationAdapter adapter;
    //--------------
    
    
    
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
       
 
        listView = (ListView) findViewById(R.id.list);
 
        feedItems = new ArrayList<FeedItem>();
 
        listAdapter = new FeedListAdapter(this, feedItems);
        listView.setAdapter(listAdapter);
         
        // These two lines not needed,
        // just to get the look of facebook (changing background color & hiding the icon)
        getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#EF7B00")));
      //  getActionBar().setIcon(
                  // new ColorDrawable(getResources().getColor(android.R.color.transparent)));
 
        
        
        //---Spinner Navigation
        actionBar = getActionBar();
        
        // Hide the action bar title
        actionBar.setDisplayShowTitleEnabled(false);
 
        // Enabling Spinner dropdown navigation
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
         
        // Spinner title navigation data
        navSpinner = new ArrayList<SpinnerNavItem>();
        navSpinner.add(new SpinnerNavItem("Apnalot Home", R.drawable.ic_home));
        navSpinner.add(new SpinnerNavItem("Books", R.drawable.book_icon));
        navSpinner.add(new SpinnerNavItem("Novels", R.drawable.novel_icon));
        navSpinner.add(new SpinnerNavItem("Hot Offers", R.drawable.ic_whats_hot));     
         
        // title drop down adapter
        adapter = new TitleNavigationAdapter(getApplicationContext(), navSpinner);
 
        // assigning the spinner navigation     
        actionBar.setListNavigationCallbacks(adapter, this);
        //actionBar.setSelectedNavigationItem(position);
        
        
        
        //-------------------
        
        
        
        
        
    }
 
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_actions, menu);
        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search)
                .getActionView();
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));
 
        
        return super.onCreateOptionsMenu(menu);
    }
    
    
 
    
    /**
     * On selecting action bar icons
     * */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        switch (item.getItemId()) {
        case R.id.action_search:
            // search action
            return true;
        case R.id.action_wishlist:
            
            return true;
        case R.id.action_rateapp:
            
        	ProductList();
            return true;
        case R.id.action_share:
        	Intent i=new Intent(android.content.Intent.ACTION_SEND);
        	i.setType("text/plain");
        	i.putExtra(android.content.Intent.EXTRA_SUBJECT,"Apnalot.com");
        	i.putExtra(android.content.Intent.EXTRA_TEXT, "There is no link but soon will be on Play Store :)");
        	startActivity(Intent.createChooser(i,"Share via"));
            return true;
        case R.id.action_login:
            // check for updates action
        	Login();
            return true;
        case R.id.action_contact:
            // check for updates action
        	ContactUs();
            return true; 
        case R.id.action_policies:
            // check for updates action
        	Policies();
            return true;    
        default:
            return super.onOptionsItemSelected(item);
        }
    }
 
    
    /**
     * Actionbar navigation item select listener
     * */
    @Override
    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
    // Action to be taken after selecting a spinner item
    	SpinnerNavItem selectedItem = navSpinner.get(itemPosition);
    	
    	switch (itemPosition){

        case 0: 
            
            return true;
        case 1:
            startActivity(new Intent("com.pravesh.apnalot.EXPANDABLELIST"));
            
            return true;
        case 2:
            startActivity(new Intent("com.pravesh.apnalot.EXPANDABLELISTFORNOVEL"));
            return true;

        default:
            return onNavigationItemSelected(itemPosition, itemId);
        }
    	
        
    }
    
    
    /**
     * Launching new activity
     * */
   
    private void Login() {
        Intent i = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(i);
    }
    
    private void Policies() {
        Intent i = new Intent(MainActivity.this, Policies.class);
        startActivity(i);
    }
    
    private void ContactUs() {
        Intent i = new Intent(MainActivity.this, ContactUs.class);
        startActivity(i);
    }
    
    private void ProductList() {
        Intent i = new Intent(MainActivity.this, ProductList.class);
        startActivity(i);
    }
    

    
    
    
    
    
   
    
    
    
    
}

