package com.example.mybluetooth;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DialFragment extends Fragment {
    ImageView dial_btn;
    ArrayList<HashMap<String, Object>> record_listItems = null;
    HashMap<String, Object> map = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);//如果不设置这个属性，fragment中的onCreateOptionsMenu()回调不会被执行！
    }

    @Nullable
    //给当前的fragment绘制UI布局
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("拨号");
        View view = inflater.inflate(R.layout.dial_page, null);
        ListView record_listview = (ListView) view.findViewById(R.id.record_listview); //拨号记录列表
        dial_btn = (ImageView) view.findViewById(R.id.dial_btn);  //进入拨号按键
        record_listItems = new ArrayList<HashMap<String, Object>>();
        int[] userImg = {R.drawable.call_incoming,
                R.drawable.call_missed,
                R.drawable.call_missed,
                R.drawable.call_outgoing,
                R.drawable.call_incoming,
                R.drawable.call_incoming,
                R.drawable.call_missed,
                R.drawable.call_outgoing,
                R.drawable.call_incoming,
                R.drawable.call_outgoing,};
        String[] userName = getResources().getStringArray(R.array.user_note);
        String[] userTell = getResources().getStringArray(R.array.user_tell);
        String[] dialTime = getResources().getStringArray(R.array.dial_time);
        for (int i = 0; i < userTell.length; i++) {
            map = new HashMap<String, Object>();
            map.put("img", userImg[i]);
            map.put("name", userName[i]);
            map.put("phone", userTell[i]);
            map.put("time", dialTime[i]);
            record_listItems.add(map);
        }

        //创建拨号记录列表并实例化
        SimpleAdapter record_adapter = new SimpleAdapter(getActivity(), record_listItems,
                R.layout.list_item, new String[]{"img", "name", "phone", "time"},
                new int[]{R.id.user_image, R.id.user_note, R.id.user_tell, R.id.dial_time});
        //绑定列表控件的数据源
        record_listview.setAdapter(record_adapter);
        dial_btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    Intent myIntent = new Intent(getActivity(), DialActivity.class);
                    startActivity(myIntent);
                }
                return true;
            }
        });
        return view;
    }

    public static DialFragment newInstance(String name) {
        Bundle args = new Bundle();
        args.putString("name", name);
        DialFragment fragment = new DialFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // TODO Auto-generated method stub
        inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    //菜单监听
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete_records: { //删除通话记录

                break;
            }
            case R.id.export_records: { //导出通话记录
                break;
            }
            case R.id.settings: { //相关设置

                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
