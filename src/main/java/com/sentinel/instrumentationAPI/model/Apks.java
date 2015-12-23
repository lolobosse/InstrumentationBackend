package com.sentinel.instrumentationAPI.model;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.annotation.Generated;
import java.util.List;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "apks"
})
public class Apks {

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("apks")
    private List<InstrumentedApk> apks;

    /**
     *
     * (Required)
     *
     * @return
     *     The apks
     */
    @JsonProperty("apks")
    public List<InstrumentedApk> getApks() {
        return apks;
    }

    /**
     *
     * (Required)
     *
     * @param apks
     *     The apks
     */
    @JsonProperty("apks")
    public void setApks(List<InstrumentedApk> apks) {
        this.apks = apks;
    }

    public Apks withApks(List<InstrumentedApk> apks) {
        this.apks = apks;
        return this;
    }


}
