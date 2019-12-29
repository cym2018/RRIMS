package xyz.cym2018.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import xyz.cym2018.DAO.Goods;

import java.util.List;

@SuppressWarnings("unused")
@Service
public class GoodsService extends TService<Goods> {
    private static Logger logger = LogManager.getLogger(GoodsService.class);

    public GoodsService() {
    }

    public List ShopMenu(int shopId) {
        HQL = "from xyz.cym2018.DAO.Goods where shopid=?1 and state=0";
        values = new Object[]{shopId};
        return QueryList();
    }

    public Goods goodsidQuery(int goodsid) {
        HQL = "from xyz.cym2018.DAO.Goods where goodsid=?1";
        values = new Object[]{goodsid};
        return QueryObject();
    }

    @Override
    public boolean Update(Goods goods) {
        session.beginTransaction();
        Goods before = session.get(Goods.class, goods.getGoodsid());
        before.setState(1);
        session.getTransaction().commit();
        Creat(goods);
        return true;
    }

    @Override
    public boolean Delete(Goods goods) {
        session.beginTransaction();
        goods = session.get(Goods.class, goods.getGoodsid());
        goods.setState(1);
        session.getTransaction().commit();
        return true;
    }

}
