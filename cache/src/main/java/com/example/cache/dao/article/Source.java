package com.example.cache.dao.article;

import androidx.room.ColumnInfo;

public class Source {

    @ColumnInfo(name = "id")
    String mId;

    @ColumnInfo(name = "name")
    String mName;

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }
}
