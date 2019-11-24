package com.xum.weather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.xum.reviewdemo.R;

import java.util.List;

public class WeatherAdapter extends ArrayAdapter<Weather> {

    private int resourceId;

    public WeatherAdapter(Context context, int textViewResourceId, List<Weather> obj){
        super(context, textViewResourceId, obj);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Weather weather = getItem(position);//获取当前项的Weather实例
        //LayoutInflater的inflate()方法接收3个参数：需要实例化布局资源的id、ViewGroup类型视图组对象、false
        //false表示只让父布局中声明的layout属性生效，但不会为这个view添加父布局
        View view;
        ViewHolder viewHolder;
        //如果convertView为空，则使用LayoutInflater()去加载布局
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            //通过ViewHolder获取实例
            viewHolder.weatherImage = view.findViewById(R.id.weather_image);
            viewHolder.weatherName = view.findViewById(R.id.weather_name);
            //将ViewHolder存储在view中
            view.setTag(viewHolder);
        }else{
            //否则，重用convertView
            view = convertView;
            //重新获取ViewHolder（利用View的getTag()方法，把ViewHolder重新取出）
            viewHolder = (ViewHolder)view.getTag();
        }
        //设置图片和文字
        viewHolder.weatherImage.setImageResource(weather.getImageId());
        viewHolder.weatherName.setText(weather.getName());
        return view;
    }

    //定义ViewHolder内部类，用于对控件实例进行缓存
    class ViewHolder{
        ImageView weatherImage;
        TextView weatherName;
    }

}
