package com.nkufall2021.retrofitgson.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Character {
    @SerializedName("id")
    String characterId;

    @SerializedName("name")
    String characterName;

    @SerializedName("status")
    String characterStatus;

    @SerializedName("species")
    String characterSpecies;

    @SerializedName("gender")
    String characterGender;

    @SerializedName("created")
    String characterCreated;

    @SerializedName("image")
    String characterImageUrl;

    @SerializedName("location")
    private Location location;

    @SerializedName("origin")
    private Origin origin;

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

    public String getCharacterGender() {
        return characterGender;
    }

    public String getCharacterCreated() {
        return characterCreated;
    }

    public String getCharacterImageUrl() {
        return characterImageUrl;
    }

    @SerializedName("results")
    private ArrayList<CharacterResults> results;

    public Location getLocation() {
        return location;
    }

    public Origin getOrigin() {
        return origin;
    }

    public ArrayList<CharacterResults> getData() {
        return results;
    }

    public static class CharacterResults {
        @SerializedName("id")
        String characterId;

        @SerializedName("name")
        String characterName;

        @SerializedName("status")
        String characterStatus;

        @SerializedName("species")
        String characterSpecies;

        @SerializedName("gender")
        String characterGender;

        @SerializedName("created")
        String characterCreated;

        @SerializedName("image")
        String characterImageUrl;

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

        public String getCharacterGender() {
            return characterGender;
        }

        public String getCharacterCreated() {
            return characterCreated;
        }

        public String getCharacterImageUrl() {
            return characterImageUrl;
        }
    }
}
