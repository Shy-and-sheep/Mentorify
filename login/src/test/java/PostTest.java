import com.example.PostsPackage.Post;
import com.example.PostsPackage.PostFacade;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;
public class PostTest {

    private PostFacade postFacade;

    @Before
    public void setUp() {
        postFacade = PostFacade.getInstance();
    }

    @After
    public void tearDown() {
        postFacade = null;
    }

    @Test
    public void testAddAndGetPost() {
        int authorId = 1;
        String contenu = "Contenu du post";
        int typePostId = 1;
        int nbLike = 0;
        int sessionId = 1;

        Post addedPost = postFacade.addPost(authorId, contenu, typePostId, nbLike, sessionId);
        assertNotNull(addedPost);

        int postId = addedPost.getId();
        Post retrievedPost = postFacade.getPostById(postId);
        assertNotNull(retrievedPost);
        assertEquals(authorId, retrievedPost.getAuteurId());
        assertEquals(contenu, retrievedPost.getContenu());
        assertEquals(typePostId, retrievedPost.getTypePostId());
        assertEquals(nbLike, retrievedPost.getNbLike());
        assertEquals(sessionId, retrievedPost.getSessionId());

        postFacade.removePost(postId);
        Post removedPost = postFacade.getPostById(postId);
        assertNull(removedPost);
    }

    @Test
    public void testSetAndGetPost() {
        int authorId = 1;
        String contenu = "Contenu du post";
        int typePostId = 1;
        int nbLike = 0;
        int sessionId = 1;

        Post addedPost = postFacade.addPost(authorId, contenu, typePostId, nbLike, sessionId);
        assertNotNull(addedPost);

        int postId = addedPost.getId();
        Post retrievedPost = postFacade.getPostById(postId);
        assertNotNull(retrievedPost);

        String updatedContenu = "Contenu mis à jour";
        retrievedPost.setContenu(updatedContenu);
        postFacade.setPost(postId, retrievedPost.getAuteurId(), updatedContenu, retrievedPost.getTypePostId(), retrievedPost.getNbLike(), retrievedPost.getSessionId());

        Post updatedPost = postFacade.getPostById(postId);
        assertNotNull(updatedPost);
        assertEquals(updatedContenu, updatedPost.getContenu());

        postFacade.removePost(postId);
    }

    @Test
    public void testGetPost() {
        List<Post> allPosts = postFacade.getPost();
        assertNotNull(allPosts);
        assertFalse(allPosts.isEmpty());
    }

    @Test
    public void testGetPostByTPId() {
        int typePostId = 1;
        List<Post> postsByType = postFacade.getPostByTPId(typePostId);
        assertNotNull(postsByType);
    }

}
