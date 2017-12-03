package com.bwei.text.suanfademo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.czp.library.ArcProgress;

public class AnJuActivity extends AppCompatActivity {

    private ArcProgress myProgress;
    private EditText fangZonM;
    private EditText shangDaiM;
    private TextView shouM;
    private TextView shouB;
    private TextView daiZM;
    private String fangZonStr;
    private String shouMStr;
    private String daiZMStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_an_ju);

        intiView();
    }

    private void intiView() {
        myProgress = (ArcProgress) findViewById(R.id.myProgress);

//        上边
        fangZonM = (EditText) findViewById(R.id.fangZonM);
        shouM = (EditText) findViewById(R.id.shouM);
        shouB = (TextView) findViewById(R.id.shouB);
        daiZM = (TextView) findViewById(R.id.daiZM);

//    下边
        shangDaiM = (EditText) findViewById(R.id.shangDaiM);

        //设置进度条
        setprogress();
    }
    //计算
    public void setFangZon(){

        shouMStr = shouM.getText().toString().trim();
        daiZMStr = daiZM.getText().toString().trim();
        //监听动态跟随键盘输入的监听方式
//        fangZonM.addTextChangedListener(new TextWatcher(){
//
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                // 输入前的监听
//                Log.e("this", "-----------beforeTextChanged文字变化");
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                // 输入的内容变化的监听
//                Log.e("this", "-----------onTextChanged开始输入");
//                fangZonStr = fangZonM.getText().toString().trim();
//                Toast.makeText(AnJuActivity.this,"------"+fangZonStr,Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                // 输入后的监听
//                Log.e("this", "------------afterTextChanged输入结束");
//
//            }
//        });

//        EditText输入框的动态监听方法
        fangZonM.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    Log.d("fangZonM", "onFocusChange: 得到焦点");
                    shouM.setText("onFocusChange");
                }else{
                    Log.d("fangZonM", "onFocusChange: 失去焦点");
                    shouM.setText("onFocusChange");
                }
            }
        });
    }


    public void setprogress(){
        myProgress.setOnCenterDraw(new ArcProgress.OnCenterDraw() {
            @Override
            public void draw(Canvas canvas, RectF rectF, float x, float y, float storkeWidth, int progress) {
                //标题月供
                Paint titlePaint = new Paint(Paint.DEV_KERN_TEXT_FLAG);
                titlePaint.setStrokeWidth(50);
                titlePaint.setColor(getResources().getColor(R.color.titleColor));
                titlePaint.setTextSize(35);
                //价格
                Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
                textPaint.setStrokeWidth(50);
                textPaint.setColor(getResources().getColor(R.color.textColor));
                textPaint.setTextSize(35);
//                String progressStr = String.valueOf(progress+"%");//进度条
                String progressStr = String.valueOf("￥"+progress);
                String title = String.valueOf("月供");
                float textX = x-(textPaint.measureText(progressStr)/2);
                float textY = y-((textPaint.descent()+textPaint.ascent())/2);
                canvas.drawText(progressStr,textX,textY+50,textPaint);
                canvas.drawText(title,textX,textY,titlePaint);
            }
        });
        //点击
        myProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AnJuActivity.this,"吐司",Toast.LENGTH_SHORT).show();
                addProrgress(myProgress);
            }
        });
    }
    //handler发送消息
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            ArcProgress progressBar = (ArcProgress) msg.obj;
            //更新进度条
            progressBar.setProgress(msg.what);
        }
    };
    //进度条
    public void addProrgress(ArcProgress progressBar) {
        Thread thread = new Thread(new ProgressThread(progressBar));
        thread.start();
    }
    class ProgressThread implements Runnable{
        int i= 0;
        private ArcProgress progressBar;
        public ProgressThread(ArcProgress progressBar) {
            this.progressBar = progressBar;
        }
        @Override
        public void run() {
            for(;i<=90;i++){
                if(isFinishing()){
                    break;
                }
                Message msg = new Message();
                msg.what = i;
                Log.e("DEMO","i == "+i);
                msg.obj = progressBar;
                SystemClock.sleep(100);
                handler.sendMessage(msg);
            }
        }
    }
}
