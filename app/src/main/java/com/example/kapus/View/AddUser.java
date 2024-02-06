package com.example.kapus.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.kapus.Handler.UserHandler;
import com.example.kapus.R;

public class AddUser extends MainActivity {
    private EditText editTextUsername, editTextPassword;
    private String username, password;
    private Button buttonSave, buttonUpdate, buttonCheck;
    private UserHandler userHandler = new UserHandler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonSave = findViewById(R.id.button2);
        buttonUpdate = findViewById(R.id.button3);
        buttonCheck = findViewById(R.id.button4);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = editTextUsername.getText().toString();
                password = editTextPassword.getText().toString();
                userHandler.addUser(dbUrl, username, password, AddUser.this);
            }
        });

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(AddUser.this, UpdateUser.class);
                startActivity(intent);
            }
        });

        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = editTextUsername.getText().toString();
                password = editTextPassword.getText().toString();
                userHandler.checkUser(dbUrl, username, password, AddUser.this);
            }
        });
    }
}