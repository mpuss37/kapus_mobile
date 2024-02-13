package com.example.kapus.Handler;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.kapus.Model.UserModel;
import com.example.kapus.View.AddUser;
import com.example.kapus.View.MainActivity;
import com.example.kapus.View.MenuUser;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class UserHandler extends MainActivity {
    private UserModel userModel = new UserModel();
    protected DatabaseReference childUser = dbUrl.child("users");
    protected DatabaseReference childData = dbUrl.child("data");
    private String key = null;

    public void insertUser(String username, String password, Context context) {
        if (username.equals("") || password.equals("")) {
            Toast.makeText(context, "kolom kosong", Toast.LENGTH_SHORT).show();
        } else {
            userModel.setId_user(childUser.push().getKey());
            userModel.setUsername(username);
            userModel.setPassword(password);
            childUser.child(userModel.getUsername()).setValue(userModel).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    Toast.makeText(context, "data berhasil masuk", Toast.LENGTH_SHORT).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(context, "data gagal", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public void updateUser(String username, String password, String email, String namalengkap, String alamat, Context context) {
        if (username.equals("") || password.equals("") || email.equals("") || namalengkap.equals("") || alamat.equals("")) {
            Toast.makeText(context, "kolom kosong", Toast.LENGTH_SHORT).show();
        } else {
            userModel.setId_user(childUser.push().getKey());
            userModel.setUsername(username);
            userModel.setPassword(password);
            userModel.setEmail(email);
            userModel.setNama_lengkap(namalengkap);
            userModel.setAlamat(alamat);
            childUser.child(userModel.getUsername()).setValue(userModel).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    Toast.makeText(context, "data berhasil masuk", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public String checkUser(String username, String password, Context context, String menu) {
        if (username.equals("") || password.equals("")) {
            Toast.makeText(context, "kolom kosong", Toast.LENGTH_SHORT).show();
        } else {
            childUser.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (username.equals("") || password.equals("")) {
                        Toast.makeText(context, "kolom kosong", Toast.LENGTH_SHORT).show();
                    } else {
                        if (snapshot.child(username).exists()) {
                            if (snapshot.child(username).child("password").getValue(String.class).equals(password)) {
                                key = snapshot.child(username).child("id_user").getValue(String.class);
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
        return key;
    }

}
