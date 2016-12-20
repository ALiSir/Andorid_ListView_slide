package mylistview.libo.com.andorid_listview_slide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2016/12/20.
 */

public class MyAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<HashMap<String,String>> arrayList;
    private int rightWidth = 50;
    private String[] fromStr;
    private int[] toId;
    private int parentId;

    private IOnItemRightClickListener mListener = null;
    public interface IOnItemRightClickListener {
        void onItemClike(View v,int position);
    }

    public MyAdapter(Context context,int parentId,ArrayList<HashMap<String,String>> arrayList,String[] fromStr,int[] toId) {
        this.context = context;
        this.arrayList = arrayList;
        this.fromStr = fromStr;
        this.toId = toId;
        this.parentId = parentId;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setOnItemOncliclikListener(IOnItemRightClickListener itemOncliclikListener){
            this.mListener = itemOncliclikListener;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int currPosition = position;
        View[] views = getAllView();
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(parentId,parent,false);
            for(int i = 0 ; i< views.length;i++){
                views[i] = convertView.findViewById(toId[i]);
            }
            convertView.setTag(views);
        }else{
            views = (View[])convertView.getTag();
        }
        if(mListener !=null){
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClike(v,currPosition);
                }
            });
        }
        return convertView;
    }

    private View[] getAllView(){
        return new View[fromStr.length];
    }

}
