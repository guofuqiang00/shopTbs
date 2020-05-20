package com.tbs.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * PK活动配置表
 *
 * @author Auto
 * @email Auto
 * @date 2020-05-01 10:53:10
 */
@Data
public class HonourConfig implements Serializable {
	private static final long serialVersionUID = 1L;


	@ApiModelProperty("ID ")
	private Long id;

	@ApiModelProperty("商品id")
	private Long goodsId;

	@ApiModelProperty("商品活动id")
	private Long goodsObjectId;

	@ApiModelProperty("货源类别(1现货，2.预售，3拼团 4秒杀,5,活动,6拿样 7礼包,8兑换商品,9充值)")
	private Integer goodsType;

	@ApiModelProperty("商品名称")
	private String goodsName;

	@ApiModelProperty("前端显示名称")
	private String goodsActivityName;

	@ApiModelProperty("开始时间")
	private Date startTime;

	@ApiModelProperty("结束时间")
	private Date endTime;

	@ApiModelProperty("首页活动图")
	private String homeActivityImageUrl;

	@ApiModelProperty("启用状态(1启用，0未启用)")
	private Integer status;

	@ApiModelProperty("创建时间")
	private Date createTime;

	@ApiModelProperty("更新时间")
	private Date updatedTime;

	@ApiModelProperty("更新人")
	private String updateBy;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getGoodsObjectId() {
		return goodsObjectId;
	}

	public void setGoodsObjectId(Long goodsObjectId) {
		this.goodsObjectId = goodsObjectId;
	}

	public Integer getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(Integer goodsType) {
		this.goodsType = goodsType;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsActivityName() {
		return goodsActivityName;
	}

	public void setGoodsActivityName(String goodsActivityName) {
		this.goodsActivityName = goodsActivityName;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getHomeActivityImageUrl() {
		return homeActivityImageUrl;
	}

	public void setHomeActivityImageUrl(String homeActivityImageUrl) {
		this.homeActivityImageUrl = homeActivityImageUrl;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
}
