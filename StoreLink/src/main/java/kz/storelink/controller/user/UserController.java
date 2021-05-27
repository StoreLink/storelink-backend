package kz.storelink.controller.user;

import io.swagger.annotations.ApiOperation;
import kz.storelink.model.Comment;
import kz.storelink.model.user.User;
import kz.storelink.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    UserService userService;

    @ApiOperation(value = "Update user fields by id", response = User.class)
    @PutMapping("/updateUser")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public User updateUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @ApiOperation(value = "Show all users", response = List.class)
    @GetMapping("/showUser")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<User> showAllUser() {
        return userService.showAllUsers();
    }

    @ApiOperation(value = "Get user by id", response = List.class)
    @PostMapping("/getUserById/{userId}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public User getUserById(@PathVariable("userId") Long userId) {
        return userService.getUserById(userId);
    }

    @ApiOperation(value = "Delete user from database", response = List.class)
    @PostMapping("/deleteUser/{userId}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public String deleteUserById(@PathVariable("userId") Long userId) {
        userService.deleteUserById(userId);
        return "User deleted successfully!";
    }

    @ApiOperation(value = "Add new comment", response = List.class)
    @PostMapping("/postComment")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Comment saveUser(@RequestBody() Long storageId, @RequestBody() Comment comment) {
        return userService.postComment(storageId, comment);
    }

    @ApiOperation(value = "Show all comments", response = List.class)
    @GetMapping("/showComment")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Comment> showAllComments() {
        return userService.showAllComments();
    }

    @ApiOperation(value = "Get comment by id", response = List.class)
    @PostMapping("/getCommentById/{commentId}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Comment getCommentById(@PathVariable("commentId") Long commentId) {
        return userService.getCommentById(commentId);
    }

    @ApiOperation(value = "Delete comment from database", response = List.class)
    @PostMapping("/deleteComment/{commentId}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String deleteCommentById(@PathVariable("commentId") Long commentId) {
        userService.deleteCommentById(commentId);
        return "Comment deleted successfully!";
    }

}
