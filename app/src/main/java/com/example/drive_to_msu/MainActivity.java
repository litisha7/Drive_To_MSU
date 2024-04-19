package com.example.drive_to_msu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private final int TIME_LIMIT = 8000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Navigate(View view){
        // Montclair State University directions are created
        Uri Intenturi = Uri.parse("google.navigation:q=40.8644624104021, -74.19858111477711");
        // Intent is created to launch Google Maps
        Intent Map = new Intent(Intent.ACTION_VIEW, Intenturi);
        // Google Maps package is set
        Map.setPackage("com.google.android.apps.maps");
        // Navigation will begin upon the button being pressed
        startActivity(Map);

        // Second activity for map navigation has started with postDelayed
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, TIME_LIMIT);
    }
}