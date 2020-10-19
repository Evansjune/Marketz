package com.example.marketz.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marketz.Interface.ItemClickListener;
import com.example.marketz.R;

public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public ItemClickListener listener;
    public ImageView productImageView;
    public TextView tvProductName, tvProductDescription, tvProductPrice;

    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);
        productImageView = itemView.findViewById(R.id.productImageView);
        tvProductName = itemView.findViewById(R.id.tvProductName);
        tvProductDescription = itemView.findViewById(R.id.tvProductDescription);
        tvProductPrice = itemView.findViewById(R.id.tvProductPrice);
    }
    public void setItemClickListener(ItemClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        listener.onClick(v,getAdapterPosition(),false);
    }
}
