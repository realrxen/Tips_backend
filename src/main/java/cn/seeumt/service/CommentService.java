package cn.seeumt.service;

import cn.seeumt.dataobject.Comment;
import cn.seeumt.model.CommentContent;

import java.util.List;

/**
 * @author Seeumt
 * @date 2019/12/8 16:17
 */
public interface CommentService {
    Comment selectByCommentId(String commentId);
    List<CommentContent> findUserCommentsOfAnArticle(String articleId, String userId);

}
