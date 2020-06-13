package me.puredouble.forydiary2.fragment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import me.puredouble.forydiary2.R;
import me.puredouble.forydiary2.callback.FragmentChangeCallback;
import me.puredouble.forydiary2.common.enums.Emotion;
import me.puredouble.forydiary2.common.util.DateUtil;

public class DetailFragment extends Fragment {

    FragmentChangeCallback callback;
    LocalDate localDate;

    String date;
    String dayOfWeek;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public DetailFragment(LocalDate localDate) {
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
        final ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_detail, container, false);

        TextView txtDate = rootView.findViewById(R.id.txtDate);
        txtDate.setText(this.date);

        TextView txtDayOfWeek = rootView.findViewById(R.id.txtDayOfWeek);
        txtDayOfWeek.setText(this.dayOfWeek);



        return rootView;
    }
}