
package com.sentinel.instrumentationAPI.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "errorId",
    "msg"
})
public class Error {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("errorId")
    private Double errorId;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("msg")
    private String msg;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The errorId
     */
    @JsonProperty("errorId")
    public Double getErrorId() {
        return errorId;
    }

    /**
     * 
     * (Required)
     * 
     * @param errorId
     *     The errorId
     */
    @JsonProperty("errorId")
    public void setErrorId(Double errorId) {
        this.errorId = errorId;
    }

    public Error withErrorId(Double errorId) {
        this.errorId = errorId;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The msg
     */
    @JsonProperty("msg")
    public String getMsg() {
        return msg;
    }

    /**
     * 
     * (Required)
     * 
     * @param msg
     *     The msg
     */
    @JsonProperty("msg")
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Error withMsg(String msg) {
        this.msg = msg;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Error withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
