package com.example.administrator.yuekaolianxi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ShowActivity extends AppCompatActivity {
    private XRecyclerView xrv;
    private Apdte myApdte;
    private List<String> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        xrv = (XRecyclerView) findViewById(R.id.XRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrv.setLayoutManager(layoutManager);
        setData();
        myApdte = new Apdte(ShowActivity.this, list);
        xrv.setAdapter(myApdte);
        xrv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                list.clear();
                setData();
                myApdte = new Apdte(ShowActivity.this, list);
                myApdte.notifyDataSetChanged();
                xrv.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                setData();
                myApdte.notifyDataSetChanged();
                xrv.loadMoreComplete();
            }
        });
    }

    private void setData() {
        for(int i=0;i<20;i++) {
            list.add("第"+i+"条数据");
        }
    }
}
