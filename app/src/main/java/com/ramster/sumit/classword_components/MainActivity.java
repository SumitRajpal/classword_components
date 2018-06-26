package com.ramster.sumit.classword_components;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    String india[]={"Maharashtra","Karnataka","Uttar Pradesh"};
    String m[]={"PUNE","Mumbai","Solapur"};
    String b[]={"Bangalore","Khola","Domlur"};
    String u[]={"LUCKNOW","KANPUR","FAIZABAD"};
    Spinner s,s1,s2;Button next;
    Switch aSwitch;EditText name,phone,birth;
    ImageView imageview; DatePickerDialog dpd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s=(Spinner)findViewById(R.id.s);
        s1=(Spinner)findViewById(R.id.s1);
        next=(Button)findViewById(R.id.nextButton);
        aSwitch=(Switch)findViewById(R.id.on_off_switch) ;
        imageview=(ImageView)findViewById(R.id.monthvie);
        name=(EditText)findViewById(R.id.userName);
        phone=(EditText)findViewById(R.id.userPhone);
        birth=(EditText)findViewById(R.id.userDob);

        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                dpd = DatePickerDialog.newInstance(
                        MainActivity.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.show(getFragmentManager(),"Pick Date");
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    next.setEnabled(false);
                }else{
                    next.setEnabled(false);
                }
            }

        });
        final ArrayAdapter<String> ia=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,india);

        final ArrayAdapter<String>ma=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,m);

        final ArrayAdapter<String>ba=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,b);

        final ArrayAdapter<String>ua=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,u);

        ia.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        s.setAdapter(ia);

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (parent.getId()){
                    case R.id.s:{
                        if(india[position].equals("Maharashtra")){

                            ma.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            s1.setAdapter(ma);

                        }
                        if(india[position].equals("Karnataka")){

                            ba.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            s1.setAdapter(ba);

                        }
                        if(india[position].equals("Uttar Pradesh")){

                            ua.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            s1.setAdapter(ua);

                        }

                    }


                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {
        String time = ""+hourOfDay+"h"+minute+"m"+second;
        birth.setText(time);
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String date = ""+dayOfMonth+"/"+(monthOfYear+1)+"/"+year;
        birth.setText(date);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
