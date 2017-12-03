package com.bwei.text.lianxi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xue on 2017-11-30.
 * 10.求100之内的素数
 * //使用除sqrt(n)的方法求出的素数不包括2和3
 */

public class GetZhiShu {

    /**
     * 得到1到n之间的素数，存到一个ArrayList集合
     */
    public List<Integer> getZhiShu(int n){
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {//可以根据起始值排除2，3，写4就行
            if (numberIsPrime(i)) {
                result.add(i);
            }
        }
        return result;
    }

    /**
     * 判断一个数是不是素数：只能被1和本身整除
     * 说明：从2开始除，不需要到n，也就是循环条件是 < n 就可以，这之间只要被整除了，那么他就不是素数了
     */
    private static boolean numberIsPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
