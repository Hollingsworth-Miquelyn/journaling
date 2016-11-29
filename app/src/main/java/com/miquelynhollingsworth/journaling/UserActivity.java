package com.miquelynhollingsworth.journaling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserActivity extends AppCompatActivity {
    Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_user);
        logout = (Button) findViewById(R.id.b_logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(getApplicationContext(), LoginActivity.class);
                login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(login);
                finish();
            }
        });
    }
    public void NewEntryButton(View view){
        Intent newEntry = new Intent(UserActivity.this, NewEntryActivity.class);
        startActivity(newEntry);
    }
    public void OldEntriesButton(View view){
        Intent oldEntries = new Intent(UserActivity.this, OldEntriesActivity.class);
        startActivity(oldEntries);
    }


}
