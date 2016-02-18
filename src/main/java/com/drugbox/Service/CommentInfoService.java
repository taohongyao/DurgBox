package com.drugbox.Service;

import com.drugbox.Bean.BeanBase;
import com.drugbox.DAO.CommentInfoDAO;
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
@RequestMapping("/forum")
public class CommentInfoService {
    @Resource
    CommentInfoDAO dao;
    @RequestMapping(value="/commentinfo.do",method= RequestMethod.GET)
    @ResponseBody
    public BeanBase getCommentInfo(){
        BeanBase carrier =new BeanBase();
        return carrier;
    }
}
