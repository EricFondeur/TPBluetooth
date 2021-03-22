package com.example.tpbluetooh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView readbuffer, status;
    Button btOn, btOff, showpaired, discoverDev, makeDev;
    ListView listDev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //test
    }

    public void Init(){
        readbuffer = findViewById(R.id.Readbuffer);
        status = findViewById(R.id.Status);
        btOn = findViewById(R.id.BTon);
        btOff = findViewById(R.id.BToff);
        showpaired = findViewById(R.id.Showpaired);
        discoverDev = findViewById(R.id.Dicoverdev);
        makeDev = findViewById(R.id.Makedev);
        listDev = findViewById(R.id.Listdev);
    }
}