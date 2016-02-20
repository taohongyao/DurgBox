package com.drugbox.Service;

import com.drugbox.Bean.OBeanBase;
import com.drugbox.Bean.PurchaseInfo.PurchaseInfoIBean;
import com.drugbox.Bean.PurchaseInfo.PurchaseInfoOBean;
import com.drugbox.DAO.PurchaseInfoDAO;
import com.drugbox.Service.User.UserPool;
import com.drugbox.Util.BeanConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 44247 on 2016/2/17 0017.
 */
@Controller
@RequestMapping("/purchase")
public class PurchaseInfoService {
    @Resource
    private PurchaseInfoDAO dao;
    @Resource
    private UserPool userpool;

    @RequestMapping(value = "/purchaselist.do", method = RequestMethod.POST)
    @ResponseBody
    public OBeanBase getPurchaseList(@RequestBody PurchaseInfoIBean purchaseInfoIBean) {
        OBeanBase carrier = new OBeanBase();

        if (userpool.checkUser(purchaseInfoIBean)) {
            int first = purchaseInfoIBean.getStart() - purchaseInfoIBean.getPage() * purchaseInfoIBean.getCapacity();
            List<PurchaseInfoOBean> outlist = BeanConverter.PurchaseInfotoListOBean(dao.getList(purchaseInfoIBean.getAccount(), first, purchaseInfoIBean.getCapacity()));
            carrier.setContents(outlist);
            if (outlist.size() != 0) {
                carrier.setInfo("N01", "查询成功");
            } else {
                carrier.setInfo("E01", "查询失败");
            }
        } else {
            carrier.setInfo("E02", "用户验证错误，请重新登陆");
        }
        return carrier;
    }

    @RequestMapping(value = "/maxcount.do", method = RequestMethod.POST)
    @ResponseBody
    public OBeanBase getPurchaseMaxCount(@RequestBody PurchaseInfoIBean purchaseInfoIBean) {
        OBeanBase carrier = new OBeanBase();
        if (userpool.checkUser(purchaseInfoIBean)) {
            long count = dao.getAllCount(purchaseInfoIBean.getAccount());
            carrier.setContents(count);
            carrier.setInfo("N01", "查询记录总数成功");
        } else {
            carrier.setInfo("E02", "用户验证错误，请重新登陆");
        }
        return carrier;
    }


}
