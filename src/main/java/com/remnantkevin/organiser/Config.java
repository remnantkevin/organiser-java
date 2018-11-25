package com.remnantkevin.organiser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown = false)
class Config {
  private static final String RESOURCE_NAME = "config.json";

  @JsonProperty("tableName") public String tableName;

  private Config() {}

  public static Config get() {
    try {
      ObjectMapper mapper = new ObjectMapper();
      // https://stackoverflow.com/questions/28673651/how-to-get-the-path-of-src-test-resources-directory-in-junit/28674517
      ClassLoader loader = Config.class.getClassLoader();
      return mapper.readValue(loader.getResourceAsStream(RESOURCE_NAME), Config.class);
    } catch(Exception e) {
      throw new RuntimeException("Could not read config: " + e.getMessage(), e);
    }
  }
}