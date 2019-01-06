package com.example.wz.ns;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wz.ns.model.Leg;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtraResultAdapter extends RecyclerView.Adapter<ExtraResultAdapter.ExtraResultViewHolder> {

    private List<Leg> legList;
    private int i;

    private static ExtraResultAdapterClickListener mExtraResultAdapterClickListener;

    public ExtraResultAdapter(List<Leg> legList, ExtraResultAdapterClickListener mExtraResultAdapterClickListener) {
        this.legList = legList;
        this.mExtraResultAdapterClickListener = mExtraResultAdapterClickListener;
    }

    public interface ExtraResultAdapterClickListener {
        void ExtraResultAdapterOnClick(int i);
    }


    @NonNull
    @Override
    public ExtraResultViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.extra_result_view, viewGroup, false);

        return new ExtraResultViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ExtraResultViewHolder holder, int i) {

        this.i = i;
        String from = legList.get(i).getOrigin().getName();
        String to = legList.get(i).getDestination().getName();
        String originPlannedDateTime = convertTime(legList.get(i).getOrigin().getPlannedDateTime());
        String destPlannedDateTime = convertTime(legList.get(i).getDestination().getPlannedDateTime());
        String track = legList.get(i).getOrigin().getPlannedTrack();
        String trainType = legList.get(i).getProduct().getDisplayName();


        holder.from.setText(from);
        holder.to.setText(to);
        holder.fromTime.setText(originPlannedDateTime);
        holder.toTime.setText(destPlannedDateTime);
        holder.track.setText(track);
        holder.trainType.setText(trainType);
    }

    private String convertTime(String time) {

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
        return legList.size();
    }

    public class ExtraResultViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView from, to, fromTime, toTime, track, trainType;

        public ExtraResultViewHolder(View itemView) {
            super(itemView);
            from = itemView.findViewById(R.id.view_extra_from);
            to = itemView.findViewById(R.id.view_extra_to);
            fromTime = itemView.findViewById(R.id.view_extra_fromTime);
            toTime = itemView.findViewById(R.id.view_extra_To_Time);
            track = itemView.findViewById(R.id.view_extra_track);
            trainType = itemView.findViewById(R.id.view_extra_trainType);
            itemView.setOnClickListener(this);
        }

        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            mExtraResultAdapterClickListener.ExtraResultAdapterOnClick(clickedPosition);
        }
    }
}
