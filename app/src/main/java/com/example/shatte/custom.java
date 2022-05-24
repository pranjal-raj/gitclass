package com.example.shatte;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;


public class custom extends Fragment {

    ArrayAdapter<String> adapter;
    ListView lv;
    AppCompatButton co;
    cart cart = new cart();
    int i = 0;
    int t = 0;
    public custom() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_custom, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lv = view.findViewById(R.id.toppings);
        RadioGroup rg = view.findViewById(R.id.rg);
        Bundle bundle = getArguments();
        String toppingsarr[] = {"Extra Froth", "Extra Sugar", "Chocochips"};
        String caketop[] = {"Extra Frosting idk", "Cherrys", "Chocochips"};
        String foodtop[] = {"Extra Ketchup", "Extra Something", "Bro idk :["};
        FragmentManager fm = getChildFragmentManager();
        int c = bundle.getInt("listguide") ;

        switch(c){
            case 0:
                adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_multiple_choice,toppingsarr);
                break;

            case 1:
                adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_multiple_choice,caketop);
                break;

            case 2:
                adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_multiple_choice,foodtop);
                break;


        }

        lv.setAdapter(adapter);
        co = view.findViewById(R.id.checkout);
        co.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = cart.Order.size();
                int j=0;

                    for (int k = 0; k < lv.getCount(); k++) {
                        if (lv.isItemChecked(k)) {
                            cart.Order.set(j, cart.Order.get(j) + " [with" + lv.getItemAtPosition(k)+ "] ");
                        }
                    }

                Intent i = new Intent(getActivity(), checkout.class);
                t = 1;
                startActivity(i);

            }


        });




    }





    @Override
    public void onPause() {
        super.onPause();
        if(t==0) {
            i = cart.Order.size();
            int j =0;
                for (int k = 0; k < lv.getCount(); k++) {
                    if (lv.isItemChecked(k)) {
                        com.example.shatte.cart.Order.set(j, cart.Order.get(j) + "[with " + lv.getItemAtPosition(k).toString()+ "]");
                    }
                }
            }
        }





    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}