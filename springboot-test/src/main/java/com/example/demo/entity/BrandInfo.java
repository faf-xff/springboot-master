package com.example.demo.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;

/**
 * 路径：com.example.demo.entity
 * 类名：
 * 功能：使用easypoi导出excel
 * 备注：
 * 创建人：typ
 * 创建时间：2019/5/19 20:54
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
public class BrandInfo implements Serializable{

    @Excel(name = "brandGuid", width = 25,orderNum = "0")
    private String brandGuid;

    @Excel(name = "brandName", width = 25,orderNum = "0")
    private String brandName;

    @Excel(name = "ytFullcode", width = 25,orderNum = "0")
    private String ytFullcode;

    @Excel(name = "formatGuid", width = 25,orderNum = "0")
    private String formatGuid;

    @Excel(name = "flag", width = 25,orderNum = "0")
    private String flag;

    @Excel(name = "customerid", width = 25,orderNum = "0")
    private String customerid;

    @Excel(name = "createDatetime",width = 20,exportFormat = "yyyy-MM-dd HH:mm:ss", orderNum = "1")
    private String createDatetime;

    @Excel(name = "updateDatetime",width = 20,exportFormat = "yyyy-MM-dd HH:mm:ss", orderNum = "1")
    private String updateDatetime;

    @Excel(name = "source", width = 25,orderNum = "0")
    private Integer source;

    public String getBrandGuid() {
        return brandGuid;
    }

    public void setBrandGuid(String brandGuid) {
        this.brandGuid = brandGuid;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getYtFullcode() {
        return ytFullcode;
    }

    public void setYtFullcode(String ytFullcode) {
        this.ytFullcode = ytFullcode;
    }

    public String getFormatGuid() {
        return formatGuid;
    }

    public void setFormatGuid(String formatGuid) {
        this.formatGuid = formatGuid;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(String createDatetime) {
        this.createDatetime = createDatetime;
    }

    public String getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(String updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }
}
