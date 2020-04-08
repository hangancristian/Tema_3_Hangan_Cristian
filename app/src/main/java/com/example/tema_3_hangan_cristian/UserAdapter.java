package com.example.tema_3_hangan_cristian;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.FeedViewHolder> {
    ArrayList<User> arrayList = new ArrayList<>();

    public UserAdapter(ArrayList<User> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public FeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new FeedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedViewHolder holder, int position) {
        User data = arrayList.get(position);
        holder.name.setText(data.getName());
        holder.username.setText(data.getUsername());
        holder.email.setText(data.getEmail());


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class FeedViewHolder extends RecyclerView.ViewHolder {
        TextView id,name, username, email;

        FeedViewHolder(@NonNull final View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.userId);
            name = itemView.findViewById(R.id.name);
            username = itemView.findViewById(R.id.username);
            email = itemView.findViewById(R.id.email);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) { ;

                }
            });



        }
    }
}
