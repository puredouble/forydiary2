package me.puredouble.forydiary2;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.time.LocalDate;

import me.puredouble.forydiary2.callback.FragmentChangeCallback;
import me.puredouble.forydiary2.common.handler.BackPressHandler;
import me.puredouble.forydiary2.fragment.AddFragment;
import me.puredouble.forydiary2.fragment.CalendarFragment;
import me.puredouble.forydiary2.fragment.MoreFragment;

public class MainActivity extends AppCompatActivity implements FragmentChangeCallback {

    CalendarFragment calendarFragment;
    AddFragment addFragment;
    MoreFragment moreFragment;

    final FragmentManager fragmentManager = getSupportFragmentManager();

    // BackPressHandler 객체 선언, 할당
    private BackPressHandler backPressHandler = new BackPressHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarFragment = new CalendarFragment();
        fragmentManager.beginTransaction().replace(R.id.container, calendarFragment).commit();

        // 버튼 클릭시 사용되는 리스너를 구현합니다.
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.menu_bottom);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        // 어떤 메뉴 아이템이 터치되었는지 확인합니다.
                        switch (item.getItemId()) {
                            case R.id.menu_calendar:
                                fragmentManager.beginTransaction().replace(R.id.container, calendarFragment).commit();
                                return true;

                            case R.id.menu_add:
                                addFragment = new AddFragment(LocalDate.now());
                                fragmentManager.beginTransaction().replace(R.id.container, addFragment).commit();
                                return true;

                            case R.id.menu_more:
                                moreFragment = new MoreFragment();
                                fragmentManager.beginTransaction().replace(R.id.container, moreFragment).commit();
                                return true;
                        }
                        return false;
                    }
                });
    }

    @Override
    public void onFragmentChange(Fragment fragment) {
        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
    }

    @Override
    public void onBackPressed() {
        // Default
        backPressHandler.onBackPressed();
//        // Toast 메세지 사용자 지정
//        backPressHandler.onBackPressed("뒤로가기 버튼 한번 더 누르면 종료");
//        // 뒤로가기 간격 사용자 지정
//        backPressHandler.onBackPressed(3000);
//        // Toast, 간격 사용자 지정
//        backPressHandler.onBackPressed("뒤로가기 버튼 한번 더 누르면 종료", 3000);
    }

}