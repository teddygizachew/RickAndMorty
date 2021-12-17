package com.nkufall2021.retrofitgson;

import com.nkufall2021.retrofitgson.models.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderAPI {
    // https://jsonplaceholder.typicode.com/posts
    @GET("posts")
    Call<List<Post>> getPosts();

//    @GET("")
//    Call<> get
}
