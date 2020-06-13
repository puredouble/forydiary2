package me.puredouble.forydiary2.fragment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class AddFragment extends Fragment {

    FragmentChangeCallback callback;

    Add2Fragment add2Fragment;

    LocalDate localDate;
    String date;
    String dayOfWeek;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public AddFragment(LocalDate localDate) {
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
        final ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_add, container, false);

        TextView txtDate = rootView.findViewById(R.id.txtDate);
        txtDate.setText(this.date);

        TextView txtDayOfWeek = rootView.findViewById(R.id.txtDayOfWeek);
        txtDayOfWeek.setText(this.dayOfWeek);

        ImageButton btnHappy = rootView.findViewById(R.id.btnHappy);
        btnHappy.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                moveToAdd2(Emotion.HAPPY);
            }
        });

        ImageButton btnFun = rootView.findViewById(R.id.btnFun);
        btnFun.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                moveToAdd2(Emotion.FUN);
            }
        });

        ImageButton btnRandom = rootView.findViewById(R.id.btnRandom);
        btnRandom.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                moveToAdd2(Emotion.RANDOM);
            }
        });

        ImageButton btnSad = rootView.findViewById(R.id.btnSad);
        btnSad.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                moveToAdd2(Emotion.SAD);
            }
        });

        ImageButton btnAngry = rootView.findViewById(R.id.btnAngry);
        btnAngry.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                moveToAdd2(Emotion.ANGRY);
            }
        });

        return rootView;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void moveToAdd2(Emotion emotion) {
        add2Fragment = new Add2Fragment(emotion, localDate);
        callback.onFragmentChange(add2Fragment);
    }

}