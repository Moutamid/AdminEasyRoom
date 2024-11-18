package com.admineasyroom.model;

public class FeedBackModel {
    public String key;
    public String name;
    public String feedback;

    public FeedBackModel() {
        // Default constructor
    }

    // Getter and Setter for 'key'
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    // Getter and Setter for 'name'
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for 'feedback'
    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}

