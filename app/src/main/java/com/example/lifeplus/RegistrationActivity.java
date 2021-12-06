package com.example.lifeplus;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {

    ArrayAdapter<CharSequence>arrayAdapter;
    private TextView tv_result;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        final String[]categoryy={"음식점","카페","편의점","의료","교육","미용","문화/취미","유통","기타"};

        Spinner spinner=(Spinner) findViewById(R.id.spin1);

        ArrayAdapter<String> adapter;
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,categoryy);
        spinner.setAdapter(adapter);
    }

}