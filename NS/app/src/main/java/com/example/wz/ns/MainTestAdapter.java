package com.example.wz.ns;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.wz.ns.model.Destination;
import com.example.wz.ns.model.Trip;
import com.example.wz.ns.model.Origin;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainTestAdapter extends RecyclerView.Adapter<MainTestAdapter.MainTestViewHolder> {

    private List<Origin> mOriginList;
    private List<Destination> mDestinationList;
    private List<Trip> mTripList;

    final private MainTestClickListener mMainTestClickListener;

    public interface MainTestClickListener {
        void mainTestOnClick(int i);
    }

    public MainTestAdapter(List<Trip> tripList, List<Origin> mOriginList,
                           List<Destination> mDestinationList, MainTestClickListener mMainTestClickListener) {
        this.mTripList = tripList;
        this.mOriginList = mOriginList;
        this.mDestinationList = mDestinationList;
        this.mMainTestClickListener = mMainTestClickListener;
    }

    @NonNull
    @Override
    public MainTestAdapter.MainTestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.trip_card_view, parent, false);

        return new MainTestViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MainTestViewHolder holder, int position) {
        String originPlannedDateTime = mOriginList.get(position).getPlannedDateTime();
        String destPlannedDateTime = mDestinationList.get(position).getPlannedDateTime();
        String durationTime = mTripList.get(position).getPlannedDurationInMinutes().toString();

        String status = mTripList.get(position).getStatus();

        //pattern for extracting time
        Pattern p = Pattern.compile("\\d\\d:+\\d\\d");

        Matcher originPlan = p.matcher(originPlannedDateTime);
        Matcher destPlan = p.matcher(destPlannedDateTime);
        String originPlannedTime = "";
        String destPlannedTime = "";

        //getting time
        if (originPlan.find() && destPlan.find()) {
            originPlannedTime = originPlan.group();
            destPlannedTime = destPlan.group();
        }

        holder.vertrekTijd.setText(originPlannedTime);
        holder.aankomtTijd.setText(destPlannedTime);
        holder.duration.setText(durationTime);
        holder.status.setText(status);
    }

    @Override
    public int getItemCount() {
        return mDestinationList.size();
    }

    public class MainTestViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView vertrekTijd, aankomtTijd, duration, status;

        public MainTestViewHolder(View itemView) {
            super(itemView);
            vertrekTijd = itemView.findViewById(R.id.view_vertrekTijd);
            aankomtTijd = itemView.findViewById(R.id.view_aankomtTijd);
            duration = itemView.findViewById(R.id.view_duration);
            status = itemView.findViewById(R.id.view_status);
            itemView.setOnClickListener(this);
        }

        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            mMainTestClickListener.mainTestOnClick(clickedPosition);
        }
    }
}

