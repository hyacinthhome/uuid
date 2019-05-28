package cn.itcast.action;

import cn.itcast.entity.Bottle;
import cn.itcast.service.BottleService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class BottleAction {
    private BottleService bottleService;
    private List<String> myjson=new ArrayList<String>();
    private Bottle bottle;
    private String user_username;

    public void setBottleService(BottleService bottleService) {
        this.bottleService = bottleService;
    }
    public List<String> getMyjson() {
        return myjson;
    }
    public Bottle getBottle() {
        return bottle;
    }
    public void setBottle(Bottle bottle) {
        this.bottle = bottle;
    }
    public String getUser_username() {
        return user_username;
    }
    public void setUser_username(String user_username) {
        this.user_username = user_username;
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

    public String add(){
        System.out.println("start-------------------------BottleAction.add");
        befAction(ServletActionContext.getResponse(),ServletActionContext.getRequest());
        myjson=bottleService.add(bottle,user_username);
        System.out.println("end---------------------------BottleAction.add");
        return "ok";
    }

    public String gtone(){
        System.out.println("start-------------------------BottleAction.gtone");
        befAction(ServletActionContext.getResponse(),ServletActionContext.getRequest());
        myjson=bottleService.gtone(user_username);
        System.out.println("end---------------------------BottleAction.gtone");
        return "ok";
    }
}
