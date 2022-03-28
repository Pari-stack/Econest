package com.example.econest.data;

import java.util.ArrayList;
import java.util.List;

public class Post {
    String title;
    String description;

    public Post(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
    public static List<Post> getDummyItems() {
        ArrayList<Post> list = new ArrayList<>();
        list.add(new Post("title1", "description1"));
        list.add(new Post("title2", "description2"));
        return list;
    }
}
