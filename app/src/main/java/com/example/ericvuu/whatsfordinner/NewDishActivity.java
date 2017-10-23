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
    String ingredient1, ingredient2, ingredient3;

    public String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/WhatsforDinner";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_dish);

        findViewById(R.id.Addbutton).setOnClickListener(this);
        findViewById(R.id.Savebutton).setOnClickListener(this);
        findViewById(R.id.RecipeName).setOnFocusChangeListener(this);
        imageView = (ImageView) findViewById(R.id.recipeimage);
        recipeText = (EditText) findViewById(R.id.RecipeName);
        Spinner dropdown1 = (Spinner) findViewById(R.id.ingredient1);
        Spinner dropdown2 = (Spinner) findViewById(R.id.ingredient2);
        Spinner dropdown3 = (Spinner) findViewById(R.id.ingredient3);
        Spinner dropdown4 = (Spinner) findViewById(R.id.ingredient4);
        Spinner dropdown5 = (Spinner) findViewById(R.id.ingredient5);
        direction = (EditText) findViewById(R.id.DirectionText);

        //dropdown1
         ArrayAdapter<String> adapterIngredient1 = new ArrayAdapter<String>(NewDishActivity.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.names));
        adapterIngredient1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown1.setAdapter(adapterIngredient1);
        dropdown1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                @Override
                                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                                    String parent = adapterView.getItemAtPosition(i).toString();
                                                    try {
                                                        FileOutputStream fos1 = openFileOutput(file_name1, MODE_PRIVATE);
                                                        fos1.write(parent.getBytes());
                                                    } catch (FileNotFoundException e) {
                                                        e.printStackTrace();
                                                    } catch (IOException e) {
                                                        e.printStackTrace();
                                                    }

                                                }

                                                @Override
                                                public void onNothingSelected(AdapterView<?> adapterView) {

                                                }
                                            });

        //dropdown2
        ArrayAdapter<String> adapterIngredient2 = new ArrayAdapter<String>(NewDishActivity.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.names));
        adapterIngredient2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown2.setAdapter(adapterIngredient2);
        dropdown2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String parent = adapterView.getItemAtPosition(i).toString();
                try {
                    FileOutputStream fos2 = openFileOutput(file_name2, MODE_PRIVATE);
                    fos2.write(parent.getBytes());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //dropdown3
        ArrayAdapter<String> adapterIngredient3 = new ArrayAdapter<String>(NewDishActivity.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.names));
        adapterIngredient3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown3.setAdapter(adapterIngredient3);
        dropdown3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String parent = adapterView.getItemAtPosition(i).toString();
                try {
                    FileOutputStream fos3 = openFileOutput(file_name3, MODE_PRIVATE);
                    fos3.write(parent.getBytes());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //dropdown4
        ArrayAdapter<String> adapterIngredient4 = new ArrayAdapter<String>(NewDishActivity.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.names));
        adapterIngredient4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown4.setAdapter(adapterIngredient4);
        dropdown4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String parent = adapterView.getItemAtPosition(i).toString();
                try {
                    FileOutputStream fos4 = openFileOutput(file_name4, MODE_PRIVATE);
                    fos4.write(parent.getBytes());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //dropdown5
        ArrayAdapter<String> adapterIngredient5 = new ArrayAdapter<String>(NewDishActivity.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.names));
        adapterIngredient5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown5.setAdapter(adapterIngredient5);
        dropdown5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String parent = adapterView.getItemAtPosition(i).toString();
                try {
                    FileOutputStream fos5 = openFileOutput(file_name5, MODE_PRIVATE);
                    fos5.write(parent.getBytes());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //dropdown3.setAdapter(myAdapter);
        //dropdown4.setAdapter(myAdapter);
        //dropdown5.setAdapter(myAdapter);
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
                FileOutputStream fosRecipeText = openFileOutput(file_name, MODE_PRIVATE);
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
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
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}



