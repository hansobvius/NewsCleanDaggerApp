package com.example.cache.dao.article;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "article_table")
public class Article {

    @PrimaryKey(autoGenerate = true)
    int mId;

    @ColumnInfo(name = "title")
    String mTitle;

    @ColumnInfo(name = "description")
    String mDescription;

    @ColumnInfo(name = "url")
    String mUrl;

    @ColumnInfo(name = "image")
    String mImage;

    @ColumnInfo(name = "source")
    String mSource;

    @ColumnInfo(name = "date")
    String mDate;

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public String getmImage() {
        return mImage;
    }

    public void setmImage(String mImage) {
        this.mImage = mImage;
    }

    public String getmSource() {
        return mSource;
    }

    public void setmSource(String mSource) {
        this.mSource = mSource;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }
}
