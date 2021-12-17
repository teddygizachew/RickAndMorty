package com.nkufall2021.retrofitgson;

import static android.content.ContentValues.TAG;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.nkufall2021.retrofitgson.models.Character;
import com.nkufall2021.retrofitgson.models.Location;
import com.nkufall2021.retrofitgson.models.Origin;
import com.nkufall2021.retrofitgson.models.Post;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailActivity extends AppCompatActivity {

    RickandMortyAPI rickandMortyAPI;
    TextView charName;
    TextView charStatus;
    TextView charSpecies;
    TextView charGender;
    ImageView charPoster;
    TextView charCreated;
    TextView charLocation;
    TextView charOrigin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        rickandMortyAPI = retrofit.create(RickandMortyAPI.class);

        String charId = getIntent().getStringExtra("characterId");
        getCharacterInfo(charId);
    }

    private void getCharacterInfo(String charId) {

        charName = findViewById(R.id.charDetailName);
        charStatus = findViewById(R.id.charDetailStatus);
        charSpecies = findViewById(R.id.charDetailSpecies);
        charGender = findViewById(R.id.charDetailGender);
        charPoster = findViewById(R.id.charDetailPoster);
        charCreated = findViewById(R.id.charDetailCreated);
        charLocation = findViewById(R.id.charDetailLocation);
        charOrigin = findViewById(R.id.charDetailOrigin);

        Log.d(TAG, "onCreate: charId " + parseInt(charId));

        Call<Character> call = rickandMortyAPI.getCharacterInfo(parseInt(charId));

        call.enqueue(new Callback<Character>() {
            @Override
            public void onResponse(Call<Character> call, Response<Character> response) {
                if(!response.isSuccessful()) {
                    Log.d(TAG, TAG + "onResponse: " + response.code());
                    return;
                }

                Character character = response.body();

                String character0 = response.body().getCharacterName();
                String character1 = response.body().getCharacterStatus();
                String character2 = response.body().getCharacterSpecies();
                String character3 = response.body().getCharacterGender();
                String character4 = response.body().getCharacterImageUrl();
                String character5 = response.body().getCharacterCreated();

                charName.setText(response.body().getCharacterName());
                charStatus.setText(response.body().getCharacterStatus());
                charSpecies.setText(character2);
                charGender.setText(character3);
                Picasso.get()
                        .load(character4)
                        .into(charPoster);
                charCreated.setText(character5);

                Location location = response.body().getLocation();
                Origin origin = response.body().getOrigin();
                charOrigin.setText(origin.getName());
                charLocation.setText(location.getName());
            }

            @Override
            public void onFailure(Call<Character> call, Throwable t) {

            }
        });
    }
}