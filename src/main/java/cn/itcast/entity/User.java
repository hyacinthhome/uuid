package cn.itcast.entity;

import com.google.gson.annotations.Expose;

import java.util.HashSet;
import java.util.Set;

public class User {
    @Expose(serialize = true, deserialize = true)
    private String user_id;
    @Expose(serialize = true, deserialize = true)
    private String user_username;
    @Expose(serialize = true, deserialize = true)
    private String user_password;
    @Expose(serialize = true, deserialize = true)
    private String user_stunum;
    @Expose(serialize = true, deserialize = true)
    private String user_phonenumber;
    @Expose(serialize = true, deserialize = true)
    private String user_email;
    @Expose(serialize = true, deserialize = true)
    private String user_school;
    @Expose(serialize = true, deserialize = true)
    private String user_gender;
    @Expose(serialize = true, deserialize = true)
    private String user_academy;
    @Expose(serialize = false, deserialize = true)
    private Set<Bottle> user_bottles=new HashSet<Bottle>();

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Set<Bottle> getUser_bottles() {
        return user_bottles;
    }

    public void setUser_bottles(Set<Bottle> user_bottles) {
        this.user_bottles = user_bottles;
    }

    public String getUser_username() {
        return user_username;
    }

    public void setUser_username(String user_username) {
        this.user_username = user_username;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_stunum() {
        return user_stunum;
    }

    public void setUser_stunum(String user_stunum) {
        this.user_stunum = user_stunum;
    }

    public String getUser_phonenumber() {
        return user_phonenumber;
    }

    public void setUser_phonenumber(String user_phonenumber) {
        this.user_phonenumber = user_phonenumber;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_school() {
        return user_school;
    }

    public void setUser_school(String user_school) {
        this.user_school = user_school;
    }

    public String getUser_gender() {
        return user_gender;
    }

    public void setUser_gender(String user_gender) {
        this.user_gender = user_gender;
    }

    public String getUser_academy() {
        return user_academy;
    }

    public void setUser_academy(String user_academy) {
        this.user_academy = user_academy;
    }
}