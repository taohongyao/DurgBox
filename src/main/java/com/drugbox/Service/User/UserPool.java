package com.drugbox.Service.User;

import com.drugbox.Bean.UserInfo.UserPoolBean;
import com.drugbox.Util.DataEncoder;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Calendar;
import java.util.HashMap;

/**
 * Created by 44247 on 2016/2/18 0018.
 */
public  class UserPool {
    private static HashMap<String,UserPoolBean> userpool=new HashMap<String,UserPoolBean>( );
    public  static void addUser(String account){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE,30);
        long time=calendar.getTimeInMillis(); // 计算超时时间
        String md5=DataEncoder.getMD5("DrugBox"+account+time); //md5加密得到sessionID

        UserPoolBean user =new UserPoolBean();
        user.setAccount(account);
        user.setVaild(time);
        user.setSessionID(md5);
        userpool.put(account,user);
    }
    public static  void removeUserBean(String account){
        userpool.remove(account);
    }
    public static String getUserSessionID(String account){
        UserPoolBean user=userpool.get(account);
        if (user!=null){
            return user.getSessionID();
        }
        return null;
    }
    public static Boolean checkUser(String account,String sessionID){
        UserPoolBean user=userpool.get(account);
        Calendar calendar = Calendar.getInstance();
        long time=calendar.getTimeInMillis(); // 计算超时时间
        if (user!=null){
            if(user.getSessionID().equals(sessionID)&&time<=user.getVaild()){
                    addUser(account);
                    return true;
            }
            userpool.remove(account);
        }
        return false;
    }
}