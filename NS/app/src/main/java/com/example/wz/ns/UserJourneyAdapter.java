package com.example.wz.ns;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wz.ns.model.UserJourney;

import java.util.ArrayList;
import java.util.List;

public class UserJourneyAdapter extends RecyclerView.Adapter<UserJourneyAdapter.UserJourneyViewHolder> {

    final private UserJourneyClickListener mUserJourneyClickListener;

    List<UserJourney> userJourneyList;

    public interface UserJourneyClickListener {
        void userJourneyOnClick(int i);
    }

    public UserJourneyAdapter(List<UserJourney> userJourneyList, UserJourneyClickListener mUserJourneyClickListener) {
        this.mUserJourneyClickListener = mUserJourneyClickListener;
        this.userJourneyList = userJourneyList;
    }

    @NonNull
    @Override
    public UserJourneyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.saved_user_journey_card_view, viewGroup, false);

        return new UserJourneyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UserJourneyViewHolder holder, int i) {
        UserJourney u = userJourneyList.get(i);
        String from = u.getFrom();
        String to = u.getTo();

        holder.from.setText(from);
        holder.to.setText(to);
    }

    public int getItemCount() {
        return userJourneyList.size();
    }

    public class UserJourneyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView from, to;

        public UserJourneyViewHolder(View itemView) {
            super(itemView);
            from = itemView.findViewById(R.id.view_saved_from);
            to = itemView.findViewById(R.id.view_saved_to);
            itemView.setOnClickListener(this);
        }

        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            mUserJourneyClickListener.userJourneyOnClick(clickedPosition);
        }
    }

    public void swapList(List<UserJourney> newList) {
        userJourneyList = newList;
        if (newList != null) {
            // Force the RecyclerView to refresh
            this.notifyDataSetChanged();
        }
    }
}
