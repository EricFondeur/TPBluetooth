package com.example.tpbluetooh;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView readbuffer, status;
    Button btOn, btOff, showpaired, discoverDev, makeDev;
    ListView listDev;
    BluetoothAdapter bluetoothadapter;
    ArrayAdapter BTarrayadapteur;

    private static final int  REQUEST_ENABLE_BT = 2;
    private static final int REQUEST_ENABLE_LOCATION = 457;

    private BluetoothAdapter bluetoothAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //test
        Init();
        Autorisation();
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
        BTarrayadapteur = new ArrayAdapter(this,R.layout.simple_list_item_1);
        listDev.setAdapter(BTarrayadapteur);
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
                ShowPairedDev();
                break;
            case R.id.Dicoverdev:
                break;
        }
    }

    private void Autorisation(){
        bluetoothadapter = BluetoothAdapter.getDefaultAdapter();

        if ( checkSelfPermission( Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED ) {
            requestPermissions(
                    new String[] {  android.Manifest.permission.ACCESS_COARSE_LOCATION  },
                    REQUEST_ENABLE_LOCATION );
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

    public void ShowPairedDev(){
        bluetoothadapter = BluetoothAdapter.getDefaultAdapter();
        Set<BluetoothDevice> listdev;
        if (bluetoothadapter.isEnabled()){
            listdev = bluetoothadapter.getBondedDevices();
            for (BluetoothDevice device : listdev){
                BTarrayadapteur.add(device.getName()+"\n"+device.getAddress());
            }
        }
        else{
            Toast.makeText(this, "Bluetooth désactivé",Toast.LENGTH_SHORT).show();
        }

    }
}