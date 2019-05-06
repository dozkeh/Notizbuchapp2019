package de.eit7.rvwbk.rominakehl.notizbuchapp2019.Beans;

public class Note {

    private int id;
    private String title;
    private String message;

    public Note()
    {

    }

    public Note(int id, String title, String message) {
        this.id = id;
        this.title = title;
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public int getId() {
        return id;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
