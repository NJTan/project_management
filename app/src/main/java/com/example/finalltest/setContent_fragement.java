package com.example.finalltest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import static android.app.Activity.RESULT_OK;

public class setContent_fragement extends Fragment{
    private View view;
    private TextView text1,text2;
    private EditText member_i;
    private Button sumbit_name;
    private String[] nameList =new String[10];
    private String name;
    int i=0;
    public void onAttach(Activity activity){
        super.onAttach(activity);
    }
    private int pro_number;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.member_i_layout,container,false);
        if(view!=null){
            init();
            pro_number=((add_project_number)getActivity()).getPro_mem_number();
//          Log.i("tag", String.valueOf(pro_number)+"_"+member_i);
         //   ((add_project_number)getActivity()).getMembernames();
//            Log.i("tag3",((add_project_number)getActivity()).getMembernames()[0]);
        }
        setText(((add_project_number)getActivity()).getContents()[0]);
        return view;
    }
    private void init(){
        text1 = (TextView)view.findViewById(R.id.show_title);
        text2 = (TextView)view.findViewById(R.id.show_content);
        member_i=(EditText)view.findViewById(R.id.project_member_i);
        sumbit_name=(Button)view.findViewById(R.id.add_member_i);
        sumbit_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = member_i.getText().toString().trim();
                try {
                    if (name != null && !name.equals(" ")) {
                            nameList[i++] =new String(name);
                            Log.d("tag", nameList[i-1]);
                    }
                    if(i>=pro_number){
                        //这里使用bundle绷带来传输数据
                        Bundle bundle =new Bundle();
                        //传输的内容仍然是键值对的形式
                        bundle.putSerializable("nameList",nameList);//回发的消息,hello world from secondActivity!
                        getActivity().getIntent().putExtras(bundle);
                        getActivity().setResult(RESULT_OK, getActivity().getIntent());
                        getActivity().finish();

                    }

                }catch (Exception e){
                    e.printStackTrace();
                }
//                Log.i("tag", name + pro_number);
              //  nameList[i] = name;
               // Log.i("tag", nameList[i]);
            }
//                    pro_number-=1;
//                    Log.i("tag",name);
 //                   if(pro_number==0) {
//                nameList=((add_project_number)getActivity()).getMembernames();
//                Intent intent=new Intent(getActivity(),add_project_activity.class);
//                Bundle bundle=new Bundle();
//                bundle.putSerializable("nameList",nameList);
//                intent.putExtras(bundle);
//                startActivity(intent);
//            }
//                }

        });
    }
    public void setText(String[] text){
        text1.setText(text[0]);
        text2.setText(text[1]);
    }


}
