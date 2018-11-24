package com.remnantkevin.organiser;

public class Note {

    public String title;
    public String content;
    public Long createdAt;
    public Long archivedAt;

    public Note(String title, String content, Long createdAt, Long archivedAt) {
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.archivedAt = archivedAt;
    }

}