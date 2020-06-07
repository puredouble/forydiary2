package me.puredouble.forydiary2;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 버튼 누른 결과를 보여주기 위해 TextView를 사용합니다.

        final TextView message = (TextView)findViewById(R.id.textview_main_message);


        // 버튼 클릭시 사용되는 리스너를 구현합니다.

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.menu_bottom);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                        // 어떤 메뉴 아이템이 터치되었는지 확인합니다.
                        switch (item.getItemId()) {

                            case R.id.menu_calendar:

                                message.setText("Calendar 버튼을 눌렀습니다.");

                                return true;

                            case R.id.menu_add:

                                message.setText("Add 버튼을 눌렀습니다.");

                                return true;

                            case R.id.menu_more:

                                message.setText("More 버튼을 눌렀습니다.");

                                return true;
                        }
                        return false;
                    }
                });
    }

}