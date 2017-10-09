package com.example.ericvuu.whatsfordinner;

import android.content.Intent;
import android.icu.text.IDNA;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton newdish;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.newdishButton).setOnClickListener(this);
        findViewById(R.id.mealButton).setOnClickListener(this);
        findViewById(R.id.groceriesButton).setOnClickListener(this);
        findViewById(R.id.recipeButton).setOnClickListener(this);
        findViewById(R.id.infoButton).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i ==R.id.newdishButton)
        {
            Intent intent = new Intent(this, NewDishActivity.class);
            startActivity(intent);
        }
        if (i ==R.id.mealButton)
        {
            Intent intent = new Intent(this, MealActivity.class);
            startActivity(intent);
        }
        if (i ==R.id.groceriesButton)
        {
            Intent intent = new Intent(this, GroceriesActivity.class);
            startActivity(intent);
        }
        if (i ==R.id.recipeButton)
        {
            Intent intent = new Intent(this, RecipeActivity.class);
            startActivity(intent);
        }
        if (i ==R.id.infoButton)
        {
            Intent intent = new Intent(this, InfoActivity.class);
            startActivity(intent);
        }
    }
}
