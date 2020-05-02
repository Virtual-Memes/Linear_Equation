package com.example.linear_equation;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar action=getSupportActionBar();
        action.hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final Button FG_3=findViewById(R.id.fg_3);
        final Button FG_4=findViewById(R.id.fg_4);
        replaceFrag(new Frag_3());
        FG_3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                FG_3.setBackgroundResource(R.drawable.bt_second);
                FG_4.setBackgroundResource(R.drawable.bt_first);
                replaceFrag(new Frag_3());
            }
        });
        FG_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FG_4.setBackgroundResource(R.drawable.bt_second);
                FG_3.setBackgroundResource(R.drawable.bt_first);
                replaceFrag(new Frag_4());
            }
        });
    }
    public void replaceFrag(Fragment fragment){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.fragment,fragment);
        ft.commit();
    }
}
