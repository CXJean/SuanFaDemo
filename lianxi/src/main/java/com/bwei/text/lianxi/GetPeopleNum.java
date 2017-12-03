package com.bwei.text.lianxi;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by xue on 2017-11-30.
 */

public class GetPeopleNum {
    // 存储人员编号 1....N和报号 (1,2,3)的对应关系
    private static TreeMap<Integer,Integer> tm = new TreeMap<Integer,Integer>();
    // 初始化 ,假设有100人
    // 初始化 ,假设有100人
    public static void inint(int num)
    {
        for(int i=1;i<=num;i++)
        {
// 直接模3后会是1,2,0,将0改为3.
            tm.put(i, i%3==0?3:i%3);
        }
    }
    //总数
    public TreeMap<Integer, Integer> getPropleNum(int num){

        inint(num);
        compute();
        System.out.println(tm);
        return tm;
    }
    /**
     * 算法如下:
     *
     * 1 移除报号为3的人
     * 2 如果只剩两人,则结束
     * 3 根据tm中最后一个人的报号M,重新计算每个人的报号
     * 即第一个人为(M+1)%3,第二个人为(M+2)%3
     * 4 重复第一步.
     * 当然最后剩下的两人的报号肯定为1和2,若继续下去的话,就是报号为2的那个人最终剩下.这一步我没有写
     */
    public static void compute()
    {
// 1 移除报号为3的人
        Iterator<Map.Entry<Integer , Integer>> it = tm.entrySet().iterator();
        while(it.hasNext())
        {
            if(it.next().getValue().equals(3))
            {
                it.remove();
            }
        }
// 2 如果只剩两人,则结束
        if(tm.size()<=2)
        {
            return;
        }
// 3 根据tm中最后一个人的报号M,重新计算每个人的报号
// 即第一个人为(M+1)%3,第二个人为(M+2)%3
        resort();
// 4 重复第一步.
        compute();
    }
    public static void resort()
    {
        // resort排序
        int last = tm.lastEntry().getValue();
        Iterator<Map.Entry<Integer , Integer>> it = tm.entrySet().iterator();

        while(it.hasNext())
        {
            last++;
            it.next().setValue(last%3==0?3:last%3);
        }
    }

}

