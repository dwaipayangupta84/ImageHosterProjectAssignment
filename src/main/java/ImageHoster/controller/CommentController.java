package ImageHoster.controller;


import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class CommentController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private CommentService commentService;

    //This controller method is called when the request pattern is of type '/image/{imageId}/{imageTitle}/comments' and also the request type is of POST
    //It creates a comment entered by the user for an image. It associates the comment with that particular image.
    //The comments entered by the user is obtained from RequestParameter comment
    // We pass the Path Variable ImageId to associate the comment to tat aprticular image
    @RequestMapping(value = "/image/{imageId}/{imageTitle}/comments", method = RequestMethod.POST)
    public String createComment(@PathVariable("imageId") Integer imageId, @RequestParam("comment") String comment, Comment newComment, HttpSession session) throws IOException {

        User user = (User) session.getAttribute("loggeduser");
        Image image = imageService.getImageById(imageId);
        newComment.setText(comment);
        newComment.setImage(image);
        newComment.setUser(user);

        commentService.uploadComment(newComment);

        //Once the comment is persisted in db, the user is taken to the showImage() method
        return "redirect:/images/" + imageId + '/' + image.getTitle();
    }

}
