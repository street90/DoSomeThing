package com.song.app.dosomething;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by song on 2017/12/28.
 */

public class AddItemAdapter extends BaseAdapter {
    List<String> result ;

    public AddItemAdapter(List<String> result) {
        this.result = result;
    }

    @Override
    public int getCount() {
        return result == null ? 0 : result.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_added,null);
            holder.tvItem = view.findViewById(R.id.tv_item);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        holder.tvItem.setText(result.get(i));

        return view;
    }

    public void setDataChange(List<String> result){
        this.result = result;
        notifyDataSetChanged();
    }

    public class ViewHolder{
        TextView tvItem;
    }
}
