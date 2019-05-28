package cn.itcast.service;

import net.sf.json.JSONArray;

public class TestService {
    public static void main(String args[]){
        String json = "[{'day1':'work','day2':26},{'day1':123,'day2':26}]";
        JSONArray jsonArray = JSONArray.fromObject(json);
        System.out.println(jsonArray.get(0));
    }
}
