package com.example.fooddelivery.ManageInventory;

import com.example.fooddelivery.Adapter.BreakfastAdapter;
import com.example.fooddelivery.Adapter.DinnerAdapter;
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

public class menufragment extends Fragment {

    RecyclerView rec,bek,dinner;
    FirebaseFirestore db;
    //rec menus

    List<RecommendModel>recommendModelList;
    List<BreakfastModel>bekpesModelList;
    List<DinnerModel>dinnerModelList;

    RecommendAdapter recommendAdapter;
    BreakfastAdapter breakfastAdapter;
    DinnerAdapter dinnerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        View root = inflater.inflate(R.layout.fragment_menu,container,false);
        db = FirebaseFirestore.getInstance();
        rec = root.findViewById(R.id.rv1);
        bek = root.findViewById(R.id.rv2);
        dinner = root.findViewById(R.id.rv3);

        //rec item
        rec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        recommendModelList = new ArrayList<>();
        recommendAdapter = new RecommendAdapter(getActivity(),recommendModelList);
        rec.setAdapter(recommendAdapter);

        db.collection("RecommendedProduct")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful())
                        {
                            for (QueryDocumentSnapshot document: task.getResult())
                            {
                                RecommendModel recmodel = document.toObject(RecommendModel.class);
                                recommendModelList.add(recmodel);
                                recommendAdapter.notifyDataSetChanged();
                            }
                        }
                        else{
                            Toast.makeText(getActivity(), "error"+task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        //bek item
        bek.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        bekpesModelList = new ArrayList<>();
        breakfastAdapter = new BreakfastAdapter(getActivity(),bekpesModelList);
        bek.setAdapter(breakfastAdapter);

        db.collection("BreakfastProduct")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful())
                        {
                            for (QueryDocumentSnapshot document: task.getResult())
                            {
                                BreakfastModel bekpesmodel = document.toObject(BreakfastModel.class);
                                bekpesModelList.add(bekpesmodel);
                                breakfastAdapter.notifyDataSetChanged();
                            }
                        }
                        else{
                            Toast.makeText(getActivity(), "error"+task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        //dinner item
        dinner.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        dinnerModelList = new ArrayList<>();
        dinnerAdapter = new DinnerAdapter(getActivity(),dinnerModelList);
        dinner.setAdapter(dinnerAdapter);

        db.collection("DinnerProduct")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful())
                        {
                            for (QueryDocumentSnapshot document: task.getResult())
                            {
                                DinnerModel dinnmodel = document.toObject(DinnerModel.class);
                                dinnerModelList.add(dinnmodel);
                                dinnerAdapter.notifyDataSetChanged();
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