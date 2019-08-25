package com.example.cache.dao.article;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "article_table")
public class Article {

    @ColumnInfo(name = "articleId")
    public String mId;

    @ColumnInfo(name = "name")
    public String mName;

    @ColumnInfo(name = "author")
    public String mAuthor;

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "title")
    public String mTitle = "";

    @ColumnInfo(name = "description")
    public String mDescription;

    @ColumnInfo(name = "url")
    public String mUrl;

    @ColumnInfo(name = "image")
    public String mImage;

    @ColumnInfo(name = "date")
    public String mDate;

    @ColumnInfo(name = "content")
    public String mContent;

    @Ignore
    public Article(){}

    public Article(String id, String name, String author, String title, String description, String url, String image, String date, String content){
        this.mId = id;
        this.mName = name;
        this.mAuthor = author;
        this.mTitle = title;
        this.mDescription = description;
        this.mUrl = url;
        this.mImage = image;
        this.mDate = date;
        this.mContent = content;
    }

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

    public String getmAuthor() {
        return mAuthor;
    }

    public void setmAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
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

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }
}
