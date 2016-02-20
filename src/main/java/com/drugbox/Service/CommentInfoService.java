package com.drugbox.Service;

import com.drugbox.Bean.OBeanBase;
import com.drugbox.Bean.CommentInfo.CommentInfoOBean;
import com.drugbox.DAO.CommentInfoDAO;
import com.drugbox.Util.BeanConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 44247 on 2016/2/17 0017.
 */
@Controller
@RequestMapping("/forum")
public class CommentInfoService {
    @Resource
    CommentInfoDAO dao;

    @RequestMapping(value = "/commentinfolist.do", method = RequestMethod.GET)
    @ResponseBody
    public OBeanBase getCommunicationTitleList(@RequestParam("start") int start,
                                               @RequestParam("page") int page,
                                               @RequestParam("capacity") int capacity,
                                               @RequestParam("communicateid") int communicateID) {
        OBeanBase carrier = new OBeanBase();
        int first = start - page * capacity;

        List<CommentInfoOBean> outlist = BeanConverter.CommentInfotoListOBean(dao.getList(communicateID, first, capacity));
        carrier.setContents(outlist);
        if (outlist.size() != 0) {
            carrier.setInfo("N01", "查询成功");
        } else {
            carrier.setInfo("E01", "查询失败");
        }
        return carrier;
    }

    @RequestMapping(value = "/commentinfomaxcount.do", method = RequestMethod.GET)
    @ResponseBody
    public OBeanBase getCommunicationTitleList(@RequestParam("communicateid") int communicateID) {
        OBeanBase carrier = new OBeanBase();
        long count = dao.getAllCount(communicateID);
        carrier.setContents(count);
        carrier.setInfo("N01", "查询记录总数成功");
        return carrier;
    }


}
