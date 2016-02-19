package com.drugbox.Service;

import com.drugbox.Bean.BeanBase;
import com.drugbox.Bean.CommentInfo.CommentInfoBean;
import com.drugbox.DAO.MedicineInfoDAO;
import com.drugbox.Entity.CommentInfo;
import com.drugbox.Entity.MedicineInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    public BeanBase getMedicineInfo(@RequestParam("id") String id){
        BeanBase carrier =new BeanBase();
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
    public BeanBase findMedicineList(@RequestParam("name") String name){
        BeanBase carrier =new BeanBase();
        List<MedicineInfo> outlist = dao.findMedicineListByname(name);
        carrier.setContents(outlist);
        if (outlist.size()!=0){
            carrier.setInfo("N01","查询成功");
        }else {
            carrier.setInfo("E01","查询失败");
        }
        return carrier;
    }
}
