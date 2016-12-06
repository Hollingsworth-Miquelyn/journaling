package com.miquelynhollingsworth.journaling;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by miquelynhollingsworth on 11/30/16.
 */

public class WriteToFile extends AppCompatActivity{



    /*public void write() {

        JSONObject countryObj = new JSONObject();
        countryObj.put("Name", "India");
        countryObj.put("Population", new Integer(1000000));

        JSONArray listOfStates = new JSONArray();
        listOfStates.add("Madhya Pradesh");
        listOfStates.add("Maharastra");
        listOfStates.add("Rajasthan");

        countryObj.put("States", listOfStates);

        try {

            // Writing to a file
            File file=new File("/Users/miquelynhollingsworth/AndroidStudioProjects/Journaling/app/src/main/java/com/miquelynhollingsworth/journaling/CountryJSONFile.json");
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);

            fileWriter.write(countryObj.toJSONString());
            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/
}
