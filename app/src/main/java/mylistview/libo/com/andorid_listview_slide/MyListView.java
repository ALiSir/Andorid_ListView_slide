package mylistview.libo.com.andorid_listview_slide;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

/**
 * Created by Administrator on 2016/12/20.
 */

public class MyListView extends ListView {
    private Boolean isHorizontal;

    private View preItemView;
    private View currentItemView;

    private float firstX;
    private float firstY;

    private int rightViewWidth = 300;

    private final int mDuration = 100;
    private final int mDurationStep = 10;

    private boolean mIsShown;

    public MyListView(Context context) {
        super(context);
    }
    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setRightViewWidth(int rightViewWidth) {
        this.rightViewWidth = rightViewWidth;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        float curreX = ev.getX();
        float curreY = ev.getY();
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                isHorizontal = null;
                firstX = curreX;
                firstY = curreY;
                int currePosition = pointToPosition((int)firstX,(int)firstY);

                if(currePosition >= 0){
                    View curreItemView = getChildAt(currePosition);
                }

                break;
        }

        return super.onInterceptTouchEvent(ev);
    }


}
