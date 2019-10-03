package com.example.mybluetooth;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DataGenerator extends Fragment {
    public static final int []mTabRes = new int[]{R.mipmap.dial_page_round,R.mipmap.tell_contacts_round,R.mipmap.icon_tell_round};
    public static final int []mTabResPressed = new int[]{R.mipmap.dial_page_press_round,R.mipmap.tell_contacts_press_round,R.mipmap.icon_tell_press_round};
    public static final String []mTabTitle = new String[]{"拨号","电话簿","座机"};

    public static Fragment[] getFragments(String from){
        Fragment fragments[] = new Fragment[3];
        fragments[0] = DialFragment.newInstance(from);     //拨打电话
        fragments[1] = ContactsFragment.newInstance(from); //电话簿
        fragments[2] = LandlineFragment.newInstance(from); //座机匹配
        return fragments;
    }

    /**
     * 获取Tab 显示的内容
     * @param context
     * @param position
     * @return
     */
    public static View getTabView(Context context, int position){
        View view = LayoutInflater.from(context).inflate(R.layout.activity_main,null);
        ImageView tabIcon = (ImageView) view.findViewById(R.id.tab_content_image);
        tabIcon.setImageResource(DataGenerator.mTabRes[position]);
        TextView tabText = (TextView) view.findViewById(R.id.tab_content_text);
        tabText.setText(mTabTitle[position]);
        return view;
    }
}
