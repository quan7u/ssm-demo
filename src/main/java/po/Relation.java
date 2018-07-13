package po;

public class Relation {
    private Integer relationId;

    private Integer userId;

    private Integer followid;

    private Integer state;

    public Integer getRelationId() {
        return relationId;
    }

    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFollowid() {
        return followid;
    }

    public void setFollowid(Integer followid) {
        this.followid = followid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}