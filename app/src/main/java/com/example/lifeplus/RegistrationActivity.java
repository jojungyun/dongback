package com.example.lifeplus;

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
    DatabaseReference mDatabase;
    EditText et_storename, et_storeaddress;
    //spin으로 한 카테고리 부분
    Button save_bt;

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
        et_storename = findViewById(R.id.et_storename);
        et_storeaddress = findViewById(R.id.et_storeaddress);
        save_bt = findViewById(R.id.save_bt);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        save_bt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String store_name = et_storename.getText().toString();
                String store_address = et_storeaddress.getText().toString();
                //spinner로 한 카테고리 부분 선언

                HashMap result = new HashMap();
                result.put("업체명", store_name);
                result.put("주소", store_address);
                //spinner로 한 카테고리 부분

                //데이터 베이스 쓰기 하는 함수개설
                writeUser("응디",store_name,store_address);


                // 저장하기 버튼 클릭 시 사진등록창으로 전환
                Intent intent = new Intent(getApplicationContext(), Registration_picActivity.class);
                startActivity(intent);
            }
        });
    }
    void writeUser(String _userId, String _storename, String _storeaddress /*String _category*/){
        User user = new User(_storename,_storeaddress);

        mDatabase.child("users").child(_userId).setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
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