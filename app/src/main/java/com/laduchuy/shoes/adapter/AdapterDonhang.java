package com.laduchuy.shoes.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.laduchuy.shoes.R;
import com.laduchuy.shoes.object.Donhang;

import java.util.ArrayList;

public class AdapterDonhang extends ArrayAdapter<Donhang> {
    private int mResource ;
    private Context mcontext ;
    public AdapterDonhang(@NonNull Context context, int resource, @NonNull ArrayList<Donhang> objects) {
        super(context, resource, objects);
        this.mcontext = context ;
        this.mResource = resource ;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mcontext);
        convertView = layoutInflater.inflate(mResource, parent, false);
        ImageView imageView = convertView.findViewById(R.id.imgdonhang);
        TextView txtName = convertView.findViewById(R.id.txtname);
        TextView txtprice = convertView.findViewById(R.id.txtname);
        TextView txtsoluong = convertView.findViewById(R.id.txtsoluong);

        imageView.setImageResource(getItem(position).getImg());
        txtName.setText(getItem(position).getName());
        txtprice.setText(String.valueOf(getItem(position).getPrice()));
        txtsoluong.setText((getItem(position).getSoluong()));
        return convertView;
    }
}
