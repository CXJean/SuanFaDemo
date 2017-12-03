package com.bwei.text.lianxi.day2;

import android.util.Log;

/**
 * Created by xue on 2017-11-30.
 */

public class Queue {

    private int maxSize; //队列长度，由构造函数初始化
    private long[] queArray; // 队列
    private int front; //队头
    private int rear; //队尾
    private int nItems;  //元素的个数

    public void getQueue(int s){
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
        //添加
        for (int i=10;i<41;i=i+10){
            this.insert(i);
            Log.d("Queue", " 入队------:"+i);
        }
        Log.d("Queue", "getQueue: --------出队--------");
        //移除
        for (int i=0;i<4;i++){
            long remove = this.remove();
            Log.d("Queue", " 出队------:"+remove);
        }
        Log.d("Queue", "getQueue: ----再次入队----------"+queArray.toString());
        //添加
        for (int i=10;i<41;i=i+10){
            this.insert(i);
            Log.d("Queue", " 入队------:"+i);
        }
        Log.d("Queue", "getQueue:------遍历移除-----");
        // 遍历队列并移除所有元素
        String a="";
        while( !this.isEmpty() )
        {
            a="";
            long n = this.remove();   // (40, 50, 60, 70, 80)
            Log.d("Queue", "getQueue:-------出队------"+n);
            for (int i=0;i<queArray.length;i++) {
                a+=queArray[i]+",下标:"+i+"    ";
            }
            Log.d("Queue", "剩余个数----"+a);
        }
        System.out.println("");
    }


    // 进队列
    public void insert(long j)
    {
        if(rear == maxSize-1)          // 处理循环
            rear = -1;
        queArray[++rear] = j;          // 队尾指针加1,把值j加入队尾
        nItems++;
    }
    // 取得队列的队头元素。
    public long remove()
    {
        long temp = queArray[front++]; // 取值和修改队头指针
        if(front == maxSize)            // 处理循环
            front = 0;
        nItems--;
        return temp;
    }
    // 取得队列的队头元素。该运算与 remove()不同，后者要修改队头元素指针。
    public long peekFront()
    {
        return queArray[front];
    }
    // 判队列是否为空。若为空返回一个真值，否则返回一个假值。
    public boolean isEmpty()
    {
        return (nItems==0);
    }
    // 判队列是否已满。若已满返回一个真值，否则返回一个假值。
    public boolean isFull()
    {
        return (nItems==maxSize);
    }
    // 返回队列的长度
    public int size()
    {
        return nItems;
    }

}
