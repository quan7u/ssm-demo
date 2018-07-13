package po;

import java.util.Date;

public class Likes {
	private Integer likesId;

	private Integer userId;

	private Integer weiboId;

	private Date likeTime;

	public Date getLikeTime() {
		return likeTime;
	}

	public void setLikeTime(Date likeTime) {
		this.likeTime = likeTime;
	}

	public Integer getLikesId() {
		return likesId;
	}

	public void setLikesId(Integer likesId) {
		this.likesId = likesId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getWeiboId() {
		return weiboId;
	}

	public void setWeiboId(Integer weiboId) {
		this.weiboId = weiboId;
	}
}