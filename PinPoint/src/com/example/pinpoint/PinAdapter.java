package com.example.pinpoint;

import java.util.ArrayList;
import java.util.List;

import com.example.pinpoint.models.Pin;
import com.example.pinpoint.models.PinResult.PinObject;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.TwoLineListItem;



public class PinAdapter extends BaseAdapter {

    private Context context;
    private List<PinObject> pins;

    public PinAdapter(Context context, List<PinObject> pins) {
        this.context = context;
        this.pins = pins;
    }

    @Override
    public int getCount() {
        return pins.size();
    }

    @Override
    public Object getItem(int position) {
        return pins.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TwoLineListItem twoLineListItem;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            twoLineListItem = (TwoLineListItem) inflater.inflate(
                    android.R.layout.simple_list_item_2, null);
        } else {
            twoLineListItem = (TwoLineListItem) convertView;
        }

        TextView text1 = twoLineListItem.getText1();
        TextView text2 = twoLineListItem.getText2();

        text1.setTextColor(Color.BLACK);
        text2.setTextColor(Color.BLACK);
        
        text1.setText(pins.get(position).getPin().getType());
        text2.setText("" + pins.get(position).getPin().getDescription());

        return twoLineListItem;
    }
}