package com.drugbox.Service;

import com.drugbox.Bean.CommentInfo.CommentAddIBean;
import com.drugbox.Bean.CommentInfo.CommentInfoOBean;
import com.drugbox.Bean.CommentInfo.CommentZanIBean;
import com.drugbox.Bean.OBeanBase;
import com.drugbox.DAO.CommentInfoDAO;
import com.drugbox.DAO.CommunicationInfoDAO;
import com.drugbox.Entity.CommentInfo;
import com.drugbox.Entity.CommunicationInfo;
import com.drugbox.Service.User.UserPool;
import com.drugbox.Util.IBeanConverter;
import com.drugbox.Util.OBeanConverter;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.List;

/**
 * Created by 44247 on 2016/2/17 0017.
 */
@Controller
@RequestMapping("/forum")
public class CommentInfoService {
    @Resource
    CommentInfoDAO dao;
    @Resource
    CommunicationInfoDAO communicationInfoDAO;
    @Resource
    UserPool userpool;

    @RequestMapping(value = "/commentinfolist.do", method = RequestMethod.GET)
    @ResponseBody
    public OBeanBase getCommentList(@RequestParam("start") int start,
                                    @RequestParam("page") int page,
                                    @RequestParam("capacity") int capacity,
                                    @RequestParam("communicateid") int communicateID) {
        OBeanBase carrier = new OBeanBase();
        int first = start - page * capacity;
        int cap=capacity;
        if(first<0){
            cap+=first;
        }
        List<CommentInfoOBean> outlist = OBeanConverter.CommentInfotoListOBean(dao.getList(communicateID, first, cap));
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
    public OBeanBase getCommentMaxCount(@RequestParam("communicateid") int communicateID) {
        OBeanBase carrier = new OBeanBase();
        long count = dao.getAllCount(communicateID);
        carrier.setContents(count);
        carrier.setInfo("N01", "查询记录总数成功");
        return carrier;
    }

    @RequestMapping(value = "/addcomment.do", method = RequestMethod.POST)
    @ResponseBody
    public OBeanBase addCollection(@RequestBody CommentAddIBean iBean) {
        OBeanBase carrier = new OBeanBase();
        if (userpool.checkUser(iBean)) {
            if(CommunicationisExsit(iBean.getCommunicateId())){
                dao.save(IBeanConverter.CommentAddIBeantoEntity(iBean, Calendar.getInstance().getTimeInMillis()));
                carrier.setInfo("N01", "评论成功");
            }else {
                carrier.setInfo("E01", "帖子不存在");
            }
        } else {
            carrier.setInfo("E02", "用户验证错误，请重新登陆");
        }
        return carrier;
    }

    @RequestMapping(value = "/zan.do", method = RequestMethod.POST)
    @ResponseBody
    public OBeanBase addZan(@RequestBody CommentZanIBean iBean) {
        OBeanBase carrier = new OBeanBase();
        if (userpool.checkUser(iBean)) {
            if(CommentisExsit(iBean.getCommentId())){
                thumb(iBean.getCommentId());
                carrier.setInfo("N01", "点赞成功");
            }else {
                carrier.setInfo("E01", "找不到评论");
            }
        } else {
            carrier.setInfo("E02", "用户验证错误，请重新登陆");
        }
        return carrier;
    }

    @RequestMapping(value = "/delcomment.do", method = RequestMethod.POST)
    @ResponseBody
    public OBeanBase delComment(@RequestBody CommentZanIBean iBean) {
        OBeanBase carrier = new OBeanBase();
        if (userpool.checkUser(iBean)) {
            if (CommentisExsit(iBean.getCommentId())) {
                if (checkId(iBean)) {
                    dao.delete(iBean.getCommentId());
                    carrier.setInfo("N01", "删除评论成功");
                } else {
                    carrier.setInfo("E01", "没有权限删除他人评论");
                }
            } else {
                carrier.setInfo("E01", "找不到评论");
            }
        } else {
            carrier.setInfo("E02", "用户验证错误，请重新登陆");
        }
        return carrier;
    }

    public boolean checkId(CommentZanIBean iBean){
        CommentInfo commentInfo = dao.findById(iBean.getCommentId());
        String account=commentInfo.getUserInfo().getUserName();
        return account.equals(iBean.getAccount());
    }

    @Transactional
    public void thumb(int commentId) {
        CommentInfo commentInfo = dao.findById(commentId);
        commentInfo.setCommentZan(commentInfo.getCommentZan() + 1);
        dao.update(commentInfo);
    }
    public boolean CommentisExsit(int commentId){
        CommentInfo bean=dao.findById(commentId);
        return bean!=null;
    }
    public boolean CommunicationisExsit(int communicationId){
        CommunicationInfo bean=communicationInfoDAO.findById(communicationId);
        return bean!=null;
    }
}
