package com.example.tpbluetooh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView readbuffer, status;
    Button btOn, btOff, showpaired, discoverDev, makeDev;
    ListView listDev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //test
        Init();
    }

    public void Init(){
        readbuffer = findViewById(R.id.Readbuffer);
        status = findViewById(R.id.Status);
        btOn = findViewById(R.id.BTon);
        btOn.setOnClickListener(this);
        btOff = findViewById(R.id.BToff);
        btOff.setOnClickListener(this);
        showpaired = findViewById(R.id.Showpaired);
        showpaired.setOnClickListener(this);
        discoverDev = findViewById(R.id.Dicoverdev);
        discoverDev.setOnClickListener(this);
        makeDev = findViewById(R.id.Makedev);
        listDev = findViewById(R.id.Listdev);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.BTon:
                break;
            case R.id.BToff:
                break;
            case R.id.Showpaired:
                break;
            case R.id.Dicoverdev:
                break;
        }
    }
}