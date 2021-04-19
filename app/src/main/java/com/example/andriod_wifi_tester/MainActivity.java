package com.example.andriod_wifi_tester;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private NetworkHelper networkHelper = new NetworkHelper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void updateBtTapped(View view) {
        System.out.println("tapped!!!");
        networkHelper.loadWifiAvailableList(findViewById(R.id.textView3));
    }
}