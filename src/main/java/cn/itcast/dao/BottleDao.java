package cn.itcast.dao;

import cn.itcast.entity.Bottle;

import java.util.List;

public interface BottleDao {
    public List<Bottle> findCon(String con,String value);
    public Bottle gtone_ex(String user_username);
}
