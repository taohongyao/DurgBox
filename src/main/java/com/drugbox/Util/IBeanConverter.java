package com.drugbox.Util;

import com.drugbox.Bean.RemindInfo.RemindInfoIBean;
import com.drugbox.Bean.RemindInfo.RemindInfoIIBean;
import com.drugbox.Entity.MedicineInfo;
import com.drugbox.Entity.RemindInfo;
import com.drugbox.Entity.UserInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 44247 on 2016/2/22 0022.
 */
public class IBeanConverter {
    public static List<RemindInfo> RmindIBeantoEntity(RemindInfoIBean IBean){
        String account=IBean.getAccount();
        List<RemindInfoIIBean> list=IBean.getList();
        List<RemindInfo> ilist=new ArrayList<RemindInfo>();
        for (RemindInfoIIBean r:list){
            RemindInfo bean=new  RemindInfo();
            bean.setUserInfo(new UserInfo(account));
            bean.setMedicineInfo(new MedicineInfo(r.getMedicineId()));
            bean.setRemindTime(r.getRemindTime());
            ilist.add(bean);
        }
        return ilist;
    }
}
