package com.example.tranlsatebook.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.tranlsatebook.R;
import com.example.tranlsatebook.databinding.ActivityMainBinding;
import com.example.tranlsatebook.fragments.books;
import com.example.tranlsatebook.fragments.dictionary;
import com.example.tranlsatebook.fragments.profile;

public class Main extends AppCompatActivity {

    ActivityMainBinding binding;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replacedFragment(new books());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch(item.getItemId()){
                case R.id.books:
                    replacedFragment(new books());
                    break;
                case R.id.dictionary:
                    replacedFragment(new dictionary());
                    break;
                case R.id.profile:
                    replacedFragment(new profile());
                    break;
            }
            return true;
        });
    }

    private void replacedFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}