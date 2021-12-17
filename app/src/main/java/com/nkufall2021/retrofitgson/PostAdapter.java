package com.nkufall2021.retrofitgson;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nkufall2021.retrofitgson.models.Post;

import org.parceler.Parcels;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder>{
    Context context;
    List<Post> posts;

    public PostAdapter(Context context, List<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("MovieAdapter", "onCreateViewHolder");
        View movieView = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
        return new ViewHolder(movieView);
    }

    // Involves populating CharacterResults into the item through holder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("MovieAdapter", "onBindViewHolder" + position);

        // Get position
        Post post = posts.get(position);
        // Bind movie CharacterResults into the ViewHolder
        holder.bind(post);
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class ViewHolder extends RecyclerView. ViewHolder {

        LinearLayout container;
        TextView postUserId;
        TextView postId;
        TextView postTitle;
        TextView postBody;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            postUserId = itemView.findViewById(R.id.user_id);
            postId = itemView.findViewById(R.id.post_id);
            postTitle = itemView.findViewById(R.id.post_title);
            postBody = itemView.findViewById(R.id.post_body);
            container = itemView.findViewById(R.id.container);
        }

        public void bind(final Post post) {
            postTitle.setText(post.getTitle());
            postBody.setText(post.getText());
            postId.setText(post.getId());
            postUserId.setText(post.getUserId());
            // Register click Listener on the whole row
            container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Navigate to a new activity when clicked
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("post", Parcels.wrap(post));
                    context.startActivity(intent);
                }
            });
        }
    }
}
