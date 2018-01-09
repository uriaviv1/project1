package com.example.aviv.project1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
EditText fName,lName,password,email;
User user;
Context context;
Button signUp;
NumberPicker numberPickerl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        fName=(EditText)findViewById(R.id.firstName);
        signUp=(Button)findViewById(R.id.signUp);
        lName=(EditText)findViewById(R.id.lastName);
        email=(EditText)findViewById(R.id.Email);
        password=(EditText)findViewById(R.id.password);
        numberPickerl=(NumberPicker)findViewById(R.id.agePicker);
        numberPickerl.setMaxValue(99);
        numberPickerl.setMinValue(0);
        signUp.setOnClickListener(this);
        context=this;

    }

    @Override
    public void onClick(View view) {

            user = new User(fName.getText().toString(), lName.getText().toString(), email.getText().toString(), password.getText().toString(), numberPickerl.getValue());
            if(user!=null){

        Toast.makeText(this, user.toString(), Toast.LENGTH_LONG).show();
        Intent intent=new Intent(context,SummeyAct.class);
        intent.putExtra("age",user.getAge());
        intent.putExtra("first name", user.firstName);
        intent.putExtra("last name",user.lastName);
        startActivity(intent);
    }
    }
}
