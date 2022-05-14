package com.example.week6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;
    private Spinner sp;
    private ImageButton bt;
    private Game g1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = findViewById(R.id.imageView);
        sp = findViewById(R.id.spNumbers);
        bt = findViewById(R.id.btTry);
        g1 = new Game(this);
        g1.changeImage(iv);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = sp.getSelectedItemPosition();
                if (g1.gameOver() && g1.isCorrect(i)) {
                    Glide.with(MainActivity.this).load(R.drawable.gameover).into(iv);
                    g1.restart();
                    return;
                }
                if (g1.isStart())
                    g1.changeImage(iv);
                else if (g1.isCorrect(i)) {
                    g1.changeImage(iv);
                    Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(MainActivity.this, "Try again", Toast.LENGTH_SHORT).show();
            }
        });
    }
}