package com.example.kapus.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.kapus.Model.UserModel;
import com.example.kapus.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.firestore.auth.User;

import java.util.ArrayList;

public class UserAdapter extends FirebaseRecyclerAdapter<UserModel, UserAdapter.ViewHolder>{
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
    protected void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position, @NonNull UserModel model) {
        holder.textViewId.setText(model.getId_user());
        holder.textViewUsername.setText(model.getUsername());
        holder.textViewpassword.setText(model.getPassword());
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserAdapter.ViewHolder(view);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewId, textViewUsername, textViewpassword;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewId = itemView.findViewById(R.id.textViewId);
            textViewUsername = itemView.findViewById(R.id.textViewUsername);
            textViewpassword = itemView.findViewById(R.id.textViewPassword);
        }
    }
}
