package com.nkufall2021.retrofitgson;

import com.nkufall2021.retrofitgson.models.Character;
import com.nkufall2021.retrofitgson.models.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RickandMortyAPI {
    // https://rickandmortyapi.com/api/character
    @GET("character")
    Call<Character> getCharacters();

    // https://rickandmortyapi.com/api/character/{id}
    @GET("character/{id}")
    Call<Character> getCharacterInfo(@Path("id") int characterId);
}
