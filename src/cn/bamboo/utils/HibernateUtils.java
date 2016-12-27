package cn.bamboo.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * hibernate工具类
 * Created by p1411 on 2016/12/26.
 */
public class HibernateUtils {
    private static final Configuration cfg;
    private static final SessionFactory sessionFactory;

    //静态代码块实现
    static {
        //加载核心配置文件
        cfg = new Configuration().configure();
        sessionFactory = cfg.buildSessionFactory();
    }

    //提供方法返回sessionFactory
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
