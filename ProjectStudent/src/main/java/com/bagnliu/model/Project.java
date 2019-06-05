package com.bagnliu.model;

/**
 * @author bagnliu
 * @create 2019-06-05 22:51
 */
public class Project {


    public String boy_100m;
    public String boy_800m;
    public String boy_5000m;
    public String boy_relay;
    public String boy_height;
    public String boy_long;
    public String girl_100m;
    public String girl_400m;
    public String girl_2000m;
    public String girl_relay;
    public String girl_height;
    public String girl_long;
    public String volunteer_court;
    public String volunteer_waiting;
    public String volunteer_logistics;
    public String number_id;

    public String getNumber_id() {
        return number_id;
    }
    public void setNumber_id(String number_id) {
        this.number_id = number_id;
    }
    public String getBoy_100m() {
        return boy_100m;
    }
    public void setBoy_100m(String boy_100m) {
        this.boy_100m = boy_100m;
    }
    public String getBoy_800m() {
        return boy_800m;
    }
    public void setBoy_800m(String boy_800m) {
        this.boy_800m = boy_800m;
    }
    public String getBoy_5000m() {
        return boy_5000m;
    }
    public void setBoy_5000m(String boy_5000m) {
        this.boy_5000m = boy_5000m;
    }
    public String getBoy_relay() {
        return boy_relay;
    }
    public void setBoy_relay(String boy_relay) {
        this.boy_relay = boy_relay;
    }
    public String getBoy_height() {
        return boy_height;
    }
    public void setBoy_height(String boy_height) {
        this.boy_height = boy_height;
    }
    public String getBoy_long() {
        return boy_long;
    }
    public void setBoy_long(String boy_long) {
        this.boy_long = boy_long;
    }
    public String getGirl_100m() {
        return girl_100m;
    }
    public void setGirl_100m(String girl_100m) {
        this.girl_100m = girl_100m;
    }
    public String getGirl_400m() {
        return girl_400m;
    }
    public void setGirl_400m(String girl_400m) {
        this.girl_400m = girl_400m;
    }
    public String getGirl_2000m() {
        return girl_2000m;
    }
    public void setGirl_2000m(String girl_2000m) {
        this.girl_2000m = girl_2000m;
    }
    public String getGirl_relay() {
        return girl_relay;
    }
    public void setGirl_relay(String girl_relay) {
        this.girl_relay = girl_relay;
    }
    public String getGirl_height() {
        return girl_height;
    }
    public void setGirl_height(String girl_height) {
        this.girl_height = girl_height;
    }
    public String getGirl_long() {
        return girl_long;
    }
    public void setGirl_long(String girl_long) {
        this.girl_long = girl_long;
    }
    public String getVolunteer_court() {
        return volunteer_court;
    }
    public void setVolunteer_court(String volunteer_court) {
        this.volunteer_court = volunteer_court;
    }
    public String getVolunteer_waiting() {
        return volunteer_waiting;
    }
    public void setVolunteer_waiting(String volunteer_waiting) {
        this.volunteer_waiting = volunteer_waiting;
    }
    public String getVolunteer_logistics() {
        return volunteer_logistics;
    }
    public void setVolunteer_logistics(String volunteer_logistics) {
        this.volunteer_logistics = volunteer_logistics;
    }

    public Project(String boy_100m, String boy_800m, String boy_5000m, String boy_relay, String boy_height,
                   String boy_long, String girl_100m, String girl_400m, String girl_2000m, String girl_relay,
                   String girl_height, String girl_long, String volunteer_court, String volunteer_waiting,
                   String volunteer_logistics, String number_id) {
        super();
        this.boy_100m = boy_100m;
        this.boy_800m = boy_800m;
        this.boy_5000m = boy_5000m;
        this.boy_relay = boy_relay;
        this.boy_height = boy_height;
        this.boy_long = boy_long;
        this.girl_100m = girl_100m;
        this.girl_400m = girl_400m;
        this.girl_2000m = girl_2000m;
        this.girl_relay = girl_relay;
        this.girl_height = girl_height;
        this.girl_long = girl_long;
        this.volunteer_court = volunteer_court;
        this.volunteer_waiting = volunteer_waiting;
        this.volunteer_logistics = volunteer_logistics;
        this.number_id = number_id;
    }
    @Override
    public String toString() {
        return "Project [boy_100m=" + boy_100m + ", boy_800m=" + boy_800m + ", boy_5000m=" + boy_5000m + ", boy_relay="
                + boy_relay + ", boy_height=" + boy_height + ", boy_long=" + boy_long + ", girl_100m=" + girl_100m
                + ", girl_400m=" + girl_400m + ", girl_2000m=" + girl_2000m + ", girl_relay=" + girl_relay
                + ", girl_height=" + girl_height + ", girl_long=" + girl_long + ", volunteer_court=" + volunteer_court
                + ", volunteer_waiting=" + volunteer_waiting + ", volunteer_logistics=" + volunteer_logistics
                + ", number_id=" + number_id + "]";
    }
    public Project() {
        super();
        // TODO Auto-generated constructor stub
    }
}
