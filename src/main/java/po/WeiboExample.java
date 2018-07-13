package po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WeiboExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WeiboExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andWeiboIdIsNull() {
            addCriterion("weibo_id is null");
            return (Criteria) this;
        }

        public Criteria andWeiboIdIsNotNull() {
            addCriterion("weibo_id is not null");
            return (Criteria) this;
        }

        public Criteria andWeiboIdEqualTo(Integer value) {
            addCriterion("weibo_id =", value, "weiboId");
            return (Criteria) this;
        }

        public Criteria andWeiboIdNotEqualTo(Integer value) {
            addCriterion("weibo_id <>", value, "weiboId");
            return (Criteria) this;
        }

        public Criteria andWeiboIdGreaterThan(Integer value) {
            addCriterion("weibo_id >", value, "weiboId");
            return (Criteria) this;
        }

        public Criteria andWeiboIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("weibo_id >=", value, "weiboId");
            return (Criteria) this;
        }

        public Criteria andWeiboIdLessThan(Integer value) {
            addCriterion("weibo_id <", value, "weiboId");
            return (Criteria) this;
        }

        public Criteria andWeiboIdLessThanOrEqualTo(Integer value) {
            addCriterion("weibo_id <=", value, "weiboId");
            return (Criteria) this;
        }

        public Criteria andWeiboIdIn(List<Integer> values) {
            addCriterion("weibo_id in", values, "weiboId");
            return (Criteria) this;
        }

        public Criteria andWeiboIdNotIn(List<Integer> values) {
            addCriterion("weibo_id not in", values, "weiboId");
            return (Criteria) this;
        }

        public Criteria andWeiboIdBetween(Integer value1, Integer value2) {
            addCriterion("weibo_id between", value1, value2, "weiboId");
            return (Criteria) this;
        }

        public Criteria andWeiboIdNotBetween(Integer value1, Integer value2) {
            addCriterion("weibo_id not between", value1, value2, "weiboId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andPostTimeIsNull() {
            addCriterion("post_time is null");
            return (Criteria) this;
        }

        public Criteria andPostTimeIsNotNull() {
            addCriterion("post_time is not null");
            return (Criteria) this;
        }

        public Criteria andPostTimeEqualTo(Date value) {
            addCriterion("post_time =", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeNotEqualTo(Date value) {
            addCriterion("post_time <>", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeGreaterThan(Date value) {
            addCriterion("post_time >", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("post_time >=", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeLessThan(Date value) {
            addCriterion("post_time <", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeLessThanOrEqualTo(Date value) {
            addCriterion("post_time <=", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeIn(List<Date> values) {
            addCriterion("post_time in", values, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeNotIn(List<Date> values) {
            addCriterion("post_time not in", values, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeBetween(Date value1, Date value2) {
            addCriterion("post_time between", value1, value2, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeNotBetween(Date value1, Date value2) {
            addCriterion("post_time not between", value1, value2, "postTime");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andPic1IsNull() {
            addCriterion("pic1 is null");
            return (Criteria) this;
        }

        public Criteria andPic1IsNotNull() {
            addCriterion("pic1 is not null");
            return (Criteria) this;
        }

        public Criteria andPic1EqualTo(String value) {
            addCriterion("pic1 =", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1NotEqualTo(String value) {
            addCriterion("pic1 <>", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1GreaterThan(String value) {
            addCriterion("pic1 >", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1GreaterThanOrEqualTo(String value) {
            addCriterion("pic1 >=", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1LessThan(String value) {
            addCriterion("pic1 <", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1LessThanOrEqualTo(String value) {
            addCriterion("pic1 <=", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1Like(String value) {
            addCriterion("pic1 like", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1NotLike(String value) {
            addCriterion("pic1 not like", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1In(List<String> values) {
            addCriterion("pic1 in", values, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1NotIn(List<String> values) {
            addCriterion("pic1 not in", values, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1Between(String value1, String value2) {
            addCriterion("pic1 between", value1, value2, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1NotBetween(String value1, String value2) {
            addCriterion("pic1 not between", value1, value2, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic2IsNull() {
            addCriterion("pic2 is null");
            return (Criteria) this;
        }

        public Criteria andPic2IsNotNull() {
            addCriterion("pic2 is not null");
            return (Criteria) this;
        }

        public Criteria andPic2EqualTo(String value) {
            addCriterion("pic2 =", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2NotEqualTo(String value) {
            addCriterion("pic2 <>", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2GreaterThan(String value) {
            addCriterion("pic2 >", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2GreaterThanOrEqualTo(String value) {
            addCriterion("pic2 >=", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2LessThan(String value) {
            addCriterion("pic2 <", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2LessThanOrEqualTo(String value) {
            addCriterion("pic2 <=", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2Like(String value) {
            addCriterion("pic2 like", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2NotLike(String value) {
            addCriterion("pic2 not like", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2In(List<String> values) {
            addCriterion("pic2 in", values, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2NotIn(List<String> values) {
            addCriterion("pic2 not in", values, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2Between(String value1, String value2) {
            addCriterion("pic2 between", value1, value2, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2NotBetween(String value1, String value2) {
            addCriterion("pic2 not between", value1, value2, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic3IsNull() {
            addCriterion("pic3 is null");
            return (Criteria) this;
        }

        public Criteria andPic3IsNotNull() {
            addCriterion("pic3 is not null");
            return (Criteria) this;
        }

        public Criteria andPic3EqualTo(String value) {
            addCriterion("pic3 =", value, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3NotEqualTo(String value) {
            addCriterion("pic3 <>", value, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3GreaterThan(String value) {
            addCriterion("pic3 >", value, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3GreaterThanOrEqualTo(String value) {
            addCriterion("pic3 >=", value, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3LessThan(String value) {
            addCriterion("pic3 <", value, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3LessThanOrEqualTo(String value) {
            addCriterion("pic3 <=", value, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3Like(String value) {
            addCriterion("pic3 like", value, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3NotLike(String value) {
            addCriterion("pic3 not like", value, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3In(List<String> values) {
            addCriterion("pic3 in", values, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3NotIn(List<String> values) {
            addCriterion("pic3 not in", values, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3Between(String value1, String value2) {
            addCriterion("pic3 between", value1, value2, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3NotBetween(String value1, String value2) {
            addCriterion("pic3 not between", value1, value2, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic4IsNull() {
            addCriterion("pic4 is null");
            return (Criteria) this;
        }

        public Criteria andPic4IsNotNull() {
            addCriterion("pic4 is not null");
            return (Criteria) this;
        }

        public Criteria andPic4EqualTo(String value) {
            addCriterion("pic4 =", value, "pic4");
            return (Criteria) this;
        }

        public Criteria andPic4NotEqualTo(String value) {
            addCriterion("pic4 <>", value, "pic4");
            return (Criteria) this;
        }

        public Criteria andPic4GreaterThan(String value) {
            addCriterion("pic4 >", value, "pic4");
            return (Criteria) this;
        }

        public Criteria andPic4GreaterThanOrEqualTo(String value) {
            addCriterion("pic4 >=", value, "pic4");
            return (Criteria) this;
        }

        public Criteria andPic4LessThan(String value) {
            addCriterion("pic4 <", value, "pic4");
            return (Criteria) this;
        }

        public Criteria andPic4LessThanOrEqualTo(String value) {
            addCriterion("pic4 <=", value, "pic4");
            return (Criteria) this;
        }

        public Criteria andPic4Like(String value) {
            addCriterion("pic4 like", value, "pic4");
            return (Criteria) this;
        }

        public Criteria andPic4NotLike(String value) {
            addCriterion("pic4 not like", value, "pic4");
            return (Criteria) this;
        }

        public Criteria andPic4In(List<String> values) {
            addCriterion("pic4 in", values, "pic4");
            return (Criteria) this;
        }

        public Criteria andPic4NotIn(List<String> values) {
            addCriterion("pic4 not in", values, "pic4");
            return (Criteria) this;
        }

        public Criteria andPic4Between(String value1, String value2) {
            addCriterion("pic4 between", value1, value2, "pic4");
            return (Criteria) this;
        }

        public Criteria andPic4NotBetween(String value1, String value2) {
            addCriterion("pic4 not between", value1, value2, "pic4");
            return (Criteria) this;
        }

        public Criteria andPic5IsNull() {
            addCriterion("pic5 is null");
            return (Criteria) this;
        }

        public Criteria andPic5IsNotNull() {
            addCriterion("pic5 is not null");
            return (Criteria) this;
        }

        public Criteria andPic5EqualTo(String value) {
            addCriterion("pic5 =", value, "pic5");
            return (Criteria) this;
        }

        public Criteria andPic5NotEqualTo(String value) {
            addCriterion("pic5 <>", value, "pic5");
            return (Criteria) this;
        }

        public Criteria andPic5GreaterThan(String value) {
            addCriterion("pic5 >", value, "pic5");
            return (Criteria) this;
        }

        public Criteria andPic5GreaterThanOrEqualTo(String value) {
            addCriterion("pic5 >=", value, "pic5");
            return (Criteria) this;
        }

        public Criteria andPic5LessThan(String value) {
            addCriterion("pic5 <", value, "pic5");
            return (Criteria) this;
        }

        public Criteria andPic5LessThanOrEqualTo(String value) {
            addCriterion("pic5 <=", value, "pic5");
            return (Criteria) this;
        }

        public Criteria andPic5Like(String value) {
            addCriterion("pic5 like", value, "pic5");
            return (Criteria) this;
        }

        public Criteria andPic5NotLike(String value) {
            addCriterion("pic5 not like", value, "pic5");
            return (Criteria) this;
        }

        public Criteria andPic5In(List<String> values) {
            addCriterion("pic5 in", values, "pic5");
            return (Criteria) this;
        }

        public Criteria andPic5NotIn(List<String> values) {
            addCriterion("pic5 not in", values, "pic5");
            return (Criteria) this;
        }

        public Criteria andPic5Between(String value1, String value2) {
            addCriterion("pic5 between", value1, value2, "pic5");
            return (Criteria) this;
        }

        public Criteria andPic5NotBetween(String value1, String value2) {
            addCriterion("pic5 not between", value1, value2, "pic5");
            return (Criteria) this;
        }

        public Criteria andPic6IsNull() {
            addCriterion("pic6 is null");
            return (Criteria) this;
        }

        public Criteria andPic6IsNotNull() {
            addCriterion("pic6 is not null");
            return (Criteria) this;
        }

        public Criteria andPic6EqualTo(String value) {
            addCriterion("pic6 =", value, "pic6");
            return (Criteria) this;
        }

        public Criteria andPic6NotEqualTo(String value) {
            addCriterion("pic6 <>", value, "pic6");
            return (Criteria) this;
        }

        public Criteria andPic6GreaterThan(String value) {
            addCriterion("pic6 >", value, "pic6");
            return (Criteria) this;
        }

        public Criteria andPic6GreaterThanOrEqualTo(String value) {
            addCriterion("pic6 >=", value, "pic6");
            return (Criteria) this;
        }

        public Criteria andPic6LessThan(String value) {
            addCriterion("pic6 <", value, "pic6");
            return (Criteria) this;
        }

        public Criteria andPic6LessThanOrEqualTo(String value) {
            addCriterion("pic6 <=", value, "pic6");
            return (Criteria) this;
        }

        public Criteria andPic6Like(String value) {
            addCriterion("pic6 like", value, "pic6");
            return (Criteria) this;
        }

        public Criteria andPic6NotLike(String value) {
            addCriterion("pic6 not like", value, "pic6");
            return (Criteria) this;
        }

        public Criteria andPic6In(List<String> values) {
            addCriterion("pic6 in", values, "pic6");
            return (Criteria) this;
        }

        public Criteria andPic6NotIn(List<String> values) {
            addCriterion("pic6 not in", values, "pic6");
            return (Criteria) this;
        }

        public Criteria andPic6Between(String value1, String value2) {
            addCriterion("pic6 between", value1, value2, "pic6");
            return (Criteria) this;
        }

        public Criteria andPic6NotBetween(String value1, String value2) {
            addCriterion("pic6 not between", value1, value2, "pic6");
            return (Criteria) this;
        }

        public Criteria andPic7IsNull() {
            addCriterion("pic7 is null");
            return (Criteria) this;
        }

        public Criteria andPic7IsNotNull() {
            addCriterion("pic7 is not null");
            return (Criteria) this;
        }

        public Criteria andPic7EqualTo(String value) {
            addCriterion("pic7 =", value, "pic7");
            return (Criteria) this;
        }

        public Criteria andPic7NotEqualTo(String value) {
            addCriterion("pic7 <>", value, "pic7");
            return (Criteria) this;
        }

        public Criteria andPic7GreaterThan(String value) {
            addCriterion("pic7 >", value, "pic7");
            return (Criteria) this;
        }

        public Criteria andPic7GreaterThanOrEqualTo(String value) {
            addCriterion("pic7 >=", value, "pic7");
            return (Criteria) this;
        }

        public Criteria andPic7LessThan(String value) {
            addCriterion("pic7 <", value, "pic7");
            return (Criteria) this;
        }

        public Criteria andPic7LessThanOrEqualTo(String value) {
            addCriterion("pic7 <=", value, "pic7");
            return (Criteria) this;
        }

        public Criteria andPic7Like(String value) {
            addCriterion("pic7 like", value, "pic7");
            return (Criteria) this;
        }

        public Criteria andPic7NotLike(String value) {
            addCriterion("pic7 not like", value, "pic7");
            return (Criteria) this;
        }

        public Criteria andPic7In(List<String> values) {
            addCriterion("pic7 in", values, "pic7");
            return (Criteria) this;
        }

        public Criteria andPic7NotIn(List<String> values) {
            addCriterion("pic7 not in", values, "pic7");
            return (Criteria) this;
        }

        public Criteria andPic7Between(String value1, String value2) {
            addCriterion("pic7 between", value1, value2, "pic7");
            return (Criteria) this;
        }

        public Criteria andPic7NotBetween(String value1, String value2) {
            addCriterion("pic7 not between", value1, value2, "pic7");
            return (Criteria) this;
        }

        public Criteria andPic8IsNull() {
            addCriterion("pic8 is null");
            return (Criteria) this;
        }

        public Criteria andPic8IsNotNull() {
            addCriterion("pic8 is not null");
            return (Criteria) this;
        }

        public Criteria andPic8EqualTo(String value) {
            addCriterion("pic8 =", value, "pic8");
            return (Criteria) this;
        }

        public Criteria andPic8NotEqualTo(String value) {
            addCriterion("pic8 <>", value, "pic8");
            return (Criteria) this;
        }

        public Criteria andPic8GreaterThan(String value) {
            addCriterion("pic8 >", value, "pic8");
            return (Criteria) this;
        }

        public Criteria andPic8GreaterThanOrEqualTo(String value) {
            addCriterion("pic8 >=", value, "pic8");
            return (Criteria) this;
        }

        public Criteria andPic8LessThan(String value) {
            addCriterion("pic8 <", value, "pic8");
            return (Criteria) this;
        }

        public Criteria andPic8LessThanOrEqualTo(String value) {
            addCriterion("pic8 <=", value, "pic8");
            return (Criteria) this;
        }

        public Criteria andPic8Like(String value) {
            addCriterion("pic8 like", value, "pic8");
            return (Criteria) this;
        }

        public Criteria andPic8NotLike(String value) {
            addCriterion("pic8 not like", value, "pic8");
            return (Criteria) this;
        }

        public Criteria andPic8In(List<String> values) {
            addCriterion("pic8 in", values, "pic8");
            return (Criteria) this;
        }

        public Criteria andPic8NotIn(List<String> values) {
            addCriterion("pic8 not in", values, "pic8");
            return (Criteria) this;
        }

        public Criteria andPic8Between(String value1, String value2) {
            addCriterion("pic8 between", value1, value2, "pic8");
            return (Criteria) this;
        }

        public Criteria andPic8NotBetween(String value1, String value2) {
            addCriterion("pic8 not between", value1, value2, "pic8");
            return (Criteria) this;
        }

        public Criteria andPic9IsNull() {
            addCriterion("pic9 is null");
            return (Criteria) this;
        }

        public Criteria andPic9IsNotNull() {
            addCriterion("pic9 is not null");
            return (Criteria) this;
        }

        public Criteria andPic9EqualTo(String value) {
            addCriterion("pic9 =", value, "pic9");
            return (Criteria) this;
        }

        public Criteria andPic9NotEqualTo(String value) {
            addCriterion("pic9 <>", value, "pic9");
            return (Criteria) this;
        }

        public Criteria andPic9GreaterThan(String value) {
            addCriterion("pic9 >", value, "pic9");
            return (Criteria) this;
        }

        public Criteria andPic9GreaterThanOrEqualTo(String value) {
            addCriterion("pic9 >=", value, "pic9");
            return (Criteria) this;
        }

        public Criteria andPic9LessThan(String value) {
            addCriterion("pic9 <", value, "pic9");
            return (Criteria) this;
        }

        public Criteria andPic9LessThanOrEqualTo(String value) {
            addCriterion("pic9 <=", value, "pic9");
            return (Criteria) this;
        }

        public Criteria andPic9Like(String value) {
            addCriterion("pic9 like", value, "pic9");
            return (Criteria) this;
        }

        public Criteria andPic9NotLike(String value) {
            addCriterion("pic9 not like", value, "pic9");
            return (Criteria) this;
        }

        public Criteria andPic9In(List<String> values) {
            addCriterion("pic9 in", values, "pic9");
            return (Criteria) this;
        }

        public Criteria andPic9NotIn(List<String> values) {
            addCriterion("pic9 not in", values, "pic9");
            return (Criteria) this;
        }

        public Criteria andPic9Between(String value1, String value2) {
            addCriterion("pic9 between", value1, value2, "pic9");
            return (Criteria) this;
        }

        public Criteria andPic9NotBetween(String value1, String value2) {
            addCriterion("pic9 not between", value1, value2, "pic9");
            return (Criteria) this;
        }

        public Criteria andOriginalIsNull() {
            addCriterion("original is null");
            return (Criteria) this;
        }

        public Criteria andOriginalIsNotNull() {
            addCriterion("original is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalEqualTo(Integer value) {
            addCriterion("original =", value, "original");
            return (Criteria) this;
        }

        public Criteria andOriginalNotEqualTo(Integer value) {
            addCriterion("original <>", value, "original");
            return (Criteria) this;
        }

        public Criteria andOriginalGreaterThan(Integer value) {
            addCriterion("original >", value, "original");
            return (Criteria) this;
        }

        public Criteria andOriginalGreaterThanOrEqualTo(Integer value) {
            addCriterion("original >=", value, "original");
            return (Criteria) this;
        }

        public Criteria andOriginalLessThan(Integer value) {
            addCriterion("original <", value, "original");
            return (Criteria) this;
        }

        public Criteria andOriginalLessThanOrEqualTo(Integer value) {
            addCriterion("original <=", value, "original");
            return (Criteria) this;
        }

        public Criteria andOriginalIn(List<Integer> values) {
            addCriterion("original in", values, "original");
            return (Criteria) this;
        }

        public Criteria andOriginalNotIn(List<Integer> values) {
            addCriterion("original not in", values, "original");
            return (Criteria) this;
        }

        public Criteria andOriginalBetween(Integer value1, Integer value2) {
            addCriterion("original between", value1, value2, "original");
            return (Criteria) this;
        }

        public Criteria andOriginalNotBetween(Integer value1, Integer value2) {
            addCriterion("original not between", value1, value2, "original");
            return (Criteria) this;
        }

        public Criteria andRepostIdIsNull() {
            addCriterion("repost_id is null");
            return (Criteria) this;
        }

        public Criteria andRepostIdIsNotNull() {
            addCriterion("repost_id is not null");
            return (Criteria) this;
        }

        public Criteria andRepostIdEqualTo(Integer value) {
            addCriterion("repost_id =", value, "repostId");
            return (Criteria) this;
        }

        public Criteria andRepostIdNotEqualTo(Integer value) {
            addCriterion("repost_id <>", value, "repostId");
            return (Criteria) this;
        }

        public Criteria andRepostIdGreaterThan(Integer value) {
            addCriterion("repost_id >", value, "repostId");
            return (Criteria) this;
        }

        public Criteria andRepostIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("repost_id >=", value, "repostId");
            return (Criteria) this;
        }

        public Criteria andRepostIdLessThan(Integer value) {
            addCriterion("repost_id <", value, "repostId");
            return (Criteria) this;
        }

        public Criteria andRepostIdLessThanOrEqualTo(Integer value) {
            addCriterion("repost_id <=", value, "repostId");
            return (Criteria) this;
        }

        public Criteria andRepostIdIn(List<Integer> values) {
            addCriterion("repost_id in", values, "repostId");
            return (Criteria) this;
        }

        public Criteria andRepostIdNotIn(List<Integer> values) {
            addCriterion("repost_id not in", values, "repostId");
            return (Criteria) this;
        }

        public Criteria andRepostIdBetween(Integer value1, Integer value2) {
            addCriterion("repost_id between", value1, value2, "repostId");
            return (Criteria) this;
        }

        public Criteria andRepostIdNotBetween(Integer value1, Integer value2) {
            addCriterion("repost_id not between", value1, value2, "repostId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}