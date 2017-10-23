package com.example.ericvuu.whatsfordinner;

import android.gesture.Gesture;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static android.R.id.message;

public class GroceriesActivity extends AppCompatActivity {

    private static final String TAG ="GroceriesActivity";
    int amount = 0;
    int amount2 = 0;
    int amount3 = 0;
    int amount4 = 0;
    int amount5 = 0;

    ArrayAdapter adapter;
    public TextView textView, textView2, textView3, textView4, textView5;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groceries);
        final SwipeMenuListView listView  = (SwipeMenuListView) findViewById(R.id.listView);

        FileInputStream fis1 = null;
        FileInputStream fis2 = null;
        FileInputStream fis3 = null;
        FileInputStream fis4 = null;
        FileInputStream fis5 = null;

        String message;
        String message2;
        String message3;
        String message4;
        String message5;

        textView = (TextView) findViewById(R.id.number);
        textView2 = (TextView) findViewById(R.id.number2);
        textView3 = (TextView) findViewById(R.id.number3);
        textView4 = (TextView) findViewById(R.id.number4);
        textView5 = (TextView) findViewById(R.id.number5);

        ArrayList<String> list = new ArrayList<>();


        try {
            fis1 = openFileInput("Ingredient1");
            fis2 = openFileInput("Ingredient2");
            fis3 = openFileInput("Ingredient3");
            fis4 = openFileInput("Ingredient4");
            fis5 = openFileInput("Ingredient5");
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

        //grocery text 1
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
        list.add(sb.toString());

        // grocery text 2
        InputStreamReader isr2 = new InputStreamReader(fis2);
        BufferedReader br2 = new BufferedReader(isr2);
        StringBuffer sb2 = new StringBuffer();
        try {
            while ((message2 = br2.readLine()) != null) {
                sb2.append(message2);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        list.add(sb2.toString());


        //grocery text 3
        InputStreamReader isr3 = new InputStreamReader(fis3);
        BufferedReader br3 = new BufferedReader(isr3);
        StringBuffer sb3 = new StringBuffer();
        try {
            while ((message3 = br3.readLine()) != null) {
                sb3.append(message3);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        list.add(sb3.toString());


        //grocery text 4
        InputStreamReader isr4 = new InputStreamReader(fis4);
        BufferedReader br4 = new BufferedReader(isr4);
        StringBuffer sb4 = new StringBuffer();
        try {
            while ((message4 = br4.readLine()) != null) {
                sb4.append(message4);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        list.add(sb4.toString());


        //grocery text 5
        InputStreamReader isr5 = new InputStreamReader(fis5);
        BufferedReader br5 = new BufferedReader(isr5);
        StringBuffer sb5 = new StringBuffer();
        try {
            while ((message5 = br5.readLine()) != null) {
                sb5.append(message5);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        list.add(sb5.toString());


        adapter =  new ArrayAdapter(GroceriesActivity.this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        final SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // create "open" item
                SwipeMenuItem openItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                openItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,
                        0xCE)));
                // set item width
                openItem.setWidth(170);
                // set item title
                openItem.setTitle("+");
                // set item title fontsize
                openItem.setTitleSize(18);
                // set item title font color
                openItem.setTitleColor(Color.WHITE);
                // add to menu
                menu.addMenuItem(openItem);

                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                // set item width
                deleteItem.setWidth(170);
                // set a icon
                deleteItem.setIcon(R.mipmap.ic_minus);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };

        // set creator
        listView.setMenuCreator(creator);

        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0:
                        // +
                        Log.d(TAG, "onMenuItemCLick: clicked postion " + position);
                        if(position == 0)
                        {
                            amount++;
                            textView.setText(String.valueOf(amount));
                            Log.d(TAG, "onMenuItemCLick: amount " + amount);
                        }
                        if(position == 1)
                        {
                            amount2++;
                            textView2.setText(String.valueOf(amount2));
                            Log.d(TAG, "onMenuItemCLick: amount " + amount2);
                        }
                        if(position == 2)
                        {
                            amount3++;
                            textView3.setText(String.valueOf(amount3));
                            Log.d(TAG, "onMenuItemCLick: amount " + amount3);
                        }
                        if(position == 3)
                        {
                            amount4++;
                            textView4.setText(String.valueOf(amount4));
                            Log.d(TAG, "onMenuItemCLick: amount " + amount4);
                        }
                        if(position == 4)
                        {
                            amount5++;
                            textView5.setText(String.valueOf(amount5));
                            Log.d(TAG, "onMenuItemCLick: amount " + amount5);
                        }


                        break;
                    case 1:
                        // -
                        Log.d(TAG, "onMenuItemCLick: clicked postion " + position);
                        if(position == 0)
                        {
                            amount--;
                        }
                        if(position == 1)
                        {
                            amount2--;
                        }
                        if(position == 2)
                        {
                            amount3--;
                        }
                        if(position == 3)
                        {
                            amount4--;
                        }
                        if(position == 4)
                        {
                            amount5--;
                        }
                        break;
                }
                // false : close the menu; true : not close the menu
                return false;
            }
        });
    }

}




