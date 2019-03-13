package com.example.pshruthi.miniproj1;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {
    public Button btnLogout;
    public Spinner spinComp;
    public EditText editName;
    public EditText editBranch;
    public EditText editResume;
    public EditText editTenth;
    public EditText editPuc;
    public EditText editDegree;
    public EditText editPg;
    public EditText editOthers;
    public Button buttonSave;
    DatabaseReference databaseReference;
    DatabaseReference databaseReference1;
    ListView listViewUsers;
    List<Student> students;
    public static String StudentId;
    public static String StudentEmail;



    @Override

    public void onBackPressed(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        students=new ArrayList<Student>();
        databaseReference = FirebaseDatabase.getInstance().getReference("users");
        databaseReference1 = FirebaseDatabase.getInstance().getReference("students");
        spinComp=(Spinner)findViewById(R.id.spinnerCompanies);
        editName = (EditText) findViewById(R.id.editTextName);
        editBranch = (EditText) findViewById(R.id.editTextBranch);
        editResume=(EditText)findViewById(R.id.editTextResume);
        editTenth=(EditText)findViewById(R.id.editTextTenth);
        editPuc=(EditText)findViewById(R.id.editTextPuc);
        editDegree=(EditText)findViewById(R.id.editTextDegree);
        editPg=(EditText)findViewById(R.id.editTextPG);
        editOthers=(EditText)findViewById(R.id.editTextOthers);
        buttonSave = (Button) findViewById(R.id.buttonSave);
        listViewUsers=(ListView)findViewById(R.id.listViewUsers);
        btnLogout=(Button)findViewById(R.id.buttonLogout);
        StudentEmail=FirebaseAuth.getInstance().getCurrentUser().getEmail();
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(ProfileActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                final List<String> users=new ArrayList<String>();
                for (DataSnapshot compSnapshot:dataSnapshot.getChildren()){
                    String name= compSnapshot.child("name").getValue(String.class);
                    users.add(name);

                }

                Spinner compSpinner= (Spinner)findViewById(R.id.spinnerCompanies);
                ArrayAdapter<String> compAdapter=new ArrayAdapter<String>(ProfileActivity.this,android.R.layout.simple_spinner_item, users);
                compAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                compSpinner.setAdapter(compAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String comp=spinComp.getSelectedItem().toString();
                String name = editName.getText().toString();
                String branch=editBranch.getText().toString();
                String resume = editResume.getText().toString();
                String tenth = editTenth.getText().toString();
                String puc = editPuc.getText().toString();
                String degree= editDegree.getText().toString();
                String pg=editPg.getText().toString();
                String others=editOthers.getText().toString();
                if((StudentEmail.equals(null)||name.equals("")||(branch.equals(""))||(resume.equals(""))||(tenth.equals("")||(!tenth.matches("\\d+(?:\\.\\d+)?")))||(puc.equals("")||(!puc.matches("\\d+(?:\\.\\d+)?")))||(degree.equals("")||(!degree.matches("\\d+(?:\\.\\d+)?")))||(pg.equals("")||(!pg.matches("\\d+(?:\\.\\d+)?"))))){
                    Toast.makeText(ProfileActivity.this,"Please fill all the fields and in right data type",Toast.LENGTH_LONG).show();
                }
                else
                    {
                    if (TextUtils.isEmpty(StudentId)) {
                        String id = databaseReference1.push().getKey();
                        Student student = new Student(id, StudentEmail, comp, name, branch, resume, tenth, puc, degree, pg, others);
                        databaseReference1.child(id).setValue(student);
                        Toast.makeText(ProfileActivity.this, "Student Added Successfully", Toast.LENGTH_SHORT).show();
                        StudentId = "";


                    }

                spinComp.clearFocus();
                editName.setText(null);
                editBranch.setText(null);
                editResume.setText(null);
                editTenth.setText(null);
                editPuc.setText(null);
                editDegree.setText(null);
                editPg.setText(null);
                editOthers.setText(null);


            }
            }
        });


    }
    protected void onStart(){
        super.onStart();
        databaseReference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                students.clear();
                for (DataSnapshot postSnapshot:dataSnapshot.getChildren()){
                    Student student=postSnapshot.getValue(Student.class);
                    students.add(student);

                }
                StudentList studentAdapter= new StudentList(ProfileActivity.this,students,databaseReference1,spinComp,editName,editBranch,editResume,editTenth,editPuc,editDegree,editPg,editOthers);
                listViewUsers.setAdapter(studentAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

}
