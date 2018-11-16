package com.example.mahendranm.sampletrue.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mahendranm.sampletrue.R;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;

public class HomeMenuAdapter extends RecyclerView.Adapter<HomeMenuAdapter.HomeMenuViewHolder> {

    Context context;
    ArrayList<String> _homeMneu;


    public HomeMenuAdapter(Context context, ArrayList<String> _homeMneu) {

        this.context = context;
        this._homeMneu =_homeMneu;
    }

    @NonNull
    @Override
    public HomeMenuViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.homemenulistitem, viewGroup, false);
        return new HomeMenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeMenuViewHolder homeMenuViewHolder, int i) {

        homeMenuViewHolder.textView.setText(_homeMneu.get(i));

    }

    @Override
    public int getItemCount() {
        return _homeMneu.size();
    }

    public class HomeMenuViewHolder extends RecyclerView.ViewHolder
    {
        TextView textView;

        public HomeMenuViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.HomeMenuItem);
        }
    }
}
