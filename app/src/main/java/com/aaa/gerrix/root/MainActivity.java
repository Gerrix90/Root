package com.aaa.gerrix.root;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileReader;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;


public class MainActivity extends AppCompatActivity {

    public static final String TAG = "Provera";
    private TextView devicesTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        devicesTv = (TextView) findViewById(R.id.devicesTV);

        RootManagerHelper packetMennager = new RootManagerHelper();

        devicesTv.setText(packetMennager.scanWlan().getMessage());

    }
}

