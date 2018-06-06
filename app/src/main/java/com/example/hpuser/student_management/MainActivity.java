package com.example.hpuser.student_management;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

class hero
{
    String name;
    int phone;
    String college;
    String address;

   public hero( String name,int phone,String college,String address)
    {
        this.name=name;
        this.phone=phone;
        this.college=college;
        this.address=address;
    }

}
public class MainActivity extends AppCompatActivity {

    EditText ob1;
    EditText ob2;
    EditText ob3;
    EditText ob4;
    Button b1;
    Button b2;
    TextView t;


    ArrayList<hero> al=new ArrayList<hero>();

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

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                String name= String.valueOf(ob1.getText());
                String college= String.valueOf(ob3.getText());
                String address= String.valueOf(ob4.getText());
                int phone= Integer.parseInt(ob2.getText().toString());

                if (name.isEmpty()|| college.isEmpty()||address.isEmpty()||phone==0)
                {
                    Toast.makeText(getApplicationContext(),"enter valid entries",Toast.LENGTH_SHORT).show();
                }
                else {

                    hero obj= new hero(name,phone,college,address);


                     al.add(new hero(name, phone, college, address));


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
                    t.setText(t.getText()+"\n"+al.get(i).address);

                }
            }
        });



    }
}
