package com.example.quizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    Adapter adapter;
    Integer[] colors= null;
    List<CardModel> cardModels;
    ArgbEvaluator argbEvaluator;
    private FirebaseAuth auth;
    private Object cardAdapter;

    public void onStart(){

        super.onStart();

        FirebaseUser currentuser=auth.getCurrentUser();
        if(currentuser==null){

            startActivity(new Intent(MainActivity.this, Login.class));

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start= (Button) findViewById(R.id.start);
        auth= FirebaseAuth.getInstance();


        cardModels= new ArrayList<>();
        cardModels.add(new CardModel(R.drawable.cara, "HatchBack", "Cheap and comfortable"));
        cardModels.add(new CardModel(R.drawable.carb, "Lemo", "Expensive and comfortable"));
        cardModels.add(new CardModel(R.drawable.carc, "Classic", "Old and comfortable"));
        cardModels.add(new CardModel(R.drawable.card, "Sedan", " Premium and comfortable"));
        cardModels.add(new CardModel(R.drawable.care, "Truck", "Heavy and comfortable"));
        cardModels.add(new CardModel(R.drawable.carf, "SUV", "Rugged and comfortable"));

        cardAdapter= new cardAdapter(cardModels, this);


        viewPager= findViewById(R.id.viewPager);
        viewPager.setAdapter((PagerAdapter) cardAdapter);
        viewPager.setPadding(130,500,130,0);

        Integer[] colors_temp= {getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color5),
                getResources().getColor(R.color.color6)};
        colors=colors_temp;

        argbEvaluator= new ArgbEvaluator();

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(position<(((PagerAdapter) cardAdapter).getCount()-1)&& position<(colors.length-1)){

                    viewPager.setBackgroundColor((Integer) argbEvaluator.evaluate(positionOffset,colors[position], colors[position+1]));

                }
                else {
                    viewPager.setBackgroundColor(colors[colors.length-1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }



}