
package zhiyiting2.model;

import java.util.Date;

public class MarketingPlan {
	private Integer id;
    private Integer operatorId;//运营商id
    private String type;//营销类型
    private String name;//活动名称
    private String groupCode;//活动分组编码
    private String description;//描述
    private String briefIntroduction;//app描述
    private String userOrderType;//业务类型
    private String conditionAmount;//条件金额
    private String couponType;//优惠券类型
    private String count;//数量
    private String validDays;//有效期天数
    private String moneyAmount;//优惠券金额
    private Date validEnd;//到期时间
    private Date validStart;//开始时间
    private String cashMinAmount;//优惠券最低消费金额
    private String discountMaxAmount;
    private String allowancaAmount;
    
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOperatorId() {
        return operatorId;
    }
    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGroupCode() {
        return groupCode;
    }
    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getBriefIntroduction() {
        return briefIntroduction;
    }
    public void setBriefIntroduction(String briefIntroduction) {
        this.briefIntroduction = briefIntroduction;
    }
    public String getUserOrderType() {
        return userOrderType;
    }
    public void setUserOrderType(String userOrderType) {
        this.userOrderType = userOrderType;
    }
    public String getConditionAmount() {
        return conditionAmount;
    }
    public void setConditionAmount(String conditionAmount) {
        this.conditionAmount = conditionAmount;
    }
    public String getCouponType() {
        return couponType;
    }
    public void setCouponType(String couponType) {
        this.couponType = couponType;
    }
    public String getCount() {
        return count;
    }
    public void setCount(String count) {
        this.count = count;
    }
    public String getValidDays() {
        return validDays;
    }
    public void setValidDays(String validDays) {
        this.validDays = validDays;
    }
    public String getMoneyAmount() {
        return moneyAmount;
    }
    public void setMoneyAmount(String moneyAmount) {
        this.moneyAmount = moneyAmount;
    }
    public Date getValidEnd() {
        return validEnd;
    }
    public void setValidEnd(Date validEnd) {
        this.validEnd = validEnd;
    }
    public Date getValidStart() {
        return validStart;
    }
    public void setValidStart(Date validStart) {
        this.validStart = validStart;
    }
    public String getCashMinAmount() {
        return cashMinAmount;
    }
    public void setCashMinAmount(String cashMinAmount) {
        this.cashMinAmount = cashMinAmount;
    }
    public String getDiscountMaxAmount() {
        return discountMaxAmount;
    }
    public void setDiscountMaxAmount(String discountMaxAmount) {
        this.discountMaxAmount = discountMaxAmount;
    }
    public String getAllowancaAmount() {
        return allowancaAmount;
    }
    public void setAllowancaAmount(String allowancaAmount) {
        this.allowancaAmount = allowancaAmount;
    }


}
