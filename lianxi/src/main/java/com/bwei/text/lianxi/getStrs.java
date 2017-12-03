package com.bwei.text.lianxi;

import java.util.Scanner;

/**
 * Created by xue on 2017-11-30.
 */

public class getStrs {

    public String getString(String str){
        int abcCount=0;//英文字母个数
        int spaceCount=0;//空格键个数
        int numCount=0;//数字个数
        int otherCount=0;//其他字符个数
        //控制台输入
//        Scanner scan=new Scanner(System.in);
//        String str=scan.nextLine();
        char[] ch = str.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(Character.isLetter(ch[i])){
//判断是否字母
                abcCount++;
            }
            else if(Character.isDigit(ch[i])){
//判断是否数字
                numCount++;
            }
            else if(Character.isSpaceChar(ch[i])){
//判断是否空格键
                spaceCount++;
            }
            else{
//以上都不是则认为是其他字符
                otherCount++;
            }
        }
        System.out.println("字母个数："+abcCount);
        System.out.println("数字个数："+numCount);
        System.out.println("空格个数："+spaceCount);
        System.out.println("其他字符个数："+otherCount);

        return  "字母个数："+abcCount+"\r\n数字个数："+numCount+"\r\n空格个数："+spaceCount+"\r\n其他字符个数："+otherCount;
    }

}
