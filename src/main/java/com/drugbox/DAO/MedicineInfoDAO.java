package com.drugbox.DAO;

import com.drugbox.Entity.MedicineInfo;
import com.drugbox.Util.DataEncoder;
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
public class MedicineInfoDAO {
    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    @Transactional(readOnly = false)
    public void update(MedicineInfo entity) {
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
    public void save(MedicineInfo entity) {
        this.getSession().save(entity);
    }


    public MedicineInfo findById(Serializable id) {
        return (MedicineInfo) this.getSession().get(MedicineInfo.class, id);
    }

    public List<MedicineInfo> findByHQL(String hql, Object... params) {
        Query query = this.getSession().createQuery(hql);
        for (int i = 0; params != null && i < params.length; i++) {
            query.setParameter(i, params);
        }
        return query.list();
    }
    public List<MedicineInfo> findMedicineListByname (String name) {
        Query query = this.getSession().createQuery("from MedicineInfo where medicineName like ?").setParameter(0,"%"+ name +"%");
        return query.list();
    }

    @Test
    public void getTitleListTest () {

//        Query query = this.getSession().createQuery("from MedicineInfo where medicineName like ?").setParameter(0,"%太极%");
//        List<MedicineInfo> list=query.list();
//        System.out.println(list.size());
//        for(MedicineInfo m:list){
//            System.out.println(m.getMedicineName());
//        }
//
//        Query query1 = this.getSession().createQuery("from MedicineInfo where medicineId like ?").setParameter(0,"%H44%");
//        List<MedicineInfo> list1=query1.list();
//        System.out.println(list1.size());
//        for(MedicineInfo m:list1){
//            System.out.println(m.getMedicineName());
//        }
        MedicineInfo bean =new MedicineInfo();
        bean.setMedicineId("fffff");
        save(bean);

//        String hql = "select count(*) from CommunicationInfo";
//        Query query2 = this.getSession().createQuery(hql);
//        System.out.println(((Long)query2.uniqueResult()).intValue());
    }
}
