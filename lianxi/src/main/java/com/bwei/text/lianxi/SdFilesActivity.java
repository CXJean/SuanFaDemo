package com.bwei.text.lianxi;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

/**
 * 文件读取器，列表展示，可以点击前进，点击后退键退回到前一个页面
 */
public class SdFilesActivity extends AppCompatActivity {


    private File[] files;
    private ListView lv;
    private Button startShow;
    private File currentFile;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sd_files);

        startShow = (Button) findViewById(R.id.startShow);
        lv = (ListView) findViewById(R.id.lv);
    }
    public void backFile(View view){
        backFileForAll();
    }
    //后退键
    public void backFileForAll(){
        //如果当前位置不是sdcard(起点)；返回上一层,通过上一级文件夹，获得他下面的所有文件

        //因为之前的上一级变成了当前级文件夹,要获得当前文件夹的上一级文件夹，应对紧接着再次点击返回
        if(currentFile.equals(Environment.getExternalStorageDirectory())){
            //当前位置是sdcard，不再往前一个文件夹推进，退出系统进入桌面
//			startShow.setText("sdcard");
            this.finish();
        }else{//反之，往前一个文件夹推进
            File parentFile = new File(currentFile.getParent());
            files = parentFile.listFiles();
            //刷新适配器
            myAdapter.notifyDataSetChanged();

            currentFile = parentFile;//返回到的父亲一级文件夹，就是当前文件夹

            if(currentFile.equals(Environment.getExternalStorageDirectory())){//判断是否为根目录
                startShow.setText("sdcard");
            }else{
                startShow.setText(currentFile.getName());//显示当前的文件夹
            }
        }
        //刷新适配器，显示

    }
    /**
     * 手机（当前屏幕）的键按下监听方法
     * keyDown
     * 返回键
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if(keyCode == KeyEvent.KEYCODE_BACK){//如果按下后退键
            if(currentFile.equals(Environment.getExternalStorageDirectory())){
                //当前位置是sdcard，不再往前一个文件夹推进，退出系统进入桌面
//				startShow.setText("sdcard");
                return super.onKeyDown(keyCode, event);
            }else{//反之，往前一个文件夹推进
                File parentFile = new File(currentFile.getParent());
                files = parentFile.listFiles();
                myAdapter.notifyDataSetChanged();
                currentFile = parentFile;//返回到的父亲一级文件夹，就是当前文件夹
                if(currentFile.equals(Environment.getExternalStorageDirectory())){
                    startShow.setText("sdcard");
                }else{
                    startShow.setText(currentFile.getName());
                }
                return false;
            }
        }

        return super.onKeyDown(keyCode, event);
    }
    public void showSdcardFile(View view){
        String state = Environment.getExternalStorageState();//获得sdcard的状态
        if(state.equals(Environment.MEDIA_MOUNTED)){//sdcard已安装
            currentFile = Environment.getExternalStorageDirectory();//当前位置就是sdcard
            findFiles(currentFile);//扫描sdcard下的文件和文件夹
            myAdapter = new MyAdapter();
            lv.setAdapter(myAdapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    File file = files[position];//得到lv点击的文件
                    currentFile = file;//得到当前点击的文件夹的父文件夹

                    // 把点击的file的名字显示在页面中
                    if(currentFile.isDirectory()){
                        startShow.setText(currentFile.getName());
                        findFiles(currentFile);//获得此点击文件夹下的文件
//						lv.setAdapter(new MyAdapter());
                        myAdapter.notifyDataSetChanged();
                    }else{
                        Toast.makeText(SdFilesActivity.this, "这是文件，没有下一层了", Toast.LENGTH_SHORT).show();
                        //读取此文件的内容，显示
                    }

                }
            });
        }
    }
    //适配器
    class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return files.length;
        }

        @Override
        public Object getItem(int position) {
            return files[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            MyViewHolder holder = null;
            if(convertView == null){
                //加载子布局
                convertView = View.inflate(SdFilesActivity.this, R.layout.file_item_layout, null);
                //实例化holder
                holder = new MyViewHolder();
                holder.filePath = (TextView) convertView.findViewById(R.id.filePath);
                convertView.setTag(holder);//把当前子布局中的组件收集起来
            }else{
                holder = (MyViewHolder) convertView.getTag();
            }
            //配置文件数据
            File file = files[position];//得到当前行要显示的数据
            //显示数据
//			String info = file.getName()+"，"+file.getPath()+","+file.length();
            holder.filePath.setText(file.getName());

            return convertView;
        }

    }

    class MyViewHolder{
        TextView filePath;
    }

    public void findFiles(File file){
        files = file.listFiles();
    }

}
