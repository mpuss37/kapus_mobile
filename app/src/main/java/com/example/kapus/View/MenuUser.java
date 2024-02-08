package com.example.kapus.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.kapus.Adapter.UserAdapter;
import com.example.kapus.Handler.UserHandler;
import com.example.kapus.Model.UserModel;
import com.example.kapus.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class MenuUser extends AppCompatActivity {
    private RecyclerView recyclerView;
    private UserHandler userHandler;
    private UserAdapter userAdapter;
    private FirebaseRecyclerOptions<UserModel> options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_user);
        userHandler = new UserHandler();
        recyclerView = findViewById(R.id.rvUser);
        userAdapter = new UserAdapter(options);
        userHandler.displayUserRv(this, userAdapter, recyclerView, options);
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