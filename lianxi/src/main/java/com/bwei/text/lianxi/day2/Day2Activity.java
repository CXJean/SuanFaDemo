package com.bwei.text.lianxi.day2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bwei.text.lianxi.R;

public class Day2Activity extends AppCompatActivity {

    private EditText editZhanNum;
    private EditText editQueueNum;
    private Button btnZhan;
    private Button btnQueue;
    private StackByArray stackByArray;
    private Queue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day2);

        initZhan();

        initQueue();
    }

    private void initQueue() {
        editQueueNum = (EditText) findViewById(R.id.editQueueNum);
        btnQueue = (Button) findViewById(R.id.btnQueue);



        queue = new Queue();

        btnQueue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String QueueNumStr = editQueueNum.getText().toString().trim();
                try {
                    queue.getQueue(Integer.parseInt(QueueNumStr));
                    Log.d("initQueue", "onClick:----- 出来了");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    private void initZhan() {
        editZhanNum = (EditText) findViewById(R.id.editZhanNum);
        btnZhan = (Button) findViewById(R.id.btnZhan);
        stackByArray = new StackByArray(100);
        btnZhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ZhanNumStr = Day2Activity.this.editZhanNum.getText().toString().trim();
                try {
                    stackByArray.getStack(Integer.parseInt(ZhanNumStr));
                    Log.d("initZhan", "onClick:----- 出来了");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
