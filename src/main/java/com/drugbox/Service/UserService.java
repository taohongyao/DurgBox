package com.drugbox.Service;

import com.drugbox.DAO.MedicineInfoDAO;
import com.drugbox.Entity.MedicineInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by 44247 on 2016/2/17 0017.
 */
@Controller
@RunWith(SpringJUnit4ClassRunner.class) // 整合
@ContextConfiguration(locations="classpath:applicationContext.xml") // 加载配置
public class UserService {
    @Resource
    MedicineInfoDAO dao;
    @Test
    public  void test(){
        System.out.println("here is bean MedicineInfoDAO : "+dao);
        System.out.println(dao.findById("H20133031"));
    }
    @RequestMapping(name="/medicineinfo.do",method= RequestMethod.GET)
    @ResponseBody
    public MedicineInfo test1(@RequestParam("id") String id){
        MedicineInfo medicineInfo = dao.findById(id);
        return medicineInfo;
    }
}
