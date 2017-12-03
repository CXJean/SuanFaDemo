package com.bwei.text.lianxi;

/**
 * Created by xue on 2017-11-30.
 */

public class getRabbitS {
    //递归求总和
    public int rabbit(int month){
        if(month==1||month==2){
            return 1;
        }
        else{
            return rabbit(month-1)+rabbit(month-2);
        }
    }

}
