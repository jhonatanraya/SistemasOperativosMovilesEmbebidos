package com.example.hito3.Adapters;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hito3.OnBoarding.SegundoFragment;
import com.example.hito3.OnBoarding.SeleccionarFragment;
import com.example.hito3.OnBoarding.SomeFragment;
import com.example.hito3.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OnboardingAdapter extends FragmentPagerAdapter {

    public OnboardingAdapter(FragmentManager fm) {
        super(fm);
    }
        // Required empty public constructor



    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new SomeFragment();
            case 1:
                return new SegundoFragment();

            case 2:
                return new SeleccionarFragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
