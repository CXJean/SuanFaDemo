package com.bwei.text.suanfademo;

/**
 * Created by xue on 2017-11-29.
 * 杨辉三角
 */

public class YangHui {

    String str="";
    int a[][]=new int[100][100];//定义二维数组
    int i,j;
    //l为传过来的值
    public String sanjiao(int l){
            a[0][0]=a[1][0]=a[1][1]=1;
            if (l>1){//从第二行进入
                for( i = 2 ; i < l;i++)
                {   a[i][0]=a[i][i]=1;// 每行第一个和最后一个数都是1
                    for( j = 1; j < i ; j ++ )
                    {
                        //循环存入数组
                        a[i][j]=a[i-1][j]+a[i-1][j-1];
                    }
                }
            }
            //循环打印
            for (i=0;i<l;i++){
                for (j=0;j<=i;j++){
                    System.out.print(a[i][j]+" ");
                    str+=a[i][j]+" ";//追加
                }
                //换行
                System.out.println(" ");
                str+="\r\n";
            }
        return str;
    }
}
