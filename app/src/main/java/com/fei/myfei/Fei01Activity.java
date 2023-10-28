package com.fei.myfei;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.time.Duration;

public class Fei01Activity extends AppCompatActivity implements View.OnClickListener {

    private TextView fei1_text;
    // 第1个操作数
    private String firstNum = "";
    // 运算符
    private String operator = "";
    // 第2个操作数
    private String secondNum = "";
    // 当前运算结果
    private String resData = "";
    // 显示文本内容
    private String showText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fei01);

        // 获取 fei1_text 的视图
        fei1_text = findViewById(R.id.fei1_text);
        // 监听按钮点击
        findViewById(R.id.btn_cancel).setOnClickListener(this); // 取消
        findViewById(R.id.btn_divide).setOnClickListener(this); // 除法
        findViewById(R.id.btn_multiply).setOnClickListener(this); // 乘法
        findViewById(R.id.btn_clear).setOnClickListener(this); // 删除

        findViewById(R.id.btn_seven).setOnClickListener(this); // 数字7
        findViewById(R.id.btn_eight).setOnClickListener(this); // 数字8
        findViewById(R.id.btn_nine).setOnClickListener(this); // 数字9
        findViewById(R.id.btn_plus).setOnClickListener(this); // 加法

        findViewById(R.id.btn_four).setOnClickListener(this); // 数字4
        findViewById(R.id.btn_five).setOnClickListener(this); // 数字5
        findViewById(R.id.btn_six).setOnClickListener(this); // 数字6
        findViewById(R.id.btn_minus).setOnClickListener(this); // 减法

        findViewById(R.id.btn_one).setOnClickListener(this); // 数字1
        findViewById(R.id.btn_two).setOnClickListener(this); // 数字2
        findViewById(R.id.btn_three).setOnClickListener(this); // 数字3
        findViewById(R.id.btn_sqrt).setOnClickListener(this); // 开方

        findViewById(R.id.btn_zero).setOnClickListener(this); // 数字0
        findViewById(R.id.btn_dot).setOnClickListener(this); // 小数点
        findViewById(R.id.btn_equal).setOnClickListener(this); // 等于

    }


    @Override
    public void onClick(View v) {
        String inputText;
        if (v.getId() ==  R.id.btn_sqrt) {
            inputText = "√";
        } else {
            // 获取按钮中的值
            inputText = ((TextView) v).getText().toString();
        }

        switch (inputText) {
            // 运算符按钮
            case "CE":
                clearAll();
                break;
            case "+":
                operator = "+";
                refreshText(showText + "+");
                break;
            case "−":
                operator = "−";
                refreshText(showText + "−");
                break;
            case "=":
                double calResData = calculateData();
                refreshText(String.valueOf(calResData));
                break;
            default:
                // 没有运算符,把数字拼接在第一个操作数
                if (operator.equals("")) {
                    firstNum = firstNum + inputText;
                } else {
                    // 有运算符,把数字拼接到第二个操作数
                    secondNum = secondNum + inputText;
                }

                refreshText(showText + inputText);
                break;
        }
    }

    // 加减乘除四则远算
    private double calculateData() {
        switch (operator) {
            case "+":
                return Double.parseDouble(firstNum) + Double.parseDouble(secondNum);
            case "−":
                return Double.parseDouble(firstNum) - Double.parseDouble(secondNum);
            default:
                return 0;
        }
    }

    // 清空所有内容
    private void clearAll() {
        refreshResData("");
    }

    // 刷新运算结构
    private void refreshResData(String text) {
        resData = text;
        firstNum = "";
        operator = "";
        secondNum = "";
        refreshText("");
    }

    // 刷新显示内容
    private void refreshText(String text) {
        showText = text;
        fei1_text.setText(showText);
    }

}
