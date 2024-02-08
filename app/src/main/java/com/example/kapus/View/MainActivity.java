package com.example.kapus.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kapus.Handler.UserHandler;
import com.example.kapus.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton floatingActionButton;
    private Button buttonMenu;
    final protected DatabaseReference dbUrl = FirebaseDatabase.getInstance().getReferenceFromUrl("https://kapus-f9efb-default-rtdb.firebaseio.com/");
    protected Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingActionButton = findViewById(R.id.floatingActionButton);
        buttonMenu = findViewById(R.id.buttonMenu);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, AddUser.class);
                startActivity(intent);
            }
        });

        buttonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, MenuUser.class);
                startActivity(intent);
            }
        });
    }

}