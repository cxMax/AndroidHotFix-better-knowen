package com.cxmax.hotfixdemo;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Cat cat = new Cat();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, cat.say(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.e("info", "onSaveInstanceState: ");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e("info", "onRestoreInstanceState: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("info", "onPause: ");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("info", "onStop: ");

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public static class Cat {

        public String say() {
            return "汪汪汪!";
        }
    }
}
