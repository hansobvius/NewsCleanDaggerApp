package com.example.remote.models;

import com.google.gson.annotations.SerializedName;

public class Source {

    @SerializedName("id")
    public String mId;

    @SerializedName("name")
    public String mName;

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }
}
