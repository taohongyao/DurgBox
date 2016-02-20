package com.drugbox.Service;

import com.drugbox.Bean.OBeanBase;
import com.drugbox.DAO.MedicineInfoDAO;
import com.drugbox.Entity.MedicineInfo;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by 44247 on 2016/2/17 0017.
 */
@Controller
@RequestMapping("/medicine")
public class MedicineinfoService {
    @Resource
    MedicineInfoDAO dao;
    @RequestMapping(value="/medicineinfo.do",method= RequestMethod.GET)
    @ResponseBody
    public OBeanBase getMedicineInfo(@RequestParam("id") String id)  {
        OBeanBase carrier =new OBeanBase();
        MedicineInfo medicineInfo = dao.findById(id);
        carrier.setContents(medicineInfo);
        if (medicineInfo!=null){
            carrier.setInfo("N01","查询成功");
        }else {
            carrier.setInfo("E01","查询失败");
        }
        return carrier;
    }

    @RequestMapping(value="/findmedicinelist.do",method= RequestMethod.GET)
    @ResponseBody
    public OBeanBase findMedicineList(@RequestParam("name") String name){
        OBeanBase carrier =new OBeanBase();
        List<MedicineInfo> outlist = dao.findMedicineListByname(name);
        carrier.setContents(outlist);
        if (outlist.size()!=0){
            carrier.setInfo("N01","查询成功");
        }else {
            carrier.setInfo("E01","查询失败");
        }
        return carrier;
    }

    @Test
    public void test(){
        Timestamp time =new Timestamp(1455894818000L);
        System.out.println(time);
    }
}
