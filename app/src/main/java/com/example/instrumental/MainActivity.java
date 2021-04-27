package com.example.instrumental;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableRow;
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
    //button3 is typically profile
    private Button button3;
    //button4 is typically chat
    private Button button4;
    //button 5 is typically back
    private Button button5;

    private ImageButton imgButton1;
    private ImageButton imgButton2;
    //imgButton3 is typically back button
    private ImageButton imgButton3;
    private EditText editText1;
    private EditText editText2;

    private TableRow tableRow1;
    private TableRow tableRow2;
    private TableRow tableRow3;

    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        setupLogin();
        //SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        //mapFragment.getMapAsync(this);
        //imageView = (ImageView) findViewById(R.id.imageView);
        //imageView.setImageResource(R.drawable.instrumental);
    }

    public void setupLogin(){
        // Remap buttons for each view change
        button1 = (Button) findViewById(R.id.login_register);
        button2 = (Button) findViewById(R.id.login_sign_in);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.create_account_layout);
                button1 = null;
                button2 = null;
                setupCreateAccount();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                editText1 = (EditText) findViewById(R.id.login_username);
                editText2 = (EditText) findViewById(R.id.login_password);

                String username = editText1.getText().toString().replace(" ", "");
                String password = editText2.getText().toString().replace(" ", "");

                if(username.equals("admin") && password.equals("password")){
                    Toast.makeText(MainActivity.this, "Yes :) Logging you in", Toast.LENGTH_SHORT).show();
                    setContentView(R.layout.whoareyou_layout);
                    editText1 = null;
                    editText2 = null;
                    setupWhoareyou();
                }else{
                    Toast.makeText(MainActivity.this, "Credentials incorrect. Hint, please try admin and password", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void setupWhoareyou(){
        button1 = (Button) findViewById(R.id.who_borrow_button);
        button2 = (Button) findViewById(R.id.who_lend_button);
        button3 = (Button) findViewById(R.id.who_profile);
        button4 = (Button) findViewById(R.id.who_chat);

        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setContentView(R.layout.borrower_main);
                button1 = null;
                button2 = null;
                setupBorrowerMain();
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setContentView(R.layout.lender_side);
                setupLenderSide();
            }
        });

        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // TODO waiting on pages
                setContentView(R.layout.profile_layout);
                button4 = null;
                setupProfileLayout("who");
            }
        });

        button4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // TODO waiting on pages
                setContentView(R.layout.chat_home);
                setupChatHome("who");
            }
        });
    }

    public void setupBorrowerMain(){
        LinearLayout layout1 = (LinearLayout) findViewById(R.id.sitarOnClick);
        LinearLayout layout2 = (LinearLayout) findViewById(R.id.grandOnClick);
        LinearLayout layout3 = (LinearLayout) findViewById(R.id.drumsetOnClick);
        LinearLayout layout4 = (LinearLayout) findViewById(R.id.ampOnClick);
        LinearLayout layout5 = (LinearLayout) findViewById(R.id.clarinetOnClick);
        imgButton1 = (ImageButton) findViewById(R.id.borrow_main_map);
        imgButton2 = (ImageButton) findViewById(R.id.borrow_main_filter);
        imgButton3 = (ImageButton) findViewById(R.id.borrow_main_back);
        button3 = (Button) findViewById(R.id.borrow_main_profile);
        button4 = (Button) findViewById(R.id.borrow_main_chat);

        imgButton1.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v){
               setContentView(R.layout.borrower_alternate);
               imgButton2 = null;
               setupBorrowAlt();
           }
        });

        imgButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                setContentView(R.layout.search_filter_layout);
                setup_SearchFilter();
            }
        });

        imgButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                setContentView(R.layout.whoareyou_layout);
                imgButton1 = null;
                imgButton2 = null;
                imgButton3 = null;
                setupWhoareyou();
            }
        });

        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setContentView(R.layout.profile_layout);
                imgButton1 = null;
                imgButton2 = null;
                imgButton3 = null;
                button4 = null;
                setupProfileLayout("borrow main");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                setContentView(R.layout.chat_home);
                setupChatHome("borrow main");
            }
        });

        layout1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setContentView(R.layout.sitar);
                setupBorrower_Sitar();
            }
        });

        layout2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setContentView(R.layout.grand_piano);
                setupBorrower_GrandPiano();
            }
        });

        layout3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setContentView(R.layout.drumset);
                setupBorrower_Drumset();
            }
        });

        layout4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setContentView(R.layout.amp);
                setupBorrower_Amp();
            }
        });

        layout5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setContentView(R.layout.clarinet);
                setupBorrower_Clarinet();
            }
        });
    }

    public void setupBorrower_Drumset(){
        button3 = (Button) findViewById(R.id.button_guitar_back);
        button4 = (Button) findViewById(R.id.button_3);

        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setContentView(R.layout.borrower_main);
                button3 = null;
                setupBorrowerMain();
            }
        });


        button4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setContentView(R.layout.chat_message);
                button3 = null;
                setupChatMessage();
            }
        });

    }

    public void setupBorrower_Sitar(){
        button3 = (Button) findViewById(R.id.btn_back_s);
        button4 = (Button) findViewById(R.id.button_3);

        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setContentView(R.layout.borrower_main);
                button3 = null;
                setupBorrowerMain();
            }
        });


        button4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setContentView(R.layout.chat_message);
                button3 = null;
                setupChatMessage();
            }
        });

    }

    public void setupBorrower_Amp(){
        button3 = (Button) findViewById(R.id.btn_back_a);
        button4 = (Button) findViewById(R.id.button_3);

        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setContentView(R.layout.borrower_main);
                button3 = null;
                setupBorrowerMain();
            }
        });


        button4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setContentView(R.layout.chat_message);
                button3 = null;
                setupChatMessage();
            }
        });

    }

    public void setupBorrower_Clarinet(){
        button3 = (Button) findViewById(R.id.btn_back_clar);
        button4 = (Button) findViewById(R.id.button_3);

        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setContentView(R.layout.borrower_main);
                button3 = null;
                setupBorrowerMain();
            }
        });


        button4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setContentView(R.layout.chat_message);
                button3 = null;
                setupChatMessage();
            }
        });

    }

    public void setupBorrower_GrandPiano(){
        button3 = (Button) findViewById(R.id.btn_back_grand);
        button4 = (Button) findViewById(R.id.button_3);

        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setContentView(R.layout.borrower_main);
                button3 = null;
                setupBorrowerMain();
            }
        });


        button4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setContentView(R.layout.chat_message);
                button3 = null;
                setupChatMessage();
            }
        });

    }

    public void setupChatHome(String pastView){
        imgButton1 = (ImageButton) findViewById(R.id.chat_home_back);
        LinearLayout layout1 = (LinearLayout) findViewById(R.id.chat1);
        LinearLayout layout2 = (LinearLayout) findViewById(R.id.chat2);
        LinearLayout layout3 = (LinearLayout) findViewById(R.id.chat3);
        LinearLayout layout4 = (LinearLayout) findViewById(R.id.chat4);

        layout1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setContentView(R.layout.chat_message);
                button3 = null;
                setupChatMessage();
            }
        });

        layout2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setContentView(R.layout.chat_message);
                button3 = null;
                setupChatMessage();
            }
        });
        layout3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setContentView(R.layout.chat_message);
                button3 = null;
                setupChatMessage();
            }
        });
        layout4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setContentView(R.layout.chat_message);
                button3 = null;
                setupChatMessage();
            }
        });

        imgButton1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                switch(pastView){
                    case "who":
                        setContentView(R.layout.whoareyou_layout);
                        setupWhoareyou();
                        break;
                    case "borrow main":
                        setContentView(R.layout.borrower_main);
                        setupBorrowerMain();
                        break;
                    case "borrow alt":
                        setContentView(R.layout.borrower_alternate);
                        setupBorrowAlt();
                        break;
                    case "lend":
                        setContentView(R.layout.lender_side);
                        setupLenderSide();
                        break;
                    case "borrow drum":
                        setContentView(R.layout.drumset);
                        setupBorrower_Drumset();
                        break;
                    case "borrow amp":
                        setContentView(R.layout.amp);
                        setupBorrower_Amp();
                        break;
                    case "borrow sitar":
                        setContentView(R.layout.sitar);
                        setupBorrower_Sitar();
                        break;
                    case "borrow clarinet":
                        setContentView(R.layout.clarinet);
                        setupBorrower_Clarinet();
                        break;
                    case "borrow piano":
                        setContentView(R.layout.grand_piano);
                        setupBorrower_GrandPiano();
                        break;
                    default:
                        setContentView(R.layout.whoareyou_layout);
                        setupWhoareyou();
                        break;
                }
            }
        });
    }

    SupportMapFragment mapFragment;


    public void setupBorrowAlt(){
        if(mapFragment == null){
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
        }
        imgButton1 = (ImageButton) findViewById(R.id.borrow_alt_list);
        imgButton3 = (ImageButton) findViewById(R.id.borrow_alt_back);
        button3 = (Button) findViewById(R.id.borrow_alt_profile);
        button4 = (Button) findViewById(R.id.borrow_alt_chat);

        imgButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.remove(getSupportFragmentManager().findFragmentById(R.id.map)).commit();
                mapFragment = null;
                setContentView(R.layout.borrower_main);
                setupBorrowerMain();
            }
        });

        imgButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.remove(getSupportFragmentManager().findFragmentById(R.id.map)).commit();
                mapFragment = null;
                setContentView(R.layout.whoareyou_layout);
                imgButton1 = null;
                imgButton3 = null;
                setupWhoareyou();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.remove(getSupportFragmentManager().findFragmentById(R.id.map)).commit();
                mapFragment = null;
                setContentView(R.layout.profile_layout);
                imgButton1 = null;
                imgButton3 = null;
                button4 = null;
                setupProfileLayout("borrow alt");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.remove(getSupportFragmentManager().findFragmentById(R.id.map)).commit();
                mapFragment = null;
                setContentView(R.layout.chat_home);
                imgButton1 = null;
                imgButton3 = null;
                button4 = null;
                setupChatHome("borrow alt");
            }
        });
    }

    public void setupProfileLayout(String pastView){
        button1 = (Button) findViewById(R.id.profile_layout_save);
        button2 = (Button) findViewById(R.id.profile_layout_logout);
        button3 = (Button) findViewById(R.id.profile_layout_myinst);
        button5 = (Button) findViewById(R.id.profile_layout_back);

        // IMPORTANT BUTTON 1 and BUTTON 5 are the same function!!!!

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                switch(pastView){
                    case "who":
                        setContentView(R.layout.whoareyou_layout);
                        setupWhoareyou();
                        break;
                    case "borrow main":
                        setContentView(R.layout.borrower_main);
                        button1 = null;
                        button2 = null;
                        button5 = null;
                        setupBorrowerMain();
                        break;
                    case "borrow alt":
                        setContentView(R.layout.borrower_alternate);
                        button1 = null;
                        button2 = null;
                        button5 = null;
                        setupBorrowAlt();
                        break;
                    case "lenderSide":
                        setContentView(R.layout.lender_side);
                        button1 = null;
                        button2 = null;
                        button3 = null;
                        button5 = null;
                        setupLenderSide();
                        break;
                    default:
                        setContentView(R.layout.login_layout);
                        button3 = null;
                        button5 = null;
                        setupLogin();
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                setContentView(R.layout.login_layout);
                button3 = null;
                button5 = null;
                setupLogin();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                setContentView(R.layout.lender_side);
                setupLenderSide();
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                switch(pastView){
                    case "who":
                        setContentView(R.layout.whoareyou_layout);
                        setupWhoareyou();
                        break;
                    case "borrow main":
                        setContentView(R.layout.borrower_main);
                        button1 = null;
                        button2 = null;
                        button5 = null;
                        setupBorrowerMain();
                        break;
                    case "borrow alt":
                        setContentView(R.layout.borrower_alternate);
                        button1 = null;
                        button2 = null;
                        button5 = null;
                        setupBorrowAlt();
                        break;
                    case "lenderSide":
                        setContentView(R.layout.lender_side);
                        button1 = null;
                        button2 = null;
                        button3 = null;
                        button5 = null;
                        setupLenderSide();
                        break;
                    default:
                        setContentView(R.layout.login_layout);
                        button3 = null;
                        button5 = null;
                        setupLogin();
                }
            }
        });
    }

    public void setupLenderSide(){
        button1 = (Button) findViewById(R.id.who_lend_button);
        button2 = (Button) findViewById(R.id.btn_login5);
        button3 = (Button) findViewById(R.id.who_profile);
        button4 = (Button) findViewById(R.id.who_chat);

        tableRow1 = (TableRow) findViewById(R.id.row1);
        tableRow2 = (TableRow) findViewById(R.id.row2);
        tableRow3 = (TableRow) findViewById(R.id.row3);

        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setContentView(R.layout.add_instr_layout);
                button1 = null;
                button2 = null;
                button3 = null;
                button4 = null;
                setup_Add_Instr_Layout();
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setContentView(R.layout.whoareyou_layout);
                button1 = null;
                button2 = null;
                button3 = null;
                button4 = null;
                setupWhoareyou();
            }
        });

        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setContentView(R.layout.profile_layout);
                button1 = null;
                button2 = null;
                button3 = null;
                button4 = null;
                setupProfileLayout("lenderSide");
            }
        });

        button4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setContentView(R.layout.chat_home);
                button1 = null;
                button2 = null;
                button3 = null;
                button4 = null;
                setupChatHome("lend");


            }
        });

        tableRow1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setContentView(R.layout.lender_guitar);
                button1 = null;
                button2 = null;
                button3 = null;
                button4 = null;
                setupLenderGuitar();
            }
        });

        tableRow2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setContentView(R.layout.lender_drumset);
                button1 = null;
                button2 = null;
                button3 = null;
                button4 = null;
                setupLenderDrumset();
            }
        });

        tableRow3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setContentView(R.layout.lender_windchimes);
                button1 = null;
                button2 = null;
                button3 = null;
                button4 = null;
                setupLenderWindChime();
            }
        });

    }

    // Add Individual Instrument Layout
    public void setupLenderDrumset(){
        button3 = (Button) findViewById(R.id.btn_drum_back);


        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setContentView(R.layout.lender_side);
                button3 = null;
                setupLenderSide();
            }
        });

    }

    // Add Individual Instrument Layout
    public void setupLenderGuitar(){
        button3 = (Button) findViewById(R.id.btn_guitar_back);


        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setContentView(R.layout.lender_side);
                button3 = null;
                setupLenderSide();
            }
        });

    }

    // Add Individual Instrument Layout
    public void setupLenderWindChime(){
        button3 = (Button) findViewById(R.id.btn_wind_back);


        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setContentView(R.layout.lender_side);
                button3 = null;
                setupLenderSide();
            }
        });

    }


    // Add Instrument Layout
    public void setup_Add_Instr_Layout(){
        button1 = (Button) findViewById(R.id.btn_okay);
        button2 = (Button) findViewById(R.id.btn_cancel);
        button3 = (Button) findViewById(R.id.borrow_main_chat);
        button4 = (Button) findViewById(R.id.btn_addimage);

        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setContentView(R.layout.lender_side);
                button1 = null;
                button2 = null;
                button3 = null;
                setupLenderSide();
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setContentView(R.layout.lender_side);
                button1 = null;
                button2 = null;
                button3 = null;
                setupLenderSide();
            }
        });

        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setContentView(R.layout.lender_side);
                button1 = null;
                button2 = null;
                button3 = null;
                setupLenderSide();
            }
        });

        button4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(getApplicationContext(),"Oops! Backend not available", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void setup_SearchFilter(){
        button1 = (Button) findViewById(R.id.btn_okay_s);
        button2 = (Button) findViewById(R.id.btn_cancel_s);
        button3 = (Button) findViewById(R.id.btn_back_search);


        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setContentView(R.layout.borrower_main);
                button1 = null;
                button2 = null;
                button3 = null;
                setupBorrowerMain();
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setContentView(R.layout.borrower_main);
                button1 = null;
                button2 = null;
                button3 = null;
                setupBorrowerMain();
            }
        });

        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setContentView(R.layout.borrower_main);
                button1 = null;
                button2 = null;
                button3 = null;
                setupBorrowerMain();
            }
        });
    }

    public void setupCreateAccount(){
        button1 = (Button) findViewById(R.id.create_account_create);
        imageView = (ImageView) findViewById(R.id.create_account_back);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.whoareyou_layout);
                button1 = null;
                imageView = null;
                setupWhoareyou();
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.login_layout);
                button1 = null;
                imageView = null;
                setupLogin();
            }
        });
    }

    public void setupLenderProfile(){
        button1 = (Button) findViewById(R.id.profile_lender_message);
        imageView = (ImageView) findViewById(R.id.profile_lender_back);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.chat_message);
                button1 = null;
                imageView = null;
//                setupWhoareyou();
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.lender_side);
                button1 = null;
                imageView = null;
                setupBorrowerMain();
            }
        });
    }

    public void setupChatMessage(){
        button3 = (Button) findViewById(R.id.back_button_message); //back button

        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setContentView(R.layout.chat_home);
                button3 = null;
                setupChatHome("");
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