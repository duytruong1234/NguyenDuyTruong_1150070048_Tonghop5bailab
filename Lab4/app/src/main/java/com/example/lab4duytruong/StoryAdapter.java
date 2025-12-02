package com.example.lab4duytruong;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {
    private List<StoryItem> storyItems;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(StoryItem item);
    }
    public StoryAdapter(List<StoryItem> storyItems, OnItemClickListener listener) {
        this.storyItems = storyItems;
        this.listener = listener;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_story, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StoryItem item = storyItems.get(position);
        holder.bind(item, listener);
    }
    @Override
    public int getItemCount() {
        return storyItems.size();
    }
    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView storyImage;
        TextView storyTitle;

        ViewHolder(View itemView) {
            super(itemView);
            storyImage = itemView.findViewById(R.id.storyImage);
            storyTitle = itemView.findViewById(R.id.storyTitle);
        }
        void bind(final StoryItem item, final OnItemClickListener listener) {
            storyImage.setImageResource(item.getImageResId());
            storyTitle.setText(item.getTitle());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onItemClick(item);
                    }
                }
            });
        }
    }
}
