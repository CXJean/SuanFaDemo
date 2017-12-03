package com.bwei.text.lianxi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bwei.text.lianxi.day2.Day2Activity;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MainActivity extends AppCompatActivity {

    private EditText inputEdit;
    private Button btnJiSuan;
    private TextView resultStr;
    private com.bwei.text.lianxi.getStrs getStrs;
    private EditText inputMonth;
    private com.bwei.text.lianxi.getRabbitS getRabbitS;
    private TextView reRabbits;
    private String monRaits;
    private TextView getNumsText;
    private EditText inputHui;
    private Button btnHui;
    private TextView rehui;
    private FiveNums fiveNums;
    private EditText inputJie;
    private Button btnJie;
    private TextView reJie;
    private GetJieHe getJieHe;
    private EditText inputReStr;
    private EditText inputChildReStr;
    private Button btnReStr;
    private TextView reStrNums;
    private GetReStr getReStr;
    private EditText inputNums;
    private Button btnZhiRe;
    private GetZhiShu getZhiShu;
    private Button btnThree;
    private EditText inputThreeNums;
    private GetPeopleNum getPeopleNum;
    private Button btnDuquFile;
    private GetFiles getFiles;
    private Button btntiaoNew;
    private Button tiaoFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTiao();

//        遍历出一个文件夹下的所有文件，并展示出层级关系，
// 文件夹优先显示，最后以一定格式写入文本中
        initFiles();

        initStr();

        initRabbits();
//有1,2,3,4四个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
        initNums();
//  6.5位数中找出所有，判断它是不是回文数。即12321是回文数，个位与万位相同，十位与千位相同。
        initFive();
//        5.求1+2!+3!+...+20!的和
        init20();
//        8.计算字符串中子串出现的次数
        initReStr();
//9.有n个人围成一圈，顺序排号。从第一个人开始报数（从1到3报数），
// 凡报到3的人退出圈子，问最后留下的是原来第几号的那位。
        initPeople();
//10.求100之内的素数    //使用除sqrt(n)的方法求出的素数不包括2和3
        initZhiShu();
    }

    private void initTiao() {
        btntiaoNew = (Button) findViewById(R.id.tiaoNew);
        btntiaoNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Day2Activity.class);
                startActivity(intent);
            }
        });

        tiaoFile = (Button) findViewById(R.id.tiaoFile);
        tiaoFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SdFilesActivity.class);
                startActivity(intent);

            }
        });
    }

    //读取文件夹内的东西
    private void initFiles() {
        btnDuquFile = (Button) findViewById(R.id.btnDuquFile);

        getFiles = new GetFiles();
        btnDuquFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<String> getimages = getFiles.getimages();
                for (int i =0;i<getimages.size();i++){
                    Log.d("this", "onClick: "+getimages.get(i));
                }
                Toast.makeText(MainActivity.this,"吐司......."+getimages,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initPeople() {
        btnThree = (Button) findViewById(R.id.btnThree);
        inputThreeNums = (EditText) findViewById(R.id.inputThreeNums);

        getPeopleNum = new GetPeopleNum();
        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ThreeNums = inputThreeNums.getText().toString().trim();

                TreeMap<Integer, Integer> propleNum = getPeopleNum.getPropleNum(Integer.parseInt(ThreeNums));
                Log.d("initPeople", "onClick: "+propleNum);
                btnThree.setText(propleNum+"");
            }
        });
    }

    private void initZhiShu() {

        inputNums = (EditText) findViewById(R.id.inputNums);
        btnZhiRe = (Button) findViewById(R.id.btnZhiRe);

        getZhiShu = new GetZhiShu();
        btnZhiRe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Nums = inputNums.getText().toString().trim();
                List<Integer> zhiShu = getZhiShu.getZhiShu(Integer.parseInt(Nums));
                Log.d("zhishu", "onClick:----------- "+zhiShu);
                btnZhiRe.setText(zhiShu+"");
            }
        });

    }

    private void initReStr() {
        inputReStr = (EditText) findViewById(R.id.inputReStr);
        inputChildReStr = (EditText) findViewById(R.id.inputChildReStr);
        btnReStr = (Button) findViewById(R.id.btnReStr);
        reStrNums = (TextView) findViewById(R.id.reStrNums);
        getReStr = new GetReStr();
        btnReStr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ReStr = inputReStr.getText().toString().trim();
                String ChildReStr = inputChildReStr.getText().toString().trim();

                int reStrnums = getReStr.getReStrnums(ReStr, ChildReStr);
                reStrNums.setText(ChildReStr+"一共出现: "+reStrnums+" 次");
            }
        });


    }

    //阶乘求和
    private void init20() {
        inputJie = (EditText) findViewById(R.id.inputJie);
        btnJie = (Button) findViewById(R.id.btnJie);
        reJie = (TextView) findViewById(R.id.reJie);

        getJieHe = new GetJieHe();
        btnJie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strJie = inputJie.getText().toString().trim();
                //阶乘求和
                BigDecimal he = getJieHe.getHe(Integer.parseInt(strJie));
                //单独阶乘
//                BigDecimal jie = getJieHe.getJie(Integer.parseInt(strJie));
                reJie.setText(he.toString());
            }
        });

    }

    private void initFive() {
        inputHui = (EditText) findViewById(R.id.inputHui);
        btnHui = (Button) findViewById(R.id.btnHui);
        rehui = (TextView) findViewById(R.id.rehui);

        fiveNums = new FiveNums();
        btnHui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strFive = inputHui.getText().toString().trim();
                String fiveNums = MainActivity.this.fiveNums.getFiveNums(Integer.parseInt(strFive));
                rehui.setText(fiveNums);
            }
        });
    }

    private void initNums() {

        getNumsText = (TextView) findViewById(R.id.getNums);
        GetNumS getNumS = new GetNumS();
        String s = getNumS.fun1234();
        getNumsText.setText(s);

    }

    //    古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，
// 小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，
// 问每个月的兔子总数为多少？
    private void initRabbits() {
        inputMonth = (EditText) findViewById(R.id.inputMonth);
        Button btnRabbit = (Button) findViewById(R.id.btnRabbit);
        reRabbits = (TextView) findViewById(R.id.reRabbits);
        monRaits = "";
        getRabbitS = new getRabbitS();
        btnRabbit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String inStr = inputMonth.getText().toString().trim();
                int mon = Integer.parseInt(inStr);
                for (int i=1;i<=mon;i++){
                    //输入的应该是月份，主键递增
                    int rabbits = getRabbitS.rabbit(i);
                    Log.d("btnRabbit", "onClick: "+i+"月:"+ rabbits);
                    monRaits +="第"+i+"月兔子数:"+rabbits*2+"\r\n";
                }
                reRabbits.setText(monRaits);

            //总和
//           int rabbit = getRabbitS.rabbit(Integer.parseInt(inStr));
//           reRabbits.setText("兔子总数:"+rabbit);

            }
        });
    }

    //输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。
    private void initStr() {

        inputEdit = (EditText) findViewById(R.id.inputEdit);
        btnJiSuan = (Button) findViewById(R.id.btnJiSuan);
        resultStr = (TextView) findViewById(R.id.resultStr);
        getStrs = new getStrs();
        btnJiSuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inStr = inputEdit.getText().toString().trim();
                String strResult = getStrs.getString(inStr);

                resultStr.setText(strResult);
            }
        });
    }



}
