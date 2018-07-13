package po;

public class UserCustom extends User {

	// 用户生日String
	private String bir_String;

	// 用户关系 0——未关注 1——已关注 2——相互关注
	private Relation relation;

	// 扩展用户年龄
	private int age;

	// 与我相关session计数
	private MentionCustom mentionCustom;

	// 消息通知 存储差值
	private MentionCustom notice;

	// 省
	private String p;

	// 市
	private String c;

	// 微博数
	private int weiboCount;
	// 关注数
	private int followCount;
	// 粉丝数
	private int fansCount;

	public int getWeiboCount() {
		return weiboCount;
	}

	public void setWeiboCount(int weiboCount) {
		this.weiboCount = weiboCount;
	}

	public int getFollowCount() {
		return followCount;
	}

	public void setFollowCount(int followCount) {
		this.followCount = followCount;
	}

	public int getFansCount() {
		return fansCount;
	}

	public void setFansCount(int fansCount) {
		this.fansCount = fansCount;
	}

	public MentionCustom getNotice() {
		return notice;
	}

	public void setNotice(MentionCustom notice) {
		this.notice = notice;
	}

	public String getP() {
		return p;
	}

	public void setP(String p) {
		this.p = p;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public MentionCustom getMentionCustom() {
		return mentionCustom;
	}

	public void setMentionCustom(MentionCustom mentionCustom) {
		this.mentionCustom = mentionCustom;
	}

	public String getBir_String() {
		return bir_String;
	}

	public void setBir_String(String bir_String) {
		this.bir_String = bir_String;
	}

	public Relation getRelation() {
		return relation;
	}

	public void setRelation(Relation relation) {
		this.relation = relation;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
