package com.bagnliu.model;

/**
 * @author bagnliu
 * @create 2019-06-05 22:25
 */
public class Admin {
    private String username;
    private String userpassword;
    private String idcard;

    public String getUsername() {
        return username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String toString() {
        return "Admin{" +
                "username='" + username + '\'' +
                ", userpassword='" + userpassword + '\'' +
                ", idcard='" + idcard + '\'' +
                '}';
    }

    public Admin(String username, String userpassword, String idcard) {
        this.username = username;
        this.userpassword = userpassword;
        this.idcard = idcard;
    }

    public Admin() {
        super();
    }
}
