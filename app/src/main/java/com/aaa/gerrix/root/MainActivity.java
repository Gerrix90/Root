package com.aaa.gerrix.root;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    public static final String TAG = "Provera";
    private RootManagerHelper packetMennager;
    @BindView(R.id.devicesTV) TextView devicesTv;
    @BindView(R.id.loadClients) Button loadClients;
    @BindView(R.id.clearTV) Button clearTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        ButterKnife.bind(this);


         packetMennager = new RootManagerHelper();


    }

    @OnClick({R.id.loadClients, R.id.clearTV})
    public void handleClickEvent(View view){

        switch (view.getId()){

            case R.id.loadClients:
                devicesTv.setText(packetMennager.scanWlan().getMessage());
                break;

            case R.id.clearTV:
                if (!devicesTv.getText().toString().isEmpty())
                    devicesTv.setText("");
                break;

        }
    }
}

