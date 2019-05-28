package cn.itcast.service;

import cn.itcast.dao.BottleDao;
import cn.itcast.dao.UserDao;
import cn.itcast.entity.Bottle;
import cn.itcast.entity.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
public class BottleService {
    BottleDao bottleDao;
    UserDao userDao;
    public void setBottleDao(BottleDao bottleDao) {
        this.bottleDao = bottleDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<String> add(Bottle bottle, String user_username){
        List<String> myjson=new ArrayList<String>();
        JsonObject jsonObject = new JsonObject();
        try {
            List<User> list = userDao.findCon("user_username", user_username);
            if (list.size() == 0) {
                jsonObject.addProperty("status", "NotExist");
            } else {
                User user = list.get(0);
                user.getUser_bottles().add(bottle);
                userDao.save(user);
                jsonObject.addProperty("status", "Success");
            }
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.addProperty("status","Error");
        }
        myjson.add(jsonObject.toString());
        return myjson;
    }

    public List<String> gtone(String user_username){
        List<String> myjson=new ArrayList<String>();
        JsonObject jsonObject=new JsonObject();
        try{
            List<User> list=userDao.findCon("user_username",user_username);
            if(list.size()==0){
                jsonObject.addProperty("status","NotExist");
            }else{
                    Bottle bottle = bottleDao.gtone_ex(user_username);
                    if(bottle==null) {
                        jsonObject.addProperty("status","NoOtherBottle");
                    }else {
                        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
                        jsonObject.addProperty("status", "Success");
                        jsonObject.addProperty("mydata",gson.toJson(bottle));
                    }
                }
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.addProperty("status","Error");
        }
        myjson.add(jsonObject.toString());
        return myjson;
    }

    public List<Bottle> findCon(String con,String value){
        return bottleDao.findCon(con,value);
    }
}
