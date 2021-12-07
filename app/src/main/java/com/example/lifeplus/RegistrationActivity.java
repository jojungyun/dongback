package com.example.lifeplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        final String[]category={"카테고리를 선택해주세요","음식점","카페","편의점","의료","교육","미용","문화/취미","유통","기타"};

        Spinner spinner=(Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<String> adapter;
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,category);
        spinner.setAdapter(adapter);

        // 저장하기 버튼 클릭 시 사진등록창으로 전환
        Button button = (Button) findViewById(R.id.upload);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), Registration_picActivity.class);
                startActivity(intent);
            }
        });
    }
}