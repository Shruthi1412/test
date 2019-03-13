package com.example.pshruthi.miniproj1;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class StudentList extends ArrayAdapter<Student> {

    private Activity context;
    private List<Student> students;
    DatabaseReference databaseReference1;
    Spinner comp;
    EditText name;
    EditText branch;
    EditText resume;
    EditText tenth;
    EditText puc;
    EditText degree;
    EditText pg;
    EditText others;

    public StudentList(@NonNull Activity context, List<Student> students, DatabaseReference databaseReference1,Spinner comp, EditText name, EditText branch, EditText resume, EditText tenth,EditText puc, EditText degree,EditText pg, EditText others) {
        super(context, R.layout.layout_student_list,students);
        this.context=context;
        this.students=students;
        this.databaseReference1=databaseReference1;
        this.comp=comp;
        this.name=name;
        this.branch=branch;
        this.resume=resume;
        this.tenth=tenth;
        this.puc=puc;
        this.degree=degree;
        this.pg=pg;
        this.others=others;
    }
    public View getView(int pos, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.layout_student_list, null, true);
        final TextView txtName = (TextView) listViewItem.findViewById(R.id.txtName);





        final Student student=students.get(pos);
        //txtName.setText(student.getComp());


        return listViewItem;
    }
}
