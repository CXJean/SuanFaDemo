package com.bwei.text.suanfademo;

/**
 * Created by xue on 2017-11-29.
 * 5-100的斐波那契数
 */

public class FeiBo {

    String str="";

    public int getFeiBo(int i){
        if (i==1||i==2){
           return 1;
        }else{
            return getFeiBo(i-1)+getFeiBo(i-2);
        }
    }
    //斐波那契数列
    public String getResult(int num){
        for (int j=1;j<=num;j++){
            System.out.print(getFeiBo(j)+"\t");
            if (getFeiBo(j)>5&&getFeiBo(j)<100){
                str+=getFeiBo(j)+"\t";
            }
            if (j%5==0){
                System.out.println();
                str+="\t";
            }
        }
        return str;
    }


}
