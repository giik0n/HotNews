package com.babylon.alex.hotnews;

import android.media.Image;

public class Item {
    private String  content, image;

    public Item(String content, String image) {
        this.content = content;
        this.image = image;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
