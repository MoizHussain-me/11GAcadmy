package com.example.a11gacadmey.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.textclassifier.TextClassification;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.a11gacadmey.R;
import com.example.a11gacadmey.databinding.FragmentCourseDetailBinding;
import com.example.a11gacadmey.viewmodels.CourseViewModel;

public class CourseDetailFragment extends Fragment {

    FragmentCourseDetailBinding binding;
CourseViewModel viewModel;

    public CourseDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding = FragmentCourseDetailBinding.inflate(inflater,container,false);




        return binding.getRoot();
 }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(CourseViewModel.class);


        binding.setVariable(viewModel.getCourseModel());



    }
}