package com.nkufall2021.retrofitgson.models;

import com.google.gson.annotations.SerializedName;

public class Origin {

    @SerializedName("name")
    private String name;

    @SerializedName("url")
    private String url;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
