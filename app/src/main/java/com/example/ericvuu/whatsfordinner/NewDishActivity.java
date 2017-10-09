package com.example.ericvuu.whatsfordinner;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.*;
import java.net.URI;
import java.util.ArrayList;

public class NewDishActivity extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener, AdapterView.OnItemSelectedListener {

    private static final int PICK_IMAGE = 100;
    public Uri imageUri;
    public ImageView imageView;
    public EditText recipeText, direction;
    public TextView textView;
    public Spinner dropdown1, dropdown2, dropdown3, dropdown4, dropdown5;
    ArrayList<String> options = new ArrayList<String>();
    String file_name1 = "Ingredient1";
    String file_name2 = "Ingredient2";
    String file_name3 = "Ingredient3";
    String file_name4 = "Ingredient4";
    String file_name5 = "Ingredient5";

    public String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/WhatsforDinner";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_dish);

        findViewById(R.id.Addbutton).setOnClickListener(this);
        findViewById(R.id.Savebutton).setOnClickListener(this);
        findViewById(R.id.loadButton).setOnClickListener(this);
        findViewById(R.id.RecipeName).setOnFocusChangeListener(this);
        imageView = (ImageView) findViewById(R.id.recipeimage);
        recipeText = (EditText) findViewById(R.id.RecipeName);
        Spinner dropdown1 = (Spinner) findViewById(R.id.ingredient1);
        Spinner dropdown2 = (Spinner) findViewById(R.id.ingredient2);
        Spinner dropdown3 = (Spinner) findViewById(R.id.ingredient3);
        Spinner dropdown4 = (Spinner) findViewById(R.id.ingredient4);
        Spinner dropdown5 = (Spinner) findViewById(R.id.ingredient5);
        dropdown1.setOnItemSelectedListener(this);
        dropdown2.setOnItemSelectedListener(this);
        dropdown3.setOnItemSelectedListener(this);
        dropdown4.setOnItemSelectedListener(this);
        dropdown5.setOnItemSelectedListener(this);
        direction = (EditText) findViewById(R.id.DirectionText);
        textView = (TextView) findViewById(R.id.loadView);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(NewDishActivity.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown1.setAdapter(myAdapter);
        dropdown2.setAdapter(myAdapter);
        dropdown3.setAdapter(myAdapter);
        dropdown4.setAdapter(myAdapter);
        dropdown5.setAdapter(myAdapter);
        File dir = new File(path);
        dir.mkdirs();

    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.Addbutton) {
            openGallery();
        }
        if (i == R.id.Savebutton) {
            String message = recipeText.getText().toString();
            String file_name = "RecipeText";

            String file_name6 = "Directions";

            try {
                FileOutputStream fos = openFileOutput(file_name, MODE_PRIVATE);
                FileOutputStream fos6 = openFileOutput(file_name6, MODE_APPEND);
                fos.write(message.getBytes() );
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if (i == R.id.loadButton) {
            try {
                String message;
                FileInputStream fis = openFileInput("RecipeText");
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);
                StringBuffer sb = new StringBuffer();
                while ((message = br.readLine()) != null) {
                    sb.append(message);
                }
                textView.setText(sb.toString());

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageUri = data.getData();
            imageView.setImageURI(imageUri);
        }
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        if (!b) {
            try {
                String message;
                FileInputStream fis = openFileInput("RecipeText");
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);
                StringBuffer sb = new StringBuffer();
                while ((message = br.readLine()) != null) {

                    if (sb.toString().equals(recipeText.getText().toString())) {
                        recipeText.setError("Recipe is already exisit");
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
    {


        String ingredient = adapterView.getItemAtPosition(i).toString();

        try {
            FileOutputStream fos1 = openFileOutput(file_name1, MODE_PRIVATE);
            FileOutputStream fos2 = openFileOutput(file_name2, MODE_PRIVATE);
            FileOutputStream fos3 = openFileOutput(file_name3, MODE_PRIVATE);
            FileOutputStream fos4 = openFileOutput(file_name4, MODE_PRIVATE);
            FileOutputStream fos5 = openFileOutput(file_name5, MODE_PRIVATE);
            fos1.write(ingredient.getBytes());
            fos2.write(ingredient.getBytes());
            fos3.write(ingredient.getBytes());
            fos4.write(ingredient.getBytes());
            fos5.write(ingredient.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}



