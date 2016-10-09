package com.example.hais.simle;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.hais.simle.emojutils.DefaultEmojiconDatas;
import com.example.hais.simle.emojutils.Emojicon;
import com.example.hais.simle.emojutils.SmileUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Huang hai-sen on 2016/10/9.
 */
public class EmojAdater extends RecyclerView.Adapter<EmojAdater.MyViewHolder> {
    private Context mContent;
    private EditText etContent;
    private List<Emojicon> list = new ArrayList<>();

    public EmojAdater(Context comtent, EditText etContent) {
        this.mContent = comtent;
        Collections.addAll(list, DefaultEmojiconDatas.getData());
        this.etContent = etContent;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContent).inflate(R.layout.item_emoj, null);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final Emojicon emoj = list.get(position);
        holder.image.setImageResource(emoj.getIcon());

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //获取光标位置
                int index = etContent.getSelectionStart();
                Editable editable = etContent.getText();
                //获取表情的名字
                String emojName = "@#$%^&" + emoj.getName();
                editable.insert(index, emojName);

                //计算表情的结束位置
                int endIndex = index + emojName.length();

                SpannableString msp = new SpannableString(etContent.getText());
                Drawable drawable = mContent.getResources().getDrawable(emoj.getIcon());
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                msp.setSpan(new ImageSpan(drawable), index, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                etContent.setText(msp);
                //修正当前光标位置
                etContent.setSelection(endIndex);
                //Log.e("tag", etContent.getText().toString());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.iv_item);
        }
    }
}
