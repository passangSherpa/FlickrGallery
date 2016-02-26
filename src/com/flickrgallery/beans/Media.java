
package com.flickrgallery.beans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "m"
})
public class Media implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -1564344150442419082L;
	@JsonProperty("m")
    private String m;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Media() {
    }

    /**
     * 
     * @param m
     */
    public Media(String m) {
        this.m = m;
    }

    /**
     * 
     * @return
     *     The m
     */
    @JsonProperty("m")
    public String getM() {
        return m;
    }

    /**
     * 
     * @param m
     *     The m
     */
    @JsonProperty("m")
    public void setM(String m) {
        this.m = m;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
