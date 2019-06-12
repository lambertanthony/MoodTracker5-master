package com.example.myapplication.moodtracker;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by <VOTRE-NOM> on <DATE-DU-JOUR>.
 */
public class SwipeAdapter extends FragmentStatePagerAdapter {




    public SwipeAdapter(FragmentManager fm ) {super(fm);}

    @Override
    public Fragment getItem(int position) {

        FragmentPage pageFragment;
        pageFragment = new  FragmentPage();
        Bundle bundle =new Bundle();
        bundle.putInt("pageNumber",position+1);
        pageFragment.setArguments(bundle);

        return pageFragment;
    }


    @Override
    public int getCount() {
        return 4;
    }
}
