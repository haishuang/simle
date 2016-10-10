package com.example.hais.simle;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.PopupWindow;


/**
 * Created by Administrator on 2016/10/10.
 */
public class EmojPop extends PopupWindow{
    private Context mContent;
    private EditText editText;
    private View view;
    private int width;
    private int height;
    private RecyclerView rcvEmoj;
    private EmojAdater adapter;
    public  EmojPop (Context content, EditText editText){
        mContent = content;
        this.editText = editText;
        view = LayoutInflater.from(mContent).inflate(R.layout.pop,null);
        setContentView(view);
        setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        setHeight(WindowManager.LayoutParams.WRAP_CONTENT);

        setInit();
        rcvEmoj = (RecyclerView) view.findViewById(R.id.rcv_emoj);
        rcvEmoj.setLayoutManager(new StaggeredGridLayoutManager(6,StaggeredGridLayoutManager.VERTICAL));
        adapter = new EmojAdater(mContent,editText);
        rcvEmoj.setAdapter(adapter);
    }

    private void setInit() {
        setTouchable(true);
        setOutsideTouchable(true);
        setFocusable(true);
        setBackgroundDrawable(new BitmapDrawable());

        setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {

            }
        });
    }
}
