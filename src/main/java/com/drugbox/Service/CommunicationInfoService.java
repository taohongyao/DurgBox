package com.drugbox.Service;

import com.drugbox.Bean.BeanBase;
import com.drugbox.DAO.CommunicationInfoDAO;
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
@RequestMapping("/comment")
public class CommunicationInfoService {
    @Resource
    CommunicationInfoDAO dao;
    @RequestMapping(value="/communicationinfo.do",method= RequestMethod.GET)
    @ResponseBody
    public BeanBase getCommunicationInfo(){
        BeanBase carrier =new BeanBase();
        return carrier;
    }
}
