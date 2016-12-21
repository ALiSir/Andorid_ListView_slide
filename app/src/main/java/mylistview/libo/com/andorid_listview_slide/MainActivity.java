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
    private SwipeListView myListView;
    private SimpleAdapter simpleAdapter;
    private ArrayList<HashMap<String, String>> listData;
    private final static int ITEM_RIGHT_WIDTH = 300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        myListView = (SwipeListView) findViewById(R.id.listview);
        myListView.addHeaderView(LayoutInflater.from(this).inflate(R.layout.hander,null));
        myListView.setRightViewWidth(ITEM_RIGHT_WIDTH);

        String[] fromStr = {"item_right","text3","textView6","textView", "button", "editText","item_right"};
        int[] toInt = {R.id.item_right,R.id.text3,R.id.textView6,R.id.imageView, R.id.textView, R.id.editText,R.id.button};
        MyAdapter ma = new MyAdapter(this, R.layout.item, listData, fromStr, toInt);
        ma.setRightWidth(ITEM_RIGHT_WIDTH);
        ma.setOnItemOncliclikListener(new MyAdapter.IOnItemRightClickListener() {
            @Override
            public void onItemClike(View v, int position) {
                switch (v.getId()){
                    case R.id.text3:
                        Toast.makeText(MainActivity.this,"点击了第"+position +"项编辑按钮",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.textView6:
                        Toast.makeText(MainActivity.this,"点击了"+position +"项详细按钮",Toast.LENGTH_SHORT).show();
                        break;
                    default:Toast.makeText(MainActivity.this,"点击了"+position +"项",Toast.LENGTH_SHORT).show();
                }

            }
        });
        myListView.setAdapter(ma);
    }

    private void initData() {
        listData = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("id", "2");
        map.put("name", "李四");
        map.put("sex", "女");
        map.put("age", "20");

        HashMap<String, String> map1 = new HashMap<String, String>();
        map1.put("id", "1");
        map1.put("name", "张三");
        map1.put("sex", "男");
        map1.put("age", "19");

        for (int i = 0; i < 100; i++) {
            if(i%3 == 0){
                listData.add(map);
            }
            listData.add(map1);
        }

    }

}
