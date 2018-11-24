package com.remnantkevin.organiser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/** Utility class for converting JSON to and from the {Note} */
public class Json {
  private final ObjectMapper mapper;

  public Json() {
    this.mapper = new ObjectMapper();
  }
  
  /**
   * @see https://www.baeldung.com/jackson-deserialize-json-unknown-properties
   */
  public Note getNote(final String json) {
    try {
      return mapper.readValue(json, Note.class);
    } catch(Exception e) {
      throw new RuntimeException("Error: " + e.getMessage(), e);
    }
  }

  /**
   * @see https://www.baeldung.com/jackson-annotations
   */
  public String getJson(final Note note) {
    try {
      return mapper.writeValueAsString(note);
    } catch(JsonProcessingException e) {
      throw new RuntimeException("Error: " + e.getMessage(), e);
    }
  }
}