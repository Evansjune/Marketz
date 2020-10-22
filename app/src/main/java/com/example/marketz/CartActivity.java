package com.example.marketz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.marketz.Model.Cart;
import com.example.marketz.Prevalent.Prevalent;
import com.example.marketz.ViewHolder.CartViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CartActivity extends AppCompatActivity {
    private TextView mTextTotal, mTextTitle;
    private Button mButtonContinue, mButtonCheckout;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        mTextTitle = findViewById(R.id.cart_title);
        mTextTotal = findViewById(R.id.tvCartTotal);
        mButtonCheckout = findViewById(R.id.cart_checkout);
        mButtonContinue = findViewById(R.id.cart_continue);
        recyclerView = findViewById(R.id.cart_recyclerview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

    }

    @Override
    protected void onStart() {
        super.onStart();
        final DatabaseReference cartListRef = FirebaseDatabase.getInstance().getReference().child("cart list");
        FirebaseRecyclerOptions<Cart> options = new FirebaseRecyclerOptions.Builder<Cart>()
                .setQuery(cartListRef.child("User View").child(Prevalent.currentOnlineUser.getEmail())
                        .child("products"), Cart.class).build();
        FirebaseRecyclerAdapter<Cart, CartViewHolder> adapter = new FirebaseRecyclerAdapter<Cart, CartViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull CartViewHolder holder, int position, @NonNull Cart model) {
                holder.cartItemPrice.setText(model.getPrice());
                holder.cartItemName.setText(model.getName());
                holder.cartItemQuantity.setText(model.getQuantity());

            }

            @NonNull
            @Override
            public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.cart_list_item, parent, false);
                CartViewHolder holder = new CartViewHolder(view);
                return holder;
            }
        };
        recyclerView.setAdapter(adapter);
        adapter.startListening();

    }
}