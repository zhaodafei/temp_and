package com.fei.myfei;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Locale;

public class Fei032Activity extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private DatePicker dp_date;
    private TextView tv_date;
    private TextView tv_date2;
    // =========================== 时间 ============================================
    private TimePicker tp_time;
    private TextView tv_time;
    private TextView tv_time2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fei032);

        // =========================== 日期 ============================================
        // 一般日期选择
        findViewById(R.id.fei032_btn_ok).setOnClickListener(this);
        dp_date = findViewById(R.id.fei032_dp_date);
        tv_date = findViewById(R.id.fei032_tv_date);

        // 弹窗日期选择
        findViewById(R.id.fei032_btn_date).setOnClickListener(this);
        tv_date2 = findViewById(R.id.fei032_tv_date2);

        // =========================== 时间 ============================================
        findViewById(R.id.fei032_btn_ok_time).setOnClickListener(this);
        tp_time = findViewById(R.id.fei032_tp_time);
        tp_time.setIs24HourView(true); // 这是为24小时制
        tv_time = findViewById(R.id.fei032_tv_time);

        // 弹窗时间
        findViewById(R.id.fei032_btn_time).setOnClickListener(this);
        tv_time2 = findViewById(R.id.fei032_tv_time2);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fei032_btn_ok) {
            String desc = String.format("您选择的日期是: %d年%d月%d日", dp_date.getYear(), dp_date.getMonth(), dp_date.getDayOfMonth());
            tv_date.setText(desc);
        } else if (v.getId() == R.id.fei032_btn_date) {
            // 获取当前日期
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int monday = calendar.get(Calendar.MONDAY);
            int dayOfMonday = calendar.get(Calendar.DAY_OF_MONTH);

            // 第二个参数使用监听 onDateSet,
            // DatePickerDialog dialog = new DatePickerDialog(this, this, 2090, 5, 11);
            DatePickerDialog dialog = new DatePickerDialog(this, this, year, monday, dayOfMonday);
            dialog.show(); // 显示日期对话框
        } else if (v.getId() == R.id.fei032_btn_ok_time) {

            // ========================================== 时间选择 ==================================
            String desc = String.format("您选择的时间是: %d时%d分", tp_time.getHour(), tp_time.getMinute());
            tv_time.setText(desc);
        } else if (v.getId() == R.id.fei032_btn_time) {
            // 获取当前时间
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR);
            int minute = calendar.get(Calendar.MINUTE);
            // TimePickerDialog dialog = new TimePickerDialog(this, this, hour, minute, true);

            int themeResId = 3; // 时间主题样式,范围(1-5)
            TimePickerDialog dialog = new TimePickerDialog(this,themeResId, this, hour, minute, true);
            dialog.show(); // 显示时间对话框
        }
    }

    // 日期 dialog 监听
    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        String desc = String.format("您选择的日期是: %d年%d月%d日 ", year, month + 1, dayOfMonth);
        tv_date2.setText(desc);
    }

    // 时间 dialog 监听
    @Override
    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
        String desc = String.format("您选择的时间是: %d时%d分", hour, minute);
        tv_time2.setText(desc);
    }
}