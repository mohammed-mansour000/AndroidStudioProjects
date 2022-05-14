package com.example.complex;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText a_text1,a_text2,a_text3,a_text4,a_text5,a_text6,a_text7,a_text8;
    TextView a1,a2,a3,a4,a5,a6,a7,a8,b1,b2,b3,b4,b5,b6,b7,b8,c1,c2,c3,c4,c5,c6,c7,c8,d1,d2,d3,d4,d5,d6,d7,d8;
    TextView A1,A2,A3,A4,B1,B2,B3,B4,C1,C2,C3,C4,D1,D2,D3,D4;
    TextView T1,T2,T3,T4;
    Button add,reset,add_all,reset_all;
    AlertDialog.Builder alertDialog;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        a_text1 = findViewById(R.id.a1_text);a_text2 = findViewById(R.id.a2_text);a_text3 = findViewById(R.id.a3_text);
        a_text4 = findViewById(R.id.a4_text);a_text5 = findViewById(R.id.a5_text);a_text6 = findViewById(R.id.a6_text);
        a_text7 = findViewById(R.id.a7_text);a_text8 = findViewById(R.id.a8_text);

        a1 = findViewById(R.id.a1);a2 = findViewById(R.id.a2);a3 = findViewById(R.id.a3);a4 = findViewById(R.id.a4);
        a5 = findViewById(R.id.a5);a6 = findViewById(R.id.a6);a7 = findViewById(R.id.a7);a8 = findViewById(R.id.a8);

        b1 = findViewById(R.id.b1);b2 = findViewById(R.id.b2);b3 = findViewById(R.id.b3);b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);b6 = findViewById(R.id.b6);b7 = findViewById(R.id.b7);b8 = findViewById(R.id.b8);

        c1 = findViewById(R.id.c1);c2 = findViewById(R.id.c2);c3 = findViewById(R.id.c3);c4 = findViewById(R.id.c4);
        c5 = findViewById(R.id.c5);c6 = findViewById(R.id.c6);c7 = findViewById(R.id.c7);c8 = findViewById(R.id.c8);

        d1 = findViewById(R.id.d1);d2 = findViewById(R.id.d2);d3 = findViewById(R.id.d3);d4 = findViewById(R.id.d4);
        d5 = findViewById(R.id.d5);d6 = findViewById(R.id.d6);d7 = findViewById(R.id.d7);d8 = findViewById(R.id.d8);

        A1 = findViewById(R.id.A1);A2 = findViewById(R.id.A2);A3 = findViewById(R.id.A3);A4 = findViewById(R.id.A4);
        B1 = findViewById(R.id.B1);B2 = findViewById(R.id.B2);B3 = findViewById(R.id.B3);B4 = findViewById(R.id.B4);
        C1 = findViewById(R.id.C1);C2 = findViewById(R.id.C2);C3 = findViewById(R.id.C3);C4 = findViewById(R.id.C4);
        D1 = findViewById(R.id.D1);D2 = findViewById(R.id.D2);D3 = findViewById(R.id.D3);D4 = findViewById(R.id.D4);

        T1 = findViewById(R.id.total_1);
        T2 = findViewById(R.id.total_2);
        T3 = findViewById(R.id.total_3);
        T4 = findViewById(R.id.total_4);

        add = findViewById(R.id.add);reset = findViewById(R.id.reset);add_all = findViewById(R.id.add_all);reset_all = findViewById(R.id.reset_all);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (a_text1.getText().toString().isEmpty() || a_text2.getText().toString().isEmpty() || a_text3.getText().toString().isEmpty()
                        || a_text4.getText().toString().isEmpty() || a_text5.getText().toString().isEmpty() || a_text6.getText().toString().isEmpty()
                        || a_text7.getText().toString().isEmpty() || a_text8.getText().toString().isEmpty()) {

                    Toast.makeText(MainActivity.this, "Fill All Fields", Toast.LENGTH_SHORT).show();

                } else {

                    if (count == 0) {
                        a1.setText(a_text1.getText().toString());
                        a2.setText(a_text2.getText().toString());
                        a3.setText(a_text3.getText().toString());
                        a4.setText(a_text4.getText().toString());
                        a5.setText(a_text5.getText().toString());
                        a6.setText(a_text6.getText().toString());
                        a7.setText(a_text7.getText().toString());
                        a8.setText(a_text8.getText().toString());

                        A1.setText(Integer.parseInt(a_text1.getText().toString()) + Integer.parseInt(a_text5.getText().toString()) + "");
                        A2.setText(Integer.parseInt(a_text2.getText().toString()) + Integer.parseInt(a_text6.getText().toString()) + "");
                        A3.setText(Integer.parseInt(a_text3.getText().toString()) + Integer.parseInt(a_text7.getText().toString()) + "");
                        A4.setText(Integer.parseInt(a_text4.getText().toString()) + Integer.parseInt(a_text8.getText().toString()) + "");


                    }

                    if (count == 1) {
                        b1.setText(a_text1.getText().toString());
                        b2.setText(a_text2.getText().toString());
                        b3.setText(a_text3.getText().toString());
                        b4.setText(a_text4.getText().toString());
                        b5.setText(a_text5.getText().toString());
                        b6.setText(a_text6.getText().toString());
                        b7.setText(a_text7.getText().toString());
                        b8.setText(a_text8.getText().toString());

                        B1.setText(Integer.parseInt(a_text1.getText().toString()) + Integer.parseInt(a_text5.getText().toString()) + "");
                        B2.setText(Integer.parseInt(a_text2.getText().toString()) + Integer.parseInt(a_text6.getText().toString()) + "");
                        B3.setText(Integer.parseInt(a_text3.getText().toString()) + Integer.parseInt(a_text7.getText().toString()) + "");
                        B4.setText(Integer.parseInt(a_text4.getText().toString()) + Integer.parseInt(a_text8.getText().toString()) + "");


                    }

                    if (count == 2) {
                        c1.setText(a_text1.getText().toString());
                        c2.setText(a_text2.getText().toString());
                        c3.setText(a_text3.getText().toString());
                        c4.setText(a_text4.getText().toString());
                        c5.setText(a_text5.getText().toString());
                        c6.setText(a_text6.getText().toString());
                        c7.setText(a_text7.getText().toString());
                        c8.setText(a_text8.getText().toString());

                        C1.setText(Integer.parseInt(a_text1.getText().toString()) + Integer.parseInt(a_text5.getText().toString()) + "");
                        C2.setText(Integer.parseInt(a_text2.getText().toString()) + Integer.parseInt(a_text6.getText().toString()) + "");
                        C3.setText(Integer.parseInt(a_text3.getText().toString()) + Integer.parseInt(a_text7.getText().toString()) + "");
                        C4.setText(Integer.parseInt(a_text4.getText().toString()) + Integer.parseInt(a_text8.getText().toString()) + "");


                    }

                    if (count == 3) {
                        d1.setText(a_text1.getText().toString());
                        d2.setText(a_text2.getText().toString());
                        d3.setText(a_text3.getText().toString());
                        d4.setText(a_text4.getText().toString());
                        d5.setText(a_text5.getText().toString());
                        d6.setText(a_text6.getText().toString());
                        d7.setText(a_text7.getText().toString());
                        d8.setText(a_text8.getText().toString());

                        D1.setText(Integer.parseInt(a_text1.getText().toString()) + Integer.parseInt(a_text5.getText().toString()) + "");
                        D2.setText(Integer.parseInt(a_text2.getText().toString()) + Integer.parseInt(a_text6.getText().toString()) + "");
                        D3.setText(Integer.parseInt(a_text3.getText().toString()) + Integer.parseInt(a_text7.getText().toString()) + "");
                        D4.setText(Integer.parseInt(a_text4.getText().toString()) + Integer.parseInt(a_text8.getText().toString()) + "");


                    }
                }
            }
        });

        add_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(A1.getText().equals("") || B1.getText().equals("")
                        || C1.getText().equals("") || D1.getText().equals("")){

                    Toast.makeText(MainActivity.this, "Not Now Bitch", Toast.LENGTH_SHORT).show();

                } else {

                    T1.setText(Integer.parseInt(A1.getText().toString()) + Integer.parseInt(B1.getText().toString()) +
                            Integer.parseInt(C1.getText().toString()) + Integer.parseInt(D1.getText().toString()) + "");
                    T2.setText(Integer.parseInt(A2.getText().toString()) + Integer.parseInt(B2.getText().toString()) +
                            Integer.parseInt(C2.getText().toString()) + Integer.parseInt(D2.getText().toString()) + "");
                    T3.setText(Integer.parseInt(A3.getText().toString()) + Integer.parseInt(B3.getText().toString()) +
                            Integer.parseInt(C3.getText().toString()) + Integer.parseInt(D3.getText().toString()) + "");
                    T4.setText(Integer.parseInt(A4.getText().toString()) + Integer.parseInt(B4.getText().toString()) +
                            Integer.parseInt(C4.getText().toString()) + Integer.parseInt(D4.getText().toString()) + "");

                }
            }

        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!a_text1.getText().toString().isEmpty() && !a_text2.getText().toString().isEmpty() && !a_text3.getText().toString().isEmpty()
                    && !a_text4.getText().toString().isEmpty() && !a_text5.getText().toString().isEmpty() && !a_text6.getText().toString().isEmpty()
                      &&!a_text7.getText().toString().isEmpty() && !a_text8.getText().toString().isEmpty()) {
                    a_text1.setText("");
                    a_text2.setText("");
                    a_text3.setText("");
                    a_text4.setText("");
                    a_text5.setText("");
                    a_text6.setText("");
                    a_text7.setText("");
                    a_text8.setText("");
                    count++;
                }
            }
        });

        reset_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Hey Bitch!");
                alertDialog.setMessage("Are You Sure? All Data Will Be Deleted");
                alertDialog.setCancelable(false);
                alertDialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                a_text1.setText("");
                a_text2.setText("");
                a_text3.setText("");
                a_text4.setText("");
                a_text5.setText("");
                a_text6.setText("");
                a_text7.setText("");
                a_text8.setText("");

                a1.setText("");a2.setText("");a3.setText("");a4.setText("");
                a5.setText("");a6.setText("");a7.setText("");a8.setText("");
                A1.setText("");A2.setText("");A3.setText("");A4.setText("");

                b1.setText("");b2.setText("");b3.setText("");b4.setText("");
                b5.setText("");b6.setText("");b7.setText("");b8.setText("");
                B1.setText("");B2.setText("");B3.setText("");B4.setText("");

                c1.setText("");c2.setText("");c3.setText("");c4.setText("");
                c5.setText("");c6.setText("");c7.setText("");c8.setText("");
                C1.setText("");C2.setText("");C3.setText("");C4.setText("");

                d1.setText("");d2.setText("");d3.setText("");d4.setText("");
                d5.setText("");d6.setText("");d7.setText("");d8.setText("");
                D1.setText("");D2.setText("");D3.setText("");D4.setText("");

                T1.setText("");T2.setText("");T3.setText("");T4.setText("");

                count = 0;


                    }
                });
                alertDialog.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog dialog = alertDialog.create();
                dialog.show();
            }
        });
    }
}