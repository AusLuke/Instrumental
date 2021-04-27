package com.example.instrumental;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private Button button1;
    private Button button2;
    private EditText editText1;
    private EditText editText2;

    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_lender);

        // Remap buttons for each view change
        button1 = (Button) findViewById(R.id.login_register);
        button2 = (Button) findViewById(R.id.login_sign_in);
//
//
//        button2.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v){
//                EditText editText1 = (EditText) findViewById(R.id.login_username);
//                EditText editText2 = (EditText) findViewById(R.id.login_password);
//
//                String username = editText1.getText().toString().replace(" ", "");
//                String password = editText2.getText().toString().replace(" ", "");
//
//                System.out.println(username);
//                System.out.println(password);
//                if(username.equals("admin") && password.equals("password")){
//                    Toast.makeText(MainActivity.this, "Yes :) Logging you in", Toast.LENGTH_SHORT).show();
//                    setContentView(R.layout.whoareyou_layout);
//                    setupWhoareyou();
//                }else{
//                    Toast.makeText(MainActivity.this, "Credentials incorrect. Hint, please try admin and password", Toast.LENGTH_LONG).show();
//                }
//            }
//        });

        //SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        //mapFragment.getMapAsync(this);
        //imageView = (ImageView) findViewById(R.id.imageView);
        //imageView.setImageResource(R.drawable.instrumental);
    }

    public void setupWhoareyou(){
        System.out.println("got here");
        button1 = (Button) findViewById(R.id.who_borrow_button);
        button2 = (Button) findViewById(R.id.who_lend_button);

        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setContentView(R.layout.borrower_main);
                //setupBorrowerMain();
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setContentView(R.layout.lender_side);
                //setupLenderSide();
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng nycCenter = new LatLng(40.758, -73.982);
        LatLng nycMarker1 = new LatLng(40.762, -73.981);
        LatLng nycMarker2 = new LatLng(40.759, -73.976);
        LatLng nycMarker3 = new LatLng(40.756, -73.980);
        LatLng nycMarker4 = new LatLng(40.758, -73.983);
        LatLng nycMarker5 = new LatLng(40.761, -73.985);
        mMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(this, R.raw.style_json));
        mMap.addMarker(new MarkerOptions()
                .position(nycMarker1)
                .title("Grand Piano"));
        mMap.addMarker(new MarkerOptions()
                .position(nycMarker2)
                .title("Sitar"));
        mMap.addMarker(new MarkerOptions()
                .position(nycMarker3)
                .title("Amplifier"));
        mMap.addMarker(new MarkerOptions()
                .position(nycMarker4)
                .title("Drumset"));
        mMap.addMarker(new MarkerOptions()
                .position(nycMarker5)
                .title("Clarinet"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(nycCenter, 15));
    }

}