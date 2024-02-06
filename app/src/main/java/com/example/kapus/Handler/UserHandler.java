package com.example.kapus.Handler;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.kapus.Model.UserModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class UserHandler extends AppCompatActivity {
    final private UserModel userModel = new UserModel();
    private DatabaseReference childUser;

    public void addUser(DatabaseReference dbUrl, String username, String password, Context context) {
        if (username.equals("") || password.equals("")) {
            Toast.makeText(context, "kolom kosong", Toast.LENGTH_SHORT).show();
        } else {
            childUser = dbUrl.child("user");
            userModel.setId_user(childUser.push().getKey());
            userModel.setUsername(username);
            userModel.setPassword(password);
            childUser.child(userModel.getUsername()).setValue(userModel);
            Toast.makeText(context, "data masuk", Toast.LENGTH_SHORT).show();
        }
    }

    public void updateUser(String username, String password, Context context) {
        if (username.equals("") || password.equals("")) {
            Toast.makeText(context, "kolom kosong", Toast.LENGTH_SHORT).show();
        } else {

        }
    }

    public void checkUser(DatabaseReference dbUrl, String username, String password, Context context) {
        if (username.equals("") || password.equals("")) {
            Toast.makeText(context, "kolom kosong", Toast.LENGTH_SHORT).show();
        } else {
            childUser = dbUrl.child("users");
            childUser.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (username.equals("") || password.equals("")) {
                        Toast.makeText(context, "kolom kosong", Toast.LENGTH_SHORT).show();
                    } else {
                        if (snapshot.child(username).exists()) {
                            if (snapshot.child(username).child("password").equals(password)) {
                                Toast.makeText(context, "user/pass benar", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(context, "user/pass salah", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(context, "data kosong", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    }
//            ref.child("myDb").child("awais@gmailcom").child("leftSpace").setValue("YourDateHere");

}