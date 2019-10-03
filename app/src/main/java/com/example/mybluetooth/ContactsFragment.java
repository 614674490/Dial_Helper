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
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class ContactsFragment extends Fragment {
    ArrayList<HashMap<String, Object>> contacts_listItems = null;
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
        View view = inflater.inflate(R.layout.contacts_page, null);
        getActivity().setTitle("电话簿");
        ListView contacts_listView = (ListView) view.findViewById(R.id.contacts_listView); //联系人列表
        contacts_listItems = new ArrayList<HashMap<String, Object>>();
        String[] note_name = getResources().getStringArray(R.array.note_name);
        String[] tell_number = getResources().getStringArray(R.array.tell_number);
        for (int i = 0; i < note_name.length; i++) {
            map = new HashMap<String, Object>();
            map.put("name", note_name[i]);
            map.put("phone", tell_number[i]);
            contacts_listItems.add(map);
        }
        //创建拨号记录列表并实例化
        SimpleAdapter record_adapter = new SimpleAdapter(getActivity(), contacts_listItems,
                R.layout.contacts_listitem, new String[]{"name", "phone"},
                new int[]{R.id.note_name, R.id.tell_number});
        //绑定列表控件的数据源
        contacts_listView.setAdapter(record_adapter);
        return view;
    }

    public static ContactsFragment newInstance(String name) {
        Bundle args = new Bundle();
        args.putString("name", name);
        ContactsFragment fragment = new ContactsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // TODO Auto-generated method stub
        inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.contacts_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    //菜单监听
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.contacts_export_records: { //导出联系人信息

                break;
            }
            case R.id.contacts_settings: { //设置
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
