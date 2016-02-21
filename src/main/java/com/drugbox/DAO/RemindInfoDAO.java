package com.drugbox.DAO;

import com.drugbox.Entity.MedicineInfo;
import com.drugbox.Entity.RemindInfo;
import com.drugbox.Entity.UserInfo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;


/**
 * Created by 44247 on 2016/2/4 0004.
 */
@Transactional
@Component
@RunWith(SpringJUnit4ClassRunner.class) // 整合
@ContextConfiguration(locations="classpath:applicationContext.xml") // 加载配置
public class RemindInfoDAO {
    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    @Transactional(readOnly = false)
    public void update(RemindInfo entity) {
        this.getSession().update(entity);
    }

    @Transactional(readOnly = false)
    public void delete(Serializable id) {
        this.getSession().delete(this.findById(id));
    }

    public Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }
    @Transactional(readOnly = false)
    public void save(RemindInfo entity) {
        this.getSession().save(entity);
    }
    @Transactional(readOnly = false)
    public void saveList(List<RemindInfo> list){
        RemindInfo remindInfo;
        Session session=this.getSession();
        for (int i = 0; i < list.size(); i++) {
            remindInfo = (RemindInfo) list.get(i); // 获取药品
            session.save(remindInfo); // 保存药品对象
            // 批插入的对象立即写入数据库并释放内存
            if (i % 10 == 0) {
                session.flush();
                session.clear();
            }
        }
    }
    @Transactional(readOnly = false)
    public void deleteByAccount(String account){
        Query q= this.getSession().createQuery("delete from RemindInfo where userInfo.userName=?");
        q.setParameter(0,account);
        q.executeUpdate();
    }
    public RemindInfo findById(Serializable id) {
        return (RemindInfo) this.getSession().get(RemindInfo.class, id);
    }

    public List<RemindInfo> findByHQL(String hql, Object... params) {
        Query query = this.getSession().createQuery(hql);
        for (int i = 0; params != null && i < params.length; i++) {
            query.setParameter(i, params);
        }
        return query.list();
    }

    public List<RemindInfo> getList (String userName) {
        Query query = this.getSession().createQuery("from RemindInfo where userInfo.userName = ?");
        query.setParameter(0,userName);
        return query.list();
    }
    public long getAllCount (String userName) {
        String hql = "select count(*) from RemindInfo where userInfo.userName = ?";
        Query query = this.getSession().createQuery(hql);
        query.setParameter(0,userName);
        return ((Long)query.uniqueResult()).intValue();
    }
}
