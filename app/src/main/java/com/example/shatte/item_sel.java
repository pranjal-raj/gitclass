package com.example.shatte;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class item_sel extends Fragment {

    int cc = 0;
    int c =0;
    ImageView img;
    TextView tv_item;
    AppCompatButton add;
    AppCompatButton cust;
    ElegantNumberButton eleg ;
    cart cart = new cart();
    int i = 0;

    item_menu im = new item_menu();


    public item_sel() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_item_sel, container, false);
    }

    public void set(int img, String t){
        this.img.setBackgroundResource(img);
        tv_item.setText(t);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = this.getArguments();
        cart.Order = bundle.getStringArrayList("order");
        c = bundle.getInt("categ");
        cc = bundle.getInt("item");
        ConstraintLayout cl = view.findViewById(R.id.cl);
        ElegantNumberButton el = view.findViewById(R.id.eleg);
        img = view.findViewById(R.id.item1_img);
        tv_item = view.findViewById(R.id.item1tv);
        add = view.findViewById(R.id.add);
        eleg = view.findViewById(R.id.eleg);



        switch (c){

            case 0 :

                switch(cc){
                    case 0:

                        set(R.drawable.img_capp,"Cappucino");
                        break;
                    case 1:
                        set(R.drawable.latte,"Latte");
                        break;
                    case 2:
                        set(R.drawable.espresso,"Espresso");
                        break;
                }
                break;
            case 1 :
                switch(cc){
                    case 0:

                        set(R.drawable.pastry,"Vanilla");
                        break;
                    case 1:
                        set(R.drawable.cupcake,"Cupcake");

                        break;
                    case 2:
                        set(R.drawable.cheesecake,"Cheesecake");
                        break;
                }
                break;
            case 2 :
                switch(cc){
                    case 0:

                        set(R.drawable.garlic,"Garlic Bread");
                        break;
                    case 1:
                        set(R.drawable.pasta,"Pasta");
                        break;
                    case 2:
                        set(R.drawable.loda,"Patrick");
                        break;
                }
                break;

        }

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Animation fadeInAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.popup);
                im.cust.setVisibility(View.VISIBLE);
                im.cust.setAnimation(fadeInAnimation);

                eleg.setVisibility(View.VISIBLE);
                eleg.setNumber("1");
                add.setVisibility(View.GONE);

                cart.Order.add(i,tv_item.getText().toString()+" x"+eleg.getNumber() + " ");
                i++;

            }
        });

        eleg.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(eleg.getNumber().equals("0")){
                    eleg.setVisibility(View.GONE);
                    add.setVisibility(View.VISIBLE);
                    com.example.shatte.cart.Order.remove(i-1);
                    im.cust.setVisibility(View.INVISIBLE);
                }
                else{
                cart.Order.set(i-1,tv_item.getText().toString()+"x"+eleg.getNumber());}
            }
        });





    }




}


