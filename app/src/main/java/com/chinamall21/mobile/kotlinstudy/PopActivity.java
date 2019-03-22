package com.chinamall21.mobile.kotlinstudy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;

/**
 * desc：
 * author：Created by xusong on 2019/2/28 12:34.
 */


public class PopActivity extends AppCompatActivity {

    Button mButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);
        mButton = findViewById(R.id.btn);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view =View.inflate(v.getContext(),R.layout.pop_window,null);
                PopupWindow popupWindow = new PopupWindow(view, -2, -2);
                popupWindow.setOutsideTouchable(true);
                popupWindow.setFocusable(true);
                popupWindow.showAsDropDown(mButton);
            }
        });

    }



}
