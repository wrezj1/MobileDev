package com.example.wz.ns;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.wz.ns.model.CustomTrip;
import com.example.wz.ns.model.Destination;
import com.example.wz.ns.model.Trip;
import com.example.wz.ns.model.Origin;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainTestAdapter extends RecyclerView.Adapter<MainTestAdapter.MainTestViewHolder> {

    private List<CustomTrip> customTrips;

    final private MainTestClickListener mMainTestClickListener;

    public interface MainTestClickListener {
        void mainTestOnClick(int i);
    }

    public MainTestAdapter(List<CustomTrip> customTrips, MainTestClickListener mMainTestClickListener) {
        this.customTrips = customTrips;
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
        String originPlannedDateTime = convertTime(customTrips.get(position).getOriginTime());
        String destPlannedDateTime = convertTime(customTrips.get(position).getDestTime());
        String durationTime = customTrips.get(position).getJourneyTime();
        String status = customTrips.get(position).getStatus();

        holder.vertrekTijd.setText(originPlannedDateTime);
        holder.aankomtTijd.setText(destPlannedDateTime);
        holder.duration.setText(durationTime);
        holder.status.setText(status);
    }

    private String convertTime(String time){

        //pattern for extracting time
        Pattern p = Pattern.compile("\\d\\d:+\\d\\d");
        Matcher originPlan = p.matcher(time);

        //getting time
        if (originPlan.find()) {
            time = originPlan.group();
        }

        return time;
    }

    @Override
    public int getItemCount() {
        return customTrips.size();
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

