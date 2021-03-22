package com.example.tpbluetooh;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView readbuffer, status;
    Button btOn, btOff, showpaired, discoverDev, makeDev;
    ListView listDev;
    BluetoothAdapter bluetoothadapter;

    private static final int  REQUEST_ENABLE_BT = 2;

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
                TurnBTon();
                break;
            case R.id.BToff:
                TurnBToff();
                break;
            case R.id.Showpaired:
                break;
            case R.id.Dicoverdev:
                break;
        }
    }

    public void TurnBTon(){
        bluetoothadapter = BluetoothAdapter.getDefaultAdapter();

        if(bluetoothadapter == null){
            Toast.makeText(this,"cet appareil ne dispose pas du bluetooth",Toast.LENGTH_SHORT).show();
        }
        else{
            Intent enableBTintent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBTintent,REQUEST_ENABLE_BT);
        }
    }

    public void TurnBToff(){
        bluetoothadapter = BluetoothAdapter.getDefaultAdapter();

        if(bluetoothadapter.isEnabled()){
            bluetoothadapter.disable();
        }
        else{
            Toast.makeText(this,"le bluetooth est déjà désactivé",Toast.LENGTH_SHORT).show();
        }
    }
}