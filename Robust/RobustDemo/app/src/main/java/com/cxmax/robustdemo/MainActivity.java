package com.cxmax.robustdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button changeBtn;
    private TextView textTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initChildViews();
    }

    private void initChildViews() {
        changeBtn = (Button) findViewById(R.id.change_btn);
        textTv = (TextView) findViewById(R.id.text_tv);
        changeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textTv.setText(changeText());
            }
        });
    }

    private String changeText() {
        return "hello earth";
    }
}
