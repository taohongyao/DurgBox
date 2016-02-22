package com.drugbox.Util;

import com.drugbox.Bean.CollectionInfo.CollectionInfoIBean;
import com.drugbox.Bean.CommentInfo.CommentAddIBean;
import com.drugbox.Bean.CommunicationInfo.CommunicationIBean;
import com.drugbox.Bean.PurchaseInfo.PurchaseAddIBean;
import com.drugbox.Bean.RemindInfo.RemindInfoIBean;
import com.drugbox.Bean.RemindInfo.RemindInfoIIBean;
import com.drugbox.Bean.UserInfo.RegisterIBean;
import com.drugbox.Entity.*;
import sun.nio.cs.ext.IBM037;

import java.sql.Date;
import java.sql.Timestamp;
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
    public static CollectionInfo CollctionIBeantoEntity(CollectionInfoIBean IBean,long time){
        CollectionInfo bean=new CollectionInfo();
        bean.setMedicineInfo(new MedicineInfo(IBean.getMedicineId()));
        bean.setUserInfo(new UserInfo(IBean.getAccount()));
        bean.setCollectionTime(new Timestamp(time));
        return bean;
    }

    public static PurchaseInfo PurchaseAddIBeantoEntity(PurchaseAddIBean IBean, long time){
        PurchaseInfo bean=new PurchaseInfo();
        bean.setMedicineInfo(new MedicineInfo(IBean.getMedicineId()));
        bean.setUserInfo(new UserInfo(IBean.getAccount()));
        bean.setPurchaseTime(new Timestamp(time));
        bean.setPurchaseNum(IBean.getPurchaseNum());
        return bean;
    }

    public static CommentInfo CommentAddIBeantoEntity(CommentAddIBean IBean, long time){
        CommentInfo bean=new CommentInfo();
        bean.setUserInfo(new UserInfo(IBean.getAccount()));
        bean.setCommentContent(IBean.getCommentContent());
        bean.setCommentTime(new Timestamp(time));
        bean.setCommunicationInfo(new CommunicationInfo(IBean.getCommunicateId()));
        bean.setCommentZan(0);
        return bean;
    }

    public static UserInfo RegisterIBeantoEntity(RegisterIBean iBean){
        UserInfo bean=new UserInfo();
        bean.setUserName(iBean.getAccount());
        bean.setUserPassword(iBean.getPassword());
        return bean;
    }

    public static CommunicationInfo CommunicationIBeantoEntity(CommunicationIBean iBean){
        CommunicationInfo bean=new CommunicationInfo();
        bean.setUserInfo(new UserInfo(iBean.getAccount()));
        bean.setCommunicateTopic(iBean.getCommunicateTopic());
        bean.setCommunitcateContent(iBean.getCommunitcateContent());
        bean.setCommunicateZhuan(0);
        StringBuffer pic=new StringBuffer();
        List<String> list =iBean.getPictureAttached();
        if(list!=null){
            for(int i=0;i <list.size();i++){
                String string=list.get(i).trim();
                if(string.equals("") )continue;
                pic.append(string);
                if(i!=list.size()-1) pic.append(",");
            }
            if (!pic.toString().equals("")) bean.setPictureAttached(pic.toString());
        }
        return bean;
    }
}
