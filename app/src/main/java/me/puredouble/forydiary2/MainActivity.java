package me.puredouble.forydiary2;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import me.puredouble.forydiary2.fragment.AddFragment;
import me.puredouble.forydiary2.fragment.CalendarFragment;
import me.puredouble.forydiary2.fragment.MoreFragment;

public class MainActivity extends AppCompatActivity {

    CalendarFragment calendarFragment;
    AddFragment addFragment;
    MoreFragment moreFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FragmentManager fragmentManager = getSupportFragmentManager();
//        calendarFragment = (CalendarFragment) fragmentManager.findFragmentById(R.id.calendarFragment);
        calendarFragment = new CalendarFragment();
        addFragment = new AddFragment();
        moreFragment = new MoreFragment();

        fragmentManager.beginTransaction().replace(R.id.container, calendarFragment).commit();

        // 버튼 클릭시 사용되는 리스너를 구현합니다.
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.menu_bottom);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        // 어떤 메뉴 아이템이 터치되었는지 확인합니다.
                        switch (item.getItemId()) {
                            case R.id.menu_calendar:
                                fragmentManager.beginTransaction().replace(R.id.container, calendarFragment).commit();
                                return true;

                            case R.id.menu_add:
                                fragmentManager.beginTransaction().replace(R.id.container, addFragment).commit();
                                return true;

                            case R.id.menu_more:
                                fragmentManager.beginTransaction().replace(R.id.container, moreFragment).commit();
                                return true;
                        }
                        return false;
                    }
                });
    }

}