package com.laduchuy.shoes.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.laduchuy.shoes.R;
import com.laduchuy.shoes.object.ProductCart;

import java.util.List;

public class AdapterProductCart extends RecyclerView.Adapter<AdapterProductCart.ViewHolder> {

    List<ProductCart> productCarts;
    OnProductItemClick onProductItemClick;

    public void setOnProductItemClick(OnProductItemClick onProductItemClick) {
        this.onProductItemClick = onProductItemClick;
    }

    public AdapterProductCart(List<ProductCart> productCarts) {
        this.productCarts = productCarts;
    }

    @NonNull
    @Override
    public AdapterProductCart.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.product_cart_item,parent,false);
        ViewHolder viewHoder = new ViewHolder(view);
        return viewHoder;

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterProductCart.ViewHolder holder, int position) {
        final ProductCart productCart = productCarts.get(position);
        holder.tvName.setText(productCart.getName());
        holder.imgAva.setImageResource(Integer.parseInt(productCart.getImg()));
        holder.tvDes.setText(productCart.getDescribe());
        holder.tvPrice.setText("đ "+productCart.getPrice());
        holder.imgDelete.setOnClickListener(view -> {
            onProductItemClick.onClickDelete(productCart);
        });
    }

    @Override
    public int getItemCount() {
        return productCarts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAva,imgDelete;
        TextView tvName,tvDes,tvPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAva = itemView.findViewById(R.id.imgAva);
            imgDelete = itemView.findViewById(R.id.imgDelete);
            tvName = itemView.findViewById(R.id.tvName);
            tvDes = itemView.findViewById(R.id.tvDes);
            tvPrice = itemView.findViewById(R.id.tvPrice);
        }
    }
}
