package com.example.webservicesfun;

public class InterestingPhoto {
    String id;
    String title;
    String dateTaken;
    String photoUrl;
    
    public InterestingPhoto(String id, String title, String dateTaken, String photoUrl) {
        this.id = id;
        this.title = title;
        this.dateTaken = dateTaken;
        this.photoUrl = photoUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(String dateTaken) {
        this.dateTaken = dateTaken;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Override
    public String toString() {
        return "Interesting photo: id = " + id + ", title= " + title + ", dateTaken=" + dateTaken + ", url: " + photoUrl;
    }
}
