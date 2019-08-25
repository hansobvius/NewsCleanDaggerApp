package com.example.cache.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.cache.dao.article.Article;
import com.example.cache.dao.article.ArticleDao;

@Database(entities = {Article.class}, version = 1)
public abstract class NewsDatabase extends RoomDatabase {

    private static final String DATABASE = "DATABASE";

    public static volatile NewsDatabase INSTANCE;

    public abstract ArticleDao articleDao();

    public static NewsDatabase getNewsDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (NewsDatabase.class){
                INSTANCE = Room.databaseBuilder(
                        context.getApplicationContext(),
                        NewsDatabase.class,
                        DATABASE).allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }
        return INSTANCE;
    }
}
