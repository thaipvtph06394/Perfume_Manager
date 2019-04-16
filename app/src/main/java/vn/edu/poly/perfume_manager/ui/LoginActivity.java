package vn.edu.poly.perfume_manager.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import vn.edu.poly.perfume_manager.R;
import vn.edu.poly.perfume_manager.database.DatabaseHelper;
import vn.edu.poly.perfume_manager.model.User;
import vn.edu.poly.perfume_manager.sqlitedao.UserDAO;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity{
    private EditText edEmail;
    private EditText edPass;
    private Button btnSignIn;
    private Button btnSignFB;
    private TextView tvSignUp;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();

        databaseHelper = new DatabaseHelper(this);

        UserDAO userDAO = new UserDAO(databaseHelper);

        final User user = new User();
        user.setUsername("admin");
        user.setName("Perfume Manager");
        user.setPassword("admin123");
        user.setSdt("0377326091");
        userDAO.insertUser(user);

        btnSignIn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = edEmail.getText().toString().trim();
                String password = edPass.getText().toString().trim();
                if (password.length() < 6 || userName.isEmpty() || password.isEmpty()) {

                    if (userName.isEmpty())
                        edEmail.setError(getString(R.string.error_empty_username));

                    if (password.length() < 6)
                        edPass.setError(getString(R.string.error_length_password));

                    if (password.isEmpty())
                        edPass.setError(getString(R.string.error_empty_password));


                } else {


                    UserDAO userDAO = new UserDAO(databaseHelper);
                    User user = userDAO.getUser(userName);

                    if (user == null) {
                        Toast.makeText(
                                LoginActivity.this,
                                getString(R.string.error_wrong_username_password), Toast.LENGTH_SHORT).show();

                    } else {

                        String passwordOnDB = user.getPassword();

                        if (passwordOnDB.equals(password)) {
                            Toast.makeText(LoginActivity.this, getString(R.string.login_success_sign_in), Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this, Nav_Home_Activity.class));
                            finish();
                        } else Toast.makeText(
                                LoginActivity.this,
                                getString(R.string.error_wrong_username_password), Toast.LENGTH_SHORT).show();

                    }


                }

            }
        });
        tvSignUp.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, CreateUserActivity.class));
                finish();
            }
        });

    }


    private void initViews() {
        edEmail =  findViewById(R.id.edEmail);
        edPass =  findViewById(R.id.edPass);
        btnSignIn =  findViewById(R.id.btnSignIn);
        btnSignFB =  findViewById(R.id.btnSignFB);
        tvSignUp =  findViewById(R.id.tvSignUp);

    }
}

