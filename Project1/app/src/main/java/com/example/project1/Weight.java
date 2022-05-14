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

public class Weight extends AppCompatActivity {

    TextView unitName1,unitName2;
    EditText input_from,input_to;
    RadioGroup group_from,group_to;
    Button convert;
    ImageView reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

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

                    } else if(r_from_text.equals("Kilogram") && r_to_text.equals("Gram")){

                        input_to.setText(from_Kg_To_g());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Kilogram") && r_to_text.equals("Pound")){

                        input_to.setText(from_Kg_To_Pound());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Kilogram") && r_to_text.equals("Ounce")){

                        input_to.setText(from_Kg_To_Ounce());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Gram") && r_to_text.equals("Kilogram")){

                        input_to.setText(from_g_To_kg());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Gram") && r_to_text.equals("Pound")){

                        input_to.setText(from_g_To_Pound());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Gram") && r_to_text.equals("Ounce")){

                        input_to.setText(from_g_To_Ounce());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Pound") && r_to_text.equals("Kilogram")){

                        input_to.setText(from_Pound_To_kg());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Pound") && r_to_text.equals("Gram")){

                        input_to.setText(from_Pound_To_g());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Pound") && r_to_text.equals("Ounce")){

                        input_to.setText(from_Pound_To_Ounce());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Ounce") && r_to_text.equals("Kilogram")){

                        input_to.setText(from_Ounce_To_kg());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Ounce") && r_to_text.equals("Gram")){

                        input_to.setText(from_Ounce_To_g());
                        Toast.makeText(getApplicationContext(),"Data Converted",Toast.LENGTH_SHORT).show();

                    } else if(r_from_text.equals("Ounce") && r_to_text.equals("Pound")){

                        input_to.setText(from_Ounce_To_pound());
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
// from kg to
////////////////////

public String from_Kg_To_g(){

    double kg = Double.parseDouble(input_from.getText().toString());
    String formula = String.format("%.1f",kg * 1000);
    return formula + " g";

}
public String from_Kg_To_Pound(){

    double kg = Double.parseDouble(input_from.getText().toString());
    String formula = String.format("%.4f",kg * 2.205);
    return formula + " pound";
}
public String from_Kg_To_Ounce(){

    double kg = Double.parseDouble(input_from.getText().toString());
    String formula = String.format("%.4f",kg * 35.274);
    return formula + " ounce";
}

////////////////////
// from gram to
////////////////////

public String from_g_To_kg(){

    double g = Double.parseDouble(input_from.getText().toString());
    String formula = String.format("%.4f",g / 1000);
    return formula + " kg";

}
public String from_g_To_Pound(){

    double g = Double.parseDouble(input_from.getText().toString());
    String formula = String.format("%.4f",g / 454);
    return formula + " pound";
}
public String from_g_To_Ounce(){

    double g = Double.parseDouble(input_from.getText().toString());
    String formula = String.format("%.4f",g / 28.35);
    return formula + " ounce";
}

////////////////////
// from pound to
////////////////////

public String from_Pound_To_kg(){

    double Pound = Double.parseDouble(input_from.getText().toString());
    String formula = String.format("%.4f",Pound / 2.205);
    return formula + " kg";

}
public String from_Pound_To_g(){

    double Pound = Double.parseDouble(input_from.getText().toString());
    String formula = String.format("%.2f",Pound * 454);
    return formula + " g";
}
public String from_Pound_To_Ounce(){

    double Pound = Double.parseDouble(input_from.getText().toString());
    String formula = String.format("%.2f",Pound * 16);
    return formula + " ounce";
}

////////////////////
// from ounce to
////////////////////

public String from_Ounce_To_kg(){

    double ounce = Double.parseDouble(input_from.getText().toString());
    String formula = String.format("%.4f",ounce / 35.274);
    return formula + " kg";

}
public String from_Ounce_To_g(){

    double ounce = Double.parseDouble(input_from.getText().toString());
    String formula = String.format("%.2f",ounce * 28.35);
    return formula + " g";
}
public String from_Ounce_To_pound(){

    double ounce = Double.parseDouble(input_from.getText().toString());
    String formula = String.format("%.4f",ounce / 16);
    return formula + " pound";
}

}