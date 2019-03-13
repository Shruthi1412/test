package com.example.pshruthi.miniproj1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AdminProfile extends AppCompatActivity {
    Button btnSave;
    Button btnLogout;
    EditText edtName;
    EditText edtDesc;
    EditText edtElig;
    EditText edtSchedule;
    DatabaseReference databaseReference;
    ListView listViewUsers;
    List<User> users;
    public static String userId;

    @Override
    public void onBackPressed(){
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_profile);
        users=new ArrayList<User>();
        databaseReference=FirebaseDatabase.getInstance().getReference("users");
        btnSave=(Button)findViewById(R.id.btnSave);
        edtName=(EditText)findViewById(R.id.edtName);
        edtDesc=(EditText)findViewById(R.id.edtDesc);
        edtElig=(EditText)findViewById(R.id.edtElig);
        edtSchedule=(EditText)findViewById(R.id.edtSchedule);
        btnLogout=(Button)findViewById(R.id.buttonLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(AdminProfile.this,AdminLogin.class);
                startActivity(intent);
            }
        });


        listViewUsers=(ListView)findViewById(R.id.listViewUsers);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString();
                String desc = edtDesc.getText().toString();
                String elig = edtElig.getText().toString();
                String schedule = edtSchedule.getText().toString();
                if ((name.equals("")) || (desc.equals("")) || (elig.equals("")||(!elig.matches("\\d+(?:\\.\\d+)?"))) || (schedule.equals("")||(!schedule.matches("\\d{1,2}-\\d{1,2}-\\d{4}")))) {
                    Toast.makeText(AdminProfile.this, "Please fill all the fields, in right data format", Toast.LENGTH_SHORT).show();
                } else {
                    if (TextUtils.isEmpty(userId)) {
                        String id = databaseReference.push().getKey();
                        User user = new User(id, name, desc, elig, schedule);
                        databaseReference.child(id).setValue(user);
                        Toast.makeText(AdminProfile.this, "Company Added Successfully", Toast.LENGTH_SHORT).show();

                    } else {
                        databaseReference.child(userId).child("name").setValue(name);
                        databaseReference.child(userId).child("desc").setValue(desc);
                        databaseReference.child(userId).child("elig").setValue(elig);
                        databaseReference.child(userId).child("schedule").setValue(schedule);
                        Toast.makeText(AdminProfile.this, "User Updated Successfully", Toast.LENGTH_SHORT).show();
                        userId = "";
                    }


                    edtName.setText(null);
                    edtDesc.setText(null);
                    edtElig.setText(null);
                    edtSchedule.setText(null);

                }
            }
        });


    }
    protected void onStart(){
        super.onStart();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                users.clear();
                for (DataSnapshot postSnapshot:dataSnapshot.getChildren()){
                    User user=postSnapshot.getValue(User.class);
                    users.add(user);

                }
                UserList userAdapter= new UserList(AdminProfile.this,users,databaseReference,edtName,edtDesc,edtElig,edtSchedule);
                listViewUsers.setAdapter(userAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

}
