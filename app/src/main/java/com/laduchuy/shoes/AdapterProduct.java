package com.laduchuy.shoes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.laduchuy.shoes.object.Product;

import java.util.List;

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ViewHoder> {
    List<Product> productList;

    public AdapterProduct(List<Product> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public AdapterProduct.ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.product_item,parent,false);
        ViewHoder viewHoder = new ViewHoder(view);
        return viewHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterProduct.ViewHoder holder, int position) {
        Product product = productList.get(position);
        holder.tvName.setText(product.getName());
        holder.tvPrice.setText("đ"+product.getPrice());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHoder extends RecyclerView.ViewHolder {
        ImageView imgAva;
        TextView tvName,tvPrice;
        public ViewHoder(@NonNull View itemView) {
            super(itemView);
            imgAva = itemView.findViewById(R.id.imgAva);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);

        }
    }
}
