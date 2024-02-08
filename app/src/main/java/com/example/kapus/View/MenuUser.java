package com.example.kapus.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.kapus.Adapter.UserAdapter;
import com.example.kapus.Handler.UserHandler;
import com.example.kapus.Model.UserModel;
import com.example.kapus.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class MenuUser extends UserHandler {
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_user);
        recyclerView = findViewById(R.id.rvUser);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<UserModel> options = new FirebaseRecyclerOptions.Builder<UserModel>().setQuery(childUser, UserModel.class).build();
        userAdapter = new UserAdapter(options);
        recyclerView.setAdapter(userAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        userAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        userAdapter.stopListening();
    }
}