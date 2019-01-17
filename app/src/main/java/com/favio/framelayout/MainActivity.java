package com.favio.framelayout;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    TextView lbl_contador;
    int cont=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toast.makeText(this, "Hola", Toast.LENGTH_LONG).show();

        //Alt+P Navigate file -> moverse en archivos
        //Alt+R Reformat code -> acomodar código
        //Alt+D Add selection for next ocurrence -> para multicursor
        //Ctrl+F encontrar palabra en el archivo abierto

        btn1 = findViewById(R.id.btn1);
        lbl_contador = findViewById(R.id.lbl_contador);

        View.OnClickListener click_btn =new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cont++;
                lbl_contador.setText(String.valueOf(cont));
                //lbl_contador.setText(Integer.toString(cont))
            }
        };

        btn1.setOnClickListener(click_btn);

        new CountDownTimer(50000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                Random rdm = new Random();
                int n = rdm.nextInt(7)+1;

                Log.d("número", Integer.toString(n));

                FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(-2, -2);

                switch (n) {
                    case 1:
                        lp.gravity = Gravity.TOP | Gravity.LEFT;
                        break;
                    case 2:
                        lp.gravity = Gravity.TOP | Gravity.CENTER_HORIZONTAL;
                        break;
                    case 3:
                        lp.gravity = Gravity.TOP | Gravity.RIGHT;
                        break;
                    case 4:
                        lp.gravity = Gravity.CENTER_VERTICAL | Gravity.LEFT;
                        break;
                    case 5:
                        lp.gravity = Gravity.CENTER_VERTICAL | Gravity.RIGHT;
                        break;
                    case 6:
                        lp.gravity = Gravity.BOTTOM | Gravity.LEFT;
                        break;
                    case 7:
                        lp.gravity = Gravity.BOTTOM | Gravity.RIGHT;
                        break;
                    default:
                        break;
                }

                btn1.setLayoutParams(lp);
            }

            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this, "Tiempo terminado", Toast.LENGTH_LONG).show();
            }
        }.start();
    }
}
