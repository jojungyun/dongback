package com.example.dongback;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class RegistrationActivity extends AppCompatActivity {

    private Spinner spinner;//spinner사용하기 위한 선언

    //데베에 저장하기 위한 선언
    EditText et_store_name, et_store_address;
    Button save_bt;

    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        //spinner
        final String[]categoryy={"카테고리를 선택해주세요","음식점","카페","편의점","의료","교육","미용","문화/취미","유통","기타"};

        Spinner spinner=(Spinner) findViewById(R.id.spin1);

        ArrayAdapter<String> adapter;
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,categoryy);
        spinner.setAdapter(adapter);

        //edittext
        et_store_name = findViewById(R.id.et_store_name);
        et_store_address = findViewById(R.id.et_store_address);
        save_bt = findViewById(R.id.save_bt);

        //firebase 데이터베이스 정의
        mDatabase = FirebaseDatabase.getInstance().getReference();

        save_bt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String store_name = et_store_name.getText().toString();
                String store_address = et_store_address.getText().toString();

                HashMap result = new HashMap();
                result.put("store_name", store_name);
                result.put("store_address", store_address);

                //데이터 베이스 쓰기 하는 함수개설
                writeUser("응디",store_name,store_address);


                // 저장하기 버튼 클릭 시 사진등록창으로 전환
                Intent intent = new Intent(getApplicationContext(), Registration_picActivity.class);
                startActivity(intent);
            }
        });
    }
    void writeUser(String _userId, String _store_name, String _store_address){
        User user = new User(_store_name,_store_address);

        mDatabase.child("users").child(_userId).setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                //성공하면 실행
                Toast.makeText(getApplicationContext(),"저장 완료",Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                //실패하면 실행
                Toast.makeText(getApplicationContext(),"저장 실패",Toast.LENGTH_SHORT).show();
            }
        });
    }
}