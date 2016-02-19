package com.drugbox.Service;

import com.drugbox.Bean.BeanBase;
import com.drugbox.Bean.CommentInfo.CommentInfoBean;
import com.drugbox.DAO.CommentInfoDAO;
import com.drugbox.Entity.CommentInfo;
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
public class CommentInfoService {
    @Resource
    CommentInfoDAO dao;

    @RequestMapping(value = "/commentinfolist.do", method = RequestMethod.GET)
    @ResponseBody
    public BeanBase getCommunicationTitleList(@RequestParam("start") int start,
                                              @RequestParam("page") int page,
                                              @RequestParam("capacity") int capacity,
                                              @RequestParam("communicateid") int communicateID) {
        BeanBase carrier = new BeanBase();
        int first = start - page * capacity;

        List<CommentInfoBean> outlist = InfotoBean(dao.getList(communicateID, first, capacity));
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
    public BeanBase getCommunicationTitleList(@RequestParam("communicateid") int communicateID) {
        BeanBase carrier = new BeanBase();
        long count = dao.getAllCount(communicateID);
        carrier.setContents(count);
        carrier.setInfo("N01", "查询记录总数成功");
        return carrier;
    }

    public static List<CommentInfoBean> InfotoBean(List<CommentInfo> datalist) {
        List<CommentInfoBean> outlist = new ArrayList<CommentInfoBean>();
        for (CommentInfo c : datalist) {
            CommentInfoBean bean = new CommentInfoBean();
            bean.setCommentContent(c.getCommentContent());
            bean.setCommentId(c.getCommentId());
            bean.setCommentZan(c.getCommentZan());
            bean.setCommunicationId(c.getCommunicationInfo().getCommunicateId());
            bean.setUserName(c.getUserInfo().getUserName());
            bean.setCommentTime(c.getCommentTime().toString());
            outlist.add(bean);
        }
        return outlist;
    }
}
