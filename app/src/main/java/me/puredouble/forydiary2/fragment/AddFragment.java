package me.puredouble.forydiary2.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import me.puredouble.forydiary2.R;
import me.puredouble.forydiary2.callback.FragmentChangeCallback;
import me.puredouble.forydiary2.common.enums.Emotion;

public class AddFragment extends Fragment {

    FragmentChangeCallback callback;

    Add2Fragment add2Fragment;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof FragmentChangeCallback) {
            callback = (FragmentChangeCallback) context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_add, container, false);

        ImageButton btnHappy = rootView.findViewById(R.id.btnHappy);
        btnHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add2Fragment = new Add2Fragment(Emotion.HAPPY);
                callback.onFragmentChange(add2Fragment);
            }
        });

        ImageButton btnFun = rootView.findViewById(R.id.btnFun);
        btnFun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add2Fragment = new Add2Fragment(Emotion.FUN);
                callback.onFragmentChange(add2Fragment);
            }
        });

        ImageButton btnRandom = rootView.findViewById(R.id.btnRandom);
        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add2Fragment = new Add2Fragment(Emotion.RANDOM);
                callback.onFragmentChange(add2Fragment);
            }
        });

        ImageButton btnSad = rootView.findViewById(R.id.btnSad);
        btnSad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add2Fragment = new Add2Fragment(Emotion.SAD);
                callback.onFragmentChange(add2Fragment);
            }
        });

        ImageButton btnAngry = rootView.findViewById(R.id.btnAngry);
        btnAngry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add2Fragment = new Add2Fragment(Emotion.ANGRY);
                callback.onFragmentChange(add2Fragment);
            }
        });

        return rootView;
    }

}