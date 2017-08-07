package models;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import models.Post;

import static org.junit.Assert.*;

/**
 * Created by Guest on 8/7/17.
 */

public class PostTest {

    @Test
    public void NewPostObjectGetsCorrectlyCreated_true() throws Exception{
        Post testPost = new Post("Day1: Intro");
        assertEquals(true, testPost instanceof Post);
    }

    @Test
    public void PostInstantiatesWithContent_true() throws Exception {
        Post testPost = new Post("Day 1: Intro");
        assertEquals("Day 1: Intro", testPost.getContent());
    }

    @After
    public void tearDown() {
        Post.clearAllPosts(); //clear out allll the posts before each test.
    }

    @Test
    public void AllPostsAreCorrectlyReturned_true() {
        Post post = new Post("Day 1: Intro");
        Post otherPost = new Post ("How to pair successfully");
        assertEquals(2, Post.getAll().size());
    }

    @Test
    public void AllPostsContainsAllPosts_true() {
        Post post = new Post("Day 1: Intro");
        Post otherPost = new Post ("How to pair successfully");
        assertEquals(true, Post.getAll().contains(post));
        assertEquals(true, Post.getAll().contains(otherPost));
    }

}