package cn.itcast.service;

import cn.itcast.dao.UserDao;
import cn.itcast.entity.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
public class UserService {
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> findCon(String con,String value){
        return userDao.findCon(con,value);
    }
    public List<String> login(String user_username,String user_password){
        List<String> myjson=new ArrayList<String>();
        JsonObject jsonObject = new JsonObject();
        try {
            List<User> list = findCon("user_username", user_username);

            if (list.size() == 0) {
                jsonObject.addProperty("status", "NotExist");
            } else {
                if(list.get(0).getUser_password().equals(user_password)){
                    jsonObject.addProperty("status","Success");
                    Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
                    System.out.println("info of user:"+gson.toJson(list.get(0)));
                    jsonObject.addProperty("mydata",gson.toJson(list.get(0)));
                }else{
                    //密码错误
                    jsonObject.addProperty("status","Fail");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            //异常
            jsonObject.addProperty("status","Error");
        }
        myjson.add(jsonObject.toString());
        return myjson;
    }

    public List<String> register(User user){
        List<String> myjson=new ArrayList<String>();
        JsonObject jsonObject=new JsonObject();
        try {
            List<User> list = findCon("user_username", user.getUser_username());
            if(list.size()!=0){
                jsonObject.addProperty("status","Exist");
            }else{
                user=userDao.save(user);

                jsonObject.addProperty("status","Success");
                Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
                jsonObject.addProperty("mydata",gson.toJson(user,User.class));
            }
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.addProperty("status","Error");
        }
        myjson.add(jsonObject.toString());
        return myjson;
    }
}
