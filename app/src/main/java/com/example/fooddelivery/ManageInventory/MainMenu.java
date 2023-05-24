package com.example.fooddelivery.ManageInventory;

import com.example.fooddelivery.ManageOrder.orderfragment;
import com.example.fooddelivery.ManageProfile.profilefragment;
import com.example.fooddelivery.ManageUser.Login;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.example.fooddelivery.R;
import com.google.firebase.auth.FirebaseAuth;


public class MainMenu extends AppCompatActivity {

    //bottomnaviation
    BottomNavigationView bottomNavigationView;

    com.example.fooddelivery.ManageOrder.orderfragment orderfragment = new orderfragment();
    com.example.fooddelivery.ManageProfile.profilefragment profilefragment = new profilefragment();
    com.example.fooddelivery.ManageInventory.menufragment menufragment = new menufragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu_list);

        //bottomnavigation prodcut
        bottomNavigationView = findViewById(R.id.bottomNavigationView2);
        //dia launch
        getSupportFragmentManager().beginTransaction().replace(R.id.container,menufragment).commit();
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                if (item.getItemId() == R.id.menu)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,menufragment).commit();
                    return true;
                }
                if (item.getItemId() == R.id.order)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,orderfragment).commit();
                    return true;
                }

                if (item.getItemId() == R.id.profile)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,profilefragment).commit();
                    return true;
                }
                if (item.getItemId() == R.id.logout)
                {
                    FirebaseAuth.getInstance().signOut();
                    Intent intent = new Intent(MainMenu.this, Login.class);
                    startActivity(intent);
                    finish();
                }

                return false;
            }
        });


    }

}
