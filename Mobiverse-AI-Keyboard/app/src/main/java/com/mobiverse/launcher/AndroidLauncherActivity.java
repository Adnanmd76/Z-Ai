package com.mobiverse.launcher;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mobiverse.aikeyboard.R;

public class AndroidLauncherActivity extends AppCompatActivity {

    private ViewPager2 vpHomeScreens;
    private LinearLayout pageIndicator;
    private LinearLayout dockContainer;
    private FloatingActionButton fabAppDrawer;
    
    private HomeScreenPagerAdapter pagerAdapter;
    private int totalPages = 3; // Default 3 home screens

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_launcher);

        initializeViews();
        setupHomeScreens();
        setupDock();
        setupAppDrawer();
    }

    private void initializeViews() {
        vpHomeScreens = findViewById(R.id.vp_home_screens);
        pageIndicator = findViewById(R.id.page_indicator);
        dockContainer = findViewById(R.id.dock_container);
        fabAppDrawer = findViewById(R.id.fab_app_drawer);
    }

    private void setupHomeScreens() {
        pagerAdapter = new HomeScreenPagerAdapter(this, totalPages);
        vpHomeScreens.setAdapter(pagerAdapter);
        
        // Set middle page as default
        vpHomeScreens.setCurrentItem(1, false);
        
        // Page change listener for indicator
        vpHomeScreens.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                updatePageIndicator(position);
            }
        });
        
        createPageIndicator();
    }

    private void createPageIndicator() {
        pageIndicator.removeAllViews();
        for (int i = 0; i < totalPages; i++) {
            android.view.View dot = new android.view.View(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                24, 24
            );
            params.setMargins(8, 0, 8, 0);
            dot.setLayoutParams(params);
            dot.setBackground(getDrawable(R.drawable.page_indicator_dot));
            dot.setAlpha(i == 1 ? 1.0f : 0.3f);
            pageIndicator.addView(dot);
        }
    }

    private void updatePageIndicator(int position) {
        for (int i = 0; i < pageIndicator.getChildCount(); i++) {
            pageIndicator.getChildAt(i).setAlpha(i == position ? 1.0f : 0.3f);
        }
    }

    private void setupDock() {
        // Add 4-5 most used apps to dock
        String[] dockApps = {
            "com.android.dialer",     // Phone
            "com.android.mms",        // Messages
            "com.android.chrome",     // Browser
            "com.android.camera2"     // Camera
        };
        
        // Create app icons for dock (simplified)
        for (String packageName : dockApps) {
            ImageView appIcon = new ImageView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                64, 64
            );
            params.setMargins(12, 0, 12, 0);
            appIcon.setLayoutParams(params);
            appIcon.setImageResource(R.drawable.ic_app_placeholder);
            appIcon.setOnClickListener(v -> launchApp(packageName));
            dockContainer.addView(appIcon);
        }
    }

    private void setupAppDrawer() {
        fabAppDrawer.setOnClickListener(v -> openAppDrawer());
    }

    private void openAppDrawer() {
        // Open bottom sheet or full screen app drawer
        AppDrawerBottomSheet drawer = new AppDrawerBottomSheet();
        drawer.show(getSupportFragmentManager(), "app_drawer");
    }

    private void launchApp(String packageName) {
        Intent intent = getPackageManager()
            .getLaunchIntentForPackage(packageName);
        if (intent != null) {
            startActivity(intent);
        }
    }
}