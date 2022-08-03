package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void MyOnClick(View v)
    {
        switch (v.getId()){
            case R.id.button:
                onButton1Clicked();
                break;
            case R.id.button2:
                onButton2Clicked();
                break;
            case R.id.button3:
                onButton3Clicked();
                break;
        }
    }

    public void onButton1Clicked(){
        Intent myIntent = new Intent(MainActivity.this, LayoutCodeActivity.class);
        startActivity(myIntent);
    }

    public void onButton2Clicked(){
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        startActivity(myIntent);
    }

    public void onButton3Clicked(){
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-9590-2959"));
        startActivity(myIntent);
    }
}