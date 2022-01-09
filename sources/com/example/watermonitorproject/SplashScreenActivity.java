package com.example.watermonitorproject;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {
    boolean isLoggedIn;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        SplashScreenActivity.super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_splash_screen);
        new LogoLauncher().start();
    }

    private class LogoLauncher extends Thread {
        private LogoLauncher() {
        }

        /* JADX WARNING: type inference failed for: r2v2, types: [com.example.watermonitorproject.SplashScreenActivity, android.content.Context] */
        public void run() {
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (SplashScreenActivity.this.getSharedPreferences("choppu_data", 0).getBoolean("is_logged_in", false)) {
                SplashScreenActivity.this.startActivity(new Intent(SplashScreenActivity.this.getApplicationContext(), NavigationActivity.class));
            } else {
                SplashScreenActivity.this.startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
            }
            SplashScreenActivity.this.finish();
        }
    }
}
