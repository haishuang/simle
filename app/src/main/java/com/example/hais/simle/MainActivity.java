package com.example.hais.simle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @Bind(R.id.et_content)
    EditText etContent;
    @Bind(R.id.rcv_emoj)
    RecyclerView rcvEmoj;

    private EmojAdater adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        rcvEmoj.setLayoutManager(new StaggeredGridLayoutManager(6,StaggeredGridLayoutManager.VERTICAL));
        adapter = new EmojAdater(this,etContent);
        rcvEmoj.setAdapter(adapter);
    }
}
