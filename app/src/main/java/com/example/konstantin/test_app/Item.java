package com.example.konstantin.test_app;


class Item {

    private String name;
    private String description;
    private String upvote;
    private int id_post;
    private String imageurl;

    Item(String name, String description, String upvote, int id_post, String imageurl) {
        super();
        this.name = name;
        this.description = description;
        this.upvote = upvote;
        this.id_post = id_post;
        this.imageurl = imageurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    String getUpvote() {
        return upvote;
    }

    public void setUpvote(String upvote) {
        this.upvote = upvote;
    }

    String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    int getId_post() {
        return id_post;
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
    }
}
