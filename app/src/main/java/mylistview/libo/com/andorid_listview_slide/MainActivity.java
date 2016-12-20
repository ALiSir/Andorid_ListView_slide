package mylistview.libo.com.andorid_listview_slide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private MyListView myListView;
    private SimpleAdapter simpleAdapter;
    private ArrayList<HashMap<String, String>> listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        myListView = (MyListView) findViewById(R.id.listview);
        myListView.addHeaderView(LayoutInflater.from(this).inflate(R.layout.hander,null));

        MyAdapter ma = new MyAdapter(this, R.layout.item, listData, new String[]{"textView", "button", "editText"}, new int[]{R.id.textView, R.id.button, R.id.editText});
        ma.setOnItemOncliclikListener(new MyAdapter.IOnItemRightClickListener() {
            @Override
            public void onItemClike(View v, int position) {
                Toast.makeText(MainActivity.this,"点击了"+position +"项",Toast.LENGTH_SHORT).show();
            }
        });
        myListView.setAdapter(ma);
    }

    private void initData() {
        listData = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map1 = new HashMap<String, String>();
        map1.put("textView", "文本");
        map1.put("button", "按钮");
        map1.put("editText", "输入框");
        listData.add(map1);
        listData.add(map1);
        listData.add(map1);
        listData.add(map1);
        listData.add(map1);
        listData.add(map1);
        listData.add(map1);
        listData.add(map1);
        listData.add(map1);
        listData.add(map1);
        listData.add(map1);
        listData.add(map1);
    }

}
