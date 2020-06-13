package me.puredouble.forydiary2.fragment;


import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.time.LocalDate;

import me.puredouble.forydiary2.R;
import me.puredouble.forydiary2.callback.FragmentChangeCallback;
import me.puredouble.forydiary2.common.enums.Emotion;
import me.puredouble.forydiary2.common.util.DateUtil;

public class Add2Fragment extends Fragment {

    FragmentChangeCallback callback;

    Emotion emotion;

    EditText mtxtContent;

    DetailFragment detailFragment;

    LocalDate localDate;
    String date;
    String dayOfWeek;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Add2Fragment(Emotion emotion, LocalDate localDate) {
        this.emotion = emotion;
        this.localDate = localDate;

        this.date = DateUtil.format(localDate, "MM/dd");
        this.dayOfWeek = DateUtil.getDayOfWeekKorean(localDate);
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
        final ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_add2, container, false);

        TextView txtDate = rootView.findViewById(R.id.txtDate);
        txtDate.setText(this.date);

        TextView txtDayOfWeek = rootView.findViewById(R.id.txtDayOfWeek);
        txtDayOfWeek.setText(this.dayOfWeek);

        mtxtContent = rootView.findViewById(R.id.mtxtContent);

        ImageButton btnSave = (ImageButton) rootView.findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                // todo save code

                detailFragment = new DetailFragment(localDate);
                callback.onFragmentChange(detailFragment);
            }
        });

        return rootView;
    }
}
