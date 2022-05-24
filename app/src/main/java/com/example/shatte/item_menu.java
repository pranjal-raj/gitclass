package com.example.shatte;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class item_menu extends Fragment {

    int cc= 0;
    AppCompatButton prev;
    AppCompatButton next;
    static AppCompatButton cust;
    item_sel selector;





    public item_menu() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_item_menu, container, false);
    }





    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        selector = new item_sel();
        prev = view.findViewById(R.id.btnprev);
        next = view.findViewById(R.id.btnnext);
        cust = view.findViewById(R.id.custbtn);
        TextView tv = view.findViewById(R.id.textView);
        ImageView iv = view.findViewById(R.id.imageview);
        Bundle bundle = this.getArguments();
        FragmentManager fm = getChildFragmentManager();
        int c = bundle.getInt("catg");

        switch (c)
        {
            case 0:
                tv.setText("Coffee");
                iv.setBackgroundResource(R.drawable.coffeeimg);
                break;
            case 1:
                tv.setText("Cakes");
                iv.setBackgroundResource(R.drawable.cake);
                break;

            case 2:
                tv.setText("Scacks");
                iv.setBackgroundResource(R.drawable.food);
                break;



        }

        bundle.putInt("categ", c);
        bundle.putInt("item", 0);
        selector.setArguments(bundle);
        fm.beginTransaction().replace(R.id.selector_frag, selector).commit();



        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cc--;
                if (cc < 0) {
                    cc = 2;
                }
                swich(c,cc,R.anim.efl,R.anim.xfr);
            }


        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cc++;
                if (cc > 2) {
                    cc = 0;
                }
                swich(c,cc,R.anim.enter_from_right,R.anim.xfl);
            }

        });

        cust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    bundle.putInt("listguide", c);
                    Fragment f = new custom();
                    f.setArguments(bundle);
                FragmentManager fm = getChildFragmentManager();
                fm.beginTransaction().setCustomAnimations(R.anim.efb,R.anim.xfb)
                        .replace(R.id.fcont,f)
                        .addToBackStack(null)
                        .commit();
            }
        });


    }

    public void swich(int c,int cc,int ae, int ax) {
        Bundle bundle = this.getArguments();
        FragmentManager fm = getChildFragmentManager();
        c = bundle.getInt("categ");
        switch (c){

            case 0 :

                switch(cc){
                    case 0:
                        selector = new item_sel();
                        bundle.putInt("categ", 0);
                        bundle.putInt("item", 0);
                        selector.setArguments(bundle);
                        fm.beginTransaction().setCustomAnimations(ae,ax).replace(R.id.selector_frag, selector).commit();
                        break;
                    case 1:
                        selector= new item_sel();
                        bundle.putInt("categ", 0);
                        bundle.putInt("item", 1);
                        selector.setArguments(bundle);
                        fm.beginTransaction().setCustomAnimations(ae,ax).replace(R.id.selector_frag, selector).commit();
                        break;
                    case 2:
                        selector= new item_sel();
                        bundle.putInt("categ", 0);
                        bundle.putInt("item", 2);
                        selector.setArguments(bundle);
                        fm.beginTransaction().setCustomAnimations(ae,ax).replace(R.id.selector_frag, selector).commit();
                        break;
                }
                break;
            case 1 :
                switch(cc){
                    case 0:
                        selector = new item_sel();
                        bundle.putInt("categ", 1);
                        bundle.putInt("item", 0);
                        selector.setArguments(bundle);
                        fm.beginTransaction().setCustomAnimations(ae,ax).replace(R.id.selector_frag, selector).commit();
                        break;
                    case 1:
                        selector= new item_sel();
                        bundle.putInt("categ", 1);
                        bundle.putInt("item", 1);
                        selector.setArguments(bundle);
                        fm.beginTransaction().setCustomAnimations(ae,ax).replace(R.id.selector_frag, selector).commit();
                        break;
                    case 2:
                        selector = new item_sel();
                        bundle.putInt("categ", 1);
                        bundle.putInt("item", 2);
                        selector.setArguments(bundle);
                        fm.beginTransaction().setCustomAnimations(ae,ax).replace(R.id.selector_frag, selector).commit();
                        break;
                }
                break;
            case 2 :
                switch(cc){
                    case 0:
                        item_sel selector = new item_sel();
                        bundle.putInt("categ", 2);
                        bundle.putInt("item", 0);
                        selector.setArguments(bundle);
                        fm.beginTransaction().setCustomAnimations(ae,ax).replace(R.id.selector_frag, selector).commit();
                        break;
                    case 1:
                        selector = new item_sel();
                        bundle.putInt("categ", 2);
                        bundle.putInt("item", 1);
                        selector.setArguments(bundle);
                        fm.beginTransaction().setCustomAnimations(ae,ax).replace(R.id.selector_frag, selector).commit();
                        break;
                    case 2:
                        selector = new item_sel();
                        bundle.putInt("categ", 2);
                        bundle.putInt("item", 2);
                        selector.setArguments(bundle);
                        fm.beginTransaction().setCustomAnimations(ae,ax).replace(R.id.selector_frag, selector).commit();
                        break;
                }
                break;

        }
    }


}