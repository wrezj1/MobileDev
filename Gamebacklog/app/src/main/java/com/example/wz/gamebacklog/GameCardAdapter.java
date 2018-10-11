package com.example.wz.gamebacklog;

import android.content.Context;
import android.support.annotation.NonNull;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import java.util.List;

public class GameCardAdapter extends RecyclerView.Adapter<GameCardAdapter.GameCardViewHolder> {


    private List<GameCard> mGameCardList;
    final private GameCardClickListener mGameCardClickListener;

    public interface GameCardClickListener {
        void gameCardOnClick(int i);
    }

    public GameCardAdapter(List<GameCard> mGameCardList, GameCardClickListener mGameCardClickListener) {
        this.mGameCardList = mGameCardList;
        this.mGameCardClickListener = mGameCardClickListener;
    }

    @NonNull
    @Override
    public GameCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.game_card_view,parent,false);
        return new GameCardViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull GameCardViewHolder holder, int position) {
    GameCard gameCard = mGameCardList.get(position);

    holder.title.setText(gameCard.getTitle());
    holder.platform.setText(gameCard.getPlatform());
    holder.status.setText(gameCard.getStatus());
    holder.date.setText(gameCard.getDate());
    }

    @Override
    public int getItemCount() {
        return mGameCardList.size();
    }

    public class GameCardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView title, platform, status, date;

        public GameCardViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleView);
            platform = itemView.findViewById(R.id.platformView);
            status = itemView.findViewById(R.id.statusView);
            date = itemView.findViewById(R.id.dateView);
            itemView.setOnClickListener(this);
        }

        public void onClick(View view) {

            int clickedPosition = getAdapterPosition();
            mGameCardClickListener.gameCardOnClick(clickedPosition);
        }
    }

    public void swapList (List<GameCard> newList) {
        mGameCardList = newList;
        if (newList != null) {
            // Force the RecyclerView to refresh
            this.notifyDataSetChanged();
        }

    }
}
