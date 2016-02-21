package com.drugbox.Service;

import com.drugbox.Bean.IBeanOperation;
import com.drugbox.Bean.OBeanBase;
import com.drugbox.Bean.RemindInfo.RemindInfoIBean;
import com.drugbox.Bean.RemindInfo.RemindInfoOBean;
import com.drugbox.DAO.RemindInfoDAO;
import com.drugbox.Entity.RemindInfo;
import com.drugbox.Service.User.UserPool;
import com.drugbox.Util.OBeanConverter;
import com.drugbox.Util.IBeanConverter;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 44247 on 2016/2/17 0017.
 */
@Controller
@RequestMapping("/remind")
@RunWith(SpringJUnit4ClassRunner.class) // 整合
@ContextConfiguration(locations="classpath:applicationContext.xml") // 加载配
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
            List<RemindInfoOBean> outlist = OBeanConverter.RemindInfotoListOBean(dao.getList(iBeanOperation.getAccount()));
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

    @RequestMapping(value = "/addplanlist.do", method = RequestMethod.POST)
    @ResponseBody
    public OBeanBase addRemindInfoList(@RequestBody RemindInfoIBean iBean) {
        OBeanBase carrier = new OBeanBase();
        if (userpool.checkUser(iBean)) {
            if(iBean.getList().size()<21){
                dao.deleteByAccount(iBean.getAccount());
                List<RemindInfo> list=IBeanConverter.RmindIBeantoEntity(iBean);
                dao.saveList(list);
                carrier.setInfo("N01", "上传成功");
            }else {
                carrier.setInfo("E01", "超出上限20条记录，上传失败");
            }
        }else {
            carrier.setInfo("E02", "用户验证错误，请重新登陆");
        }
        return carrier;
    }
}
