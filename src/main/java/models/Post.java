package models;

import java.util.ArrayList;

/**
 * Created by Guest on 8/7/17.
 */
public class Post {
    private final String content;
    private static ArrayList<Post> instances = new ArrayList<>();
    private boolean published;


    public Post(String content){
        this.content = content;
        this.published = false;
        instances.add(this);
    }

    public String getContent() {
        return content;
    }
    public static ArrayList<Post> getAll(){
        return instances;
    }
    public static void clearAllPosts(){
        instances.clear();
    }
    public boolean getPublished() {
        return this.published;
    }
}
