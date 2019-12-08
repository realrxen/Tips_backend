package cn.seeumt.model;

import cn.seeumt.dataobject.Comment;
import lombok.Data;

import java.util.Date;
@Data
public class Content {

    private String contentId;

    private Byte type;

    private Date createTime;

    private Date updateTime;

    private Boolean deleted;

    private String loveId;

    private String commentId;

    private String content;

    private Comment comment;

}