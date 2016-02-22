package com.drugbox.Service;

import com.drugbox.Bean.CollectionInfo.CollectionInfoIBean;
import com.drugbox.Bean.CollectionInfo.CollectionInfoOBean;
import com.drugbox.Bean.OBeanBase;
import com.drugbox.DAO.CollectionInfoDAO;
import com.drugbox.Service.User.UserPool;
import com.drugbox.Util.IBeanConverter;
import com.drugbox.Util.OBeanConverter;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.List;

/**
 * Created by 44247 on 2016/2/17 0017.
 */
@Controller
@RequestMapping("/collection")
public class CollectionInfoService {
    @Resource
    private CollectionInfoDAO dao;
    @Resource
    private UserPool userpool;

    @RequestMapping(value = "/list.do", method = RequestMethod.GET)
    @ResponseBody
    public OBeanBase getCollectionList(@RequestParam("start") int start,
                                       @RequestParam("page") int page,
                                       @RequestParam("capacity") int capacity,
                                       @RequestParam("username") String userName) {
        OBeanBase carrier = new OBeanBase();
        int first = start - page * capacity;

        List<CollectionInfoOBean> outlist = OBeanConverter.CollectionInfotoListOBean(dao.getList(userName, first, capacity));
        carrier.setContents(outlist);
        if (outlist.size() != 0) {
            carrier.setInfo("N01", "查询成功");
        } else {
            carrier.setInfo("E01", "查询失败");
        }
        return carrier;
    }
    @RequestMapping(value = "/maxcount.do", method = RequestMethod.GET)
    @ResponseBody
    public OBeanBase getCollectionMaxCount(@RequestParam("username") String userName) {
        OBeanBase carrier = new OBeanBase();
        long count = dao.getAllCount(userName);
        carrier.setContents(count);
        carrier.setInfo("N01", "查询记录总数成功");
        return carrier;
    }

    @RequestMapping(value = "/addcollection.do", method = RequestMethod.POST)
    @ResponseBody
    public OBeanBase addCollection(@RequestBody CollectionInfoIBean iBean) {
        OBeanBase carrier = new OBeanBase();
        if (userpool.checkUser(iBean)) {
            dao.save(IBeanConverter.CollctionIBeantoEntity(iBean, Calendar.getInstance().getTimeInMillis()));
            carrier.setInfo("N01","添加药品收藏成功");
        }else {
            carrier.setInfo("E02", "用户验证错误，请重新登陆");
        }
        return carrier;
    }

    @RequestMapping(value = "/deletcollection.do", method = RequestMethod.POST)
    @ResponseBody
    public OBeanBase delCollection(@RequestBody CollectionInfoIBean iBean) {
        OBeanBase carrier = new OBeanBase();
        if (userpool.checkUser(iBean)) {
            dao.deleteByActMedid(iBean.getAccount(),iBean.getMedicineId());
            carrier.setInfo("N01","取消药品收藏成功");
        }else {
            carrier.setInfo("E02", "用户验证错误，请重新登陆");
        }
        return carrier;
    }
}
