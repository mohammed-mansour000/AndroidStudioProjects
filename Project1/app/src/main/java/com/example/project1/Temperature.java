package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Temperature extends AppCompatActivity {

    TextView unitName1,unitName2;
    EditText input_from,input_to;
    RadioGroup group_from,group_to;
    Button convert;
    ImageView reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        unitName1 = findViewById(R.id.unitname1);
        unitName2 = findViewById(R.id.unitname2);

        input_from = findViewById(R.id.first_input);
        input_to = findViewById(R.id.second_input);
        input_to.setEnabled(false);

        group_from = findViewById(R.id.group_from);
        group_to = findViewById(R.id.group_to);

        convert = findViewById(R.id.convert_btn);
        reset = findViewById(R.id.reset);

        takeRadioValue();

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if input fields is full
                if(!input_from.getText().toString().isEmpty()){

                    String value_from_input = input_from.getText().toString();
                    String value_to_input = input_to.getText().toString();

                    RadioButton r_from = findViewById(group_from.getCheckedRadioButtonId());
                    RadioButton r_to = findViewById(group_to.getCheckedRadioButtonId());

                    String r_from_text = r_from.getText().toString(); // value of radio_form
                    String r_to_text = r_to.getText().toString();   // value of radio_to

                    if(r_from_text.equals(r_to_text)){

                        input_to.setText(value_from_input);
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Celsius(°C)") && r_to_text.equals("Fahrenheit(°F)")){

                        input_to.setText(from_C_To_F());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Fahrenheit(°F)") && r_to_text.equals("Celsius(°C)")){

                        input_to.setText(from_F_To_C());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Celsius(°C)") && r_to_text.equals("Kelvin(°K)")){

                        input_to.setText(from_C_To_K());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Kelvin(°K)") && r_to_text.equals("Celsius(°C)")){

                        input_to.setText(from_K_To_C());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Fahrenheit(°F)") && r_to_text.equals("Kelvin(°K)")){

                        input_to.setText(from_F_To_K());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Kelvin(°K)") && r_to_text.equals("Fahrenheit(°F)")){

                        input_to.setText(from_K_To_F());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    }



                    takeRadioValue();

                }else{
                    Toast.makeText(getApplicationContext(),"Please Fill The Field",Toast.LENGTH_SHORT).show();
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioButton r_from = findViewById(R.id.radioButton);
                r_from.setChecked(true);
                RadioButton r_to = findViewById(R.id.radioButton5);
                r_to.setChecked(true);

                if(!input_from.getText().toString().isEmpty() || !input_to.getText().toString().isEmpty()) {
                    input_from.setText("");
                    input_to.setText("");
                    Toast.makeText(getApplicationContext(), "Cleared", Toast.LENGTH_SHORT).show();
                    takeRadioValue();
                }
            }
        });
    }

    public void takeRadioValue(){
        // for 1st group
        group_from = findViewById(R.id.group_from);
        RadioButton rf = findViewById(group_from.getCheckedRadioButtonId());
        unitName1.setText(rf.getText().toString());
        // for 1st group
        group_to = findViewById(R.id.group_to);
        RadioButton rd = findViewById(group_to.getCheckedRadioButtonId());
        unitName2.setText(rd.getText().toString());
    }

    public String from_C_To_F(){

        double c = Double.parseDouble(input_from.getText().toString());
        String formula = String.format("%.4f", c*(9.0/5.0) + 32);
        return formula + "";

    }
    public String from_F_To_C(){

        double f = Double.parseDouble(input_from.getText().toString());
        String formula = String.format("%.4f",(f-32)*(5.0/9.0));
        return formula + "";

    }
    public String from_C_To_K(){

        double c = Double.parseDouble(input_from.getText().toString());
        double formula = c + 273.15;
        return formula + "";

    }
    public String from_K_To_C(){

        double k = Double.parseDouble(input_from.getText().toString());
        String formula = String.format("%.4f",k - 273.15);
        return formula + "";

    }
    public String from_F_To_K(){

        double f = Double.parseDouble(input_from.getText().toString());
        String formula = String.format("%.4f",(f - 32) * (5.0/9.0) + 273.15);
        return formula + "";

    }
    public String from_K_To_F(){

        double k = Double.parseDouble(input_from.getText().toString());
        String formula = String.format("%.4f",(k - 273.15) * (9.0/5.0) + 32);
        return formula + "";

    }

}