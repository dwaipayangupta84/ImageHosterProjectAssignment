package ImageHoster.repository;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;


//The annotation is a special type of @Component annotation which describes that the class defines a data repository
@Repository
public class CommentRepository {

    //Get an instance of EntityManagerFactory from persistence unit with name as 'imageHoster'
    @PersistenceUnit(unitName = "imageHoster")
    private EntityManagerFactory emf;

    //The method receives the comment to be persisted in the database
    //Creates an instance of EntityManager
    //Starts a transaction
    //The transaction is committed if it is successful
    //The transaction is rolled back in case of unsuccessful transaction
    public Comment createComment(Comment comment){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(comment);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return comment;
    }


    //The method creates an instance of EntityManager
    //Executes JPQL query to fetch all the comments for that particular image from the database
    //Returns the list of all the comments fetched from the database for that image
   /* public List<Comment> getAllComments(Integer imageId) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Comment> query = em.createQuery("SELECT c from Comment c where c.image_id=:imageId", Comment.class).setParameter("imageId",imageId);
        List<Comment> resultList = query.getResultList();

        return resultList;
    }*/

}
