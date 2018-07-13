package po;

public class CollectCustom extends Collect {

	private String date;
	private String weibo_nickname;
	private String weibo_face;

	private WeiboCustom weibo;
	private UserCustom user;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getWeibo_nickname() {
		return weibo_nickname;
	}

	public void setWeibo_nickname(String weibo_nickname) {
		this.weibo_nickname = weibo_nickname;
	}

	public String getWeibo_face() {
		return weibo_face;
	}

	public void setWeibo_face(String weibo_face) {
		this.weibo_face = weibo_face;
	}

	public WeiboCustom getWeibo() {
		return weibo;
	}

	public void setWeibo(WeiboCustom weibo) {
		this.weibo = weibo;
	}

	public UserCustom getUser() {
		return user;
	}

	public void setUser(UserCustom user) {
		this.user = user;
	}

}
