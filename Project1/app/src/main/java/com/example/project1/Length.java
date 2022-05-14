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

import static java.lang.Math.round;

public class Length extends AppCompatActivity {

    TextView unitName1,unitName2;
    EditText input_from,input_to;
    RadioGroup group_from,group_to;
    Button convert;
    ImageView reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);

        unitName1 = findViewById(R.id.unitname1);
        unitName2 = findViewById(R.id.unitname2);

        input_from = findViewById(R.id.first_input);
        input_to = findViewById(R.id.second_input);
        input_to.setEnabled(false); //disable the input so it will only show the result

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

                    } else if(r_from_text.equals("Kilometer") && r_to_text.equals("Meter")){

                        input_to.setText(from_Kilo_To_Meter());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Kilometer") && r_to_text.equals("Mile")){

                        input_to.setText(from_Kilo_To_Mile());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Kilometer") && r_to_text.equals("Feet")){

                        input_to.setText(from_Kilo_To_Feet());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Kilometer") && r_to_text.equals("Inch")){

                        input_to.setText(from_Kilo_To_Inch());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Kilometer") && r_to_text.equals("Centimeter")){

                        input_to.setText(from_Kilo_To_Cm());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Meter") && r_to_text.equals("Kilometer")){

                        input_to.setText(from_Meter_To_Kilo());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Meter") && r_to_text.equals("Mile")){

                        input_to.setText(from_Meter_To_Mile());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Meter") && r_to_text.equals("Feet")){

                        input_to.setText(from_Meter_To_Feet());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Meter") && r_to_text.equals("Inch")){

                        input_to.setText(from_Meter_To_Inch());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Meter") && r_to_text.equals("Centimeter")){

                        input_to.setText(from_Meter_To_Cm());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Mile") && r_to_text.equals("Kilometer")){

                        input_to.setText(from_Mile_To_Kilo());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Mile") && r_to_text.equals("Meter")){

                        input_to.setText(from_Mile_To_Meter());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Mile") && r_to_text.equals("Feet")){

                        input_to.setText(from_Mile_To_Feet());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Mile") && r_to_text.equals("Inch")){

                        input_to.setText(from_Mile_To_Inch());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Mile") && r_to_text.equals("Centimeter")){

                        input_to.setText(from_Mile_To_Cm());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Feet") && r_to_text.equals("Kilometer")){

                        input_to.setText(from_Feet_To_Kilo());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Feet") && r_to_text.equals("Meter")){

                        input_to.setText(from_Feet_To_Meter());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Feet") && r_to_text.equals("Mile")){

                        input_to.setText(from_Feet_To_Mile());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Feet") && r_to_text.equals("Inch")){

                        input_to.setText(from_Feet_To_Inch());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Feet") && r_to_text.equals("Centimeter")){

                        input_to.setText(from_Feet_To_Cm());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Inch") && r_to_text.equals("Kilometer")){

                        input_to.setText(from_Inch_To_Kilo());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Inch") && r_to_text.equals("Meter")){

                        input_to.setText(from_Inch_To_Meter());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Inch") && r_to_text.equals("Mile")){

                        input_to.setText(from_Inch_To_Mile());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Inch") && r_to_text.equals("Feet")){

                        input_to.setText(from_Inch_To_Feet());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Inch") && r_to_text.equals("Centimeter")){

                        input_to.setText(from_Inch_To_Cm());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Centimeter") && r_to_text.equals("Kilometer")){

                        input_to.setText(from_Cm_To_Kilo());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Centimeter") && r_to_text.equals("Meter")){

                        input_to.setText(from_Cm_To_Meter());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Centimeter") && r_to_text.equals("Mile")){

                        input_to.setText(from_Cm_To_Mile());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Centimeter") && r_to_text.equals("Feet")){

                        input_to.setText(from_Cm_To_Feet());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Centimeter") && r_to_text.equals("Inch")){

                        input_to.setText(from_Cm_To_Inch());
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

////////////////////
// from kilo to
////////////////////

public String from_Kilo_To_Meter(){

    double k = Double.parseDouble(input_from.getText().toString());
    double formula = k*1000;
    return formula + "  m";

}
public String from_Kilo_To_Mile(){

    double k = Double.parseDouble(input_from.getText().toString());
    String formula = String.format("%.4f", k / 1.6);
    return formula + " mile";

}
public String from_Kilo_To_Feet(){

        double k = Double.parseDouble(input_from.getText().toString());
        String formula = String.format("%.4f",k*3281);
        return formula + " feet";

}
public String from_Kilo_To_Inch(){

        double k = Double.parseDouble(input_from.getText().toString());
        String formula = String.format("%.4f", k*39370);
        return formula + " inch";

}
public String from_Kilo_To_Cm(){

        double k = Double.parseDouble(input_from.getText().toString());
        double formula = k*100000;
        return formula + " cm";

}

////////////////////
// from meter to
////////////////////

public String from_Meter_To_Kilo(){

    double m = Double.parseDouble(input_from.getText().toString());
    double formula = m/1000;
    return formula + " km";

}

public String from_Meter_To_Mile(){

        double m = Double.parseDouble(input_from.getText().toString());
        String formula = String.format("%.4f",m/1609);
        return formula + " mile";

}

public String from_Meter_To_Feet(){

        double m = Double.parseDouble(input_from.getText().toString());
        String formula = String.format("%.4f",m * 3.281);
        return formula + " feet";

}
public String from_Meter_To_Inch(){

        double m = Double.parseDouble(input_from.getText().toString());
        String formula = String.format("%.4f", m * 39.37);
        return formula + " inch";

}

public String from_Meter_To_Cm(){

        double m = Double.parseDouble(input_from.getText().toString());
        double formula = m * 100;
        return formula + " cm";

}

////////////////////
// from mile to
////////////////////

public String from_Mile_To_Kilo(){

        double mile = Double.parseDouble(input_from.getText().toString());
        String formula = String.format("%.4f", mile * 1.609);
        return formula + " km";

}

public String from_Mile_To_Meter(){

        double mile = Double.parseDouble(input_from.getText().toString());
        String formula = String.format("%.4f",mile * 1609);
        return formula + " m";

}

public String from_Mile_To_Feet(){

        double mile = Double.parseDouble(input_from.getText().toString());
        String formula = String.format("%.4f", mile * 5280);
        return formula + " feet";

}

public String from_Mile_To_Inch(){

        double mile = Double.parseDouble(input_from.getText().toString());
        String formula = String.format("%.4f",mile * 63360);
        return formula + " inch";

}

public String from_Mile_To_Cm(){

        double mile = Double.parseDouble(input_from.getText().toString());
    String formula = String.format("%.4f", mile * 160934);
        return formula + " cm";

}

////////////////////
// from feet to
////////////////////

public String from_Feet_To_Kilo(){

    double feet = Double.parseDouble(input_from.getText().toString());
    String formula = String.format("%.4f", feet / 3281);
    return formula + " km";

}

public String from_Feet_To_Meter(){

        double feet = Double.parseDouble(input_from.getText().toString());
        String formula = String.format("%.4f", feet / 3.2);
        return formula + " m";

}

public String from_Feet_To_Mile(){

        double feet = Double.parseDouble(input_from.getText().toString());
        String formula = String.format("%.4f",feet / 5280);
        return formula + " mile";

}

public String from_Feet_To_Inch(){

        double feet = Double.parseDouble(input_from.getText().toString());
        String formula = String.format("%.4f", feet * 12);
        return formula + " inch";

}

public String from_Feet_To_Cm(){

        double feet = Double.parseDouble(input_from.getText().toString());
        String formula = String.format("%.4f",feet * 30.48);
        return formula + " cm";

}

////////////////////
// from inch to
////////////////////

public String from_Inch_To_Kilo(){

        double inch = Double.parseDouble(input_from.getText().toString());
        String formula = String.format("%.4f",inch / 39370);
        return formula + " km";

}

public String from_Inch_To_Meter(){

        double inch = Double.parseDouble(input_from.getText().toString());
        String formula = String.format("%.4f", inch / 39);
        return formula + " m";

}

public String from_Inch_To_Mile(){

        double inch = Double.parseDouble(input_from.getText().toString());
        String formula = String.format("%.4f",inch / 63360);
        return formula + " mile";

}

public String from_Inch_To_Feet(){

        double inch = Double.parseDouble(input_from.getText().toString());
        String formula = String.format("%.4f",inch / 12);
        return formula + " feet";

}

public String from_Inch_To_Cm(){

        double inch = Double.parseDouble(input_from.getText().toString());
        String formula = String.format("%.4f",inch * 2.54);
        return formula + " cm";

}

////////////////////
// from Cm to
////////////////////

public String from_Cm_To_Kilo(){

        double cm = Double.parseDouble(input_from.getText().toString());
        String formula = String.format("%.6f",cm / 100000);
        return formula + " km";

}

public String from_Cm_To_Meter(){

        double cm = Double.parseDouble(input_from.getText().toString());
        String formula = String.format("%.4f", cm / 100);
        return formula + " m";

}

public String from_Cm_To_Mile(){

        double cm = Double.parseDouble(input_from.getText().toString());
        String formula = String.format("%.6f",cm / 160934);
        return formula + " mile";

}

public String from_Cm_To_Feet(){

        double cm = Double.parseDouble(input_from.getText().toString());
        String formula = String.format("%.4f",cm / 30.48);
        return formula + " feet";

}

public String from_Cm_To_Inch(){

        double cm = Double.parseDouble(input_from.getText().toString());
        String formula = String.format("%.4f",cm / 2.54);
        return formula + " inch";

}


}