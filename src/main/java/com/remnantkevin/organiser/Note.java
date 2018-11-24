package com.remnantkevin.organiser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Note {
    @JsonProperty("title") public String title;
    @JsonProperty("content") public String content;
    @JsonProperty("createdAt") public Long createdAt;
    @JsonProperty("archivedAt") public Long archivedAt;

    public Note() {}

    public Note(String title, String content, Long createdAt, Long archivedAt) {
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.archivedAt = archivedAt;
    }
}