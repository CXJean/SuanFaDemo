package com.bwei.text.lianxi.day2;


/**
 * Created by xue on 2017-11-30.
 * 栈：LIFO（后进先出）
 */

public class StackByArray  {
    // 栈的长度
    private int length;
    // 栈
    private Object[] array;
    // 栈顶的下标
    private int topIndex = -1;

    /**
     * StackByArry：构造方法
     * @param length 初始化栈的长度
     */
    public StackByArray (int length) {
        this.length = length;
        array = new Object[length];//初始化数组
    }
    /**
     * push:入栈
     * @param obj
     * @throws Exception
     */
    private void push(Object obj) throws Exception {
        if(isFullStack()) {
            throw new Exception("栈已满");
        }
        array[++topIndex] = obj;
    }

    /**
     * offer: 出栈，取出栈顶元素
     * @return obj
     * @throws Exception
     */
    private Object offer() throws Exception {
        if(isEmptyStack()) {
            throw new Exception("栈已空");
        }
        Object topObject = array[topIndex];
        array[topIndex] = null;
        topIndex--;
        return topObject;
    }

    /**
     * isEmptyStack:判断栈是否为空
     * @return
     */
    private boolean isEmptyStack() {
        return (topIndex == -1);
    }

    /**
     * isFullStack:判断栈是否已满
     * @return
     */
    private boolean isFullStack() {
        return topIndex == (length - 1);
    }
    /**
     * getLength:取得栈内的数据长度
     * @return length
     */
    private int getLength() {
        return topIndex + 1;
    }

    /**
     * outPut:栈内容输出
     */
    private void outPut() {
        for(Object obj : array) {
            if(obj != null) {
                System.out.print(obj + ", ");
            }
        }
        System.out.println();
    }
    /**
     * main:(这里用一句话描述这个方法的作用)
     */
    public void getStack(int length) throws Exception {
        StackByArray stack =  new StackByArray(length);

        for(int i = 1; i <= length; i++) {
            stack.push(i);//入栈
            System.out.println("入栈:--"+i);
        }

        System.out.println("---------出栈--------");
        for (int i=length;i>=1;i--){
            stack.offer();// 出栈
            System.out.println("出栈:---"+i);//出栈
        }

        System.out.println("最终栈的长度:----------"+stack.getLength());
    }

}
