package com.nkufall2021.retrofitgson;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nkufall2021.retrofitgson.models.Character;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder>{
    Context context;
    ArrayList<Character.CharacterResults> characters;

    public CharacterAdapter(Context context, ArrayList<Character.CharacterResults> characters) {
        this.context = context;
        this.characters = characters;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("MovieAdapter", "onCreateViewHolder");
        View movieView = LayoutInflater.from(context).inflate(R.layout.rick_morty_item, parent, false);
        return new ViewHolder(movieView);
    }

    // Involves populating CharacterResults into the item through holder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("MovieAdapter", "onBindViewHolder" + position);

        // Get position
        Character.CharacterResults character = characters.get(position);
        // Bind movie CharacterResults into the ViewHolder
        holder.bind(character);
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return characters.size();
    }

    public class ViewHolder extends RecyclerView. ViewHolder {

        LinearLayout container;
        TextView charName;
        TextView charStatus;
        TextView charSpecies;
        TextView charGender;
        ImageView charPoster;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            charName = itemView.findViewById(R.id.charName);
            charStatus = itemView.findViewById(R.id.charStatus);
            charSpecies = itemView.findViewById(R.id.charSpecies);
            charGender = itemView.findViewById(R.id.charGender);
            charPoster = itemView.findViewById(R.id.charPoster);
            container = itemView.findViewById(R.id.container);
        }

        public void bind(final Character.CharacterResults character) {
            String charId = character.getCharacterId();
            charName.setText(character.getCharacterName());
            charStatus.setText(character.getCharacterStatus());
            charSpecies.setText(character.getCharacterSpecies());
            charGender.setText(character.getCharacterGender());
//            Glide.with(context).load(character.getCharacterImageUrl()).into(charPoster);
            Picasso.get()
                    .load(character.getCharacterImageUrl())
                    .into(charPoster);
            // Register click Listener on the whole row
            container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Navigate to a new activity when clicked
                    Intent intent = new Intent(context, DetailActivity.class);
//                    intent.putExtra("post", Parcels.wrap(character));
                    intent.putExtra("characterId", charId);
                    context.startActivity(intent);
                }
            });
        }
    }
}
