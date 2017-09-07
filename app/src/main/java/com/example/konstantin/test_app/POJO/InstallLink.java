
package com.example.konstantin.test_app.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InstallLink {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("post_id")
    @Expose
    private Integer postId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("primary_link")
    @Expose
    private Boolean primaryLink;
    @SerializedName("redirect_url")
    @Expose
    private String redirectUrl;
    @SerializedName("platform")
    @Expose
    private String platform;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getPrimaryLink() {
        return primaryLink;
    }

    public void setPrimaryLink(Boolean primaryLink) {
        this.primaryLink = primaryLink;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

}
