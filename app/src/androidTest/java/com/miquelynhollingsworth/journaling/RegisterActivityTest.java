package com.miquelynhollingsworth.journaling;

import android.widget.EditText;

import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by miquelynhollingsworth on 11/29/16.
 */
public class RegisterActivityTest {

    @Test
    public void registerButton() throws Exception {

        String fname = "Jane";
        String lname = "Smith";
        String uname = "jsmith";
        String email = "jsmith@mail.com";
        String phone = null;
        String password = "password";
        String name = new String("Jane Smith");
        String name2 = new String("Jane Smith");
        int age = 29;
        int minAge = 13;

        JSONObject user = new JSONObject();
        user.put("First", fname);
        user.put("Last", lname);
        user.put("Username", uname);
        user.put("Email", email);
        user.put("Phone", phone);
        user.put("Password", password);

        String[] userArray = {fname, lname, uname, email, phone, password};
        String[] registerArray = {fname, lname, uname, email, phone, password};

        //Check if two objects are equal
        assertEquals(name2, name);

        //Check that a condition is true
        assertTrue(age > minAge);

        //Check that a condition is false
        assertFalse(age < minAge);

        //Check that an object isn't null
        assertNotNull(email);

        //Check that an object is null
        assertNull(phone);

        //Check if two object references point to the same object
        assertSame(fname,lname);

        //Check if two object references not point to the same object
        assertNotSame(user,name);

        //Check whether two arrays are equal to each other.
        assertArrayEquals(userArray, registerArray);

    }

}