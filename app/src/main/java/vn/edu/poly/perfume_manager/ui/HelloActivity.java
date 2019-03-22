package vn.edu.poly.perfume_manager.ui;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import vn.edu.poly.perfume_manager.R;

public class HelloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        CountDownTimer countDownTimer = new CountDownTimer(3000,3000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                finish();
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        }.start();
}
}
