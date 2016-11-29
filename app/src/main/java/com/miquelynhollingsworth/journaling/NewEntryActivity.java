package com.miquelynhollingsworth.journaling;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import com.miquelynhollingsworth.journaling.qcJSON.*;


public class NewEntryActivity extends AppCompatActivity{
    private static int SELECTED_IMAGE = 1;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newentry);

       String currentDateString = DateFormat.getDateInstance().format(new Date());
        TextView date = (TextView) findViewById(R.id.tv_today);
        date.setText(currentDateString);

        img=(ImageView)findViewById(R.id.iv_image);
    }
    public void UploadImage(View v){
        Intent upload=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(upload, SELECTED_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SELECTED_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {

            Uri uri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                // Log.d(TAG, String.valueOf(bitmap));Login

                ImageView img = (ImageView) findViewById(R.id.iv_image);
                img.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void SubmitEntry(View view){
        //If entry posts, toast Entry Posted
        Intent submitEntry = new Intent(NewEntryActivity.this, UserActivity.class);
        startActivity(submitEntry);
    }
    public void CancelEntry(View view) {
        Intent cancelEntry = new Intent(NewEntryActivity.this, UserActivity.class);
        startActivity(cancelEntry);
    }
}
