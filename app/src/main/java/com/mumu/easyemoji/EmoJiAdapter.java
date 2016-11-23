package com.mumu.easyemoji;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by lq on 16/10/11.
 */

public class EmoJiAdapter extends ArrayAdapter<String> {


    private int type = 0;

    public EmoJiAdapter(int type, Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        this.type = type;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(getContext(), R.layout.item_row_emoji, null);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.iv_emoji);
        String fileName = getItem(position);
        Integer resId = EmoJiUtils.getEmoJiMap(type).get(fileName);
        if (resId != null) {
            Drawable drawable = getContext().getResources().getDrawable(resId);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth() / 2, drawable.getIntrinsicHeight() / 2);
            imageView.setImageResource(resId);
        }

        return convertView;
    }
}
