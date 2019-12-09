package com.example.finalltest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class setNumberFragment extends Fragment {
    private View view;
    private String[] title;
    private String[][] contents;
    private ListView listView;
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState){
        view=inflater.inflate(R.layout.member_layout,container,false);
       add_project_number activity=(add_project_number) getActivity();
        title=activity.getTilte();
        contents=activity.getContents();
        if (view!=null) init();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                setContent_fragement content = (setContent_fragement) ((add_project_number)getActivity()).getSupportFragmentManager().findFragmentById(R.id.setInputMember);
                content.setText(contents[i]);
            }
        });
        return view;
    }
    private void init(){
        listView=(ListView)view.findViewById(R.id.daylist);
        if (title!=null) listView.setAdapter(new MyAdapter());
    }
    class MyAdapter extends BaseAdapter {
        public int getCount(){
            return title.length;
        }
        public Object getItem(int i){
            return title[i];
        }
        public long getItemId(int i){
            return i;
        }
        public View getView(int i,View view,ViewGroup viewGroup){
            view=View.inflate(getActivity(),R.layout.member_i,null);
            TextView titletext=(TextView)view.findViewById(R.id.days);
            titletext.setText(title[i]);
            return view;
        }
    }
}
