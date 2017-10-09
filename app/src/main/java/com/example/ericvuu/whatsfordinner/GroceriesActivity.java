package com.example.ericvuu.whatsfordinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class GroceriesActivity extends AppCompatActivity {
    public TextView groceryname1, groceryname2, groceryname3, groceryname4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groceries);


        groceryname1 = (TextView) findViewById(R.id.grocery1);
        groceryname2 = (TextView) findViewById(R.id.grocery2);
        groceryname3 = (TextView) findViewById(R.id.grocery3);
        groceryname4 = (TextView) findViewById(R.id.grocery4);

        String message;
        String message2;
        FileInputStream fis1 = null;
        FileInputStream fis2 = null;
        FileInputStream fis3 = null;
        FileInputStream fis4 = null;
        try {
            fis1 = openFileInput("Ingredient1");
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        InputStreamReader isr = new InputStreamReader(fis1);
        BufferedReader br = new BufferedReader(isr);
        StringBuffer sb = new StringBuffer();
        try {
            while ((message = br.readLine()) != null) {
                sb.append(message);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        groceryname1.setText(sb.toString());
        try {
            fis1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fis2 = openFileInput("Ingredient2");
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        InputStreamReader isr2 = new InputStreamReader(fis2);
        BufferedReader br2 = new BufferedReader(isr2);
        StringBuffer sb2 = new StringBuffer();
        try {
            while ((message2 = br2.readLine()) != null) {
                sb.append(message2);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        groceryname2.setText(sb2.toString());
        try {
            fis2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
