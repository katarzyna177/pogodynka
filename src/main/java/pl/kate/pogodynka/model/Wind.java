
package pl.kate.pogodynka.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "speed",
        "deg"
})
@Generated("jsonschema2pojo")
@Data
public class Wind {

    @JsonProperty("speed")
    private Double speed;
    @JsonProperty("deg")
    private Integer deg;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

}
