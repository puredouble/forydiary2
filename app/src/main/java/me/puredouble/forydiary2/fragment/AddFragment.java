package me.puredouble.forydiary2.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import me.puredouble.forydiary2.R;

public class AddFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_add, container, false);

        ImageButton btnHappy = rootView.findViewById(R.id.btnHappy);
        btnHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "행복!", Toast.LENGTH_SHORT).show();
            }
        });

        ImageButton btnFun = rootView.findViewById(R.id.btnFun);
        btnFun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "즐거!", Toast.LENGTH_SHORT).show();
            }
        });

        ImageButton btnRandom = rootView.findViewById(R.id.btnRandom);
        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "랜!", Toast.LENGTH_SHORT).show();
            }
        });

        ImageButton btnSad = rootView.findViewById(R.id.btnSad);
        btnSad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "슬!", Toast.LENGTH_SHORT).show();
            }
        });

        ImageButton btnAngry = rootView.findViewById(R.id.btnAngry);
        btnAngry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "화남!", Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }

}