package com.remnantkevin.organiser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/** Utility class for converting JSON to and from the {Note} */
public class ConfigTest {
  @Test
  public void test_readsConfig() {
    assertEquals("test-name", Config.get().tableName);
  }
}