package com.drugbox.DAO;

import com.drugbox.Entity.CommunicationInfo;
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
}
