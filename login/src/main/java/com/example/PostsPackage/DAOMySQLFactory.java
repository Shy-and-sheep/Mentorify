package com.example.PostsPackage;

import java.util.*;

/**
 * 
 */
public class DAOMySQLFactory extends AbstractDAOFactory {

    private PostDAOMySQL postDAOMySQL;

    /**
     * Default constructor
     */
    public DAOMySQLFactory() {
        super();
        this.postDAOMySQL = new PostDAOMySQL();
    }

    public Post getPostByIdDAO(int id) {
        return this.postDAOMySQL.getPostById(id);
    };

    public void removePostDAO(int id) {
        this.postDAOMySQL.removePost(id);
    };

    public List<Post> getPostDAO() {
        return this.postDAOMySQL.getPost();

    };

    public Post addPostDAO(int autheurId, String contenu, int typePostId, int nbLike, int sessionId) {
        return this.postDAOMySQL.addPost(autheurId, contenu, typePostId, nbLike, sessionId);
    };

    public Post setPostDAO(int postId, int autheurId, String contenu, int nbLike, int typePostId, int sessionId) {
        return this.postDAOMySQL.setPost(postId, autheurId, contenu, typePostId, nbLike, sessionId);
    };

    public  List<Post> getPostByTPId(int tpId){
        return  this.postDAOMySQL.getPostByTPId(tpId);
    }

}