package com.jq.survey.dao.entity;

import java.util.Date;

public class MenuInfoDO extends AbstractDO {
	
    /**  */
	private static final long serialVersionUID = 7993163607655999644L;

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu_info.MENU_ID
     *
     * @mbggenerated Wed Jul 20 17:14:24 CST 2016
     */
    private String menuId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu_info.MENU_NAME
     *
     * @mbggenerated Wed Jul 20 17:14:24 CST 2016
     */
    private String menuName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu_info.MENU_LEVEL
     *
     * @mbggenerated Wed Jul 20 17:14:24 CST 2016
     */
    private Integer menuLevel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu_info.MODULE_ICON
     *
     * @mbggenerated Wed Jul 20 17:14:24 CST 2016
     */
    private String moduleIcon;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu_info.PARENT_ID
     *
     * @mbggenerated Wed Jul 20 17:14:24 CST 2016
     */
    private String parentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu_info.HAVE_SON
     *
     * @mbggenerated Wed Jul 20 17:14:24 CST 2016
     */
    private String haveSon;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu_info.SERIAL
     *
     * @mbggenerated Wed Jul 20 17:14:24 CST 2016
     */
    private Integer serial;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu_info.STAT
     *
     * @mbggenerated Wed Jul 20 17:14:24 CST 2016
     */
    private String stat;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu_info.CREATE_TIME
     *
     * @mbggenerated Wed Jul 20 17:14:24 CST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu_info.UPDATE_TIME
     *
     * @mbggenerated Wed Jul 20 17:14:24 CST 2016
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu_info.MENU_ID
     *
     * @return the value of menu_info.MENU_ID
     *
     * @mbggenerated Wed Jul 20 17:14:24 CST 2016
     */
    public String getMenuId() {
        return menuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu_info.MENU_ID
     *
     * @param menuId the value for menu_info.MENU_ID
     *
     * @mbggenerated Wed Jul 20 17:14:24 CST 2016
     */
    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu_info.MENU_NAME
     *
     * @return the value of menu_info.MENU_NAME
     *
     * @mbggenerated Wed Jul 20 17:14:24 CST 2016
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu_info.MENU_NAME
     *
     * @param menuName the value for menu_info.MENU_NAME
     *
     * @mbggenerated Wed Jul 20 17:14:24 CST 2016
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu_info.MENU_LEVEL
     *
     * @return the value of menu_info.MENU_LEVEL
     *
     * @mbggenerated Wed Jul 20 17:14:24 CST 2016
     */
    public Integer getMenuLevel() {
        return menuLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu_info.MENU_LEVEL
     *
     * @param menuLevel the value for menu_info.MENU_LEVEL
     *
     * @mbggenerated Wed Jul 20 17:14:24 CST 2016
     */
    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu_info.MODULE_ICON
     *
     * @return the value of menu_info.MODULE_ICON
     *
     * @mbggenerated Wed Jul 20 17:14:24 CST 2016
     */
    public String getModuleIcon() {
        return moduleIcon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu_info.MODULE_ICON
     *
     * @param moduleIcon the value for menu_info.MODULE_ICON
     *
     * @mbggenerated Wed Jul 20 17:14:24 CST 2016
     */
    public void setModuleIcon(String moduleIcon) {
        this.moduleIcon = moduleIcon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu_info.PARENT_ID
     *
     * @return the value of menu_info.PARENT_ID
     *
     * @mbggenerated Wed Jul 20 17:14:24 CST 2016
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu_info.PARENT_ID
     *
     * @param parentId the value for menu_info.PARENT_ID
     *
     * @mbggenerated Wed Jul 20 17:14:24 CST 2016
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu_info.HAVE_SON
     *
     * @return the value of menu_info.HAVE_SON
     *
     * @mbggenerated Wed Jul 20 17:14:24 CST 2016
     */
    public String getHaveSon() {
        return haveSon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu_info.HAVE_SON
     *
     * @param haveSon the value for menu_info.HAVE_SON
     *
     * @mbggenerated Wed Jul 20 17:14:24 CST 2016
     */
    public void setHaveSon(String haveSon) {
        this.haveSon = haveSon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu_info.SERIAL
     *
     * @return the value of menu_info.SERIAL
     *
     * @mbggenerated Wed Jul 20 17:14:24 CST 2016
     */
    public Integer getSerial() {
        return serial;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu_info.SERIAL
     *
     * @param serial the value for menu_info.SERIAL
     *
     * @mbggenerated Wed Jul 20 17:14:24 CST 2016
     */
    public void setSerial(Integer serial) {
        this.serial = serial;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu_info.STAT
     *
     * @return the value of menu_info.STAT
     *
     * @mbggenerated Wed Jul 20 17:14:24 CST 2016
     */
    public String getStat() {
        return stat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu_info.STAT
     *
     * @param stat the value for menu_info.STAT
     *
     * @mbggenerated Wed Jul 20 17:14:24 CST 2016
     */
    public void setStat(String stat) {
        this.stat = stat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu_info.CREATE_TIME
     *
     * @return the value of menu_info.CREATE_TIME
     *
     * @mbggenerated Wed Jul 20 17:14:24 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu_info.CREATE_TIME
     *
     * @param createTime the value for menu_info.CREATE_TIME
     *
     * @mbggenerated Wed Jul 20 17:14:24 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu_info.UPDATE_TIME
     *
     * @return the value of menu_info.UPDATE_TIME
     *
     * @mbggenerated Wed Jul 20 17:14:24 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu_info.UPDATE_TIME
     *
     * @param updateTime the value for menu_info.UPDATE_TIME
     *
     * @mbggenerated Wed Jul 20 17:14:24 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}