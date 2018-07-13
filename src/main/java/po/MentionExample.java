package po;

import java.util.ArrayList;
import java.util.List;

public class MentionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MentionExample() {
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

        public Criteria andMentionIdIsNull() {
            addCriterion("mention_id is null");
            return (Criteria) this;
        }

        public Criteria andMentionIdIsNotNull() {
            addCriterion("mention_id is not null");
            return (Criteria) this;
        }

        public Criteria andMentionIdEqualTo(Integer value) {
            addCriterion("mention_id =", value, "mentionId");
            return (Criteria) this;
        }

        public Criteria andMentionIdNotEqualTo(Integer value) {
            addCriterion("mention_id <>", value, "mentionId");
            return (Criteria) this;
        }

        public Criteria andMentionIdGreaterThan(Integer value) {
            addCriterion("mention_id >", value, "mentionId");
            return (Criteria) this;
        }

        public Criteria andMentionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("mention_id >=", value, "mentionId");
            return (Criteria) this;
        }

        public Criteria andMentionIdLessThan(Integer value) {
            addCriterion("mention_id <", value, "mentionId");
            return (Criteria) this;
        }

        public Criteria andMentionIdLessThanOrEqualTo(Integer value) {
            addCriterion("mention_id <=", value, "mentionId");
            return (Criteria) this;
        }

        public Criteria andMentionIdIn(List<Integer> values) {
            addCriterion("mention_id in", values, "mentionId");
            return (Criteria) this;
        }

        public Criteria andMentionIdNotIn(List<Integer> values) {
            addCriterion("mention_id not in", values, "mentionId");
            return (Criteria) this;
        }

        public Criteria andMentionIdBetween(Integer value1, Integer value2) {
            addCriterion("mention_id between", value1, value2, "mentionId");
            return (Criteria) this;
        }

        public Criteria andMentionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("mention_id not between", value1, value2, "mentionId");
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

        public Criteria andRepostcountIsNull() {
            addCriterion("repostCount is null");
            return (Criteria) this;
        }

        public Criteria andRepostcountIsNotNull() {
            addCriterion("repostCount is not null");
            return (Criteria) this;
        }

        public Criteria andRepostcountEqualTo(Integer value) {
            addCriterion("repostCount =", value, "repostcount");
            return (Criteria) this;
        }

        public Criteria andRepostcountNotEqualTo(Integer value) {
            addCriterion("repostCount <>", value, "repostcount");
            return (Criteria) this;
        }

        public Criteria andRepostcountGreaterThan(Integer value) {
            addCriterion("repostCount >", value, "repostcount");
            return (Criteria) this;
        }

        public Criteria andRepostcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("repostCount >=", value, "repostcount");
            return (Criteria) this;
        }

        public Criteria andRepostcountLessThan(Integer value) {
            addCriterion("repostCount <", value, "repostcount");
            return (Criteria) this;
        }

        public Criteria andRepostcountLessThanOrEqualTo(Integer value) {
            addCriterion("repostCount <=", value, "repostcount");
            return (Criteria) this;
        }

        public Criteria andRepostcountIn(List<Integer> values) {
            addCriterion("repostCount in", values, "repostcount");
            return (Criteria) this;
        }

        public Criteria andRepostcountNotIn(List<Integer> values) {
            addCriterion("repostCount not in", values, "repostcount");
            return (Criteria) this;
        }

        public Criteria andRepostcountBetween(Integer value1, Integer value2) {
            addCriterion("repostCount between", value1, value2, "repostcount");
            return (Criteria) this;
        }

        public Criteria andRepostcountNotBetween(Integer value1, Integer value2) {
            addCriterion("repostCount not between", value1, value2, "repostcount");
            return (Criteria) this;
        }

        public Criteria andCommentcountIsNull() {
            addCriterion("commentCount is null");
            return (Criteria) this;
        }

        public Criteria andCommentcountIsNotNull() {
            addCriterion("commentCount is not null");
            return (Criteria) this;
        }

        public Criteria andCommentcountEqualTo(Integer value) {
            addCriterion("commentCount =", value, "commentcount");
            return (Criteria) this;
        }

        public Criteria andCommentcountNotEqualTo(Integer value) {
            addCriterion("commentCount <>", value, "commentcount");
            return (Criteria) this;
        }

        public Criteria andCommentcountGreaterThan(Integer value) {
            addCriterion("commentCount >", value, "commentcount");
            return (Criteria) this;
        }

        public Criteria andCommentcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("commentCount >=", value, "commentcount");
            return (Criteria) this;
        }

        public Criteria andCommentcountLessThan(Integer value) {
            addCriterion("commentCount <", value, "commentcount");
            return (Criteria) this;
        }

        public Criteria andCommentcountLessThanOrEqualTo(Integer value) {
            addCriterion("commentCount <=", value, "commentcount");
            return (Criteria) this;
        }

        public Criteria andCommentcountIn(List<Integer> values) {
            addCriterion("commentCount in", values, "commentcount");
            return (Criteria) this;
        }

        public Criteria andCommentcountNotIn(List<Integer> values) {
            addCriterion("commentCount not in", values, "commentcount");
            return (Criteria) this;
        }

        public Criteria andCommentcountBetween(Integer value1, Integer value2) {
            addCriterion("commentCount between", value1, value2, "commentcount");
            return (Criteria) this;
        }

        public Criteria andCommentcountNotBetween(Integer value1, Integer value2) {
            addCriterion("commentCount not between", value1, value2, "commentcount");
            return (Criteria) this;
        }

        public Criteria andReplycountIsNull() {
            addCriterion("replyCount is null");
            return (Criteria) this;
        }

        public Criteria andReplycountIsNotNull() {
            addCriterion("replyCount is not null");
            return (Criteria) this;
        }

        public Criteria andReplycountEqualTo(Integer value) {
            addCriterion("replyCount =", value, "replycount");
            return (Criteria) this;
        }

        public Criteria andReplycountNotEqualTo(Integer value) {
            addCriterion("replyCount <>", value, "replycount");
            return (Criteria) this;
        }

        public Criteria andReplycountGreaterThan(Integer value) {
            addCriterion("replyCount >", value, "replycount");
            return (Criteria) this;
        }

        public Criteria andReplycountGreaterThanOrEqualTo(Integer value) {
            addCriterion("replyCount >=", value, "replycount");
            return (Criteria) this;
        }

        public Criteria andReplycountLessThan(Integer value) {
            addCriterion("replyCount <", value, "replycount");
            return (Criteria) this;
        }

        public Criteria andReplycountLessThanOrEqualTo(Integer value) {
            addCriterion("replyCount <=", value, "replycount");
            return (Criteria) this;
        }

        public Criteria andReplycountIn(List<Integer> values) {
            addCriterion("replyCount in", values, "replycount");
            return (Criteria) this;
        }

        public Criteria andReplycountNotIn(List<Integer> values) {
            addCriterion("replyCount not in", values, "replycount");
            return (Criteria) this;
        }

        public Criteria andReplycountBetween(Integer value1, Integer value2) {
            addCriterion("replyCount between", value1, value2, "replycount");
            return (Criteria) this;
        }

        public Criteria andReplycountNotBetween(Integer value1, Integer value2) {
            addCriterion("replyCount not between", value1, value2, "replycount");
            return (Criteria) this;
        }

        public Criteria andLikecountIsNull() {
            addCriterion("likeCount is null");
            return (Criteria) this;
        }

        public Criteria andLikecountIsNotNull() {
            addCriterion("likeCount is not null");
            return (Criteria) this;
        }

        public Criteria andLikecountEqualTo(Integer value) {
            addCriterion("likeCount =", value, "likecount");
            return (Criteria) this;
        }

        public Criteria andLikecountNotEqualTo(Integer value) {
            addCriterion("likeCount <>", value, "likecount");
            return (Criteria) this;
        }

        public Criteria andLikecountGreaterThan(Integer value) {
            addCriterion("likeCount >", value, "likecount");
            return (Criteria) this;
        }

        public Criteria andLikecountGreaterThanOrEqualTo(Integer value) {
            addCriterion("likeCount >=", value, "likecount");
            return (Criteria) this;
        }

        public Criteria andLikecountLessThan(Integer value) {
            addCriterion("likeCount <", value, "likecount");
            return (Criteria) this;
        }

        public Criteria andLikecountLessThanOrEqualTo(Integer value) {
            addCriterion("likeCount <=", value, "likecount");
            return (Criteria) this;
        }

        public Criteria andLikecountIn(List<Integer> values) {
            addCriterion("likeCount in", values, "likecount");
            return (Criteria) this;
        }

        public Criteria andLikecountNotIn(List<Integer> values) {
            addCriterion("likeCount not in", values, "likecount");
            return (Criteria) this;
        }

        public Criteria andLikecountBetween(Integer value1, Integer value2) {
            addCriterion("likeCount between", value1, value2, "likecount");
            return (Criteria) this;
        }

        public Criteria andLikecountNotBetween(Integer value1, Integer value2) {
            addCriterion("likeCount not between", value1, value2, "likecount");
            return (Criteria) this;
        }

        public Criteria andFanscountIsNull() {
            addCriterion("fansCount is null");
            return (Criteria) this;
        }

        public Criteria andFanscountIsNotNull() {
            addCriterion("fansCount is not null");
            return (Criteria) this;
        }

        public Criteria andFanscountEqualTo(Integer value) {
            addCriterion("fansCount =", value, "fanscount");
            return (Criteria) this;
        }

        public Criteria andFanscountNotEqualTo(Integer value) {
            addCriterion("fansCount <>", value, "fanscount");
            return (Criteria) this;
        }

        public Criteria andFanscountGreaterThan(Integer value) {
            addCriterion("fansCount >", value, "fanscount");
            return (Criteria) this;
        }

        public Criteria andFanscountGreaterThanOrEqualTo(Integer value) {
            addCriterion("fansCount >=", value, "fanscount");
            return (Criteria) this;
        }

        public Criteria andFanscountLessThan(Integer value) {
            addCriterion("fansCount <", value, "fanscount");
            return (Criteria) this;
        }

        public Criteria andFanscountLessThanOrEqualTo(Integer value) {
            addCriterion("fansCount <=", value, "fanscount");
            return (Criteria) this;
        }

        public Criteria andFanscountIn(List<Integer> values) {
            addCriterion("fansCount in", values, "fanscount");
            return (Criteria) this;
        }

        public Criteria andFanscountNotIn(List<Integer> values) {
            addCriterion("fansCount not in", values, "fanscount");
            return (Criteria) this;
        }

        public Criteria andFanscountBetween(Integer value1, Integer value2) {
            addCriterion("fansCount between", value1, value2, "fanscount");
            return (Criteria) this;
        }

        public Criteria andFanscountNotBetween(Integer value1, Integer value2) {
            addCriterion("fansCount not between", value1, value2, "fanscount");
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