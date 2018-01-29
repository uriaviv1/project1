package com.example.aviv.project1;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Aviv on 28/01/2018.
 */

public class MsgAdapter extends ArrayAdapter<Message> {
    Context context;
    List<Message>msgList;
    public MsgAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<Message> objects) {
        super(context, resource, textViewResourceId, objects);
        this.context=context;
        this.msgList=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=((Activity)context).getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.massege,parent,false);
        TextView name=(TextView)view.findViewById(R.id.name);
        TextView msg=(TextView)view.findViewById(R.id.massege);
        Message temp=msgList.get(position);
        name.setText(temp.getName());
        msg.setText(temp.getMessage());
        return view;
    }
}
