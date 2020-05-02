package com.example.linear_equation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag_3 extends Fragment {
    private EditText[][] l=new EditText[3][3];

    private float[][] L=new float[3][3];

    private float result=0;

    Button getR,Clear;
    TextView disR;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.frag_3,container,false);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        getR=getActivity().findViewById(R.id.Get_R);
        Clear=getActivity().findViewById(R.id.clear);
        disR=getActivity().findViewById(R.id.Dis_R);
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
        super.onActivityCreated(savedInstanceState);
    }
    public boolean Getvalue(){
        boolean Available=true;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
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
        float R1=L[0][0]*(L[1][1]*L[2][2]-L[1][2]*L[2][1]);
        float R2=L[0][1]*(L[1][0]*L[2][2]-L[2][0]*L[1][2]);
        float R3=L[0][2]*(L[1][0]*L[2][1]-L[2][0]*L[1][1]);
        result=R1-R2+R3;
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
    protected void Edit_T_create(){
        l[0][0]=getActivity().findViewById(R.id.L_11);
        l[0][1]=getActivity().findViewById(R.id.L_12);
        l[0][2]=getActivity().findViewById(R.id.L_13);

        l[1][0]=getActivity().findViewById(R.id.L_21);
        l[1][1]=getActivity().findViewById(R.id.L_22);
        l[1][2]=getActivity().findViewById(R.id.L_23);

        l[2][0]=getActivity().findViewById(R.id.L_31);
        l[2][1]=getActivity().findViewById(R.id.L_32);
        l[2][2]=getActivity().findViewById(R.id.L_33);
    }
    public void clear(){
        for(int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++) {
                l[i][j].setText("");
            }
        }
        disR.setText("");
    }
}
