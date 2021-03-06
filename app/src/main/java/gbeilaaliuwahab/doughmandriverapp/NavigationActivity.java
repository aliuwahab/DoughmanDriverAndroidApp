package gbeilaaliuwahab.doughmandriverapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import gbeilaaliuwahab.doughmandriverapp.data.Order;

public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        OrderFragment.OnListFragmentInteractionListener,OrderDetails.OnFragmentInteractionListener{

    FragmentManager manager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

//        Open default navigation
        OrderFragment orderFragment = new OrderFragment();
        manager.beginTransaction()
                .replace(R.id.fragment_content,orderFragment,orderFragment.getTag())
                .commit();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }




    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.orders) {
            OrderFragment orderFragment = new OrderFragment();
            manager.beginTransaction()
                    .replace(R.id.fragment_content,orderFragment,orderFragment.getTag())
                    .commit();

        } else if (id == R.id.delivery_history) {

//            PastOrderFragment pastOrderFragment = new PastOrderFragment();
//            manager.beginTransaction().
//                    replace(R.id.fragment_content,pastOrderFragment,pastOrderFragment.getTag())
//                    .commit();

        } else if (id == R.id.settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);

        } else if (id == R.id.logout) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);

        } else if (id == R.id.login_activity){
            Intent loginActivity = new Intent(this, LoginActivity.class);
            startActivity(loginActivity);
        } else{

            OrderFragment orderFragment = new OrderFragment();
            manager.beginTransaction()
                    .replace(R.id.fragment_content,orderFragment,orderFragment.getTag())
                    .commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }



    private void setupSharedPreferences(){

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

    }

    private void setupPermissions(){


    }

    @Override
    public void onListFragmentInteraction(Order order) {

        Log.d("ORDER CLICKED", order.getOrderTitle());

//      OrderDetails orderDetails = new OrderDetails();

        Fragment orderDetails = OrderDetails.newInstance(order);

//        Bundle bundle = new Bundle();
//        bundle.putInt(key, value);
//        fragment.setArguments(bundle);
//        orderDetails.setArguments();

        manager.beginTransaction()
                .replace(R.id.fragment_content,orderDetails,orderDetails.getTag())
                .commit();

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}
