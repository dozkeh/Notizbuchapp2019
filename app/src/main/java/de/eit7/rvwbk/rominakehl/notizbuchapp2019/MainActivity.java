package de.eit7.rvwbk.rominakehl.notizbuchapp2019;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import de.eit7.rvwbk.rominakehl.notizbuchapp2019.Adapter.RecyclerViewAdapter;
import de.eit7.rvwbk.rominakehl.notizbuchapp2019.Beans.Note;

public class MainActivity extends AppCompatActivity {

    private TextView txtFeedback = null;
    private FloatingActionButton btnAddNote = null;
    private RecyclerView rView = null;
    private List<Note> lstNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.btnAddNote = (FloatingActionButton) findViewById(R.id.btn_main_add_id);
        this.rView = (RecyclerView) findViewById(R.id.vw_main_rec_id);

        lstNote = new ArrayList<>();
        lstNote.add(new Note(1,"Note 1","Butter, Bread, Milk, Sugar, Salt, Cookies, Flour, Cheese, Toast, Salmon, Cream, Onions, Apples, Bananas, Mushrooms "));
        lstNote.add(new Note(2,"Note 2","Milk"));
        lstNote.add(new Note(3,"Note 3","Cheese"));
        lstNote.add(new Note(4,"Note 4","Cookies"));
        lstNote.add(new Note(5,"Note 5","Butter"));
        lstNote.add(new Note(6,"Note 6","Milk"));
        lstNote.add(new Note(7,"Note 7","Cheese"));
        lstNote.add(new Note(8,"Note 8","Cookies"));
        lstNote.add(new Note(9,"Note 9","Butter"));
        lstNote.add(new Note(10,"Note 10","Milk"));
        lstNote.add(new Note(11,"Note 11","Cheese"));
        lstNote.add(new Note(12,"Note 12","Cookies"));


        RecyclerView myRV = (RecyclerView) findViewById(R.id.vw_main_rec_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,lstNote);
        myRV.setLayoutManager(new GridLayoutManager(this,3));
        //myRV.setLayoutManager(new LinearLayoutManager(this));
        myRV.setAdapter(myAdapter);

        btnAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, NoteActivity.class);
            intent.putExtra("Title","title");
            intent.putExtra("Message","message");
            intent.putExtra("Id",0);
            startActivity(intent);
            }
        });

    }
}
