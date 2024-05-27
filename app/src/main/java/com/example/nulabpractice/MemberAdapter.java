package com.example.nulabpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MemberAdapter extends BaseAdapter {
    private Context context;
    private List<Member> members;

    public MemberAdapter(Context context, List<Member> members) {
        this.context = context;
        this.members = members;
    }

    @Override
    public int getCount() {
        return members.size();
    }

    @Override
    public Object getItem(int position) {
        return members.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_member, parent, false);
        }

        Member member = members.get(position);

        TextView nameTextView = convertView.findViewById(R.id.nameTextView);
        TextView emailTextView = convertView.findViewById(R.id.emailTextView);
        TextView phoneTextView = convertView.findViewById(R.id.phoneTextView);


        nameTextView.setText(member.getName());
        emailTextView.setText(member.getEmail());
        phoneTextView.setText(member.getPhone());

        return convertView;
    }
}
