package cn.seeumt.controller;

import cn.seeumt.dto.PostDTO;
import cn.seeumt.model.Comment;
import cn.seeumt.model.Thumber;
import cn.seeumt.service.CommentService;
import cn.seeumt.service.PostService;
import cn.seeumt.utils.ThumberUtil;
import cn.seeumt.utils.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;




    @GetMapping("/comment01")
    public int comment01(String postId,
                         @RequestParam(value = "type",defaultValue ="5" ) Byte type,
                         String userId,String content) {
        return commentService.commentForRoot(postId,userId,content,type);
    }

    @GetMapping("/")
    public int send() {
        return postService.sendPost();
    }

    @GetMapping("/find")
    public List<Comment> findAllCommentsNew(String parentId) {
        List<Comment> levelCommentsList = commentService.findNextLevelCommentsByParentId(parentId);
        List<Comment> comments = TreeUtil.listToTree(levelCommentsList, parentId);
        return comments;
    }


    @GetMapping("/findPost")
    public PostDTO findAPost(String postId) {
        PostDTO postDTO = postService.selectByPostId(postId);
        List<Comment> levelCommentsList = commentService.findNextLevelCommentsByParentId(postId);
        List<Comment> comments = TreeUtil.listToTree(levelCommentsList, postId);
        postDTO.setComments(comments);
        List<Thumber> thumbers = ThumberUtil.allThumbers(postId);
        postDTO.setThumbers(thumbers);
        return postDTO;
    }








}