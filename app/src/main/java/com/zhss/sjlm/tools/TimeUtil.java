package com.zhss.sjlm.tools;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;


public class TimeUtil {
    private int time=60;

    private Timer timer;

    private TextView btnSure;

    private String btnText;

    public TimeUtil(TextView btnSure, String btnText) {
        super();
        this.btnSure = btnSure;
        this.btnText = btnText;
    }





    public void RunTimer(){
        timer=new Timer();
        TimerTask task=new TimerTask() {

            @Override
            public void run(){
                time--;
                Message msg=handler.obtainMessage();
                msg.what=1;
                handler.sendMessage(msg);

            }
        };


        timer.schedule(task, 100, 1000);
    }


    private Handler handler =new Handler(){
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:

                    if(time>0){
                        btnSure.setEnabled(false);
                        btnSure.setText("重新发送("+time+")");
                        btnSure.setTextSize(14);
                        btnSure.setTextColor(Color.parseColor("#666666"));
                    }else{
                        timer.cancel();
                        btnSure.setText("重新获取");
                        btnSure.setEnabled(true);
                        btnSure.setTextSize(14);
                        btnSure.setTextColor(Color.parseColor("#ffffff"));
                    }

                    break;


                default:
                    break;
            }

        };
    };



}
