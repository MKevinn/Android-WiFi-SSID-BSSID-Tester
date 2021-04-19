package com.example.andriod_wifi_tester;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import java.util.List;

public class NetworkHelper extends Activity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void loadWifiAvailableList(TextView etWifiList) {
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        List<ScanResult> results = wifiManager.getScanResults();
        String message = "N/A";
        if (results != null) {
            int size = results.size();
            if (size == 0) message = "No access points in range";
            else {
                ScanResult bestSignal = results.get(0);
                etWifiList.setText("");
                int count = 1;
                for (ScanResult result : results) {
                    etWifiList.append(count++ + ". " + result.SSID + " : "
                            + result.level + "\n" + result.BSSID + "\n"
                            + result.capabilities + "\n"
                            + "\n=======================\n");
                    if (WifiManager.compareSignalLevel(bestSignal.level, result.level) < 0)
                        bestSignal = result;
                }
                message = String.format("%s networks found. %s is the strongest.", size, bestSignal.SSID + " : " + bestSignal.level);
            }
        }
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
