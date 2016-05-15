package com.stateless.demo.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.commons.support.adapter.ViewHolder;
import com.commons.support.adapter.recyclerview.CommonAdapter;
import com.commons.support.adapter.recyclerview.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> mDatas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initDatas();

        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));

        mRecyclerView.setAdapter(new CommonAdapter<String>(this, R.layout.item_list, mDatas) {
            @Override
            public void convert(ViewHolder holder, String s) {
                holder.setText(R.id.id_item_list_title, s);
            }
        });

    }

    private void initDatas()
    {
        for (int i = 'A'; i < 'z'; i++)
        {
            mDatas.add((char) i + "");
        }
    }
}
