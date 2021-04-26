package com.example.instrumental;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.whoareyou_layout);

        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.instrumental);
    }
}