
package com.example.konstantin.test_app.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Medium {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("kindle_asin")
    @Expose
    private Object kindleAsin;
    @SerializedName("media_type")
    @Expose
    private String mediaType;
    @SerializedName("priority")
    @Expose
    private Integer priority;
    @SerializedName("platform")
    @Expose
    private Object platform;
    @SerializedName("video_id")
    @Expose
    private Object videoId;
    @SerializedName("original_width")
    @Expose
    private Integer originalWidth;
    @SerializedName("original_height")
    @Expose
    private Integer originalHeight;
    @SerializedName("metadata")
    @Expose
    private Metadata__ metadata;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getKindleAsin() {
        return kindleAsin;
    }

    public void setKindleAsin(Object kindleAsin) {
        this.kindleAsin = kindleAsin;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Object getPlatform() {
        return platform;
    }

    public void setPlatform(Object platform) {
        this.platform = platform;
    }

    public Object getVideoId() {
        return videoId;
    }

    public void setVideoId(Object videoId) {
        this.videoId = videoId;
    }

    public Integer getOriginalWidth() {
        return originalWidth;
    }

    public void setOriginalWidth(Integer originalWidth) {
        this.originalWidth = originalWidth;
    }

    public Integer getOriginalHeight() {
        return originalHeight;
    }

    public void setOriginalHeight(Integer originalHeight) {
        this.originalHeight = originalHeight;
    }

    public Metadata__ getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata__ metadata) {
        this.metadata = metadata;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
