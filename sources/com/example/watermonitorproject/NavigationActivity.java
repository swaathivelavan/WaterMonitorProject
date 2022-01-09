package com.example.watermonitorproject;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class NavigationActivity extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration;

    /* JADX WARNING: type inference failed for: r8v0, types: [com.example.watermonitorproject.NavigationActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity] */
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        NavigationActivity.super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        NavigationView navigationView = findViewById(R.id.nav_view);
        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.complaint).setTitle("Complaint");
        menu.findItem(R.id.nav_slideshow).setVisible(false);
        menu.findItem(R.id.nav_tools).setVisible(false);
        menu.findItem(R.id.nav_share).setVisible(false);
        menu.findItem(R.id.nav_send).setVisible(false);
        setSupportActionBar(findViewById(R.id.toolbar));
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", 0).setAction("Action", (View.OnClickListener) null).show();
            }
        });
        this.mAppBarConfiguration = new AppBarConfiguration.Builder(new int[]{R.id.nav_home, R.id.complaint, R.id.nav_slideshow, R.id.nav_tools, R.id.nav_share, R.id.nav_send}).setDrawerLayout(findViewById(R.id.drawer_layout)).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, this.mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.example.watermonitorproject.NavigationActivity, android.app.Activity, androidx.appcompat.app.AppCompatActivity] */
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(Navigation.findNavController(this, R.id.nav_host_fragment), this.mAppBarConfiguration) || NavigationActivity.super.onSupportNavigateUp();
    }
}
