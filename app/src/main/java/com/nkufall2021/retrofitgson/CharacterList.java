package com.nkufall2021.retrofitgson;

import com.google.gson.annotations.SerializedName;

public class CharacterList {

    @SerializedName("id")
    private String characterId;

    @SerializedName("name")
    private String characterName;

    @SerializedName("status")
    private String characterStatus;

    @SerializedName("species")
    private String characterSpecies;

    @SerializedName("type")
    private String characterType;

    @SerializedName("gender")
    private String characterGender;

    @SerializedName("created")
    private String characterCreated;

    @SerializedName("url")
    private String characterUrl;

    @SerializedName("image")
    private String characterImage;

    public String getCharacterId() {
        return characterId;
    }

    public String getCharacterName() {
        return characterName;
    }

    public String getCharacterStatus() {
        return characterStatus;
    }

    public String getCharacterSpecies() {
        return characterSpecies;
    }

    public String getCharacterType() {
        return characterType;
    }

    public String getCharacterGender() {
        return characterGender;
    }

    public String getCharacterCreated() {
        return characterCreated;
    }

    public String getCharacterUrl() {
        return characterUrl;
    }

    public String getCharacterImage() {
        return characterImage;
    }
}
