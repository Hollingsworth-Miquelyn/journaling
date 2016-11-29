package com.miquelynhollingsworth.journaling;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class OldEntriesActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oldentries);
    }

    public void BackButton(View view){
        Intent intent = new Intent(OldEntriesActivity.this, UserActivity.class);
        startActivity(intent);
    }

}
