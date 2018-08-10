package com.example.abhatripathi.foodcubo;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.abhatripathi.foodcubo.Database.Database;
import com.example.abhatripathi.foodcubo.Models.Food;
import com.example.abhatripathi.foodcubo.Models.Order;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FoodDetail extends AppCompatActivity {

    TextView food_name,food_price;
    TextView food_description;
    ImageView food_image;
    FloatingActionButton btnCart;
    ElegantNumberButton numberButton;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Food currentFood;

    //ElegantNumberbutton elegantNumberbutton;


    String foodId="";
    FirebaseDatabase database;
    DatabaseReference foods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        //foodDetails

        database=FirebaseDatabase.getInstance();
        foods=database.getReference("Foods");

        //init views
        numberButton = (ElegantNumberButton) findViewById(R.id.number_button);
        btnCart = (FloatingActionButton) findViewById(R.id.btnCart);

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Database(getBaseContext()).addToCart(new Order(
                        foodId,
                        currentFood.getName(),
                        numberButton.getNumber(),
                        currentFood.getPrice(),
                        currentFood.getDiscount()
                ));

            }
        });
        //elegant

        btnCart=findViewById(R.id.btnCart);

        food_description=findViewById(R.id.food_description);
        food_name=findViewById(R.id.food_name);
        food_price=findViewById(R.id.food_price);
        food_image=findViewById(R.id.img_food);

        collapsingToolbarLayout=findViewById(R.id.collapsing);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppbar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppbar);


    }
}
