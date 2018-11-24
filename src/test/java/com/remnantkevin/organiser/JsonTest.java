package com.remnantkevin.organiser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

/** Utility class for converting JSON to and from the {Note} */
public class JsonTest {
  @Test
  public void test_acceptsIncompleteJson() {
    Json json = new Json();
    Note note = json.getNote("{\"title\": \"some title\"}");
    assertNotEquals(null, note);
  }

  public void test_ignoresUnknownFields() {
    Json json = new Json();
    Note note = json.getNote("{\"title\": \"some title\", \"name\": \"roland\"}");
    assertNotEquals(null, note);
  }

  @Test
  public void test_attributesMatch() {
    Json json = new Json();
    Note note = json.getNote("{\"title\": \"some title\", \"content\": \"some content\", \"createdAt\": 1, \"archivedAt\": 2}");
    assertEquals("some title", note.title);
    assertEquals("some content", note.content);
    assertEquals(new Long(1), note.createdAt);
    assertEquals(new Long(2), note.archivedAt);
  }

  @Test
  public void test_generatesJson() {
    Json json = new Json();
    Note note = new Note();
    note.title = "some title";
    note.content = "some content";
    note.createdAt = 1L;
    note.archivedAt = 2L;
    assertEquals("{\"title\":\"some title\",\"content\":\"some content\",\"createdAt\":1,\"archivedAt\":2}", json.getJson(note));
  }
}