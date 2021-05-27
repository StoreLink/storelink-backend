package kz.storelink.service.user;

import kz.storelink.model.Comment;
import kz.storelink.model.user.User;
import kz.storelink.repository.CommentRepository;
import kz.storelink.repository.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private CommentRepository commentRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> showAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        System.out.println("User searching by id: " + user);
        return user;
    }

    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }

    public Comment postComment(Long storageId, Comment comment) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        User user = userRepository.getUserByUsername(username);
        comment.setUserId(user.getUserId());
        comment.setStorageId(storageId);

        return commentRepository.save(comment);
    }

    public List<Comment> showAllComments() {
        return commentRepository.findAll();
    }

    public Comment getCommentById(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElse(null);
        System.out.println("Comment searching by id: " + comment);
        return comment;
    }

    public void deleteCommentById(Long commentId) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Comment comment = commentRepository.findCommentByCommentId(commentId);
        String username = userDetails.getUsername();
        User user = userRepository.getUserByUsername(username);
        if(comment.getUserId().equals(user.getUserId())) {
            commentRepository.deleteById(commentId);
        } else {
            System.out.println("It is not your comment!");
        }
    }

}
