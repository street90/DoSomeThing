package com.song.app.dosomething;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    List<String> addedItemList;

    @BindView(R.id.tv_result)
    TextView tvResult;

    @BindView(R.id.et_item)
    EditText etItem;

    @BindView(R.id.bt_add)
    Button btAdd;

    @BindView(R.id.bt_get_reuslt)
    Button btGetResult;

    @BindView(R.id.lv_added_item)
    ListView lvAddedItem;


    AddItemAdapter mAddItemAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        addedItemList = new ArrayList<>();

        mAddItemAdapter = new AddItemAdapter(addedItemList);

        lvAddedItem.setAdapter(mAddItemAdapter);



    }

    @OnClick(R.id.bt_add)
    public void onclickAddItem(){

        String addedItem = etItem.getText().toString();

        etItem.setText("");

        if(!TextUtils.isEmpty(addedItem)){
            if(checkInList(addedItem,addedItemList)){
                showToast("已经添加过了");
            }else{
                addedItemList.add(addedItem);
                mAddItemAdapter.setDataChange(addedItemList);
            }

        }

    }

    @OnClick(R.id.bt_get_reuslt)
    public void onclickShowResult(){
       if(addedItemList.isEmpty()){
           tvResult.setText("");
           showToast("小伙子/姑娘不要闹了");
       }else{
           int random = (int) (Math.random() * addedItemList.size());
           String showResult = addedItemList.get(random);
           tvResult.setText(showResult);

       }
    }

    public boolean checkInList(String item , List<String> list){
        return list.contains(item);
    }

    public void showToast(String content){
        Toast.makeText(MainActivity.this,content,Toast.LENGTH_LONG).show();
    }
}
