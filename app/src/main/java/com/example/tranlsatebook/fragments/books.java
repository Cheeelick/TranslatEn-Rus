package com.example.tranlsatebook.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.tranlsatebook.R;

public class books extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_books, container, false);
        FrameLayout frameLayout = (FrameLayout) v.findViewById(R.id.nameBooks);

        Fragment newFragment = new FragmentText();
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction trans = fm.beginTransaction();
        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trans.replace(R.id.frame_layout,newFragment);
                trans.addToBackStack(null);
                trans.commit();
            }
        });

        return v;
    }
}