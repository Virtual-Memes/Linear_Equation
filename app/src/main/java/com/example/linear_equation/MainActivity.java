package com.example.linear_equation;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

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
    private EditText[][] l=new EditText[4][4];

    private float[][] L=new float[4][4];

    private float result=0;

    Button getR,Clear;
    TextView disR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar action=getSupportActionBar();
        action.hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getR=findViewById(R.id.Get_R);
        Clear=findViewById(R.id.clear);
        disR=findViewById(R.id.Dis_R);
        Edit_T_create();
        getR.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:{
                        getR.setBackgroundResource(R.drawable.button_st2);
                        break;
                    }
                    case MotionEvent.ACTION_UP:{
                        getR.setBackgroundResource(R.drawable.button_st1);
                        result=0;
                        Calculate();
                        break;
                    }
                }
                return false;
            }
        });
        Clear.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:{
                        Clear.setBackgroundResource(R.drawable.button_st4);
                        break;
                    }
                    case MotionEvent.ACTION_UP:{
                        Clear.setBackgroundResource(R.drawable.button_st3);
                        clear();
                        break;
                    }
                }
                return false;
            }
        });
    }
    protected void Edit_T_create(){
        l[0][0]=findViewById(R.id.L_11);
        l[0][1]=findViewById(R.id.L_12);
        l[0][2]=findViewById(R.id.L_13);
        l[0][3]=findViewById(R.id.L_14);

        l[1][0]=findViewById(R.id.L_21);
        l[1][1]=findViewById(R.id.L_22);
        l[1][2]=findViewById(R.id.L_23);
        l[1][3]=findViewById(R.id.L_24);

        l[2][0]=findViewById(R.id.L_31);
        l[2][1]=findViewById(R.id.L_32);
        l[2][2]=findViewById(R.id.L_33);
        l[2][3]=findViewById(R.id.L_34);

        l[3][0]=findViewById(R.id.L_41);
        l[3][1]=findViewById(R.id.L_42);
        l[3][2]=findViewById(R.id.L_43);
        l[3][3]=findViewById(R.id.L_44);
    }
    public boolean Getvalue(){
        boolean Available=true;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                String temp=l[i][j].getText().toString();
                if(temp.equals("")||temp.equals("+")||temp.equals("-")||temp.equals(".")){
                    Available=false;
                    break;
                }
                L[i][j]=Float.valueOf(temp);
            }
            if(!Available){
                break;
            }
        }
        return Available;
    }
    public void Cal(){
        for(int x0=0;x0<4;x0++){
            float Temp1=1;
            Temp1*=L[0][x0]*Math.pow(-1,2+x0);
            float[][] tempL_1=new float[3][3];
            int temp_x1=0;
            int temp_y1=0;
            for(int y1=1;y1<4;y1++){
                for (int x1=0;x1<4;x1++){
                    if(x1!=x0) {
                        tempL_1[temp_y1][temp_x1] = L[y1][x1];
                        temp_x1++;
                        if (temp_x1>2){
                            temp_x1=0;
                            temp_y1++;
                        }
                    }
                }
            }
            for(int x1=0;x1<3;x1++){
                float Temp2=1;
                float[][] tempL_2=new float[2][2];
                int temp_x2=0;
                int temp_y2=0;
                Temp2*=tempL_1[0][x1]*Math.pow(-1,2+x1);
                for(int y2=1;y2<3;y2++){
                    for(int x2=0;x2<3;x2++){
                        if(x2!=x1) {
                            tempL_2[temp_y2][temp_x2] = tempL_1[y2][x2];
                            temp_x2++;
                            if (temp_x2>1){
                                temp_x2=0;
                                temp_y2++;
                            }
                        }
                    }
                }
                float Temp3=Temp1*Temp2*(tempL_2[0][0]*tempL_2[1][1]-tempL_2[0][1]*tempL_2[1][0]);
                result+=Temp3;
            }
        }
    }
    public void Calculate() {
        boolean Flag=Getvalue();
        if(!Flag){
            disR.setText("输入错误");
        }else {
            Cal();
            disR.setText(""+result);
        }
    }
    public void clear(){
        for(int i=0;i<4;i++) {
            for (int j = 0; j < 4; j++) {
                l[i][j].setText("");
            }
        }
        disR.setText("");
    }
}
