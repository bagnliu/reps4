package com.bagnliu.model;

/**
 * @author bagnliu
 * @create 2019-06-05 22:51
 */
public class League {


    public String project;
    public String name;
    public String college;
    public String achievement;
    public String ranking;

    public String getProject() {
        return project;
    }
    public void setProject(String project) {
        this.project = project;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCollege() {
        return college;
    }
    public void setCollege(String college) {
        this.college = college;
    }
    public String getAchievement() {
        return achievement;
    }
    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }
    public String getRanking() {
        return ranking;
    }
    public void setRanking(String ranking) {
        this.ranking = ranking;
    }
    @Override
    public String toString() {
        return "League [project=" + project + ", name=" + name + ", college=" + college + ", achievement=" + achievement
                + ", ranking=" + ranking + "]";
    }
    public League(String project, String name, String college, String achievement, String ranking) {
        super();
        this.project = project;
        this.name = name;
        this.college = college;
        this.achievement = achievement;
        this.ranking = ranking;
    }
    public League() {
        super();
        // TODO Auto-generated constructor stub
    }
}
