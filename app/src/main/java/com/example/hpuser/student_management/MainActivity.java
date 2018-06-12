package com.example.hpuser.student_management;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText ob1;
    EditText ob2;
    Spinner  ob3;
    EditText ob5;
    EditText ob4;
    Button b1;
    Button b2;
    TextView t;
    String collegename="";

        String collnames[]={"select college","DIT", "GEU", "UIT"};

    ArrayList<Hero> al=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ob1= findViewById(R.id.first);
        ob2= findViewById(R.id.second);
        ob3= findViewById(R.id.third);
        ob4= findViewById(R.id.fourth);
        b1= findViewById(R.id.button_1);
        b2= findViewById(R.id.button_2);
        t= findViewById(R.id.students);
        ob3.setOnItemSelectedListener(this);

        ArrayAdapter arrayAdapter= new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,collnames);
        ob3.setPrompt(collnames[0]);
        ob3.setAdapter(arrayAdapter);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                String name= String.valueOf(ob1.getText());
                String address= String.valueOf(ob4.getText());
                long phone= Long.parseLong(ob2.getText().toString());

                if (name.isEmpty()||address.isEmpty()||phone==0)
                {
                    Toast.makeText(getApplicationContext(),"enter valid entries",Toast.LENGTH_SHORT).show();
                }
                else {

                    //hero obj= new hero(name,phone,collegename,address);


                     al.add(new Hero(name, phone, collegename, address));


                }


                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),"enter valid entries",Toast.LENGTH_SHORT).show();
                }


            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i=0;i<al.size();i++)
                {
                    t.setText(t.getText()+"\n"+al.get(i).name);
                    t.setText(t.getText()+"\n"+al.get(i).phone);
                    t.setText(t.getText()+"\n"+al.get(i).college);
                    t.setText(t.getText()+"\n"+al.get(i).address+"\n"+"******");


                }
            }
        });



    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        collegename=collnames[position];

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}



