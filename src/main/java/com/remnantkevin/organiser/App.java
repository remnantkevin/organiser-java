package com.remnantkevin.organiser;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import fi.iki.elonen.NanoHTTPD;
import fi.iki.elonen.NanoHTTPD.Response.Status;

// eg. https://github.com/NanoHttpd/nanohttpd#custom-web-app
public class App extends NanoHTTPD {

    public App() throws IOException {
        super(8080);
        start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
        System.out.println("\nRunning! Point your browsers to http://localhost:8080/ \n");
    }

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

        try {
            new App();
        } catch(IOException ioe) {
            System.err.println("Cannot start server: " + ioe.getMessage());
        }
    }

    @Override
    public Response serve(IHTTPSession session) {
        if(session.getMethod() == Method.GET) {
            Map<String, String> params = session.getParms();
            String name = params.get("name");
            if(name != null) {
                return newFixedLengthResponse("Hello, " + name + "!");
            }
        }
        return newFixedLengthResponse(Status.NOT_FOUND, "text/plain", "Unknown request");
    }
}