package vn.edu.poly.perfume_manager.ui;


import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import vn.edu.poly.perfume_manager.R;
import vn.edu.poly.perfume_manager.database.DatabaseHelper;
import vn.edu.poly.perfume_manager.model.Product;
import vn.edu.poly.perfume_manager.model.User;
import vn.edu.poly.perfume_manager.sqlitedao.UserDAO;

public class CreateUserActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText edUsername;
    private EditText edPassword;
    private EditText edRePassword;
    private EditText edName,edPhonenumber;
    private Button btnAddUser;
    private Button btnCancel;
    private TextView tvSignIn;
    private DatabaseHelper databaseHelper;
    private UserDAO userDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        databaseHelper = new DatabaseHelper(this);
        userDAO = new UserDAO(databaseHelper);

        initViews();
        toolbarViews();

        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User users = new User();

                users.username = edUsername.getText().toString().trim();
                users.name = edName.getText().toString().trim();
                users.password = edPassword.getText().toString().trim();
                String repassword = edRePassword.getText().toString().trim();

                if (users.username.isEmpty()){
                    edUsername.setError(getString(R.string.create_error_username));
                    return;
                }
                if (users.password.isEmpty()){
                    edPassword.setError(getString(R.string.create_error_username));
                    return;
                }
                if (repassword.isEmpty()){
                    edRePassword.setError(getString(R.string.create_error_username));
                    return;
                }if (users.name.isEmpty()){
                    edName.setError(getString(R.string.create_error_username));
                    return;
                }
                if ( !users.password.equals(repassword)){
                    edRePassword.setError(getString(R.string.create_error_repassword));
                    return;
                }if (users.username.length()<6){
                    edUsername.setError(getString(R.string.create_error_length_username));
                    return;
                }if (users.password.length()<6){
                    edPassword.setError(getString(R.string.create_error_length_username));
                    return;
                }try {
                    users.sdt = edPhonenumber.getText().toString().trim();

                }catch (NumberFormatException ex){
                    edPhonenumber.setError(getString(R.string.create_error_number_phone));
                }

                userDAO.insertUser(users);
                Toast.makeText(CreateUserActivity.this, getString(R.string.create_message_success), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(CreateUserActivity.this,LoginActivity.class));
                finish();


            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edUsername.setText("");
                edName.setText("");
                edPassword.setText("");
                edRePassword.setText("");
                edPhonenumber.setText("");
            }
        });
        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreateUserActivity.this,LoginActivity.class));
                finish();
            }
        });
    }

    private void toolbarViews() {
        toolbar = findViewById(R.id.toolbarCreateUser);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setTitle(getString(R.string.createuser_title));
    }


    private void initViews() {
        edUsername =  findViewById(R.id.edUsername);
        edPassword =  findViewById(R.id.edPassword);
        edRePassword =  findViewById(R.id.edRePassword);
        edPhonenumber =  findViewById(R.id.edPhonenumber);
        edName =  findViewById(R.id.edName);
        btnAddUser =  findViewById(R.id.btnAddUser);
        btnCancel =  findViewById(R.id.btnCancel);
        tvSignIn =  findViewById(R.id.tvSignIn);
    }


}
