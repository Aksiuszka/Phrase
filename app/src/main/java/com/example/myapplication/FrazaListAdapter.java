package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;


import java.util.List;

public class FrazaListAdapter extends RecyclerView.Adapter<FrazaListAdapter.FrazaViewHolder> {

    private final LayoutInflater mInflater;
    private List<Fraza> mFrazy;

    FrazaListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public FrazaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recycler_view_item, parent, false);

        return new FrazaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FrazaViewHolder holder, int position) {
        if(mFrazy != null){
            Fraza current = mFrazy.get(position);
            holder.frazaItemView.setText(current.getFraza());
        }else{
            holder.frazaItemView.setText("Brak fraz");
        }

    }

    @Override
    public int getItemCount() {
        if(mFrazy != null){
            return mFrazy.size();
        }else{
            return 0;
    }}

    void setFrazy(List<Fraza> frazy){
        mFrazy=frazy;
        notifyDataSetChanged();
    }

    class FrazaViewHolder extends RecyclerView.ViewHolder {

        private final TextView frazaItemView;

        public FrazaViewHolder(@NonNull View itemView) {
            super(itemView);
            frazaItemView = itemView.findViewById(R.id.textView);
        }
    }
}
