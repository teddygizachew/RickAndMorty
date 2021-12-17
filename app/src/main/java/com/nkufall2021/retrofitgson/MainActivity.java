package com.nkufall2021.retrofitgson;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.nkufall2021.retrofitgson.models.Character;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    CharacterAdapter movieAdapter;
    ArrayList<Character.CharacterResults> characterResults;
    RickandMortyAPI rickandMortyAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        rickandMortyAPI = retrofit.create(RickandMortyAPI.class);

        getCharacters();
    }

    private void getCharacters() {
        Call<Character> call = rickandMortyAPI.getCharacters();

        recyclerView = findViewById(R.id.rvPosts);
        characterResults = new ArrayList<>();

        // Create an Adapter
        movieAdapter = new CharacterAdapter(MainActivity.this, characterResults);
        // Set the adapter on the recycler view
        recyclerView.setAdapter(movieAdapter);
        // Set Layout Manager on the recycler view
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        call.enqueue(new Callback<Character>() {
            @Override
            public void onResponse(Call<Character> call, Response<Character> response) {
                if(!response.isSuccessful()) {
                    Log.d(TAG, "onResponse: " + response.code());
                    return;
                }
                ArrayList<Character.CharacterResults> results = response.body().getData();
                for(Character.CharacterResults characterResults1 : results) {
                    Log.d(TAG, "onResponse: results: " + characterResults1.getCharacterName());
                }

                ArrayList<Character.CharacterResults> characterResults = response.body().getData();
                // Create an Adapter
                movieAdapter = new CharacterAdapter(MainActivity.this, characterResults);
                // Set the adapter on the recycler view
                recyclerView.setAdapter(movieAdapter);
                // Set Layout Manager on the recycler view
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            }

            @Override
            public void onFailure(Call<Character> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}