package com.drugbox.DAO;

import com.drugbox.Entity.PurchaseInfo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;


/**
 * Created by 44247 on 2016/2/4 0004.
 */
@Transactional
@Component
public class PurchaseInfoDAO {
    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    @Transactional(readOnly = false)
    public void update(PurchaseInfo entity) {
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
    public void save(PurchaseInfo entity) {
        this.getSession().save(entity);
    }


    public PurchaseInfo findById(Serializable id) {
        return (PurchaseInfo) this.getSession().get(PurchaseInfo.class, id);
    }

    public List<PurchaseInfo> findByHQL(String hql, Object... params) {
        Query query = this.getSession().createQuery(hql);
        for (int i = 0; params != null && i < params.length; i++) {
            query.setParameter(i, params);
        }
        return query.list();
    }

    public List<PurchaseInfo> getList (String userName,int first,int capacity) {
        Query query = this.getSession().createQuery("from PurchaseInfo where userInfo.userName = ?");
        query.setParameter(0,userName);
        query.setFirstResult(first);
        query.setMaxResults(capacity);
        return query.list();
    }
    public long getAllCount (String userName) {
        String hql = "select count(*) from PurchaseInfo where userInfo.userName = ?";
        Query query = this.getSession().createQuery(hql);
        query.setParameter(0,userName);
        return ((Long)query.uniqueResult()).intValue();
    }
}
