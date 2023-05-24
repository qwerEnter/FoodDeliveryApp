package com.example.fooddelivery.ManageProfile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fooddelivery.Adapter.HistoryAdapter;
import com.example.fooddelivery.Model.HistoryModel;
import com.example.fooddelivery.Model.UserModel;
import com.example.fooddelivery.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class profilefragment extends Fragment {

    FirebaseFirestore db;
    FirebaseAuth auth;

    RecyclerView recyclerView;
    HistoryAdapter historyAdapter;
    List<HistoryModel> historyModelList;
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        db = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();
        recyclerView = root.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        historyModelList = new ArrayList<>();
        historyAdapter = new HistoryAdapter(getActivity(),historyModelList);
        recyclerView.setAdapter(historyAdapter);

        //db history
        db.collection("AddToCart").document(auth.getCurrentUser().getUid())
                .collection("CurrentUser").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (DocumentSnapshot documentSnapshot : task.getResult().getDocuments()){
                                HistoryModel historyModel = documentSnapshot.toObject(HistoryModel.class);
                                historyModelList.add(historyModel);
                                historyAdapter.notifyDataSetChanged();
                            }
                        }
                    }
                });

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();

        final TextView emailAddress = root.findViewById(R.id.emailAddress);
        final TextView password = root.findViewById(R.id.password);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserModel userProfile = snapshot.getValue(UserModel.class);

                if (userProfile != null) {
                    String email = userProfile.getEmail();
                    String userPassword = userProfile.getPassword();

                    emailAddress.setText(email);
                    password.setText(userPassword);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        });

        return root;
    }

}
