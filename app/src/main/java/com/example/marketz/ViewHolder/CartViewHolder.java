package com.example.marketz.ViewHolder;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marketz.Interface.ItemClickListener;
import com.example.marketz.R;

import org.w3c.dom.Text;

public class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public ImageView cartItemImage, cartItemDelete;
    public TextView cartItemName, cartItemQuantity, cartItemPrice;
    public ImageButton cartQuantityMinus, cartQuantityAdd;
    private ItemClickListener itemClickListener;

    public CartViewHolder(@NonNull View itemView) {
        super(itemView);
        cartItemImage = itemView.findViewById(R.id.cart_item_image);
        cartItemDelete = itemView.findViewById(R.id.cart_item_delete);
        cartItemName = itemView.findViewById(R.id.cart_item_name);
        cartItemQuantity = itemView.findViewById(R.id.cart_quantity);
        cartItemPrice = itemView.findViewById(R.id.cart_item_price);
        cartQuantityMinus = itemView.findViewById(R.id.cart_quant_minus);
        cartQuantityAdd = itemView.findViewById(R.id.cart_quant_add);


    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(),false);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
