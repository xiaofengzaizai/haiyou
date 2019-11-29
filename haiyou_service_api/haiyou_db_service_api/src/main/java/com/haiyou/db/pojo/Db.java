package com.haiyou.db.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:Db构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "Db",value = "Db")
@Table(name="db")
public class Db implements Serializable {

	@ApiModelProperty(value = "",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "company_name")
	private String companyName;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "sample_name")
	private String sampleName;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "value")
	private String value;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "remark")
	private String remark;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "add_time")
	private String addTime;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "update_time")
	private String updateTime;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "unit")
	private String unit;//



	//get方法
	public Integer getId() {
		return id;
	}

	//set方法
	public void setId(Integer id) {
		this.id = id;
	}
	//get方法
	public String getCompanyName() {
		return companyName;
	}

	//set方法
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	//get方法
	public String getSampleName() {
		return sampleName;
	}

	//set方法
	public void setSampleName(String sampleName) {
		this.sampleName = sampleName;
	}
	//get方法
	public String getValue() {
		return value;
	}

	//set方法
	public void setValue(String value) {
		this.value = value;
	}
	//get方法
	public String getRemark() {
		return remark;
	}

	//set方法
	public void setRemark(String remark) {
		this.remark = remark;
	}
	//get方法
	public String getAddTime() {
		return addTime;
	}

	//set方法
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	//get方法
	public String getUpdateTime() {
		return updateTime;
	}

	//set方法
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	//get方法
	public String getUnit() {
		return unit;
	}

	//set方法
	public void setUnit(String unit) {
		this.unit = unit;
	}


}
