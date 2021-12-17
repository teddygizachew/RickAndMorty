package com.nkufall2021.retrofitgson.models;

import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("name")
    private String name;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @SerializedName("url")
    private String url;
}
