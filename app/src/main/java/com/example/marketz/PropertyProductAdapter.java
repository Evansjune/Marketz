package com.example.marketz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PropertyProductAdapter extends RecyclerView.Adapter<PropertyProductAdapter.ProductViewHolder> {

    private Context mContext;

    private List<Product>mProductList;

    public PropertyProductAdapter(Context mContext, List<Product>mProductList){
        this.mContext = mContext;
        this.mProductList = mProductList;
    }
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.activity_property, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = mProductList.get(position);

        holder.textViewDescription.setText(product.getDescription());
        holder.textViewPrice.setText(String.valueOf(product.getPrice()));



    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView textViewDescription, textViewPrice;
        ImageView imageView;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewDescription = itemView.findViewById(R.id.description_view);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
