package com.example.pshruthi.miniproj1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Launch extends AppCompatActivity {
    private Button StudentLogin;
    private Button AdminLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        StudentLogin=(Button)findViewById(R.id.buttonStudent);
        AdminLogin=(Button)findViewById(R.id.buttonAdmin);
        StudentLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Launch.this,MainActivity.class);
                startActivity(intent);
            }
        });
        AdminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(Launch.this,AdminLogin.class);
                startActivity(in);
            }
        });
    }
}
