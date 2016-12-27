package cn.bamboo.hibernatetest;

import cn.bamboo.entity.User;
import cn.bamboo.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * hibernate测试
 * Created by p1411 on 2016/12/26.
 */
public class HibernateDemo {

    @Test
    public void testAdd() {
        //第一步	加载hibernate核心配置文件
        //在hibernate里面封闭对象,在src下面找到名称是hibernate.cfg.xml
//        Configuration cfg = new Configuration();
//        cfg.configure();

        //第二步	创建SessionFactory对象
        //读取hibernate核心配置文件的内空，创建sessionFactory
        //在过程中，根据映射关系，在配置数据库里面把表创建
//        SessionFactory sessionFactory = cfg.buildSessionFactory();
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        //第三步	使用SessionFactory创建session对象
        //类似于JDBC的连接
        Session session = sessionFactory.openSession();

        //第四步	开启事务
        Transaction transaction = session.beginTransaction();

        //第五步	写具体逻辑CRUD操作
        //添加功能
        User user = new User();
        user.setUsername("宫子");
        user.setAddress("北海道");
        user.setSex("女");
        user.setBirthday("19960414");
        //调用session的方法实现
        session.save(user);

        //第六步	提交事务
        transaction.commit();

        //第七步	关闭资源
        session.close();
        sessionFactory.close();
    }

}
