package com.bwei.text.suanfademo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {

    private TextView textStr;
    private TextView feiStr;
    private TextView jieStr;
    private EditText editNum;
    private Button btnSet;
    private Button clearStr;
    private Button btnFang;
    private String num;
    private YangHui yangHui;
    private FeiBo feiBo;
    private JieChen jieChen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();

    }
    private void initView() {
        editNum = (EditText) findViewById(R.id.editNum);
        btnSet = (Button) findViewById(R.id.btnSetStr);
        clearStr = (Button) findViewById(R.id.clearStr);
        btnFang = (Button) findViewById(R.id.btnFang);
        textStr = (TextView) findViewById(R.id.yangStr);
        feiStr = (TextView) findViewById(R.id.feiStr);
        jieStr = (TextView) findViewById(R.id.jieStr);


    }
    private void initData() {
        //杨辉三角
        yangHui = new YangHui();
        feiBo = new FeiBo();
        jieChen = new JieChen();
        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = editNum.getText().toString().trim();
//                String sanjiao = yangHui.sanjiao(Integer.parseInt(num));
//                textStr.setText(sanjiao);
//
//
//                String result = feiBo.getResult(Integer.parseInt(num));
//                feiStr.setText(result);
                 //递归类型解决阶乘
//                long resultnum = jieChen.getResult(Integer.parseInt(num));
//                jieStr.setText(resultnum+"");

                BigDecimal resultN = jieChen.getResultN(Integer.parseInt(num));
                jieStr.setText(resultN.toString());
//                sanjiao="";
//                result="";
            }
        });
        clearStr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textStr.setText("杨辉三角");
                feiStr.setText("斐波那契数");
                jieStr.setText("阶乘");
            }
        });
        btnFang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AnJuActivity.class);
                startActivity(intent);
            }
        });

    }



}
