package com.example.econest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.econest.data.Post;

import java.util.List;

public class PostViewAdapter extends RecyclerView.Adapter<PostViewHolder> {

    List<Post> items;
    public PostViewAdapter(List<Post> list) {
        this.items = list;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //holds views for specific row
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post,parent,false);
        PostViewHolder postViewHolder = new PostViewHolder(view);
        return postViewHolder;
    }
    //populates with posts

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post post = items.get(position);
        holder.title.setText(post.getTitle());
        holder.description.setText(post.getDescription());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
