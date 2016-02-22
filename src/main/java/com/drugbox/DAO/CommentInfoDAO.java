package com.drugbox.DAO;

import com.drugbox.Entity.CommentInfo;
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
public class CommentInfoDAO {
    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    @Transactional(readOnly = false)
    public void update(CommentInfo entity) {
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
    public void save(CommentInfo entity) {
        this.getSession().save(entity);
    }
    @Transactional(readOnly = false)
    public void deleteByActComid(String account,int commentId){
        Query q= this.getSession().createQuery("delete from CommentInfo where userInfo.userName=? and commentId=?");
        q.setParameter(0,account);
        q.setParameter(1,commentId);
        q.executeUpdate();
    }

    public CommentInfo findById(Serializable id) {
        return (CommentInfo) this.getSession().get(CommentInfo.class, id);
    }

    public List<CommentInfo> findByHQL(String hql, Object... params) {
        Query query = this.getSession().createQuery(hql);
        for (int i = 0; params != null && i < params.length; i++) {
            query.setParameter(i, params);
        }
        return query.list();
    }

    public List<CommentInfo> getList (int communicationID,int first, int capacity) {
        Query query = this.getSession().createQuery("from CommentInfo where communicationInfo ="+communicationID);
        query.setFirstResult(first);
        query.setMaxResults(capacity);
        return query.list();
    }
    public long getAllCount (int communicationID) {
        String hql = "select count(*) from CommentInfo where communicationInfo ="+communicationID;
        Query query = this.getSession().createQuery(hql);
        return ((Long)query.uniqueResult()).intValue();
    }
}
