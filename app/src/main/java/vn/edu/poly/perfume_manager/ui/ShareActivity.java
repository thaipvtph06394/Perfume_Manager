package vn.edu.poly.perfume_manager.ui;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import vn.edu.poly.perfume_manager.R;

public class ShareActivity extends AppCompatActivity {
    Toolbar toolbarShare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        toolbarShare = findViewById(R.id.toolbarShare);
        setSupportActionBar(toolbarShare);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbarShare.setTitleTextColor(Color.WHITE);
        toolbarShare.setTitle("Chia sẻ App");
        toolbarShare.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        toolbarShare.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
