package com.nursery.mybatis.entity;

public class GdshopDO {

    private String shopid;
    private String gdshopmark;
    private java.sql.Timestamp updatetime;

    public String getShopid() {
        return shopid;
    }

    public void setShopid(String shopid) {
        this.shopid = shopid;
    }

    public String getGdshopmark() {
        return gdshopmark;
    }

    public void setGdshopmark(String gdshopmark) {
        this.gdshopmark = gdshopmark;
    }

    public java.sql.Timestamp getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(java.sql.Timestamp updatetime) {
        this.updatetime = updatetime;
    }

}
