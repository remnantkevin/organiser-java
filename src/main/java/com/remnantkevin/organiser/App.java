package com.remnantkevin.organiser;

import java.util.List;

public class App {
    public static void main (String [] args){
        System.out.println("\nWelcome to Organiser v0.1\n");

        NoteStore noteStore = new NoteStore();
        List<Note> notes = noteStore.getAllNotes();
        for(Note note : notes){
            System.out.println("====================");
            System.out.println(note.title);
            System.out.println(note.content);
            System.out.println(note.createdAt);
            System.out.println(note.archivedAt);
        }

    }
}