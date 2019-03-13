package com.example.pshruthi.miniproj1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AdminLogin extends AppCompatActivity {
    private EditText txtEmailLogin;
    private EditText txtPwd;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference memail;
    @Override
    public void onBackPressed(){

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        txtEmailLogin=(EditText)findViewById(R.id.txtEmailLogin);
        txtPwd=(EditText)findViewById(R.id.txtPasswordLogin);
        firebaseAuth= FirebaseAuth.getInstance();
        memail=FirebaseDatabase.getInstance().getReference().child("Admin");


    }
    public void btnLoginUser_Click(View v){
        final String email=txtEmailLogin.getText().toString().trim();
        final String password=txtPwd.getText().toString().trim();
        memail.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String uemail=(String)dataSnapshot.child("Email").getValue().toString();
                String upassword=(String)dataSnapshot.child("Password").getValue().toString();
                if(((email.equals(uemail))&&(!TextUtils.isEmpty(email))&&(Patterns.EMAIL_ADDRESS.matcher(email).matches()))&&((password.equals(upassword))&&(!TextUtils.isEmpty(password))&&(password.length()>=6))){
                    Intent in=new Intent(AdminLogin.this,AdminProfile.class);
                    startActivity(in);
                }
                else{
                    Toast.makeText(AdminLogin.this,"Please Provide Proper Information and try again",Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


}
