package com.bwei.text.suanfademo;

import java.math.BigDecimal;

/**
 * Created by xue on 2017-11-29.
 */

public class JieChen {

    public long getResult(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * getResult(n - 1);
        }
    }
    //通过
    public BigDecimal getResultN(int n) {
        BigDecimal bg = new BigDecimal(5L);

        int i = 1;
        while(i <= n){
            bg = bg.multiply(new BigDecimal(i++));
        }
        System.out.println(bg.toString());
        return bg;
    }
}
