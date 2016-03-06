package com.drugbox.DAO;

import com.drugbox.Entity.CommunicationInfo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 44247 on 2016/2/4 0004.
 */
@Transactional
@Component
@RunWith(SpringJUnit4ClassRunner.class) // 整合
@ContextConfiguration(locations="classpath:applicationContext.xml") // 加载配置
public class CommunicationInfoDAO {
    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    @Transactional(readOnly = false)
    public void update(CommunicationInfo entity) {
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
    public void save(CommunicationInfo entity) {
        this.getSession().save(entity);
    }


    public CommunicationInfo findById(Serializable id) {
        return (CommunicationInfo) this.getSession().get(CommunicationInfo.class, id);
    }

    public List<CommunicationInfo> findByHQL(String hql, Object... params) {
        Query query = this.getSession().createQuery(hql);
        for (int i = 0; params != null && i < params.length; i++) {
            query.setParameter(i, params);
        }
        return query.list();
    }

    public List<CommunicationInfo> getTitleList (int first,int capacity) {
        Query query = this.getSession().createQuery("from CommunicationInfo ");
        query.setFirstResult(first);
        query.setMaxResults(capacity);
        return query.list();
    }

    public List<CommunicationInfo> getTitleListByUser (int first,int capacity,String user) {
        Query query = this.getSession().createQuery("from CommunicationInfo where userInfo.userName=?");
        query.setParameter(0,user);
        query.setFirstResult(first);
        query.setMaxResults(capacity);
        return query.list();
    }

    public long getAllCountByUser (String user) {
        Query query = this.getSession().createQuery("select count(*) from CommunicationInfo  where userInfo.userName=?");
        query.setParameter(0,user);
        return ((Long)query.uniqueResult()).intValue();
    }
    public long getAllCount () {
        String hql = "select count(*) from CommunicationInfo ";
        Query query = this.getSession().createQuery(hql);
        return ((Long)query.uniqueResult()).intValue();
    }
    public long getCount (String account,String topic) {
        String hql = "select count(*) from CommunicationInfo where userInfo.userName=? and communicateTopic=?";
        Query query = this.getSession().createQuery(hql);
        query.setParameter(0,account);
        query.setParameter(1,topic);
        return ((Long)query.uniqueResult()).intValue();
    }

    public long getCountExpectbyId (int id,String account,String topic) {
        String hql = "select count(*) from CommunicationInfo where userInfo.userName=? and communicateTopic=? and communicateId!=?";
        Query query = this.getSession().createQuery(hql);
        query.setParameter(0,account);
        query.setParameter(1,topic);
        query.setParameter(2,id);
        return ((Long)query.uniqueResult()).intValue();
    }
}
