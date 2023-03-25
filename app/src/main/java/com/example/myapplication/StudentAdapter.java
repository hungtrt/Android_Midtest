package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.transition.Hold;

import java.util.List;

public class StudentAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Student> studentsList;

    public StudentAdapter(Context context, int layout, List<Student> studentsList) {
        this.context = context;
        this.layout = layout;
        this.studentsList = studentsList;
    }

    @Override
    public int getCount() {
        return studentsList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        TextView txtName, txtYear, txtAddress;
        ImageView imgDelete, imgEdit;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.txtName = (TextView) view.findViewById(R.id.textviewNameCustom);
            holder.txtYear = (TextView) view.findViewById(R.id.textviewYearCustom);
            holder.txtAddress = (TextView) view.findViewById(R.id.textviewAddressCustom);
            holder.imgDelete = (ImageView) view.findViewById(R.id.imageViewDelete);
            holder.imgEdit = (ImageView) view.findViewById(R.id.imageViewEdit);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        Student student = studentsList.get(i);

        holder.txtName.setText(student.getName());
        holder.txtYear.setText("Year Old: " +student.getYear());
        holder.txtAddress.setText(student.getAddress());

        return view;
    }
}
