package com.bagnliu.model;

/**
 * @author bagnliu
 * @create 2019-06-05 22:50
 */
public class User {

    // 属性
    private String userid;
    private String username;
    private String userpassword;
    private String school;
    public String getUserid() {
        return userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUserpassword() {
        return userpassword;
    }
    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }
    public String getSchool() {
        return school;
    }
    public void setSchool(String school) {
        this.school = school;
    }
    @Override
    public String toString() {
        return "User [userid=" + userid + ", username=" + username + ", userpassword=" + userpassword + ", school="
                + school + "]";
    }
    public User(String userid, String username, String userpassword, String school) {
        super();
        this.userid = userid;
        this.username = username;
        this.userpassword = userpassword;
        this.school = school;
    }
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }
}
