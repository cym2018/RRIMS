package xyz.cym2018.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

public abstract class SessionOperate {
    private Logger logger = LogManager.getLogger(SessionOperate.class);
    @Autowired
    public HttpSession session;

    protected int getUserID() {
        try {
            return Integer.parseInt(session.getAttribute("userId").toString());
        } catch (Exception e) {
            logger.warn("获取用户id失败");
            return 0;
        }
    }

    int getShopId() {
        try {
            return Integer.parseInt(session.getAttribute("shopId").toString());
        } catch (Exception e) {
            logger.warn("获取店铺id失败");
            return 0;
        }
    }

    void setShopId(int shopId){
        session.setAttribute("shopId", shopId);
    }
    void setUserId(int userId){
        logger.info("set session:userId="+userId);
        session.setAttribute("userId", userId);
    }
}
