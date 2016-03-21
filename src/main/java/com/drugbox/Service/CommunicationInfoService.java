package com.drugbox.Service;

import com.drugbox.Bean.CommunicationInfo.*;
import com.drugbox.Bean.OBeanBase;
import com.drugbox.Bean.Upload.UploadOBean;
import com.drugbox.DAO.CommentInfoDAO;
import com.drugbox.DAO.CommunicationInfoDAO;
import com.drugbox.Entity.CommunicationInfo;
import com.drugbox.Service.User.UserPool;
import com.drugbox.Util.IBeanConverter;
import com.drugbox.Util.OBeanConverter;
import com.drugbox.Util.UploadUtil;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by 44247 on 2016/2/17 0017.
 */
@Controller
@RequestMapping("/forum")
public class CommunicationInfoService {
    @Resource
    UserPool userpool;
    @Resource
    CommunicationInfoDAO dao;
    @Resource
    CommentInfoDAO commentInfoDAO;
    @RequestMapping(value="/communicationinfo.do",method= RequestMethod.GET)
    @ResponseBody
    public OBeanBase getCommunicationInfo(@RequestParam("id") int id){
        OBeanBase carrier =new OBeanBase();
        CommunicationInfo communicationInfo=dao.findById(id);
        if (CommunicationisExsit(id)) {
            CommunicationInfoOBean obean = OBeanConverter.CommunicationtoIOBean(communicationInfo);
            carrier.setContents(obean);
            carrier.setInfo("N01","查询成功");
        }else {
            carrier.setInfo("E01","查询失败，没有此id");
        }
        return carrier;
    }


    @RequestMapping(value="/communicationtitlelist.do",method= RequestMethod.GET)
    @ResponseBody
    public OBeanBase getCommunicationTitleList(@RequestParam("start") int start,
                                               @RequestParam("page") int page,
                                               @RequestParam("capacity") int capacity){
        OBeanBase carrier =new OBeanBase();
        int first = start-page*capacity;

        List<CommunicationOBean> outlist = OBeanConverter.CommunicationtoListOBean(dao.getTitleList(first,capacity));
        carrier.setContents(outlist);
        if (outlist.size()!=0){
            carrier.setInfo("N01","查询成功");
        }else {
            carrier.setInfo("E01","查询失败");
        }
        return carrier;
    }

    @RequestMapping(value="/communicationtitlelistbyuser.do",method= RequestMethod.GET)
    @ResponseBody
    public OBeanBase getCommunicationTitleListByUser(@RequestParam("start") int start,
                                               @RequestParam("page") int page,
                                               @RequestParam("capacity") int capacity,
                                                     @RequestParam("user") String user){
        OBeanBase carrier =new OBeanBase();
        int first = start-page*capacity;

        List<CommunicationUOBean> outlist = OBeanConverter.CommunicationtoListUOBean(dao.getTitleListByUser(first,capacity,user));
        carrier.setContents(outlist);
        if (outlist.size()!=0){
            carrier.setInfo("N01","查询成功");
        }else {
            carrier.setInfo("E01","查询失败");
        }
        return carrier;
    }
    @RequestMapping(value="/communicationmaxcountbyuser.do",method= RequestMethod.GET)
    @ResponseBody
    public OBeanBase getCommunicationMaxCountByUser(@RequestParam("user") String user){
        OBeanBase carrier =new OBeanBase();
        String HQL="from CommunicationInfo where userInfo.userName=?";
        long count=dao.getAllCountByUser(user);
        carrier.setContents(count);
        carrier.setInfo("N01","查询用户总记录数成功");
        return carrier;
    }


    @RequestMapping(value="/communicationmaxcount.do",method= RequestMethod.GET)
    @ResponseBody
    public OBeanBase getCommunicationMaxCount(){
        OBeanBase carrier =new OBeanBase();
        long count=dao.getAllCount();
        carrier.setContents(count);
        carrier.setInfo("N01","查询记录总数成功");
        return carrier;
    }

    @RequestMapping(value="/addcommunication.do",method= RequestMethod.POST)
    @ResponseBody
    public OBeanBase addCommunication(@RequestBody CommunicationIBean iBean){
        OBeanBase carrier =new OBeanBase();
        if (userpool.checkUser(iBean)) {
            if(!isRepeat(iBean.getAccount(),iBean.getCommunicateTopic())){
                dao.save(IBeanConverter.CommunicationIBeantoEntity(iBean, Calendar.getInstance().getTimeInMillis()));
                carrier.setInfo("N01","发帖成功");
            }else {
                carrier.setInfo("E01", "请勿重复发帖");
            }
        }else {
            carrier.setInfo("E02", "用户验证错误，请重新登陆");
        }
        return carrier;
    }

    @RequestMapping(value="/delcommunication.do",method= RequestMethod.POST)
    @ResponseBody
    public OBeanBase delCommunication(@RequestBody CommunicationDeIBean iBean){
        OBeanBase carrier =new OBeanBase();
        if (userpool.checkUser(iBean)) {
            if (CommunicationisExsit(iBean.getCommunicateId())) {
                if (checkAccount(iBean.getAccount(), iBean.getCommunicateId())) {
                    deletCommunicateInfo(iBean);
                    carrier.setInfo("N01", "删除成功");
                } else {
                    carrier.setInfo("E01", "没有权限删除他人帖子");
                }
            } else {
                carrier.setInfo("E03", "帖子序号错误");
            }
        }else {
            carrier.setInfo("E02", "用户验证错误，请重新登陆");
        }
        return carrier;
    }
    @RequestMapping(value="/updatecommunication.do",method= RequestMethod.POST)
    @ResponseBody
    public OBeanBase updateCommunication(@RequestBody CommunicationUpIBean iBean){
        OBeanBase carrier =new OBeanBase();
        if (userpool.checkUser(iBean)) {
            if(CommunicationisExsit(iBean.getCommunicateId())){
                if (checkAccount(iBean.getAccount(), iBean.getCommunicateId())) {
                    if(!isRepeat(iBean.getCommunicateId(),iBean.getAccount(),iBean.getCommunicateTopic())){
                        updateCommunicateInfo(iBean);
                        carrier.setInfo("N01","修改成功");
                    }else {
                        carrier.setInfo("E04","标题重复");
                    }
                }else {
                    carrier.setInfo("E01", "没有权限更新他人帖子");
                }
            }else {
                carrier.setInfo("E03", "帖子序号错误");
            }
        }else {
            carrier.setInfo("E02", "用户验证错误，请重新登陆");
        }
        return carrier;
    }


    @RequestMapping(value="/uploadpic.do",method= RequestMethod.POST)
    @ResponseBody
    public OBeanBase uploadUserPic(@RequestParam(value = "file", required = true) MultipartFile file,
                                   HttpServletRequest request){
        OBeanBase carrier =new OBeanBase();
        String account=request.getParameter("account");
        String sessionId=request.getParameter("sessionId");
        if(userpool.checkUser(account,sessionId)){
            if (UploadUtil.isImageByName(file.getOriginalFilename())) {
                String path = request.getSession().getServletContext().getRealPath("/RESOURCES/images/Communication_Picture");
                String fileName = new Date().getTime() +"."+ account + ".jpg";
                File targetFile = new File(path, fileName);
                if (!targetFile.exists()) {
                    targetFile.mkdirs();
                }
                try {
                    file.transferTo(targetFile);
                } catch (Exception e) {
                    e.printStackTrace();
                    carrier.setInfo("E01", "上传失败，请注意图片不超过10M");
                    return carrier;
                }
                carrier.setInfo("N01", "上传成功");
                carrier.setContents(new UploadOBean(fileName));
            } else {
                carrier.setInfo("E01", "不是图片格式文件");
            }
        }else {
            carrier.setInfo("E02", "用户验证错误，请重新登陆");
        }
        return carrier;
    }

    @Transactional
    public void deletCommunicateInfo(CommunicationDeIBean iBean){
        commentInfoDAO.deleteByCommunicationId(iBean.getCommunicateId());
        dao.delete(iBean.getCommunicateId());
    }

    @Transactional
    public void updateCommunicateInfo(CommunicationUpIBean iBean){
        CommunicationInfo bean=dao.findById(iBean.getCommunicateId());
        bean.setCommunicateTopic(iBean.getCommunicateTopic());
        bean.setCommunitcateContent(iBean.getCommunitcateContent());
        List<String> list =iBean.getPictureList();
        if(list!=null){
            StringBuffer pic=new StringBuffer();
            for(int i=0;list!=null&&i <list.size();i++){
                String string=list.get(i).trim();
                if(string.equals("") )continue;
                pic.append(string);
                if(i!=list.size()-1) pic.append(",");
            }
            if (!pic.toString().trim().equals("")) bean.setPictureAttached(pic.toString().trim());
        }else {
            bean.setPictureAttached(null);
        }
        dao.update(bean);
    }
    public boolean checkAccount(String account,int communicationId){
        CommunicationInfo bea=dao.findById(communicationId);
        return bea.getUserInfo().getUserName().equals(account);
    }

    public boolean CommunicationisExsit(int communicationId){
        CommunicationInfo bean=dao.findById(communicationId);
        return bean!=null;
    }

    public boolean isRepeat(String account,String communicationTop){
        long count=dao.getCount(account,communicationTop);
        return count!=0?true:false;
    }

    public boolean isRepeat(int communicationId,String account,String communicationTop){
        long count=dao.getCountExpectbyId(communicationId,account,communicationTop);
        return count!=0?true:false;
    }
}
