package com.example.aviv.project1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener {
Button signIn;
EditText email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        signIn=(Button)findViewById(R.id.logIn);
        email=(EditText)findViewById(R.id.emailSignIn);
        password=(EditText)findViewById(R.id.passwordSignIn);
        signIn.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

    }
}
