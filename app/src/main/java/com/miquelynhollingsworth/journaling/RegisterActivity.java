package com.miquelynhollingsworth.journaling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.miquelynhollingsworth.journaling.qcJSON.JSONInputStream;

import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {
    EditText fname, lname, uname, email, phone, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fname = (EditText) findViewById(R.id.et_fname);
        lname = (EditText) findViewById(R.id.et_lname);
        uname = (EditText) findViewById(R.id.et_user);
        email = (EditText) findViewById(R.id.et_email);
        phone = (EditText) findViewById(R.id.et_phone);
        password = (EditText) findViewById(R.id.et_password);


        /*QJsonObject register
        {
            {"First Name", fname},

        }

        JSONObject regs = new JSONObject(fname:fname, lname:lname, uname:uname, email:email, phone:phone, password:password);
        /*RegisterActivity regUser = new RegisterActivity();
        regUser = {"First Name"fname, "Last Name"lname, "Username"uname, "Email"email, "Phone"phone, "Password"password};

       /* regUser.put("First Name", fname);
        regUser.put("Last Name", lname);
        regUser.put("Username", uname);
        regUser.put("Email", email);*/


    }



    public void RegisterButton(View view){
        Intent intent = new Intent(RegisterActivity.this, UserActivity.class);
        startActivity(intent);
    }
}
