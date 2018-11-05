package com.fox.academy_lesson1.networking_news.news_ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.fox.academy_lesson1.R;
import com.fox.academy_lesson1.networking_news.dto.MultimediaDTO;
import com.fox.academy_lesson1.networking_news.dto.ResultDTO;
import com.fox.academy_lesson1.new_list_ex.NewsListAdapter;
import java.util.ArrayList;
import java.util.List;


public class NewsFromServerAdapter extends RecyclerView.Adapter<NewsFromServerAdapter.ViewHolder> {
    private final Context context;
    private List<ResultDTO> resultDTO = new ArrayList<>();
    private final LayoutInflater layoutInflater;
    private NewsListAdapter.ItemClickListener clickListener;


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
             author= itemView.findViewById(R.id.news_author_from_server_txt);
             image = itemView.findViewById(R.id.news_from_server_img);
             category = itemView.findViewById(R.id.news_from_server_category);
             title = itemView.findViewById(R.id.news_title_from_server_txt);
             textDescription = itemView.findViewById(R.id.news_descriptions_from_server_txt);
             itemView.setOnClickListener(this);
         }

         @Override
         public void onClick(View v) {
             if(clickListener != null){
                 clickListener.onItemClick(itemView, getAdapterPosition());
             }
         }
     }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view = layoutInflater.inflate(R.layout.news_item_list_from_server, parent, false);
        return new ViewHolder(view);
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
}
