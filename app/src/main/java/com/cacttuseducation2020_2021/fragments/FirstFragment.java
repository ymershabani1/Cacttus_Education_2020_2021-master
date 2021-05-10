package com.cacttuseducation2020_2021.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.cacttuseducation2020_2021.R;


public class FirstFragment extends Fragment {

    SeekBar seekBar;
    View view;
    TextView tvValueOfSeekbar;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        System.out.println("funksioni i thirrur eshte: onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("funksioni i thirrur eshte: onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_first, container, false);

        System.out.println("funksioni i thirrur eshte: onCreateView");

        seekBar = view.findViewById(R.id.seekbar);
        tvValueOfSeekbar = view.findViewById(R.id.tvValueOfProgress);
        seekBar.setProgress(50);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                System.out.println("Progresi eshte: " + progress);
               // tvValueOfSeekbar.setText("Progresi eshte: " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                tvValueOfSeekbar.setText("Progresi eshte: " + seekBar.getProgress());

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//                tvValueOfSeekbar.setText("Progresi eshte: " + seekBar.getProgress());
            }
        });


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        System.out.println("funksioni i thirrur eshte: onViewCreated");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("funksioni i thirrur eshte: onActivityCreated");
    }


    @Override
    public void onStart() {
        super.onStart();
        System.out.println("funksioni i thirrur eshte: onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("funksioni i thirrur eshte: onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("funksioni i thirrur eshte: onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("funksioni i thirrur eshte: onStop");
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.out.println("funksioni i thirrur eshte: onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("funksioni i thirrur eshte: onDestroy");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        System.out.println("funksioni i thirrur eshte: onDetach");
    }
    

}