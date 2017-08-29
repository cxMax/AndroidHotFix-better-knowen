package com.cxmax.robustdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.meituan.robust.patch.annotaion.Add;
import com.meituan.robust.patch.annotaion.Modify;

public class MainActivity extends AppCompatActivity {

    private Button changeBtn;
    private TextView textTv;

    @Override
    @Modify
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeBtn = (Button) findViewById(R.id.change_btn);
        textTv = (TextView) findViewById(R.id.text_tv);
        changeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textTv.setText(getInfo());
            }
        });
    }

    private String changeText() {
        return "hello earth";
    }

    @Add
    public String getInfo() {
        String msg = "";
        for (int i = 0; i < 10; i++) {
            msg += i + "\n";
        }
        return msg;
    }

}
