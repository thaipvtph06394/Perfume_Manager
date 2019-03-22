package vn.edu.poly.perfume_manager.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import vn.edu.poly.perfume_manager.R;

public class CreateUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
    }

    public void onAdd(View view) {
        Toast.makeText(this, "Them thanh cong", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
    }

    public void onCannel(View view) {

    }

    public void onSignIn(View view) {
        Toast.makeText(this, "Chuyen Sang Man Hinh Dang Nhap", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
    }
}
