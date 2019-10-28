package com.example.myapplication.moodtracker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.gesture.Gesture;
import android.media.Image;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {
    GestureDetector gestureDetector;

    ImageView myImageView;
    ConstraintLayout mConstraintLayout;





    public static final int[] tableauImg = new int[]{
            R.drawable.smiley_sad,
            R.drawable.smiley_disappointed,
            R.drawable.smiley_normal,
            R.drawable.smiley_happy,
            R.drawable.smiley_super_happy,



    };

    public static final int[] tableauFnd = new int[]{
            R.color.faded_red,
            R.color.warm_grey,
            R.color.cornflower_blue_65,
            R.color.light_sage,
            R.color.banana_yellow,


    };


public TextView mText;
public EditText mEditText;
public String getString;

//pour le shared preference

public static final String SHARED_PREFS = "sharedPrefs";
public static final String text = "text";

    private int Index;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gestureDetector = new GestureDetector(MainActivity.this, MainActivity.this);

        Index = 3;




        myImageView = findViewById(R.id.my_image_view);
        myImageView.setImageResource(tableauImg[Index]);

        mConstraintLayout = findViewById(R.id.CouleurFond);
        mConstraintLayout.setBackgroundColor(tableauFnd[Index]);

        ImageButton imageButton1 = findViewById(R.id.imageButton1);
        imageButton1.setImageResource(R.drawable.ic_note_add_black);

        ImageButton imageButton2 = findViewById(R.id.imageButton2);
        imageButton2.setImageResource(R.drawable.ic_history_black);

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddItemDialog(MainActivity.this);
            }
        });


        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent historiqueIntent = new Intent(MainActivity.this, Historique.class);
                startActivity(historiqueIntent);
            }
        });


        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getString = mEditText.getText().toString();
                mText.setText(getString);


                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(text,mText.getText().toString());
                editor.apply();

            }
        });

        update();



        // update ici

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {showAddItemDialog(MainActivity.this);

            }
        });




imageButton2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        saveData();

    }
});

        loadData();
        updateViews();


    }
// update ici 2
    private void update() {

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        text = sharedPreferences.getString(text,"")
        // je n'arrive pas a mettre le default value )
        mText.setText(text);

    }




    public void saveData() {

            SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(text, )

            editor.apply();

            Toast.makeText(this, "Les données sont enregistrées", Toast.LENGTH_LONG).show();
        }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT, "");
        switchOnOff = sharedPreferences.getBoolean(SWITCH1, false);
    }

    public void updateViews() {
        textView.setText(text);
        switch1.setChecked(switchOnOff);
    }
    




    private void showAddItemDialog(Context c) {
        final EditText taskEditText = new EditText(c);
        AlertDialog dialog = new AlertDialog.Builder(c)
                .setTitle("Commentaire")
                .setView(taskEditText)
                .setPositiveButton("VALIDER", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String task = String.valueOf(taskEditText.getText());
                    }
                })
                .setNegativeButton("ANNULER", null)
                .create();
        dialog.show();
    }


    @Override
    public boolean onFling(MotionEvent motionEvent1, MotionEvent motionEvent2, float X, float Y) {
        if (motionEvent1.getY() - motionEvent2.getY() > 50) {
            Toast.makeText(MainActivity.this, "You Swiped up!", Toast.LENGTH_LONG).show();
            if (Index > 0 )
            Index = Index - 1;
            mConstraintLayout.setBackgroundColor(tableauFnd[Index]);
            myImageView.setImageResource(tableauImg[Index]);


            return true;

        }

        if (motionEvent2.getY() - motionEvent1.getY() > 50) {
            Toast.makeText(MainActivity.this, "You Swiped Down!", Toast.LENGTH_LONG).show();
            if (Index < 4 )
                Index = Index + 1;
            mConstraintLayout.setBackgroundColor(tableauFnd[Index]);
            myImageView.setImageResource(tableauImg[Index]);
            return true;
        } else {

            return true;
        }



    }




    @Override
    public void onLongPress(MotionEvent arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2, float arg3) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void onShowPress(MotionEvent arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean onSingleTapUp(MotionEvent arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        // TODO Auto-generated method stub
        return gestureDetector.onTouchEvent(motionEvent);
    }

    @Override
    public boolean onDown(MotionEvent arg0) {
        // TODO Auto-generated method stub
        return false;
    }

}