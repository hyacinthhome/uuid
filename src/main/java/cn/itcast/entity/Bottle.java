package cn.itcast.entity;

import com.google.gson.annotations.Expose;

import java.util.Calendar;

public class Bottle {
    @Expose(serialize = true, deserialize = true)
    private String bottle_id;
    @Expose(serialize = true, deserialize = true)
    private String bottle_value;
    @Expose(serialize = true, deserialize = true)
    private int bottle_year;
    @Expose(serialize = true, deserialize = true)
    private int bottle_month;
    @Expose(serialize = true, deserialize = true)
    private int bottle_day;
    @Expose(serialize = true, deserialize = true)
    private int bottle_hour;
    @Expose(serialize = true, deserialize = true)
    private int bottle_min;
    @Expose(serialize = true, deserialize = true)
    private int bottle_sec;
    @Expose(serialize = true, deserialize = true)
    private int bottle_usedtime;
    @Expose(serialize = false, deserialize = true)
    private User bottle_user;

    public String getBottle_id() {
        return bottle_id;
    }

    public void setBottle_id(String bottle_id) {
        this.bottle_id = bottle_id;
    }

    public String getBottle_value() {
        return bottle_value;
    }

    public void setBottle_value(String bottle_value) {
        this.bottle_value = bottle_value;
    }

    public int getBottle_year() {
        return bottle_year;
    }

    public void setBottle_year(int bottle_year) {
        this.bottle_year = bottle_year;
    }

    public int getBottle_month() {
        return bottle_month;
    }

    public void setBottle_month(int bottle_month) {
        this.bottle_month = bottle_month;
    }

    public int getBottle_day() {
        return bottle_day;
    }

    public void setBottle_day(int bottle_day) {
        this.bottle_day = bottle_day;
    }

    public int getBottle_hour() {
        return bottle_hour;
    }

    public void setBottle_hour(int bottle_hour) {
        this.bottle_hour = bottle_hour;
    }

    public int getBottle_min() {
        return bottle_min;
    }

    public void setBottle_min(int bottle_min) {
        this.bottle_min = bottle_min;
    }

    public int getBottle_sec() {
        return bottle_sec;
    }

    public void setBottle_sec(int bottle_sec) {
        this.bottle_sec = bottle_sec;
    }

    public int getBottle_usedtime() {
        return bottle_usedtime;
    }

    public void setBottle_usedtime(int bottle_usedtime) {
        this.bottle_usedtime = bottle_usedtime;
    }

    public User getBottle_user() {
        return bottle_user;
    }

    public void setBottle_user(User bottle_user) {
        this.bottle_user = bottle_user;
    }
}
