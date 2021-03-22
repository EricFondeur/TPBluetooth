package com.example.tpbluetooh;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.pm.PackageManager;
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

    private static final int REQUEST_ENABLE_BT = 2;
    public static final int REQUIEST_DISCOVERABLE_BLUETOOTH=123;
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
            case R.id.Makedev:
                MakeDiscoverable();
                break;
        }
    }

    private void Autorisation(){
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

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

    private void MakeDiscoverable(){
        Intent discoverableIntent=new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
        startActivityForResult(discoverableIntent, REQUIEST_DISCOVERABLE_BLUETOOTH);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case REQUIEST_DISCOVERABLE_BLUETOOTH:
                if (resultCode==300)
                    Toast.makeText(this, "l'appareil est visible", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "l'appareil n'est pas visible", Toast.LENGTH_SHORT).show();
        }
    }
}