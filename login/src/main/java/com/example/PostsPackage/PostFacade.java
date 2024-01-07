package com.example.PostsPackage;

import java.util.*;

public class PostFacade extends GenericCRUD {

    private static PostFacade instance;
    private Post post;
    private List<Post> posts;

    private PostFacade() {}

    public static PostFacade getInstance() {
        if (instance == null) {
            instance = new PostFacade();
        }
        return instance;
    }

    public List<Post> getPost() {
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        this.posts = factory.getPostDAO();
        return posts;
    }

    public Post setPost(int postId, int autheurId, String contenu, int typePostId, int nbLike, int sessionId) {
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        this.post = factory.setPostDAO(postId, autheurId, contenu, nbLike, typePostId, sessionId);
        return this.post;
    }

    public Post getPostById( int id) {
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        this.post = factory.getPostByIdDAO(id);
        return this.post;
    }

    public void removePost( int id) {
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        factory.removePostDAO(id);
    }

    public Post addPost(int autheurId, String contenu, int typePostId, int nbLike, int sessionId) {
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        this.post = factory.addPostDAO(autheurId, contenu, typePostId, nbLike, sessionId);
        return this.post;
    }

    public List<Post> getPostByTPId(int tpId) {
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        this.posts = factory.getPostByTPId(tpId);
        return this.posts;
    }

    public Post getCurrentPost() {
        return this.post;
    }
}