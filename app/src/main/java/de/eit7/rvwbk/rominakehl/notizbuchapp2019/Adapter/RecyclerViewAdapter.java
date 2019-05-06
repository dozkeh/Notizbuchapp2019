package de.eit7.rvwbk.rominakehl.notizbuchapp2019.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import de.eit7.rvwbk.rominakehl.notizbuchapp2019.Beans.NoteBean;
import de.eit7.rvwbk.rominakehl.notizbuchapp2019.Controller.MyFileHandler;
import de.eit7.rvwbk.rominakehl.notizbuchapp2019.NoteActivity;
import de.eit7.rvwbk.rominakehl.notizbuchapp2019.R;

/**
 * Created by Aws on 28/01/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext ;


    public RecyclerViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = null;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item_note_2,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.note_title.setText(MyFileHandler.getInstance().getAllNotes().get(position).getTitle());
        holder.note_text.setText(MyFileHandler.getInstance().getAllNotes().get(position).getMessage());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, NoteActivity.class);

                // passing data to the note activity
                /*intent.putExtra("Title",mData.get(position).getTitle());
                intent.putExtra("Message",mData.get(position).getMessage());
                intent.putExtra("Id",mData.get(position).getId());*/
                MyFileHandler.getInstance().setCurrentDetailNoteBean((MyFileHandler.getInstance().getAllNotes().get(position).getId()));
                // start the activity
                mContext.startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {
        return MyFileHandler.getInstance().getAllNotes().size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView note_title;
        TextView note_text;
        CardView cardView ;

        public MyViewHolder(View itemView) {
            super(itemView);

            note_title = (TextView) itemView.findViewById(R.id.txt_card_title_id) ;
            note_text = (TextView) itemView.findViewById(R.id.txt_card_message_id);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);


        }
    }


}
