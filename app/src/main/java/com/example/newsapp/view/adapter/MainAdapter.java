package com.example.newsapp.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.R;
import com.example.newsapp.model.Article;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private List<Article> articleList = new ArrayList<>();
    private Context context;

    public MainAdapter(Context context){
        this.context = context;
    }

    public void addArticles(List<Article> articleEntities){
        this.articleList = articleEntities;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.content_main, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        Article article = new Article();
        article = articleList.get(position);

        Picasso.with(context).load(article.getmImage()).into(holder.mImageView);

        holder.mTitleView.setText(article.getmTitle());
        holder.mSourceView.setText(article.getmName());
        holder.mDateView.setText(article.getmDate());
        holder.mDescriptionView.setText(article.getmContent());

    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    class MainViewHolder extends RecyclerView.ViewHolder{

        final ConstraintLayout mConstraintLayout;
        final ImageView mImageView;
        final TextView mTitleView;
        final TextView mSourceView;
        final TextView mDateView;
        final TextView mDescriptionView;
        final Button mButtonWeb;
        final Button mButtonShare;

        MainViewHolder(View view){
            super(view);

            mConstraintLayout = (ConstraintLayout) view.findViewById(R.id.article_box);
            mImageView = (ImageView) view.findViewById(R.id.image_article);
            mTitleView = (TextView) view.findViewById(R.id.title_view);
            mDateView = (TextView) view.findViewById(R.id.release_date);
            mSourceView = (TextView) view.findViewById(R.id.source_text);
            mDescriptionView = (TextView) view.findViewById(R.id.description_view);
            mButtonShare = (Button) view.findViewById(R.id.share_button);
            mButtonWeb = (Button) view.findViewById(R.id.website_button);
        }
    }


}
