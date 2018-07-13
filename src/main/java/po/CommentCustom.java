package po;

import java.util.List;

public class CommentCustom extends Comment {

	// 扩展User
	private User user;

	// 被评论微博用户昵称
	private String weibo_nickname;

	private Weibo weibo;

	// json评论时间
	private String time;

	// 评论回复数
	private int countReply;

	// 回复list
	private List<ReplyCustom> replyList;

	public String getWeibo_nickname() {
		return weibo_nickname;
	}

	public void setWeibo_nickname(String weibo_nickname) {
		this.weibo_nickname = weibo_nickname;
	}

	public Weibo getWeibo() {
		return weibo;
	}

	public void setWeibo(Weibo weibo) {
		this.weibo = weibo;
	}

	public List<ReplyCustom> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<ReplyCustom> replyList) {
		this.replyList = replyList;
	}

	public int getCountReply() {
		return countReply;
	}

	public void setCountReply(int countReply) {
		this.countReply = countReply;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
