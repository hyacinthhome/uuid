package cn.itcast.dao;

import cn.itcast.entity.User;

import java.util.List;

public interface UserDao {
    public List<User> findCon(String con, String value);
    public User save(User user);
}
