package models;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import models.Post;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * Created by Guest on 8/7/17.
 */

public class PostTest {

    @After
    public void tearDown() throws Exception {
        Post.clearAllPosts(); //clear out allll the posts before each test.
    }

    @Before
    public void setUp() throws Exception {
    }

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

    @Test
    public void AllPostsAreCorrectlyReturned_true() throws Exception {
        Post post = new Post("Day 1: Intro");
        Post otherPost = new Post ("How to pair successfully");
        assertEquals(2, Post.getAll().size());
    }

    @Test
    public void AllPostsContainsAllPosts_true() throws Exception {
        Post post = new Post("Day 1: Intro");
        Post otherPost = new Post ("How to pair successfully");
        assertEquals(true, Post.getAll().contains(post));
        assertEquals(true, Post.getAll().contains(otherPost));
    }

    @Test
    public void getPublished_isFalseAfterInstantiation_false() throws Exception {
        Post myPost = new Post("Day 1:Intro");
        assertEquals(false, myPost.getPublished()); //should never start as published
    }

    @Test
    public void getCreatedAt_instantiatesWithCurrentTime_today() throws Exception {
        Post myPost = newPost();
        assertEquals(LocalDateTime.now().getDayOfWeek(), myPost.getCreatedAt().getDayOfWeek());
    }

    @Test
    public void getId_postInstantiatesWithAnID_1() throws Exception {
        Post.clearAllPosts();
        Post myPost = new Post("Day 1: Intro");
        assertEquals(1, myPost.getId());
    }

    @Test
    public void findReturnsCorrectPost() throws Exception {
        Post post = newPost();
        assertEquals(1, Post.findById(post.getId()).getId());
    }

    @Test
    public void findReturnsCorrectPostWhenMoreThanOnePostExists() throws Exception {
        Post post = newPost();
        Post otherPost = new Post("How to pair successfully");
        assertEquals(2, Post.findById(otherPost.getId()).getId());
    }

    @Test
    public void updateChangesPostContent() throws Exception {
        Post post = newPost();
        String formerContent = post.getContent();
        LocalDateTime formerDate = post.getCreatedAt();
        int formerId = post.getId();

        post.update("Android: Day 40");

        assertEquals(formerId, post.getId());
        assertEquals(formerDate, post.getCreatedAt());
        assertNotEquals(formerContent, post.getContent());
    }

    // helper
        public Post newPost() {
        return new Post("Day 1: Intro");
    }


}