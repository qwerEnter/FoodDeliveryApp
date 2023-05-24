package com.example.fooddelivery.ManageOrder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.fooddelivery.Model.AllMenuModel;
import com.example.fooddelivery.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class OrderActivity extends AppCompatActivity {


    TextView quantity;
    int totalPrice = 0;
    int totalQuantity =1;
    ImageView image;
    Button addtocart;
    TextView price;
    ImageView addItem,removeItem;

    AllMenuModel allMenuModel = null;
    FirebaseFirestore firestore;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        firestore = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();


        final Object object = getIntent().getSerializableExtra("detail");
        if (object instanceof AllMenuModel) {
            allMenuModel = (AllMenuModel) object;
        }

        final Object object2 = getIntent().getSerializableExtra("detail");
        if (object instanceof AllMenuModel) {
            allMenuModel = (AllMenuModel) object;
        }

        quantity = findViewById(R.id.quantity);
        image = findViewById(R.id.detailed_img);

        price = findViewById(R.id.detailed_price);
        addItem = findViewById(R.id.add_item);
        removeItem = findViewById(R.id.remove_item);

        if (allMenuModel != null) {
            Glide.with(getApplicationContext()).load(allMenuModel.getImg()).into(image);
            price.setText("Price : " + allMenuModel.getPrice() + "MYR ");

            totalPrice = allMenuModel.getPrice() * totalQuantity + 2;
        }

        addtocart = findViewById(R.id.add_to_cart);
        addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addedtocart();
            }
        });

        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (totalQuantity < 10) {
                    totalQuantity++;
                    quantity.setText(String.valueOf(totalQuantity));
                }
            }
        });

        removeItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (totalQuantity > 1) {
                    totalQuantity--;
                    quantity.setText(String.valueOf(totalQuantity));
                }
            }
        });


    }

    private void addedtocart() {
        String saveCurrentDate,saveCurrentTime;
        Calendar calForDate = Calendar.getInstance();

        SimpleDateFormat currentDate = new SimpleDateFormat("MM dd,yyyy");
        saveCurrentDate = currentDate.format(calForDate.getTime());

        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
        saveCurrentTime = currentTime.format(calForDate.getTime());

        final HashMap<String,Object> cartMap = new HashMap<>();

        cartMap.put("productName",allMenuModel.getName());
        cartMap.put("productPrice",price.getText().toString());
        cartMap.put("productDate",saveCurrentDate);
        cartMap.put("productTime",saveCurrentTime);
        cartMap.put("productQuantity",quantity.getText().toString());
        cartMap.put("productPrice",totalPrice);

        firestore.collection("AddToCart").document(auth.getCurrentUser()
                .getUid()).collection("CurrentUser")
                .add(cartMap).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        Toast.makeText(OrderActivity.this,"Rider is On Your Way", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
    }
}