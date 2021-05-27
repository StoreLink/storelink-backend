package kz.storelink.repository;

import kz.storelink.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findCommentByCommentTextLike(String commentText);

    Comment findCommentByCommentId(Long commentId);

}
