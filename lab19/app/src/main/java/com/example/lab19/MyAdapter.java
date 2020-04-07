package com.example.lab19;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    Context context;
    MyApp myApp;
    List<String> notes;
    public MyAdapter(Context context){this.context=context; myApp = (MyApp)context.getApplicationContext(); notes = myApp.getNotes();}

    @Override
    public int getCount(){return notes.size();}
    @Override
    public Object getItem(int i){
        return notes.get(i);
    }
    @Override
    public long getItemId(int i){return i;}
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.layout, viewGroup, false);
        }
        //TextView textView = (TextView) view;
        //textView.setText(notes.get(i));
        //textView.setBackgroundColor(colors[i]);
        LinearLayout root = (LinearLayout) view;
        TextView textView2 = root.findViewById(R.id.textView2);
        textView2.setText(notes.get(i));


        return view;
    }
}
