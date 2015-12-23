package com.sentinel.instrumentationAPI.model;

import org.codehaus.jackson.annotate.*;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.annotation.Generated;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "hash",
        "url"
})
public class InstrumentedApk {

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("hash")
    private String hash;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("url")
    private String url;

    /**
     *
     * (Required)
     *
     * @return
     *     The hash
     */
    @JsonProperty("hash")
    public String getHash() {
        return hash;
    }

    /**
     *
     * (Required)
     *
     * @param hash
     *     The hash
     */
    @JsonProperty("hash")
    public void setHash(String hash) {
        this.hash = hash;
    }

    public InstrumentedApk withHash(String hash) {
        this.hash = hash;
        return this;
    }

    /**
     *
     * (Required)
     *
     * @return
     *     The url
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     *
     * (Required)
     *
     * @param url
     *     The url
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    public InstrumentedApk withUrl(String url) {
        this.url = url;
        return this;
    }

}
