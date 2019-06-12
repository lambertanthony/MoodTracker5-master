package com.example.myapplication.moodtracker;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView myImageView = findViewById(R.id.my_image_view);
        myImageView.setImageResource(R.drawable.smiley_super_happy);

        ImageButton imageButton1 = findViewById(R.id.imageButton1);
        imageButton1.setImageResource(R.drawable.ic_note_add_black);

        ImageButton imageButton2 = findViewById(R.id.imageButton2);
        imageButton2.setImageResource(R.drawable.ic_history_black);

        ViewPager viewPager =(ViewPager)findViewById(R.id.view_pager);
        viewPager.setOffscreenPageLimit(0) ;
         SwipeAdapter swipeAdapter = new  SwipeAdapter(getSupportFragmentManager());
        viewPager.setAdapter(swipeAdapter);
        viewPager.setCurrentItem(0);
    }
}
