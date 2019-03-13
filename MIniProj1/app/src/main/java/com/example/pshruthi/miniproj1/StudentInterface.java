package com.example.pshruthi.miniproj1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentInterface extends AppCompatActivity {

    private Button compreg;
    private  Button complist;

    @Override
    public void onBackPressed(){

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_interface);
        compreg=(Button)findViewById(R.id.buttonCompanyReg);
        complist=(Button)findViewById(R.id.buttonCompanyList);

        compreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in= new Intent(StudentInterface.this, ProfileActivity.class);
                startActivity(in);
            }
        });

        complist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in= new Intent(StudentInterface.this, StudentCompList.class);
                startActivity(in);

            }
        });
    }
}
