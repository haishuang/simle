package com.example.hais.simle;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @Bind(R.id.et_content)
    EditText etContent;
    @Bind(R.id.rcv_emoj)
    RecyclerView rcvEmoj;

    private EmojAdater adapter;

    private EmojPop emojPop;

    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        rcvEmoj.setLayoutManager(new StaggeredGridLayoutManager(6,StaggeredGridLayoutManager.VERTICAL));
//        adapter = new EmojAdater(this,etContent);
//        rcvEmoj.setAdapter(adapter);

        emojPop = new EmojPop(this, etContent);
        etContent.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Drawable drawable = etContent.getCompoundDrawables()[2];
                if (drawable != null
                        && motionEvent.getAction() == MotionEvent.ACTION_UP
                        && (motionEvent.getX() < etContent.getWidth()
                        && motionEvent.getX() > etContent.getWidth() - drawable.getIntrinsicWidth())) {
                    emojPop.showAsDropDown(etContent);
                    etContent.setSelection(i);
                    return true;
                } else {
                    i = etContent.getSelectionStart();
                    return false;
                }
            }
        });


        etContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.e("tag", "00000000");
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.e("tag", "000001111000");
            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.e("tag", "000002222000");
            }
        });
    }
}
