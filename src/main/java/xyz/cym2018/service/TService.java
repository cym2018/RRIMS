package xyz.cym2018.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public abstract class TService<T> {
    String HQL;
    Object[] values;
    private Logger logger = LogManager.getLogger(TService.class);
    @Autowired
    Base base;
    Session session;

    TService() {
        base = new Base();
        session = base.getSession();
    }

    // 增
    public boolean Creat(T Object) {
        try {
            session.beginTransaction();
            session.save(Object);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            logger.warn("Save()");
            e.printStackTrace();
            return false;
        }
    }

    // 删
    public boolean Delete(T Object) {
        try {
            session.beginTransaction();
            session.delete(Object);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            logger.warn("Delete()");
            e.printStackTrace();
            return false;
        }
    }

    //     改
    public boolean Update(T Object) {
        try {
            session.beginTransaction();
            session.saveOrUpdate(Object);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            logger.warn("Update()");
            e.printStackTrace();
            return false;
        }
    }


    List QueryList() {
        try {
            Query query = session.createQuery(HQL);
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i + 1, values[i]);
            }
            logger.info(HQL + Arrays.toString(values));
            return query.getResultList();
        } catch (Exception e) {
            logger.warn("HQLQueryList()" + HQL + Arrays.toString(values));
            return new ArrayList();
        }
    }


    T QueryObject() {
        try {
            Query query = session.createQuery(HQL);
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i + 1, values[i]);
            }
            logger.info(HQL + Arrays.toString(values));
            //noinspection unchecked
            return (T) query.getSingleResult();
        } catch (Exception e) {
            logger.warn("QueryObject()" + HQL + Arrays.toString(values));
            return null;
        }
    }

}
