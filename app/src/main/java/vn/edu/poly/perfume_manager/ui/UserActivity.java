package vn.edu.poly.perfume_manager.ui;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import vn.edu.poly.perfume_manager.R;

public class UserActivity extends AppCompatActivity {
    Toolbar toolbarUser;
    private TextView tvNameUser;
    private TextView tvEmailUser;
    private TextView tvPhoneUser;
    private TextView tvPass;
    private Button btnEditUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        toolbarUser = findViewById(R.id.toolbarUser);
        setSupportActionBar(toolbarUser);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbarUser.setTitleTextColor(Color.WHITE);
        toolbarUser.setTitle(getString(R.string.user_toolbar_title));
        toolbarUser.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        toolbarUser.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        tvNameUser = (TextView) findViewById(R.id.tvNameUser);
        tvEmailUser = (TextView) findViewById(R.id.tvEmailUser);
        tvPhoneUser = (TextView) findViewById(R.id.tvPhoneUser);
        tvPass = (TextView) findViewById(R.id.tvPass);
        btnEditUser = (Button) findViewById(R.id.btnEditUser);


    }
}
