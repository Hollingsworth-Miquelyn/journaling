package com.miquelynhollingsworth.journaling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.miquelynhollingsworth.myapplication.backend.service.RegisterUser;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    EditText fname, lname, uname, email, phone, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


    }

    public void RegisterSubmitButton(View view){

        fname = (EditText) findViewById(R.id.et_fname);
        lname = (EditText) findViewById(R.id.et_lname);
        uname = (EditText) findViewById(R.id.et_uname);
        email = (EditText) findViewById(R.id.et_email);
        phone = (EditText) findViewById(R.id.et_phone);
        password = (EditText) findViewById(R.id.et_password);

        String first = fname.getText().toString();
        String last = lname.getText().toString();
        String username = uname.getText().toString();
        String e_mail = email.getText().toString();
        String phone_number = phone.getText().toString();
        String pass = password.getText().toString();

        JSONObject user = new JSONObject();
            user.put("First", first);
            user.put("Last", last);
            user.put("Username", username);
            user.put("Email", e_mail);
            user.put("Phone", phone_number);
            user.put("Password", pass);

        String jsonUser = user.toString();
        Log.d("TAG", jsonUser);

        RegisterUser registerUser = new RegisterUser();
        registerUser.set(jsonUser);

        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
    }

}
