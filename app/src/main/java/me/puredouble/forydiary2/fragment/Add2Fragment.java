package me.puredouble.forydiary2.fragment;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import me.puredouble.forydiary2.R;
import me.puredouble.forydiary2.callback.FragmentChangeCallback;
import me.puredouble.forydiary2.common.enums.Emotion;

public class Add2Fragment extends Fragment {

    FragmentChangeCallback callback;

    Emotion emotion;

    EditText mtxtContent;

    DetailFragment detailFragment;

    public Add2Fragment(Emotion emotion) {
        this.emotion = emotion;
    }

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

        mtxtContent = rootView.findViewById(R.id.mtxtContent);
        ImageButton btnSave = rootView.findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "save", Toast.LENGTH_SHORT).show();

                // todo save code


                detailFragment = new DetailFragment();
                callback.onFragmentChange(detailFragment);
            }
        });

        return rootView;
    }
}
