package com.example.administrator.yuekaolianxi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * 用途：
 * 作者：xuBoTao
 * 时间：2017/5/2 09:12
 */

public class Apdte extends RecyclerView.Adapter<Apdte.MyApdate>{
    private Context context;
    private List<String> list;

    public Apdte(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    public MyApdate onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        MyApdate myApdate = new MyApdate(view);
        return myApdate;
    }


    @Override
    public void onBindViewHolder(MyApdate holder, int position) {
        holder.title.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyApdate extends RecyclerView.ViewHolder{
        TextView title;
        public MyApdate(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.TextView);
        }
    }
}
