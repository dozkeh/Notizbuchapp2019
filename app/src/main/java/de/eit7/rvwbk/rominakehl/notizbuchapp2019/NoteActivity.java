package de.eit7.rvwbk.rominakehl.notizbuchapp2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;



public class NoteActivity extends AppCompatActivity {

    private TextView txtNoteTitle = null;
    private TextView txtNoteMessage = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        txtNoteTitle = (TextView) findViewById(R.id.txt_note_title_id);
        txtNoteMessage = (TextView) findViewById(R.id.txt_note_message_id);


        // Recieve data
        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title");
        String Description = intent.getExtras().getString("Message");

        // Setting values

        txtNoteTitle.setText(Title);
        txtNoteMessage.setText(Description);
    }
}
