package com.example.shatte;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.ImageButton;

import com.google.android.material.internal.VisibilityAwareImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    cart cart = new cart();
    Bundle bundle = new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cart.Order.clear();
        CardView coffee = findViewById(R.id.coffee);
        CardView cakes = findViewById(R.id.cakes);
        CardView food = findViewById(R.id.food);
        FragmentManager fm = getSupportFragmentManager();
        FragmentContainerView fcv = findViewById(R.id.menu_frag);
        ImageButton ib = findViewById(R.id.imageButton);
        ImageButton ib2 = findViewById(R.id.imageButton2);

        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menu cm = new menu();
                fm.beginTransaction().replace(R.id.menu_frag, cm)
                        .addToBackStack(null)
                        .setReorderingAllowed(true)
                        .commit();
                int cx = fcv.getLeft();
                int cy = fcv.getHeight()/2;
                float finalRadius = (float) Math.hypot(cx, cy);

                // create the animator for this view (the start radius is zero)
                Animator anim = ViewAnimationUtils.createCircularReveal(fcv, cx, cy, 0f, finalRadius).setDuration(300);

                // make the view visible and start the animation
                fcv.setVisibility(View.VISIBLE);
                anim.start();
            }
        });

        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, checkout.class);
                startActivity(i);
                int cx = fcv.getLeft();
                int cy = fcv.getHeight()/2;
                float finalRadius = (float) Math.hypot(cx, cy);

                // create the animator for this view (the start radius is zero)
                Animator anim = ViewAnimationUtils.createCircularReveal(fcv, cx, cy, 0f, finalRadius).setDuration(300);

                // make t-he view visible and start the animation
                fcv.setVisibility(View.VISIBLE);
                anim.start();
            }
        });

        coffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putInt("catg", 0);
                bundle.putStringArrayList("order",cart.Order);
                item_menu cm = new item_menu();
                cm.setArguments(bundle);
                fm.beginTransaction().replace(R.id.menu_frag, cm)
                        .addToBackStack(null)
                        .setReorderingAllowed(true)
                        .commit();
                int cx = fcv.getRight();
                int cy = fcv.getBottom();
                float finalRadius = (float) Math.hypot(cx, cy);

                // create the animator for this view (the start radius is zero)
                Animator anim = ViewAnimationUtils.createCircularReveal(fcv, cx, cy, 0f, finalRadius).setDuration(300);

                // make the view visible and start the animation
                fcv.setVisibility(View.VISIBLE);
                anim.start();
            }
        });

        cakes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putInt("catg", 1);
                bundle.putStringArrayList("order",cart.Order);
                item_menu cakm = new item_menu();
                cakm.setArguments(bundle);
                fm.beginTransaction().replace(R.id.menu_frag, cakm)
                        .addToBackStack(null)
                        .setReorderingAllowed(true)
                        .commit();
                int cx = fcv.getRight();
                int cy = fcv.getBottom();
                float finalRadius = (float) Math.hypot(cx, cy);

                // create the animator for this view (the start radius is zero)
                Animator anim = ViewAnimationUtils.createCircularReveal(fcv, cx, cy, 0f, finalRadius).setDuration(300);

                // make the view visible and start the animation
                fcv.setVisibility(View.VISIBLE);
                anim.start();
            }

        });

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putInt("catg", 2);
                bundle.putStringArrayList("order",cart.Order);
                item_menu fom = new item_menu();
                fom.setArguments(bundle);
                fm.beginTransaction().replace(R.id.menu_frag, fom)
                        .addToBackStack(null)
                        .setReorderingAllowed(true)
                        .commit();
                int cx = fcv.getRight();
                int cy = fcv.getBottom();
                float finalRadius = (float) Math.hypot(cx, cy);

                // create the animator for this view (the start radius is zero)
                Animator anim = ViewAnimationUtils.createCircularReveal(fcv, cx, cy, 0f, finalRadius).setDuration(300);

                // make the view visible and start the animation
                fcv.setVisibility(View.VISIBLE);
                anim.start();
            }

        });
    }
    @Override
    protected void onResume() {
        super.onResume();

    }

}