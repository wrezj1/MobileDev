package com.example.wz.numbertrivia;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class TriviaCardAdapter extends RecyclerView.Adapter<TriviaCardAdapter.TriviaViewHolder> {

    private static List<Trivia> mTriviaCards;

    public TriviaCardAdapter(List<Trivia> mTriviaCards) {
        this.mTriviaCards = mTriviaCards;
    }

    @NonNull
    @Override
    public TriviaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.trivia_card, parent, false);
        View v1 = inflater.inflate(R.layout.trivia_card1, parent, false);

        if (viewType == 0) {
            return new TriviaViewHolder(v);
        }

        return new TriviaViewHolder(v1);

    }

    @Override
    public int getItemViewType(int position) {
        // return 0 if position is even, return 1 if position is odd
        // Note that unlike in ListView adapters, types don't have to be contiguous
        return position % 2;
    }

    @Override
    public void onBindViewHolder(@NonNull TriviaViewHolder holder, int position) {
        Trivia trivia = mTriviaCards.get(position);
        holder.number.setText(String.valueOf(trivia.getNumber()));
        holder.text.setText(trivia.getText());
    }


    public class TriviaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView text, number;

        public TriviaViewHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.view_text);
            number = itemView.findViewById(R.id.view_number);
        }

        @Override
        public void onClick(View v) {
        }
    }

    @Override
    public int getItemCount() {
        return mTriviaCards.size();
    }
}
