package com.jq.survey.dao.entity;

public class RoleMenuKey extends AbstractDO {
	
    /**  */
	private static final long serialVersionUID = -8074268710847708835L;

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_menu.MENU_ID
     *
     * @mbggenerated Mon Jul 11 16:22:21 CST 2016
     */
    private String menuId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_menu.ROLE_ID
     *
     * @mbggenerated Mon Jul 11 16:22:21 CST 2016
     */
    private String roleId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_menu.MENU_ID
     *
     * @return the value of role_menu.MENU_ID
     *
     * @mbggenerated Mon Jul 11 16:22:21 CST 2016
     */
    public String getMenuId() {
        return menuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_menu.MENU_ID
     *
     * @param menuId the value for role_menu.MENU_ID
     *
     * @mbggenerated Mon Jul 11 16:22:21 CST 2016
     */
    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_menu.ROLE_ID
     *
     * @return the value of role_menu.ROLE_ID
     *
     * @mbggenerated Mon Jul 11 16:22:21 CST 2016
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_menu.ROLE_ID
     *
     * @param roleId the value for role_menu.ROLE_ID
     *
     * @mbggenerated Mon Jul 11 16:22:21 CST 2016
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}