package edu.citymail.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class SignupActivity extends AppCompatActivity {

    public static final String TAG = "SignUpActivity";
    private EditText name;
    private EditText SignOne;
    private EditText SignTwo;
    private Button btnSign;
    ParseUser user = new ParseUser();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        name = findViewById(R.id.name);
        SignOne = findViewById(R.id.SignOne);
        SignTwo = findViewById(R.id.SignTwo);
        btnSign = findViewById(R.id.btnSign);

        //lik login activity
        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = name.getText().toString();
                String sign1 = SignOne.getText().toString();
                String sign2 = SignTwo.getText().toString();
                if (sign1 == sign2) {
                    Toast.makeText(SignupActivity.this, "Success", Toast.LENGTH_SHORT).show();
                }
                submit(username, sign1);
            }
        });
    }

    private void submit(String username, String sign1) {
        user.setUsername(username);
        user.setPassword(sign1);
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    goMainActivity();
                } else {
                    Log.e(TAG, "Signing Up issues", e);
                    return;
                }
            }
        });
    }

    private void goMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
