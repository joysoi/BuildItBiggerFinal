package com.example.mylibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainAndroidActivityFragment extends Fragment {

    public MainAndroidActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main_android_activity, container, false);

        TextView view = (TextView) root.findViewById(R.id.txt1);
        view.setText(getActivity().getIntent().getStringExtra("MESSAGE"));
        return root;
    }


}
