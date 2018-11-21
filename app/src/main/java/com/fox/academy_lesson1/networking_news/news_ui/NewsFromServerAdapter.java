package com.fox.academy_lesson1.networking_news.news_ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.fox.academy_lesson1.R;
import com.fox.academy_lesson1.networking_news.dto.MultimediaDTO;
import com.fox.academy_lesson1.networking_news.dto.ResultDTO;
import com.fox.academy_lesson1.new_list_ex.NewsListAdapter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class NewsFromServerAdapter extends RecyclerView.Adapter<NewsFromServerAdapter.ViewHolder> {
    private static final String EXTRA_NEWS_ITEM_SERVER = "ITEM_FROM_SERVER";
    private final Context context;
    private List<ResultDTO> resultDTO = new ArrayList<>();
    private final LayoutInflater layoutInflater;
    private ItemClicListner clickListener;


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView author;
        ImageView image;
        TextView category;
        @NonNull
        TextView title;
        @NonNull
        TextView textDescription;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            author = itemView.findViewById(R.id.news_author_from_server_txt);
            image = itemView.findViewById(R.id.news_from_server_img);
            category = itemView.findViewById(R.id.news_from_server_category);
            title = itemView.findViewById(R.id.news_title_from_server_txt);
            textDescription = itemView.findViewById(R.id.news_descriptions_from_server_txt);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) clickListener.onItemClick(itemView, getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = layoutInflater.inflate(R.layout.news_item_list_from_server, parent, false);
            final ViewHolder holder = new ViewHolder(view);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("holder.getAdapterPosition", String.valueOf(holder.getAdapterPosition()));
                openNewsActivity(holder.getAdapterPosition());
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ResultDTO resultItem = resultDTO.get(position);
        holder.author.setText(resultItem.getAuthor());
        holder.category.setText(resultItem.getSection());
        holder.textDescription.setText(resultItem.getAbstractDescription());
        holder.title.setText(resultItem.getPublishDate());
        Glide.with(holder.image.getContext()).load(resultItem.getMultimedia().get(0).getNewsImageUrl()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return resultDTO.size();
    }

    public NewsFromServerAdapter(List<ResultDTO> resultDTO, Context context) {
        this.resultDTO = resultDTO;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public interface ItemClicListner {
        void onItemClick(View view, int position);
    }

    private void openNewsActivity(int newsFromServerItem) {
        final ResultDTO resultItem = resultDTO.get(newsFromServerItem);
        Intent intent = new Intent(context, NewsItemFromServerActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(EXTRA_NEWS_ITEM_SERVER, resultItem);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }
}
