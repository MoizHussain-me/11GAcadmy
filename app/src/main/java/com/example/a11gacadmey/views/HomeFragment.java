package com.example.a11gacadmey.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a11gacadmey.R;
import com.example.a11gacadmey.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentHomeBinding binding =   FragmentHomeBinding.inflate(inflater, container,false );

        return binding.getRoot();
    }
}