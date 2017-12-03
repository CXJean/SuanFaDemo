package com.bwei.text.lianxi;

import android.os.Environment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xue on 2017-11-30.
 */

public class GetFiles {
    /**
     * 遍历出一个文件夹下的所有文件，并展示出层级关系，文件夹优先显示，最后以一定格式写入文本中
     */
    //找到所有图片（实则为图片所在地址） 并存入集合中
    public ArrayList<String> getimages() {
        //获得外部存储的根目录
        File dir = Environment.getExternalStorageDirectory();
        ArrayList<String> images = new ArrayList<String>();
        //调用遍历所有文件的方法
        recursionFile(dir,images);
        //返回文件路径集合
        return images;
    }
    //遍历手机所有文件 并将路径名存入集合中 参数需要 路径和集合
    public void recursionFile(File dir, List<String> images) {
        //得到某个文件夹下所有的文件
        File[] files = dir.listFiles();
        //文件为空
        if (files == null) {
            return;
        }
        //遍历当前文件下的所有文件
        for (File file : files) {
            //如果是文件夹
            if (file.isDirectory()) {
                //则递归(方法自己调用自己)继续遍历该文件夹
                recursionFile(file,images);
            } else { //如果不是文件夹 则是文件
                //如果文件名以 .mp3结尾则是mp3文件
                if (file.getName().endsWith(".mp3")) {
                    //往图片集合中 添加图片的路径
                    images.add(file.getAbsolutePath());
                }
            }
        }
    }

}
