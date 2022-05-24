package com.example.shatte;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.Animator;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class checkout extends AppCompatActivity {

    cart cart = new cart();
    TextView tv5;
    String order = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        tv5 = findViewById(R.id.textView5);
        int i = cart.Order.size();
        EditText et = findViewById(R.id.name);
        EditText eta = findViewById(R.id.Address);
        EditText etp = findViewById(R.id.phone);
        TextView tv6 = findViewById(R.id.textView6);
        for (int j = 0 ; j < i; j++ )
        {

            order =  order + "\n• " +cart.Order.get(j) ;

        }
        tv5.setText(order);

        AppCompatButton place = findViewById(R.id.place);
        place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = et.getText().toString();
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{"pranjal.2125cse1043@kiet.edu"});
                i.putExtra(Intent.EXTRA_SUBJECT, "ORDER");
                i.putExtra(Intent.EXTRA_TEXT, "Hello my name is, "+ name + "\nI would like to Order : \n"+ order + "\n\nAddress :\n" + eta.getText().toString() + "\nMobile : " + etp.getText());
                startActivity(Intent.createChooser(i,"Share"));

            }
        });



    }

}