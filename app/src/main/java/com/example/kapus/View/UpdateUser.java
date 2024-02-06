package com.example.kapus.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kapus.Handler.UserHandler;
import com.example.kapus.R;

public class UpdateUser extends AppCompatActivity {
    private EditText editTextUsername, editTextPassword;
    private String username, password;
    private Button buttonSave;
    private UserHandler userHandler = new UserHandler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);

        buttonSave = findViewById(R.id.button2);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = editTextUsername.getText().toString();
                password = editTextPassword.getText().toString();
//                userHandler.updateUser(username, password, UpdateUser.this);
            }
        });
    }
}