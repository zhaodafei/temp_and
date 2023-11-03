package com.fei.myfei;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.fei.myfei.utils.ViewUtil;

import java.util.Random;

public class Fei03Activity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private TextView tv_password;
    private EditText et_password;
    private Button btn_forget;
    private Button bth_login;
    private CheckBox ck_remember;
    private EditText et_tel;
    private RadioButton rb_password;
    private RadioButton rb_verifyCode;
    private String myPwd = "12345";
    private String myVerifyCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fei03);

        RadioGroup rg_login = findViewById(R.id.rg_login); // RadioGroup 单选按钮组
        rg_login.setOnCheckedChangeListener(this); // 设置单选监听器

        tv_password = findViewById(R.id.tv_password);
        et_password = findViewById(R.id.et_password);
        btn_forget = findViewById(R.id.btn_forget);
        bth_login = findViewById(R.id.bth_login);
        ck_remember = findViewById(R.id.ck_remember);
        et_tel = findViewById(R.id.et_tel);
        rb_password = findViewById(R.id.rb_password);
        rb_verifyCode = findViewById(R.id.rb_verifyCode);

        // et_tel.addTextChangedListener(new HidT);
        et_tel.addTextChangedListener(new HideTextWatcher(et_tel, 11));
        et_password.addTextChangedListener(new HideTextWatcher(et_password, 6));
        btn_forget.setOnClickListener(this);
        bth_login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String tel = et_tel.getText().toString();
        // 按钮,点击事件
        if (v.getId() == R.id.btn_forget) {
            if (tel.length() < 11) {
                Toast.makeText(this, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();
                return;
            }

            if (rb_password.isChecked()) {
                // 携带手机号码跳转到找回密码页面
                Intent intent = new Intent();
                intent.setClass(Fei03Activity.this, Fei031Activity.class);
                Bundle bundle = new Bundle();
                bundle.putString("request_time", "参数1来自登录页面");
                bundle.putString("request_content", "参数2来自登录页面");
                intent.putExtras(bundle);
                startActivity(intent); // 注意这个方法,不要选错了,这个方法有多个,参数不一样

                // new Intent(this);
                // register.launch();
            } else if (rb_verifyCode.isChecked()) {
                // 生成随机数字验证码
                // myVerifyCode = String.format("%06d", new Random().nextInt(999999));
                myVerifyCode = "111222";
                // 弹出提醒对话框,提示用户记住六位验证码数字
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("请记住验证码");
                builder.setMessage("手机号" + tel + ", 本次验证码是" + myVerifyCode + ", 请输入验证码");
                builder.setPositiveButton("好的", null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        } else if (v.getId()==R.id.bth_login) {
            // 密码方式校验
            if (rb_password.isChecked()) {
                if (!myPwd.equals(et_password.getText().toString())) {
                    Toast.makeText(this, "请输入正确密码", Toast.LENGTH_SHORT).show();
                    return;
                }
                // 提示用户登录成功
                loginSuccess();
            } else if (rb_verifyCode.isChecked()) {
                if (!myVerifyCode.equals(et_password.getText().toString())) {
                    Toast.makeText(this, "请输入正确验证码", Toast.LENGTH_SHORT).show();
                    return;
                }
                // 提示用户登录成功
                loginSuccess();
            }
        }
    }

    private void loginSuccess() {
        String descMsg = String.format("您的手机号码是%s, 恭喜登录成功,点击确定按钮返回上个界面",et_tel.getText().toString());

        // 弹出提醒对话框,提示用户记住六位验证码数字
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("登录成功");
        builder.setMessage(descMsg);
        builder.setPositiveButton("确定返回", (dialog, which) -> {
            // 结束当前活动页面
            finish();
        });
        builder.setNegativeButton("我再看看", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        // 单选按钮,监听事件
        if (checkedId == R.id.rb_password) {
            // 密码登录
            tv_password.setText(getString(R.string.fei03_login_password));
            et_password.setHint(getString(R.string.fei03_input_password));
            btn_forget.setText(getString(R.string.fei03_forget_password));
            ck_remember.setVisibility(View.VISIBLE);
        } else if (checkedId == R.id.rb_verifyCode) {
            // 验证码登录
            tv_password.setText(getString(R.string.fei03_verifyCode));
            et_password.setHint(getString(R.string.fei03_input_verifyCode));
            btn_forget.setText(getString(R.string.fei03_get_verifyCode));
            ck_remember.setVisibility(View.GONE);
        }
    }

    // 定义一个编辑框监听器,在输入文本达到指定长度时自动隐藏输入法
    private class HideTextWatcher implements TextWatcher {
        private EditText mView;
        private int mMaxLength;

        public HideTextWatcher(EditText v, int maxLength) {
            this.mView = v;
            this.mMaxLength = maxLength;
        }

        // CharSequence charSequence：文本改变之前的内容
        // int i：文本开始改变时的起点位置，从0开始计算
        // int i1：要被改变的文本字数，即将要被替代的选中文本字数
        // int i2：改变后添加的文本字数，即替代选中文本后的文本字数
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        // CharSequence charSequence：文本改变之后的内容
        // int i：文本开始改变时的起点位置，从0开始计算
        // int i1：要被改变的文本字数，即已经被替代的选中文本字数
        // int i2：改变后添加的文本字数，即替代选中文本后的文本字数
        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        // Editable editable: 改变后的最终文本
        @Override
        public void afterTextChanged(Editable s) {
            if (s.toString().length() == mMaxLength) {
                // 隐藏输入法软键盘
                ViewUtil.hideAllInputMethod(Fei03Activity.this, mView);
            }
        }
    }
}