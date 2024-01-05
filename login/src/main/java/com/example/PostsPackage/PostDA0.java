package com.example.PostsPackage;

import java.util.*;

/**
 * 
 */
public abstract class PostDA0 {

    public PostDA0() {
    };

    public abstract Post getPostById( int id);

    public abstract void removePost(int id);

    public abstract List<Post> getPost();

    public abstract Post addPost(int autheurId, String contenu, int nbLike, int typePostId, int sessionId);

    public abstract Post setPost(int postId, int autheurId, String contenu, int nbLike, int typePostId, int sessionId);

    public abstract List<Post> getPostByTPId(int tpId);

}