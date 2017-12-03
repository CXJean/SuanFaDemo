package com.bwei.text.lianxi;

/**
 * Created by xue on 2017-11-30.
 */

public class FiveNums {

    public String getFiveNums(int num){
        int wan=num/10000;
        int qian=num/1000%10;
        int bai=num/100%100%10;
        int shi=num/10%1000%100%10;
        int ge=num%10000%1000%100%10;
        if (wan==ge&&qian==shi){
            return "回文数";
        }else{
            return "不是回文数";
        }
    }
}
