package com.example.administrator.bujiandonghua.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.bujiandonghua.R;

import java.util.List;
import java.util.Map;

public class Bfragment_adapter extends BaseAdapter {



    private List<Map<String, Object>> data;
    private LayoutInflater layoutInflater;
    private Context context;
    public Bfragment_adapter(Context context, List<Map<String, Object>> data){
        this.context=context;
        this.data=data;
        this.layoutInflater=LayoutInflater.from(context);
    }
    /**
     * 组件集合，对应list.xml中的控件
     * @author Administrator
     */
    public final class Zujian{
        public ImageView image;
        public TextView textView1;
        public TextView textView2;
        public TextView textView3;
    }
    @Override
    public int getCount() {
        return data.size();
    }
    /**
     * 获得某一位置的数据
     */
    @Override
    public Object getItem(int position) {
        return data.get(position);
    }
    /**
     * 获得唯一标识
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Zujian zujian=null;
        if(convertView==null){
            zujian=new Zujian();
            //获得组件，实例化组件
            convertView=layoutInflater.inflate(R.layout.fragment_b_listview, null);
            zujian.image=(ImageView)convertView.findViewById(R.id.bfragmentimagine);
            zujian.textView1=(TextView)convertView.findViewById(R.id.bfragmenttextview1);
            zujian.textView2=convertView.findViewById(R.id.bfragmenttextview2);
            zujian.textView3=(TextView)convertView.findViewById(R.id.bfragmenttextview3);
            convertView.setTag(zujian);
        }else{
            zujian=(Zujian)convertView.getTag();
        }
        //绑定数据
        zujian.image.setBackgroundResource((Integer)data.get(position).get("image"));
        zujian.textView1.setText((String)data.get(position).get("t1"));
        zujian.textView2.setText((String)data.get(position).get("t2"));
        zujian.textView3.setText((String)data.get(position).get("t3"));
        return convertView;
    }



}
