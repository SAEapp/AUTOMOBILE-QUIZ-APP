package com.example.quizapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class LBrecyclerAdapter extends RecyclerView.Adapter<LBrecyclerAdapter.ViewHolder> {

    public List<LBUsers> lbUsersList;
    public LBrecyclerAdapter(List<LBUsers> lbUsersList){
        this.lbUsersList=lbUsersList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.leadboardlist,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String Name= lbUsersList.get(position).getName();
        holder.setname(Name);

        String Score= lbUsersList.get(position).getScore();

        holder.setscore(Score);


    }

    @Override
    public int getItemCount() {
        return lbUsersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView name;
        private TextView score;
        View mview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mview=itemView;
        }
        public void setname(String nametxt){
            name=mview.findViewById(R.id.listName);
            name.setText(nametxt);
        }
        public void setscore(String scoretxt){
            score=mview.findViewById(R.id.listRank);
            score.setText(scoretxt);
        }
    }



}
