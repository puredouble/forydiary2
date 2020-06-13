package me.puredouble.forydiary2.common.util;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RequiresApi(api = Build.VERSION_CODES.O)
public class DateUtil {

    public static String format(LocalDate localDate, String pattern) {
        return localDate.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 한국어 요일 구하기
     */
    public static String getDayOfWeekKorean(LocalDate localDate) {
        String result = "";

        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        switch (dayOfWeek) {
            case MONDAY:
                result = "월요일";
                break;
            case TUESDAY:
                result = "화요일";
                break;
            case WEDNESDAY:
                result = "수요일";
                break;
            case THURSDAY:
                result = "목요일";
                break;
            case FRIDAY:
                result = "금요일";
                break;
            case SATURDAY:
                result = "토요일";
                break;
            case SUNDAY:
                result = "일요일";
                break;
        }

        return result;
    }

}
