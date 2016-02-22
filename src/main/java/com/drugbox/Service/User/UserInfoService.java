package com.drugbox.Service.User;

import com.drugbox.Bean.OBeanBase;
import com.drugbox.Bean.IBeanOperation;
import com.drugbox.Bean.UserInfo.*;
import com.drugbox.DAO.UserInfoDAO;
import com.drugbox.Entity.UserInfo;
import com.drugbox.Util.IBeanConverter;
import com.drugbox.Util.OBeanConverter;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Calendar;

/**
 * Created by 44247 on 2016/2/17 0017.
 */
@Controller
@RequestMapping("/user")
public class UserInfoService {
    @Resource
    private UserPool userpool;
    @Resource
    private UserInfoDAO dao;
    @RequestMapping(value="/login.do",method= RequestMethod.POST)
    @ResponseBody
    public OBeanBase userLogin(@RequestBody UserLoginIBean userin){
        String account=userin.getAccount();
        String password=userin.getPassword();

        OBeanBase carrier =new OBeanBase();
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
                carrier.setContents(new UserLoginOBean(SessionID));
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
    public OBeanBase userLogout(@RequestBody IBeanOperation userin){
        String account=userin.getAccount();
        String sessionID=userin.getSessionID();
        OBeanBase carrier =new OBeanBase();
        if (userpool.checkUser(account,sessionID)){
            carrier.setInfo("N01","已退出");
            userpool.removeUserBean(account);
        }else{
            carrier.setInfo("N02","已退出");
        }
        return carrier;
    }

    @RequestMapping(value="/isregistered.do",method= RequestMethod.GET)
    @ResponseBody
    public OBeanBase isRegistered(@RequestParam("account") String account){
        OBeanBase carrier =new OBeanBase();
        if (checkRegistered(account)){
            carrier.setInfo("N01","未注册");
        }else{
            carrier.setInfo("E01","已注册");
        }
        return carrier;
    }

    @RequestMapping(value="/userinfo.do",method= RequestMethod.POST)
    @ResponseBody
    public OBeanBase getUserInfo(@RequestBody IBeanOperation iBean){
        OBeanBase carrier =new OBeanBase();
        if (userpool.checkUser(iBean)) {
            UserInfoOBean obean=selectUserinfo(iBean.getAccount());
            carrier.setContents(obean);
            carrier.setInfo("N01","查询成功");
        }else {
            carrier.setInfo("E02","用户验证错误，请重新登陆");
        }
        return carrier;
    }
    @RequestMapping(value="/updateinfo.do",method= RequestMethod.POST)
    @ResponseBody
    public OBeanBase updateUserInfo(@RequestBody RegisterInfoIBean iBean){
        OBeanBase carrier =new OBeanBase();
        if (userpool.checkUser(iBean)) {
            updateInfo(iBean);
            carrier.setInfo("N01","更新个人信息成功");
        }else {
            carrier.setInfo("E02", "用户验证错误，请重新登陆");
        }
        return carrier;
    }
    @RequestMapping(value="/register.do",method= RequestMethod.POST)
    @ResponseBody
    public OBeanBase userLogout(@RequestBody RegisterIBean iBean){
        OBeanBase carrier =new OBeanBase();
        if (checkRegistered(iBean.getAccount())){
            dao.save(IBeanConverter.RegisterIBeantoEntity(iBean));
            carrier.setInfo("N01","注册成功");
        }else{
            carrier.setInfo("E01","已注册");
        }
        return carrier;
    }

    @RequestMapping(value="/updatepwd.do",method= RequestMethod.POST)
    @ResponseBody
    public OBeanBase updatePassword(@RequestBody UpPwdIBean iBean){
        OBeanBase carrier =new OBeanBase();
        if (userpool.checkUser(iBean)){
            if(passwordisCorrect(iBean)){
                updatePwd(iBean);
                carrier.setInfo("N01","新密码已生效");
            }else{
                carrier.setInfo("E01","原密码输入错误");
            }
        }else{
            carrier.setInfo("E02","验证失败，请重新登陆");
        }
        return carrier;
    }

    @Transactional
    public void updatePwd(UpPwdIBean iBean){
        UserInfo bean=dao.findById(iBean.getAccount());
        bean.setUserPassword(iBean.getNewPassword());
        dao.update(bean);
    }
    @Transactional
    public void updateInfo(RegisterInfoIBean iBean){
        UserInfo bean=dao.findById(iBean.getAccount());
        bean.setUserAge(iBean.getUserAge());
        bean.setUserPossition(iBean.getUserPossition());
        bean.setUserVirtualName(iBean.getUserVirtualName());
        dao.update(bean);
    }
    public boolean passwordisCorrect(UpPwdIBean iBean){
        UserInfo bean=dao.findById(iBean.getAccount());
        return bean.getUserPassword().equals(iBean.getOldPassword());
    }

    public UserInfoOBean selectUserinfo(String account){
        UserInfo entity=dao.findById(account);
        UserInfoOBean oBean=OBeanConverter.UserInfotoInfoOBean(entity);
        return oBean;
    }
    public boolean checkRegistered(String account){
        UserInfo user=dao.findById(account);
        return user==null?true:false;
    }
}
