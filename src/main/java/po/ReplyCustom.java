package po;

public class ReplyCustom extends Reply {

	// from 昵称
	private String from;

	// to 昵称
	private String to;

	// 头像
	private String from_face;
	private String to_face;

	// 源微博
	private Weibo weibo;

	// 回复时间 sql扩展
		private String rtime;

	public Weibo getWeibo() {
		return weibo;
	}

	public void setWeibo(Weibo weibo) {
		this.weibo = weibo;
	}

	public String getFrom_face() {
		return from_face;
	}

	public void setFrom_face(String from_face) {
		this.from_face = from_face;
	}

	public String getTo_face() {
		return to_face;
	}

	public void setTo_face(String to_face) {
		this.to_face = to_face;
	}

	public String getRtime() {
		return rtime;
	}

	public void setRtime(String rtime) {
		this.rtime = rtime;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

}
