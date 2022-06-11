package com.developerx.ets.Adaptor;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.developerx.ets.Model.QuestionModel;
import com.developerx.ets.R;

import java.util.List;

public class QuestionAdaptor extends RecyclerView.Adapter<QuestionAdaptor.ViewHolder> {
    private List<QuestionModel> Questionlist;
    private Activity QuestionActivity;
//Todo question adaptor class
    public QuestionAdaptor(Activity activity) {
        this.QuestionActivity=activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_question,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return Questionlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

