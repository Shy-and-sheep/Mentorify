package com.example.PostsPackage;

import java.util.List;

public abstract class AbstractDAOFactory {

    private static AbstractDAOFactory instance;

    AbstractDAOFactory() {
    }

    public static AbstractDAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOMySQLFactory();
        }
        return instance;
    }

    public abstract Post getPostByIdDAO(int id);

    public abstract void removePostDAO(int id);

    public abstract List<Post> getPostDAO();

    public abstract Post addPostDAO(int autheurId, String contenu, int typePostId, int nbLike, int sessionId);

    public abstract Post setPostDAO(int postId, int autheurId, String contenu, int nbLike, int typePostId, int sessionId);

    public abstract List<Post> getPostByTPId(int tpId);
}
