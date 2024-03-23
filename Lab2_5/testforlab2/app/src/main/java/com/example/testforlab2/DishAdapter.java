package com.example.testforlab2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public  class DishAdapter extends BaseAdapter {
    private Context context=null;
    private int layout;
    private ArrayList<Dish> listDish=null;

    public DishAdapter(Context context, int layout, ArrayList<Dish> listDish) {
        this.context = context;
        this.layout = layout;
        this.listDish = listDish;
    }
    @Override
    public int getCount() {
        return listDish.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(final int position, View convertView, ViewGroup parent)
    {
        if(convertView==null)
        {
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_item_layout,null,false);
        }
        Dish dish = listDish.get(position);
        ImageView imgDish = (ImageView) convertView.findViewById(R.id.imgMonan);
        TextView txtMonan = (TextView) convertView.findViewById(R.id.txtMonan);
        if(dish.getName().length() > 46)
        {
            dish.setName("this is a very long piece of text that will move");
        }
        txtMonan.setSelected(true);
        if(dish.isPromotion())
        {
            txtMonan.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_star_24, 0, 0, 0);
        }
        else
        {
            txtMonan.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        imgDish.setImageResource(dish.getThumbnail());
        txtMonan.setText(dish.getName());
        return convertView;
    }
}
