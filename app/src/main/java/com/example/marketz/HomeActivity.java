package com.example.marketz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton mFood, mProperty, mServices, mElectronics, mAppliances,
            mBeauty, mCars, business_center;
    private Button postButton, reviewButton, userIconButton ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.include);
        setSupportActionBar(toolbar);

        //ImageButton
        mFood =(ImageButton) findViewById(R.id.food_image);
        mFood.setOnClickListener(this);

        mProperty = (ImageButton) findViewById(R.id.property_image);
        mProperty.setOnClickListener(this);

        mServices = (ImageButton) findViewById(R.id.services_image);
        mServices.setOnClickListener(this);

        mElectronics = (ImageButton) findViewById(R.id.electronics_image);
        mElectronics.setOnClickListener(this);

        mAppliances = (ImageButton) findViewById(R.id.appliances_image);
        mAppliances.setOnClickListener(this);

        mBeauty = (ImageButton) findViewById(R.id.beauty_image);
        mBeauty.setOnClickListener(this);

        mCars = (ImageButton) findViewById(R.id.cars_image);
        mCars.setOnClickListener(this);

        business_center = (ImageButton) findViewById(R.id.business_center);
        business_center.setOnClickListener(this);

        //Button
        postButton = (Button) findViewById(R.id.postAdButton);
        postButton.setOnClickListener(this);

        reviewButton = (Button) findViewById(R.id.reviewButton);
        reviewButton.setOnClickListener(this);

        userIconButton = (Button) findViewById(R.id.user_icon);
        userIconButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.food_image:
                Intent intentFood = new Intent(HomeActivity.this, FoodActivity.class);
                startActivity(intentFood);
                break;
            case R.id.property_image:
                // Intent intentProperty = new Intent(HomeActivity.this, )
                break;

            case R.id.services_image:
                // Intent intentServices = new Intent(HomeActivity.this, )
                break;

            case R.id.electronics_image:
                // Intent intentElectronics = new Intent(HomeActivity.this, )
                break;

            case R.id.appliances_image:
                // Intent intentAppliance = new Intent(HomeActivity.this, )
                break;

            case R.id.beauty_image:
                //Intent intentBeauty = new Intent(HomeActivity.this, )
                break;

            case R.id.business_center:
                //Intent intentBusiness = new Intent(HomeActivity.this, )
                break;

            case R.id.cars_image:
                //Intent intentCars = new Intent(HomeActivity.this, )
                break;

            case R.id.postAdButton:
                Intent i = new Intent(HomeActivity.this,PostAdActivity.class);
                startActivity(i);
                break;

            case R.id.reviewButton:
                //Intent intentReview = new Intent(HomeActivity.this, )
                break;

            case R.id.user_icon:
                Intent intentIcon = new Intent(HomeActivity.this, UserActivity.class);
                startActivity(intentIcon);
        }
    }
}