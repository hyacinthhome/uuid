package cn.itcast.action;

import cn.itcast.entity.User;
import cn.itcast.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class UserAction extends ActionSupport {
    private UserService userService;
    private User user;

    private List<String> myjson=new ArrayList<String>();

    public List<String> getMyjson() {
        return myjson;
    }
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    private void befAction(HttpServletResponse response, HttpServletRequest request){
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methods","POST");
        response.setHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
        //  response.setHeader("Access-Control-Allow-Credentials", "true");
        // response.setHeader("Access-Control-Allow-Origin", "http://localhost");
       /* String [] allowDomains=new String[21];
        for(int i=8080;i<=8100;i++){
            String temp="http://localhost:"+Integer.toString(i);
            allowDomains[i-8080]=temp;
        }
        Set allowOrigins=new HashSet(Arrays.asList(allowDomains));
        String originHeads=request.getHeader("Origin");
        if(allowOrigins.contains(originHeads)){
            response.setHeader("Access-Control-Allow-Origin",originHeads);
        }*/

        System.out.println("new");
    }
    public String login(){
        System.out.println("start----------------------UserAction.login");
        befAction(ServletActionContext.getResponse(),ServletActionContext.getRequest());
        String user_username=user.getUser_username();
        String user_password=user.getUser_password();
        System.out.println("Logining:\nusername:"+user_username+"\npassword:"+user_password);
        myjson=userService.login(user_username,user_password);
        System.out.println("end------------------------UserAction.login");
        return "ok";
    }
    public String register(){
        System.out.println("start-----------------------UserAction.register");
        befAction(ServletActionContext.getResponse(),ServletActionContext.getRequest());
        myjson=userService.register(user);
        System.out.println("end-------------------------UserAction.register");
        return "ok";
    }
}
