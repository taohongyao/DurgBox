package com.drugbox.Service;

import com.drugbox.Bean.IBeanOperation;
import com.drugbox.Bean.OBeanBase;
import com.drugbox.Bean.RemindInfo.RemindInfoOBean;
import com.drugbox.DAO.RemindInfoDAO;
import com.drugbox.Service.User.UserPool;
import com.drugbox.Util.BeanConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 44247 on 2016/2/17 0017.
 */
@Controller
@RequestMapping("/remind")
public class RemindInfoService {
    @Resource
    private RemindInfoDAO dao;
    @Resource
    private UserPool userpool;
    @RequestMapping(value = "/planlist.do", method = RequestMethod.POST)
    @ResponseBody
    public OBeanBase getRemindInfoList(@RequestBody IBeanOperation iBeanOperation) {
        OBeanBase carrier = new OBeanBase();

        if (userpool.checkUser(iBeanOperation)) {
            List<RemindInfoOBean> outlist = BeanConverter.RemindInfotoListOBean(dao.getList(iBeanOperation.getAccount()));
            carrier.setContents(outlist);
            if (outlist.size() != 0) {
                carrier.setInfo("N01", "查询成功");
            } else {
                carrier.setInfo("E01", "查询失败");
            }
        }else {
            carrier.setInfo("E02", "用户验证错误，请重新登陆");
        }
        return carrier;
    }
}
