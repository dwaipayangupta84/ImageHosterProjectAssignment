package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    //Call the getAllComments() method in the Repository and obtain a List of all the comments for that Image in the database
   /* public List<Comment> getAllComments(Integer imageId) {
        return commentRepository.getAllComments(imageId);
    }*/


    //The method calls the createComment() method in the Repository and passes the comments to be persisted in the database
    public void uploadComment(Comment comments) {
        commentRepository.createComment(comments);
    }




}
