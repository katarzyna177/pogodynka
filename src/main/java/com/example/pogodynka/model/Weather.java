
package com.example.pogodynka.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "main",
        "description",
        "icon"
})
@Generated("jsonschema2pojo")
@Data
public class Weather {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("main")
    private String main;
    @JsonProperty("description")
    private String description;
    @JsonProperty("icon")
    private String icon;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

}
