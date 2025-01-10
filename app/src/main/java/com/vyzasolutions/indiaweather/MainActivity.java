package com.vyzasolutions.indiaweather;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.vyzasolutions.indiaweather.ui.DailyFragment;
import com.vyzasolutions.indiaweather.ui.HourlyFragment;
import com.vyzasolutions.indiaweather.ui.Radar_mapsFragment;
import com.vyzasolutions.indiaweather.ui.TodayFragment;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ImageView buttonDrawerToggle;
    private NavigationView sideNavigationView;

    private FrameLayout frameLayout;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //init()
        drawerLayout = findViewById(R.id.main);
        buttonDrawerToggle = findViewById(R.id.buttonDrawerToggle);


        sideNavigationView = findViewById(R.id.navigationView);

        View headerView = sideNavigationView.getHeaderView(0);
        ImageView imageView = headerView.findViewById(R.id.imageView);
        TextView userName = headerView.findViewById(R.id.userName);

        frameLayout = findViewById(R.id.frame_layout);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        //open side menu on button click
        buttonDrawerToggle.setOnClickListener( v-> drawerLayout.open());

        // Initialize frame layout and bottom navigation view
        loadFragment(new TodayFragment(),true);
        bottomNavigationView.setOnItemSelectedListener(item -> {


            int itemId = item.getItemId();

            if (itemId == R.id.navToday){
                loadFragment(new TodayFragment(), false);
            }
            else if (itemId== R.id.navHourly){
                loadFragment(new HourlyFragment(), false);
            }
            else if (itemId== R.id.navDaily){
                loadFragment(new DailyFragment(), false);
            }
            else {
                loadFragment(new Radar_mapsFragment(), false);
            }

            return true;
        });

        // Side Menu
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, ""+userName.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        sideNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if(itemId == R.id.navNews){
                    Toast.makeText(MainActivity.this, "News Clicked", Toast.LENGTH_SHORT).show();
                }
                else if(itemId == R.id.navVideo){
                    Toast.makeText(MainActivity.this, "Video Clicked", Toast.LENGTH_SHORT).show();
                }
                else if(itemId == R.id.navSettings){
                    Toast.makeText(MainActivity.this, "Settings Clicked", Toast.LENGTH_SHORT).show();
                }
                else if(itemId == R.id.navHowWeForecast){
                    Toast.makeText(MainActivity.this, "How We Forecast Clicked", Toast.LENGTH_SHORT).show();
                }
                else if(itemId == R.id.navAboutIndiaWeather){
                    Toast.makeText(MainActivity.this, "About IndiaWeather Clicked", Toast.LENGTH_SHORT).show();
                }
                else if(itemId == R.id.navHelp){
                    Toast.makeText(MainActivity.this, "Help Clicked", Toast.LENGTH_SHORT).show();
                }
                else if(itemId == R.id.navRateOurApp){
                    Toast.makeText(MainActivity.this, "Rate our App Clicked", Toast.LENGTH_SHORT).show();
                }
                else if(itemId == R.id.navContact){
                    Toast.makeText(MainActivity.this, "Contact Clicked", Toast.LENGTH_SHORT).show();
                }
                else if(itemId == R.id.navShare){
                    Toast.makeText(MainActivity.this, "Share Clicked", Toast.LENGTH_SHORT).show();
                }
                drawerLayout.close();
                return false;
            }
        });

    }

    private void loadFragment(Fragment fragment, boolean isAppInitialize) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (isAppInitialize){
            fragmentTransaction.add(R.id.frame_layout, fragment);
        }
        else {
            fragmentTransaction.replace(R.id.frame_layout, fragment);
        }
        fragmentTransaction.commit();

    }
}