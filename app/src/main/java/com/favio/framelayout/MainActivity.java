package com.favio.framelayout;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    TextView txtv_contador;
    int cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toast.makeText(this, "Hola", Toast.LENGTH_LONG).show();

        btn1=findViewById(R.id.btn1);
        txtv_contador=findViewById(R.id.contador);

        new CountDownTimer(50000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                Random rdm = new Random();
                int n=rdm.nextInt(8);

                FrameLayout.LayoutParams lp=new FrameLayout.LayoutParams(-2,-2);

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
                cont++;

                txtv_contador.setText(Integer.toString(cont));
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }
}
