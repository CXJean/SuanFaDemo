package com.bwei.text.lianxi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xue on 2017-11-30.
 * 8.计算字符串中子串出现的次数
 */

public class GetReStr {

//    String str="abcsadsadas abc adsada abc";
    public int getReStrnums(String str,String childStr){

        Pattern p = Pattern.compile(childStr,Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(str);
        int count = 0;
        while(m.find()){
            count ++;
        }
        return count;
    }

}
