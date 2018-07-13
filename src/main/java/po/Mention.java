package po;

public class Mention {
    private Integer mentionId;

    private Integer userId;

    private Integer repostcount;

    private Integer commentcount;

    private Integer replycount;

    private Integer likecount;

    private Integer fanscount;

    public Integer getMentionId() {
        return mentionId;
    }

    public void setMentionId(Integer mentionId) {
        this.mentionId = mentionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRepostcount() {
        return repostcount;
    }

    public void setRepostcount(Integer repostcount) {
        this.repostcount = repostcount;
    }

    public Integer getCommentcount() {
        return commentcount;
    }

    public void setCommentcount(Integer commentcount) {
        this.commentcount = commentcount;
    }

    public Integer getReplycount() {
        return replycount;
    }

    public void setReplycount(Integer replycount) {
        this.replycount = replycount;
    }

    public Integer getLikecount() {
        return likecount;
    }

    public void setLikecount(Integer likecount) {
        this.likecount = likecount;
    }

    public Integer getFanscount() {
        return fanscount;
    }

    public void setFanscount(Integer fanscount) {
        this.fanscount = fanscount;
    }
}