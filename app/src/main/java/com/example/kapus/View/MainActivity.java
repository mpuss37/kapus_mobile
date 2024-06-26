package com.example.kapus.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kapus.Handler.UserHandler;
import com.example.kapus.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private Button buttonSave;
    private TextView textViewSignIn;
    private EditText editTextUsername, editTextPassword;
    private String username, password;
    protected UserHandler userHandler;
    final protected DatabaseReference dbUrl = FirebaseDatabase.getInstance().getReferenceFromUrl("https://kapus-f9efb-default-rtdb.firebaseio.com/");
    protected Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        userHandler = new UserHandler();
        buttonSave = findViewById(R.id.buttonSave);
        textViewSignIn = findViewById(R.id.textViewSignIn);
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = editTextUsername.getText().toString();
                password = editTextPassword.getText().toString();
                String id = userHandler.checkUser(username, password, MainActivity.this, "login");
                intent = new Intent(MainActivity.this, MenuUser.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });

        textViewSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textViewSignIn.getText().equals("new account")) {
                    Toast.makeText(MainActivity.this, "menu register", Toast.LENGTH_SHORT).show();
                    buttonSave.setText("REGISTER");
                    textViewSignIn.setText("have account");
                } else if (textViewSignIn.getText().equals("have account")) {
                    Toast.makeText(MainActivity.this, "menu login", Toast.LENGTH_SHORT).show();
                    buttonSave.setText("LOGIN");
                    textViewSignIn.setText("new account");
                }
            }
        });
    }

}