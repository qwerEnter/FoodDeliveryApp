package com.example.fooddelivery.ManageOrder;

import com.example.fooddelivery.Adapter.AllMenuAdapter;
import com.example.fooddelivery.Adapter.BreakfastAdapter;
import com.example.fooddelivery.Adapter.DinnerAdapter;
import com.example.fooddelivery.Model.AllMenuModel;
import com.example.fooddelivery.Model.BreakfastModel;
import com.example.fooddelivery.Model.DinnerModel;
import  com.example.fooddelivery.R;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.fooddelivery.Adapter.RecommendAdapter;
import com.example.fooddelivery.Model.RecommendModel;
import com.example.fooddelivery.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.ktx.Firebase;

import java.util.ArrayList;
import java.util.List;

public class orderfragment extends Fragment {

    RecyclerView all;
    FirebaseFirestore db;

    List<AllMenuModel>allModelList;
    AllMenuAdapter allmenuAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        View root = inflater.inflate(R.layout.fragment_order,container,false);
        db = FirebaseFirestore.getInstance();
        all = root.findViewById(R.id.rv1);


        //all item
        all.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        allModelList = new ArrayList<>();
        allmenuAdapter = new AllMenuAdapter(getActivity(),allModelList);
        all.setAdapter(allmenuAdapter);

        db.collection("AllProduct")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful())
                        {
                            for (QueryDocumentSnapshot document: task.getResult())
                            {
                                AllMenuModel allmodel = document.toObject(AllMenuModel.class);
                                allModelList.add(allmodel);
                                allmenuAdapter.notifyDataSetChanged();
                            }
                        }
                        else{
                            Toast.makeText(getActivity(), "error"+task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });


        return root;


    }
}