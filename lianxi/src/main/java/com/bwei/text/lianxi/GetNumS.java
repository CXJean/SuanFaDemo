package com.bwei.text.lianxi;

/**
 * Created by xue on 2017-11-30.
 * .有1,2,3,4四个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
 */

public class GetNumS {

    public String fun1234() {
        String str="";
        int count = 0;
        for (int x = 1; x < 5; x++) {
            for (int y = 1; y < 5; y++) {
                for (int z = 1; z < 5; z++) {
                    if (x != y && y != z && x != z) {
                        count++;
                        if (count%5==0){
                            str+="\r\n";
                        }
                        System.out.println(x * 100 + y * 10 + z + "   \r\n");
                        str+=x * 100 + y * 10 + z + "    ";
                    }
                }
            }
        }
        return str+"=====总共:"+count;

    }

}
