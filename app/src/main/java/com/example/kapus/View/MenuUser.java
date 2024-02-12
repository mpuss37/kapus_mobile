package com.example.kapus.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kapus.Adapter.UserAdapter;
import com.example.kapus.Handler.UserHandler;
import com.example.kapus.Model.UserModel;
import com.example.kapus.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;

public class MenuUser extends UserHandler {
    private RecyclerView recyclerView;
    private Button buttonCheck;
    private UserAdapter userAdapter;
    private ArrayList<UserModel> userModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_user);
        recyclerView = findViewById(R.id.rvUser);
        buttonCheck = findViewById(R.id.buttonCheck);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<UserModel> options = new FirebaseRecyclerOptions.Builder<UserModel>().setQuery(childUser, UserModel.class).build();
        userAdapter = new UserAdapter(options);
        recyclerView.setAdapter(userAdapter);
        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MenuUser.this, AddUser.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
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