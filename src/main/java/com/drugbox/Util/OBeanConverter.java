package com.drugbox.Util;

import com.drugbox.Bean.CollectionInfo.CollectionInfoOBean;
import com.drugbox.Bean.CommentInfo.CommentInfoOBean;
import com.drugbox.Bean.CommunicationInfo.CommunicationInfoOBean;
import com.drugbox.Bean.CommunicationInfo.CommunicationOBean;
import com.drugbox.Bean.CommunicationInfo.CommunicationUOBean;
import com.drugbox.Bean.MedicineInfo.MedicineInfoOBean;
import com.drugbox.Bean.PurchaseInfo.PurchaseInfoOBean;
import com.drugbox.Bean.RemindInfo.RemindInfoOBean;
import com.drugbox.Bean.UserInfo.UserInfoOBean;
import com.drugbox.Entity.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 44247 on 2016/2/20 0020.
 */
public class OBeanConverter {

    //CommunicationOBean修改为CommunicationInfoOBean 2016.3.22
    public static List<CommunicationInfoOBean> CommunicationtoListOBean(List<CommunicationInfo> datalist){
        List<CommunicationInfoOBean> outlist =new ArrayList<CommunicationInfoOBean>();
        for(CommunicationInfo c: datalist){
            CommunicationInfoOBean bean =new CommunicationInfoOBean( );
            bean.setCommunicateId(c.getCommunicateId());
            bean.setCommunicateTopic(c.getCommunicateTopic());
            bean.setCommunicateZhuan(c.getCommunicateZhuan());
            String piclist=c.getPictureAttached();
            if (piclist!=null){
                String[] list=piclist.split(",");
                List<String> olist=new ArrayList<String>();
                for (int i = 0; i < list.length; i++) {
                    olist.add(list[i]);
                }
                if (list.length!=0) bean.setPictureList(olist);
            }
            bean.setCommunicateTime(c.getCommunicateTime().toString());
            bean.setUserInfo(UserInfotoInfoOBean(c.getUserInfo()));
            bean.setCommunitcateContent(c.getCommunitcateContent());
            outlist.add(bean);
        }
        return outlist;
    }
    public static List<CommunicationUOBean> CommunicationtoListUOBean(List<CommunicationInfo> datalist){
        List<CommunicationUOBean> outlist =new ArrayList<CommunicationUOBean>();
        for(CommunicationInfo c: datalist){
            CommunicationUOBean bean =new CommunicationUOBean( );
            bean.setCommunicateId(c.getCommunicateId());
            bean.setCommunicateTopic(c.getCommunicateTopic());
            bean.setCommunicateZhuan(c.getCommunicateZhuan());
            String piclist=c.getPictureAttached();
            if (piclist!=null){
                String[] list=piclist.split(",");
                List<String> olist=new ArrayList<String>();
                for (int i = 0; i < list.length; i++) {
                    olist.add(list[i]);
                }
                if (list.length!=0) bean.setPictureList(olist);
            }
            bean.setCommunicateTime(c.getCommunicateTime().toString());
            outlist.add(bean);
        }
        return outlist;
    }

    public static CommunicationInfoOBean CommunicationtoIOBean(CommunicationInfo ibean){
        CommunicationInfoOBean obean =new CommunicationInfoOBean();
        obean.setCommunicateId(ibean.getCommunicateId());
        obean.setCommunicateTopic(ibean.getCommunicateTopic());
        obean.setCommunicateZhuan(ibean.getCommunicateZhuan());
        obean.setCommunitcateContent(ibean.getCommunitcateContent());
        String piclist=ibean.getPictureAttached();
        if (piclist!=null){
            String[] list=piclist.split(",");
            List<String> olist=new ArrayList<String>();
            for (int i = 0; i < list.length; i++) {
                olist.add(list[i]);
            }
            if (list.length!=0) obean.setPictureList(olist);
        }
        obean.setCommunicateTime(ibean.getCommunicateTime().toString());
        obean.setUserInfo(UserInfotoInfoOBean(ibean.getUserInfo()));
        return  obean;
    }

    public static List<CommentInfoOBean> CommentInfotoListOBean(List<CommentInfo> datalist) {
        List<CommentInfoOBean> outlist = new ArrayList<CommentInfoOBean>();
        for (CommentInfo c : datalist) {
            CommentInfoOBean bean = new CommentInfoOBean();
            bean.setCommentContent(c.getCommentContent());
            bean.setCommentId(c.getCommentId());
            bean.setCommentZan(c.getCommentZan());
            bean.setCommunicationId(c.getCommunicationInfo().getCommunicateId());
            bean.setUserName(c.getUserInfo().getUserName());
            bean.setCommentTime(c.getCommentTime().toString());
            bean.setUserInfo(UserInfotoInfoOBean(c.getUserInfo()));
            outlist.add(bean);
        }
        return outlist;
    }

    public static MedicineInfoOBean MedicineInfotoOBean(MedicineInfo medicineInfo){
        MedicineInfoOBean bean =new MedicineInfoOBean();
        bean.setMedicineId(medicineInfo.getMedicineId());
        bean.setMedicineName(medicineInfo.getMedicineName());
        bean.setMedicinePicture(medicineInfo.getMedicinePicture());
        bean.setMedicineProduct(medicineInfo.getMedicineProduct());
        bean.setMedicineSympton(medicineInfo.getMedicineSympton());
        return bean;
    }

    public static UserInfoOBean UserInfotoInfoOBean(UserInfo userInfo) {
            UserInfoOBean bean = new UserInfoOBean();
            bean.setUserName(userInfo.getUserName());
            bean.setUserAge(userInfo.getUserAge());
            bean.setUserVirtualName(userInfo.getUserVirtualName());
            bean.setUserPossition(userInfo.getUserPossition());
            bean.setUserLastModify(userInfo.getUserLastModify());
            bean.setUserRegisterTime(userInfo.getUserRegisterTime());
            bean.setUserPicture(userInfo.getUserPicture());

        return bean;
    }
    public static List<UserInfoOBean> UserInfotoInfoOBean(List<UserInfo> datalist) {
        List<UserInfoOBean> outlist = new ArrayList<UserInfoOBean>();
        for (UserInfo c : datalist) {
            UserInfoOBean bean = new UserInfoOBean();
            bean.setUserName(c.getUserName());
            bean.setUserAge(c.getUserAge());
            bean.setUserVirtualName(c.getUserVirtualName());
            bean.setUserPossition(c.getUserPossition());
            bean.setUserLastModify(c.getUserLastModify());
            bean.setUserRegisterTime(c.getUserRegisterTime());
            bean.setUserPicture(c.getUserPicture());
            outlist.add(bean);
        }
        return outlist;
    }

    public static List<CollectionInfoOBean> CollectionInfotoListOBean(List<CollectionInfo> datalist) {
        List<CollectionInfoOBean> outlist = new ArrayList<CollectionInfoOBean>();
        for (CollectionInfo c : datalist) {
            CollectionInfoOBean bean = new CollectionInfoOBean();
            bean.setCollectionId(c.getCollectionId());
            bean.setCollectionTime(c.getCollectionTime().toString());
            bean.setMedicineInfo(MedicineInfotoOBean(c.getMedicineInfo()));
            outlist.add(bean);
        }
        return outlist;
    }

    public static List<RemindInfoOBean> RemindInfotoListOBean(List<RemindInfo> datalist) {
        List<RemindInfoOBean> outlist = new ArrayList<RemindInfoOBean>();
        for (RemindInfo c : datalist) {
            RemindInfoOBean bean = new RemindInfoOBean();
            bean.setRemind_ID(c.getRemindId());
            bean.setRemindTime(c.getRemindTime());
            bean.setMedicineInfo(MedicineInfotoOBean(c.getMedicineInfo()));
            outlist.add(bean);
        }
        return outlist;
    }

    public static List<PurchaseInfoOBean> PurchaseInfotoListOBean(List<PurchaseInfo> datalist) {
        List<PurchaseInfoOBean> outlist = new ArrayList<PurchaseInfoOBean>();
        for (PurchaseInfo c : datalist) {
            PurchaseInfoOBean bean = new PurchaseInfoOBean();
            bean.setMedicineInfo(MedicineInfotoOBean(c.getMedicineInfo()));
            bean.setPurchaseId(c.getPurchaseId());
            bean.setPurchaseNum(c.getPurchaseNum());
            bean.setPurchaseTime(c.getPurchaseTime());
            outlist.add(bean);
        }
        return outlist;
    }
}
