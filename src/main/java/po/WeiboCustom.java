package po;

public class WeiboCustom extends Weibo {

	// 扩展user
	private User user;

	// 扩展自定义的date String类型
	private String date;

	// 扩展转发weibo
	private WeiboCustom repost;

	// 赞 0——否 1——是
	private int likes;

	// 收藏 0——否 1——是
	private int collect;

	// 被转发次数
	private int repostCount;

	// 被评论次数
	private int commentCount;

	// 被点赞次数
	private int likeCount;

	public int getCollect() {
		return collect;
	}

	public void setCollect(int collect) {
		this.collect = collect;
	}

	public int getRepostCount() {
		return repostCount;
	}

	public void setRepostCount(int repostCount) {
		this.repostCount = repostCount;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public WeiboCustom getRepost() {
		return repost;
	}

	public void setRepost(WeiboCustom repost) {
		this.repost = repost;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}