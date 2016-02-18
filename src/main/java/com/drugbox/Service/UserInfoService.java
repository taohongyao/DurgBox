package com.drugbox.Service;

import com.drugbox.Bean.BeanBase;
import com.drugbox.Bean.UserInfo.UserInBean;
import com.drugbox.Bean.UserInfo.UseroutBean;
import com.drugbox.DAO.UserInfoDAO;
import com.drugbox.Entity.MedicineInfo;
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
    @Resource
    UserInfoDAO dao;
    @RequestMapping(value="/login.do",method= RequestMethod.POST)
    @ResponseBody
    public BeanBase userLogin(@RequestBody UserInBean userin){
        BeanBase carrier =new BeanBase();
        UserInfo userInfo = dao.findById(userin.getAccount());
        if (userInfo!=null){

            if (userInfo.getUserPassword().equals(userin.getPassword())){
                carrier.setInfo("N01","登录成功");
                carrier.setContents(new UseroutBean("E20160218"));
            }else {
                carrier.setInfo("E02","密码错误");
            }
        }else {
            carrier.setInfo("E01","账户不存在");
        }
        return carrier;
    }
}
