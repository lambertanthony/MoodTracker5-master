package com.example.myapplication.moodtracker;

import android.content.Context;
import android.content.DialogInterface;
import android.gesture.Gesture;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {
    GestureDetector gestureDetector;


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

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddItemDialog(MainActivity.this);
            }
        });

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


        gestureDetector = new GestureDetector(MainActivity.this, MainActivity.this);
    }


    @Override
    public boolean onFling(MotionEvent motionEvent1, MotionEvent motionEvent2, float X, float Y) {
        if (motionEvent1.getY() - motionEvent2.getY() > 50) {
            Toast.makeText(MainActivity.this, "You Swiped up!", Toast.LENGTH_LONG).show();
            return true;
        }

        if (motionEvent2.getY() - motionEvent1.getY() > 50) {
            Toast.makeText(MainActivity.this, "You Swiped Down!", Toast.LENGTH_LONG).show();
            return true;
        }

        if (motionEvent1.getX() - motionEvent2.getX() > 50) {
            Toast.makeText(MainActivity.this, "You Swiped Left!", Toast.LENGTH_LONG).show();
            return true;
        }

        if (motionEvent2.getX() - motionEvent1.getX() > 50) {
            Toast.makeText(MainActivity.this, "You Swiped Right!", Toast.LENGTH_LONG).show();
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