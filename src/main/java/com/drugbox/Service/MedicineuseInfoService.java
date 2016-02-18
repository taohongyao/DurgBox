package com.drugbox.Service;

import com.drugbox.Bean.BeanBase;
import com.drugbox.DAO.MedicineuseInfoDAO;
import com.drugbox.Entity.MedicineInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by 44247 on 2016/2/17 0017.
 */
@Controller
@RequestMapping("/medicine")
public class MedicineuseInfoService {
    @Resource
    MedicineuseInfoDAO dao;
    @RequestMapping(value="/medicineuserinfo.do",method= RequestMethod.GET)
    @ResponseBody
    public BeanBase getMedicineuserInfo(){
        BeanBase carrier =new BeanBase();

        return carrier;
    }
}
