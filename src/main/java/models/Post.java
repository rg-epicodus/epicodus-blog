package models;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Created by Guest on 8/7/17.
 */
public class Post {
    private String content;
    private static ArrayList<Post> instances = new ArrayList<>();
    private boolean published;
    private LocalDateTime createdAt;
    private int id;
    private static int increment = 0;


    public Post(String content){
        this.content = content;
        this.createdAt = LocalDateTime.now();
        instances.add(this);
        increment++;
        this.id = increment;
        this.published = false;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public int getId() {
        return id;
    }

    public void update(String content) {
        this.content = content;
    }

    public static Post findById(int id){
        Post test= null;
        for (Post instance : instances) {
            if (instance.getId() == id) {
                test = instance;
            }
        }
        return test;
    }

    public void deletePost(){
        instances.remove(Post.findById(id));
    }
}
