package com.example.mybluetooth;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


public class LandlineFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);//如果不设置这个属性，fragment中的onCreateOptionsMenu()回调不会被执行！
    }

    @Nullable
    //给当前的fragment绘制UI布局
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.landline_page, null);
        getActivity().setTitle("座机");
        return view;
    }

    public static LandlineFragment newInstance(String name) {
        Bundle args = new Bundle();
        args.putString("name", name);
        LandlineFragment fragment = new LandlineFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // TODO Auto-generated method stub
        inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.landline_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    //菜单监听
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.disconnect: { //断开座机连接

                break;
            }
            case R.id.landLine_settings: { //相关设置

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
