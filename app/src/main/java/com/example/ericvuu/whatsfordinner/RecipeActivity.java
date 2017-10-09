package com.example.ericvuu.whatsfordinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecipeActivity extends AppCompatActivity {

    public Button recipeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);


        recipeText = (Button) findViewById(R.id.recipe1);


        try {
            String message;
            FileInputStream fis = openFileInput("RecipeText");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer sb = new StringBuffer();
            while ((message = br.readLine()) != null) {
                sb.append(message + "\n");
            }
            recipeText.setText(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        recipeText.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getApplicationContext(), "Long Clicked " ,
                        Toast.LENGTH_SHORT).show();
                longclick();
                return true;
            }
        });
    }
    public void longclick()
    {
        Intent intent = new Intent(this, NewDishActivity.class);
        startActivity(intent);

    }


}
