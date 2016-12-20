package mylistview.libo.com.andorid_listview_slide;

import android.content.Context;
import android.widget.SimpleAdapter;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/20.
 */

public class MySimpleAdapter extends SimpleAdapter {

    public MySimpleAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
    }
}
