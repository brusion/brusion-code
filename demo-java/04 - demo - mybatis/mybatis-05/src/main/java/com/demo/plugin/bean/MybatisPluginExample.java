package com.demo.plugin.bean;

import java.util.ArrayList;
import java.util.List;

public class MybatisPluginExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MybatisPluginExample() {
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

        public Criteria andPluginIdIsNull() {
            addCriterion("plugin_id is null");
            return (Criteria) this;
        }

        public Criteria andPluginIdIsNotNull() {
            addCriterion("plugin_id is not null");
            return (Criteria) this;
        }

        public Criteria andPluginIdEqualTo(Integer value) {
            addCriterion("plugin_id =", value, "pluginId");
            return (Criteria) this;
        }

        public Criteria andPluginIdNotEqualTo(Integer value) {
            addCriterion("plugin_id <>", value, "pluginId");
            return (Criteria) this;
        }

        public Criteria andPluginIdGreaterThan(Integer value) {
            addCriterion("plugin_id >", value, "pluginId");
            return (Criteria) this;
        }

        public Criteria andPluginIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("plugin_id >=", value, "pluginId");
            return (Criteria) this;
        }

        public Criteria andPluginIdLessThan(Integer value) {
            addCriterion("plugin_id <", value, "pluginId");
            return (Criteria) this;
        }

        public Criteria andPluginIdLessThanOrEqualTo(Integer value) {
            addCriterion("plugin_id <=", value, "pluginId");
            return (Criteria) this;
        }

        public Criteria andPluginIdIn(List<Integer> values) {
            addCriterion("plugin_id in", values, "pluginId");
            return (Criteria) this;
        }

        public Criteria andPluginIdNotIn(List<Integer> values) {
            addCriterion("plugin_id not in", values, "pluginId");
            return (Criteria) this;
        }

        public Criteria andPluginIdBetween(Integer value1, Integer value2) {
            addCriterion("plugin_id between", value1, value2, "pluginId");
            return (Criteria) this;
        }

        public Criteria andPluginIdNotBetween(Integer value1, Integer value2) {
            addCriterion("plugin_id not between", value1, value2, "pluginId");
            return (Criteria) this;
        }

        public Criteria andPluginNameIsNull() {
            addCriterion("plugin_name is null");
            return (Criteria) this;
        }

        public Criteria andPluginNameIsNotNull() {
            addCriterion("plugin_name is not null");
            return (Criteria) this;
        }

        public Criteria andPluginNameEqualTo(String value) {
            addCriterion("plugin_name =", value, "pluginName");
            return (Criteria) this;
        }

        public Criteria andPluginNameNotEqualTo(String value) {
            addCriterion("plugin_name <>", value, "pluginName");
            return (Criteria) this;
        }

        public Criteria andPluginNameGreaterThan(String value) {
            addCriterion("plugin_name >", value, "pluginName");
            return (Criteria) this;
        }

        public Criteria andPluginNameGreaterThanOrEqualTo(String value) {
            addCriterion("plugin_name >=", value, "pluginName");
            return (Criteria) this;
        }

        public Criteria andPluginNameLessThan(String value) {
            addCriterion("plugin_name <", value, "pluginName");
            return (Criteria) this;
        }

        public Criteria andPluginNameLessThanOrEqualTo(String value) {
            addCriterion("plugin_name <=", value, "pluginName");
            return (Criteria) this;
        }

        public Criteria andPluginNameLike(String value) {
            addCriterion("plugin_name like", value, "pluginName");
            return (Criteria) this;
        }

        public Criteria andPluginNameNotLike(String value) {
            addCriterion("plugin_name not like", value, "pluginName");
            return (Criteria) this;
        }

        public Criteria andPluginNameIn(List<String> values) {
            addCriterion("plugin_name in", values, "pluginName");
            return (Criteria) this;
        }

        public Criteria andPluginNameNotIn(List<String> values) {
            addCriterion("plugin_name not in", values, "pluginName");
            return (Criteria) this;
        }

        public Criteria andPluginNameBetween(String value1, String value2) {
            addCriterion("plugin_name between", value1, value2, "pluginName");
            return (Criteria) this;
        }

        public Criteria andPluginNameNotBetween(String value1, String value2) {
            addCriterion("plugin_name not between", value1, value2, "pluginName");
            return (Criteria) this;
        }

        public Criteria andPluginAddressIsNull() {
            addCriterion("plugin_address is null");
            return (Criteria) this;
        }

        public Criteria andPluginAddressIsNotNull() {
            addCriterion("plugin_address is not null");
            return (Criteria) this;
        }

        public Criteria andPluginAddressEqualTo(String value) {
            addCriterion("plugin_address =", value, "pluginAddress");
            return (Criteria) this;
        }

        public Criteria andPluginAddressNotEqualTo(String value) {
            addCriterion("plugin_address <>", value, "pluginAddress");
            return (Criteria) this;
        }

        public Criteria andPluginAddressGreaterThan(String value) {
            addCriterion("plugin_address >", value, "pluginAddress");
            return (Criteria) this;
        }

        public Criteria andPluginAddressGreaterThanOrEqualTo(String value) {
            addCriterion("plugin_address >=", value, "pluginAddress");
            return (Criteria) this;
        }

        public Criteria andPluginAddressLessThan(String value) {
            addCriterion("plugin_address <", value, "pluginAddress");
            return (Criteria) this;
        }

        public Criteria andPluginAddressLessThanOrEqualTo(String value) {
            addCriterion("plugin_address <=", value, "pluginAddress");
            return (Criteria) this;
        }

        public Criteria andPluginAddressLike(String value) {
            addCriterion("plugin_address like", value, "pluginAddress");
            return (Criteria) this;
        }

        public Criteria andPluginAddressNotLike(String value) {
            addCriterion("plugin_address not like", value, "pluginAddress");
            return (Criteria) this;
        }

        public Criteria andPluginAddressIn(List<String> values) {
            addCriterion("plugin_address in", values, "pluginAddress");
            return (Criteria) this;
        }

        public Criteria andPluginAddressNotIn(List<String> values) {
            addCriterion("plugin_address not in", values, "pluginAddress");
            return (Criteria) this;
        }

        public Criteria andPluginAddressBetween(String value1, String value2) {
            addCriterion("plugin_address between", value1, value2, "pluginAddress");
            return (Criteria) this;
        }

        public Criteria andPluginAddressNotBetween(String value1, String value2) {
            addCriterion("plugin_address not between", value1, value2, "pluginAddress");
            return (Criteria) this;
        }

        public Criteria andPluginTitleIsNull() {
            addCriterion("plugin_title is null");
            return (Criteria) this;
        }

        public Criteria andPluginTitleIsNotNull() {
            addCriterion("plugin_title is not null");
            return (Criteria) this;
        }

        public Criteria andPluginTitleEqualTo(String value) {
            addCriterion("plugin_title =", value, "pluginTitle");
            return (Criteria) this;
        }

        public Criteria andPluginTitleNotEqualTo(String value) {
            addCriterion("plugin_title <>", value, "pluginTitle");
            return (Criteria) this;
        }

        public Criteria andPluginTitleGreaterThan(String value) {
            addCriterion("plugin_title >", value, "pluginTitle");
            return (Criteria) this;
        }

        public Criteria andPluginTitleGreaterThanOrEqualTo(String value) {
            addCriterion("plugin_title >=", value, "pluginTitle");
            return (Criteria) this;
        }

        public Criteria andPluginTitleLessThan(String value) {
            addCriterion("plugin_title <", value, "pluginTitle");
            return (Criteria) this;
        }

        public Criteria andPluginTitleLessThanOrEqualTo(String value) {
            addCriterion("plugin_title <=", value, "pluginTitle");
            return (Criteria) this;
        }

        public Criteria andPluginTitleLike(String value) {
            addCriterion("plugin_title like", value, "pluginTitle");
            return (Criteria) this;
        }

        public Criteria andPluginTitleNotLike(String value) {
            addCriterion("plugin_title not like", value, "pluginTitle");
            return (Criteria) this;
        }

        public Criteria andPluginTitleIn(List<String> values) {
            addCriterion("plugin_title in", values, "pluginTitle");
            return (Criteria) this;
        }

        public Criteria andPluginTitleNotIn(List<String> values) {
            addCriterion("plugin_title not in", values, "pluginTitle");
            return (Criteria) this;
        }

        public Criteria andPluginTitleBetween(String value1, String value2) {
            addCriterion("plugin_title between", value1, value2, "pluginTitle");
            return (Criteria) this;
        }

        public Criteria andPluginTitleNotBetween(String value1, String value2) {
            addCriterion("plugin_title not between", value1, value2, "pluginTitle");
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