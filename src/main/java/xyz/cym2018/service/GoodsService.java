package xyz.cym2018.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;
import xyz.cym2018.DAO.Base;
import xyz.cym2018.DAO.Goods;

import java.util.List;

@SuppressWarnings("JpaQlInspection")
@Service
public class GoodsService {
    private Logger logger = LogManager.getLogger(GoodsService.class);

    GoodsService() {
        logger.info("GoodsService(0)");
    }

    public List findByShopID(int id) {
        Session session = Base.getSession();
        String hql = "from xyz.cym2018.DAO.Goods where shopid=?1 and state=0";
        Query query = session.createQuery(hql, Goods.class);
        query.setParameter(1, id);
        return query.list();
    }
    public Goods findByGoodsID(int id){
        Session session = Base.getSession();
        String hql = "from xyz.cym2018.DAO.Goods where goodsid=?1";
        Query query = session.createQuery(hql, Goods.class);
        query.setParameter(1, id);
        return (Goods) query.getSingleResult();
    }

    public boolean save(Goods goods) {
        Session session = Base.getSession();
        session.beginTransaction();
        try {
            session.save(goods);
            session.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    public boolean update(Goods goods){
        Session session = Base.getSession();
        session.beginTransaction();
        try {
            session.update(goods);
            session.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
