package com.laduchuy.shoes.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.laduchuy.shoes.R;
import com.laduchuy.shoes.object.Product;

import java.util.List;

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ViewHoder> {
    List<Product> productList;
    ItemOnclick itemOnclick;

    public void setItemOnclick(ItemOnclick itemOnclick) {
        this.itemOnclick = itemOnclick;
    }

    public AdapterProduct(List<Product> productList) {
        this.productList = productList;
      //  this.itemOnclick = itemOnclick;
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
        final Product product = productList.get(position);
        holder.tvName.setText(product.getName());
        holder.tvPrice.setText("đ"+product.getPrice());
        holder.imgAva.setImageResource(Integer.parseInt(product.getImg()));
        holder.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemOnclick.onClickItem(product);
            }
        });
        holder.tvPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemOnclick.onClickItem(product);
            }
        });
        holder.imgAva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemOnclick.onClickItem(product);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }



    public class ViewHoder extends RecyclerView.ViewHolder {
        ImageView imgAva;
        TextView tvName,tvPrice;
        LinearLayout layoutItem;
        public ViewHoder(@NonNull View itemView) {
            super(itemView);
            imgAva = itemView.findViewById(R.id.imgAva);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            layoutItem = itemView.findViewById(R.id.layoutItem);

        }
    }
}
