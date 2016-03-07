package com.drugbox.Service.User;

import com.drugbox.Bean.IBeanOperation;
import com.drugbox.Bean.UserInfo.UserPoolBean;
import com.drugbox.Util.DataEncoder;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.HashMap;

/**
 * Created by 44247 on 2016/2/18 0018.
 */
@Component
public  class UserPool extends HashMap<String,UserPoolBean>{
    public   void addUser(String account){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE,30);
        long time=calendar.getTimeInMillis(); // 计算超时时间
        String md5=DataEncoder.getMD5("DrugBox"+account+time); //md5加密得到sessionID

        UserPoolBean user =new UserPoolBean();
        user.setAccount(account);
        user.setVaild(time);
        user.setSessionID(md5);
        put(account,user);
    }
    public   void removeUserBean(String account){
        remove(account);
    }
    public  String getUserSessionID(String account){
        UserPoolBean user=get(account);
        if (user!=null){
            return user.getSessionID();
        }
        return null;
    }
    public  Boolean checkUser(String account,String sessionID){
        UserPoolBean user=get(account);
        Calendar calendar = Calendar.getInstance();
        long time=calendar.getTimeInMillis(); // 计算超时时间
        if (user!=null){
            if(user.getSessionID().equals(sessionID)&&time<=user.getVaild()){
                calendar.add(Calendar.MINUTE,30);
                long newtime=calendar.getTimeInMillis(); // 计算超时时间
                user.setVaild(newtime);
                return true;
            }
        }
        return false;
    }

    public  Boolean checkUser(IBeanOperation iBeanOperation){
        return  checkUser(iBeanOperation.getAccount(),iBeanOperation.getSessionID());
    }
}
