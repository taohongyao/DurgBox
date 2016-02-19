package com.drugbox.Service;

import com.drugbox.Bean.BeanBase;
import com.drugbox.Bean.CommunicationInfo.CommunicationBean;
import com.drugbox.DAO.CommunicationInfoDAO;
import com.drugbox.Entity.CommunicationInfo;
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
@RequestMapping("/forum")
public class CommunicationInfoService {
    @Resource
    CommunicationInfoDAO dao;
    @RequestMapping(value="/communicationinfo.do",method= RequestMethod.GET)
    @ResponseBody
    public BeanBase getCommunicationInfo(@RequestParam("id") int id){
        BeanBase carrier =new BeanBase();
        CommunicationInfo communicationInfo = dao.findById(id);
        carrier.setContents(communicationInfo);
        if (communicationInfo!=null){
            carrier.setInfo("N01","查询成功");
        }else {
            carrier.setInfo("E01","查询失败");
        }
        return carrier;
    }
    @RequestMapping(value="/communicationtitlelist.do",method= RequestMethod.GET)
    @ResponseBody
    public BeanBase getCommunicationTitleList(@RequestParam("start") int start,
                                              @RequestParam("page") int page,
                                              @RequestParam("capacity") int capacity){
        BeanBase carrier =new BeanBase();
        int first = start-page*capacity;

        List<CommunicationBean> outlist = InfotoBean(dao.getTitleList(first,capacity));
        carrier.setContents(outlist);
        if (outlist.size()!=0){
            carrier.setInfo("N01","查询成功");
        }else {
            carrier.setInfo("E01","查询失败");
        }
        return carrier;
    }
    @RequestMapping(value="/communicationmaxcount.do",method= RequestMethod.GET)
    @ResponseBody
    public BeanBase getCommunicationTitleList(){
        BeanBase carrier =new BeanBase();
        long count=dao.getAllCount();
        carrier.setContents(count);
        carrier.setInfo("N01","查询记录总数成功");
        return carrier;
    }

    public static List<CommunicationBean> InfotoBean(List<CommunicationInfo> datalist){
        List<CommunicationBean> outlist =new ArrayList<CommunicationBean>();
        for(CommunicationInfo c: datalist){
            CommunicationBean bean =new CommunicationBean( );
            bean.setCommunicateId(c.getCommunicateId());
            bean.setCommunicateTopic(c.getCommunicateTopic());
            bean.setCommunicateZhuan(c.getCommunicateZhuan());
            bean.setPictureAttached(c.getPictureAttached());
            bean.setCommunicateTime(c.getCommunicateTime().toString());
            outlist.add(bean);
        }
        return outlist;
    }
}
