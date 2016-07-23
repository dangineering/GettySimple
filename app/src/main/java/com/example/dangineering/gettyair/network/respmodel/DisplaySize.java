
package com.example.dangineering.gettyair.network.respmodel;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class DisplaySize {

    @SerializedName("is_watermarked")
    @Expose
    private Boolean isWatermarked;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("uri")
    @Expose
    private String uri;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DisplaySize() {
    }

    /**
     * 
     * @param isWatermarked
     * @param name
     * @param uri
     */
    public DisplaySize(Boolean isWatermarked, String name, String uri) {
        this.isWatermarked = isWatermarked;
        this.name = name;
        this.uri = uri;
    }

    /**
     * 
     * @return
     *     The isWatermarked
     */
    public Boolean getIsWatermarked() {
        return isWatermarked;
    }

    /**
     * 
     * @param isWatermarked
     *     The is_watermarked
     */
    public void setIsWatermarked(Boolean isWatermarked) {
        this.isWatermarked = isWatermarked;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The uri
     */
    public String getUri() {
        return uri;
    }

    /**
     * 
     * @param uri
     *     The uri
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

}
