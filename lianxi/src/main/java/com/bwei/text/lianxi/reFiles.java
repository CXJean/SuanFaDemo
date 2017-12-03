package com.bwei.text.lianxi;

import java.io.File;
import java.util.List;

/**
 * Created by xue on 2017-11-30.
 */

public class reFiles {

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
                if (file.getName().endsWith(".jpg")) {
                    //往图片集合中 添加图片的路径
                    images.add(file.getAbsolutePath());
                }
            }
        }
    }

}
