package com.example.kapus.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.kapus.Model.UserModel;
import com.example.kapus.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.firestore.auth.User;

import java.util.ArrayList;

public class UserAdapter extends FirebaseRecyclerAdapter<UserModel, RecyclerView.ViewHolder>{

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public UserAdapter(@NonNull FirebaseRecyclerOptions<UserModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position, @NonNull UserModel model) {
        if (holder instanceof ViewHolder) {
            ViewHolder viewHolder = (ViewHolder) holder;
            viewHolder.textViewId.setText(String.valueOf(model.getId_user()));
            viewHolder.textViewUsername.setText(String.valueOf(model.getUsername()));
            viewHolder.textViewPassword.setText(String.valueOf(model.getPassword()));
            viewHolder.textViewEmail.setText(String.valueOf(model.getEmail()));
            viewHolder.textViewNamaLengkap.setText(String.valueOf(model.getNama_lengkap()));
            viewHolder.textViewAlamat.setText(String.valueOf(model.getAlamat()));
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserAdapter.ViewHolder(view);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewId, textViewUsername, textViewPassword, textViewEmail, textViewNamaLengkap, textViewAlamat;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewId = itemView.findViewById(R.id.textViewId);
            textViewUsername = itemView.findViewById(R.id.textViewUsername);
            textViewPassword = itemView.findViewById(R.id.textViewPassword);
            textViewEmail = itemView.findViewById(R.id.textViewEmail);
            textViewNamaLengkap = itemView.findViewById(R.id.textViewNamaLengkap);
            textViewAlamat = itemView.findViewById(R.id.TextViewAlamat);
        }
    }
}
