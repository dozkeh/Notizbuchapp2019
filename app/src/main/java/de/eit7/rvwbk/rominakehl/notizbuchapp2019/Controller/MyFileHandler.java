package de.eit7.rvwbk.rominakehl.notizbuchapp2019.Controller;


import de.eit7.rvwbk.rominakehl.notizbuchapp2019.Beans.NoteBean;

import java.util.ArrayList;

/**
 * Created by rominakehl on 19.02.17.
 */

public class MyFileHandler {

    private static MyFileHandler instance = null;

    //Liste aller Notizen
    private ArrayList<NoteBean> allNotes = new ArrayList<>();

    //Für die Detailansicht Bean
    private NoteBean currentDetailNoteBean = new NoteBean();


    public NoteBean getCurrentDetailNoteBean() {
        return currentDetailNoteBean;
    }

    public void setCurrentDetailNoteBean(int id) {
        for(NoteBean myNote:allNotes)
        {
            if (myNote.getId()==id)
                this.currentDetailNoteBean = myNote;
        }

    }


    //Konstruktor
    private MyFileHandler(){
    }

    //Es wird genau eine Instanz der Klasse zurückgegeben -> Singelton-Pattern
    public static synchronized MyFileHandler getInstance(){
        if (instance == null){
            instance = new MyFileHandler();
        }
        return instance;
    }

    //Zugriff auf die Liste mit allen Notizen
    public ArrayList<NoteBean> getAllNotes(){
        return this.allNotes;
    }

    //Aus allen Notizen, die als Liste übergeben werden, die Liste im FileHandler erstellen -> FileService
    public void setAllNotes(ArrayList<NoteBean> allNotes){
        this.allNotes.clear();
        this.allNotes.addAll(allNotes);
    }

    public int getMaxId(){
        int maxId = 0;
        for(NoteBean myNote : allNotes)
        {
          if (myNote.getId()>maxId) maxId = myNote.getId()  ;
        }
        return maxId;
    }

    public boolean idAlreadyExists(int id){
        boolean idExists = false;

        if(!allNotes.isEmpty()){
            for(NoteBean noteBean : allNotes){
                if(noteBean.getId()==id){
                    idExists = true;
                    //TODO Dictionary
                };
            }
        }
        return idExists;
    }


}
