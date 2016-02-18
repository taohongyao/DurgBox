package com.drugbox.Service.User;

import com.drugbox.Bean.BeanBase;
import com.drugbox.Bean.OperationBean;
import com.drugbox.Bean.UserInfo.UserInBean;
import com.drugbox.Bean.UserInfo.UseroutBean;
import com.drugbox.DAO.UserInfoDAO;
import com.drugbox.Entity.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by 44247 on 2016/2/17 0017.
 */
@Controller
@RequestMapping("/user")
public class UserInfoService {
    private static UserPool userpool=new UserPool();
    @Resource
    UserInfoDAO dao;
    @RequestMapping(value="/login.do",method= RequestMethod.POST)
    @ResponseBody
    public BeanBase userLogin(@RequestBody UserInBean userin){
        String account=userin.getAccount();
        String password=userin.getPassword();

        BeanBase carrier =new BeanBase();
        UserInfo userInfo = dao.findById(account);
        if (userInfo!=null){
            if (userInfo.getUserPassword().equals(password)){
                userpool.addUser(account);
                String SessionID=userpool.getUserSessionID(account);
                if (SessionID == null){
                    carrier.setInfo("E03","服务器繁忙");
                    return carrier;
                }
                carrier.setInfo("N01","登录成功");
                carrier.setContents(new UseroutBean(SessionID));
            }else {
                carrier.setInfo("E02","密码错误");
            }
        }else {
            carrier.setInfo("E01","账户不存在");
        }
        return carrier;
    }
    @RequestMapping(value="/logout.do",method= RequestMethod.POST)
    @ResponseBody
    public BeanBase userLogout(@RequestBody OperationBean userin){
        String account=userin.getAccount();
        String sessionID=userin.getSessionID();
        BeanBase carrier =new BeanBase();
        if (userpool.checkUser(account,sessionID)){
            carrier.setInfo("N01","已退出");
            userpool.removeUserBean(account);
        }else{
            carrier.setInfo("N02","已退出");
        }
        return carrier;
    }
}
