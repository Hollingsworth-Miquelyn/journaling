package com.miquelynhollingsworth.journaling;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;




public class LoginActivity extends Activity {

    EditText user, password;
    Button login, register;

    // Creating JSON Parser object
    JSONParser jParser = new JSONParser();
    JSONObject json;
    private static String url_login = "http://10.0.2.2:8080/backend/LoginServlet";
    //JSONArray incoming_msg = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        /*findViewsById();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String username = user.getText().toString();
                String pass = password.getText().toString();
                new Login().execute();
            }
        });*/
    }

   /* private void findViewsById() {
        user = (EditText) findViewById(R.id.et_user);
        password = (EditText) findViewById(R.id.et_password);
        login = (Button) findViewById(R.id.b_login);
        register = (Button) findViewById(R.id.b_register);
    }

    private class Login extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... args) {
            // Getting username and password from user input
            String username = args[0];
            String pass = args[0];

            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("u", username));
            params.add(new BasicNameValuePair("p", pass));
            String s = null;

            try {
                s = json.getString("info");
                Log.d("Msg", json.getString("info"));
                if (s.equals("success")) {
                    Intent login = new Intent(getApplicationContext(), UserActivity.class);
                    startActivity(login);
                    finish();
                }
            } catch (JSONException e) {
                //TODO Auto-generated catch block
                e.printStackTrace();
            }

            return null;

        }
    }*/

    public void LoginButton(View v) {
        Intent intent = new Intent(LoginActivity.this, UserActivity.class);
        startActivity(intent);
    }

    public void RegisterButton(View v) {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
