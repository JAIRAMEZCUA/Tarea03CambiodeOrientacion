package com.example.tarea03cambiodeorientacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int []listaimagenes = {
            R.drawable.ic_baseline_accessibility_24,
            R.drawable.ic_baseline_account_circle_24,
            R.drawable.ic_launcher_background,
            R.drawable.ic_baseline_autorenew_24,
            R.drawable.ic_baseline_add_ic_call_24};
    int index = 0;

    ImageButton btn1,btn2,btn3,btn4,btn5;
    ImageView imageView,imageView2;

    Button btnatras,btnade;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int orientation = getResources().getConfiguration().orientation;
        if (Configuration.ORIENTATION_LANDSCAPE == orientation) {
            //  Toast toast1 = Toast.makeText(getApplicationContext(), "Landscape", Toast.LENGTH_SHORT);
            //toast1.show();
                btn1=findViewById(R.id.imageButton2);
                btn2=findViewById(R.id.imageButton3);
                btn3=findViewById(R.id.imageButton4);
                btn4=findViewById(R.id.imageButton5);
                btn5=findViewById(R.id.imageButton6);
                imageView=findViewById(R.id.imageView);

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageView.setImageResource(R.drawable.ic_baseline_accessibility_24);
                    }
                });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imageView.setImageResource(R.drawable.ic_baseline_account_circle_24);

                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imageView.setImageResource(R.drawable.ic_baseline_add_ic_call_24);

                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imageView.setImageResource(R.drawable.ic_baseline_autorenew_24);

                }
            });
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imageView.setImageResource(R.drawable.ic_launcher_foreground);

                }
            });

        } else {

            btnade=findViewById(R.id.btnade);
            btnatras=findViewById(R.id.btatras);
            imageView2 = findViewById(R.id.imageView2);

            btnatras.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imageView2.setImageResource(makeMove(1));
                }
            });
            btnade.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imageView2.setImageResource(makeMove(-1));
                }
            });
           // Toast toast1 = Toast.makeText(getApplicationContext(), "Portrait", Toast.LENGTH_SHORT);
            //toast1.show();
            //Log.d("Portrait", String.valueOf(orientation));
        }

    }
    public int makeMove(int move){
        if(move == 1){
            index = (1+index)%listaimagenes.length;
            return listaimagenes[index];
        }else{
            index--;
            if(index < 0) index = listaimagenes.length - 1;
            return listaimagenes[index];
        }
    }


}