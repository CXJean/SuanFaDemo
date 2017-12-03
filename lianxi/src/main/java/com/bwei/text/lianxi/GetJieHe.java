package com.bwei.text.lianxi;

import java.math.BigDecimal;

/**
 * Created by xue on 2017-11-30.
 * 阶乘求和
 */

public class GetJieHe {

    public BigDecimal getJie(int num){
        BigDecimal bg = new BigDecimal(1L);

        int i = 1;
        while(i <= num){
            bg = bg.multiply(new BigDecimal(i++));
        }
        System.out.println(bg.toString());
        return bg;
    }

    public BigDecimal getHe(int n){
//        修正下初始化为0：BigDecimal bgHe = BigDecimal.ZERO;
//        如果为BigDecimal bgHe = null;报空指针 java.lang.NullPointerException
        BigDecimal bgHe = BigDecimal.ZERO;
        for (int i=1;i<=n;i++){
            bgHe=bgHe.add(getJie(i));
        }
        return bgHe;
    }

}
