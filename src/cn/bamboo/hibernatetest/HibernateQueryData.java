package cn.bamboo.hibernatetest;

import cn.bamboo.entity.User;
import cn.bamboo.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.List;

/**
 * Created by p1411 on 2016/12/27.
 * 查询测试类
 */
public class HibernateQueryData {
    //使用Criteria
    @Test
    public void testCriteria() {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        try {
            //获取与本地绑定的session
            sessionFactory = HibernateUtils.getSessionFactory();
            session = HibernateUtils.getSessionObject();
            //开启事务
            transaction = session.beginTransaction();

            //1、创建Query对象
            Query query=session.createQuery("from User");
            //2、调用Query对象里面的方法得到结果
            List<User> list=query.list();
            for (User user: list) {
                System.out.println(user);
            }

            //提交事务
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            sessionFactory.close();
        }
    }
    //使用Query
    @Test
    public void testQuery() {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        try {
            //获取与本地绑定的session
            sessionFactory = HibernateUtils.getSessionFactory();
            session = HibernateUtils.getSessionObject();
            //开启事务
            transaction = session.beginTransaction();

            //1、创建Query对象
            Query query=session.createQuery("from User");
            //2、调用Query对象里面的方法得到结果
            List<User> list=query.list();
            for (User user: list) {
                System.out.println(user);
            }
            
            //提交事务
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            sessionFactory.close();
        }
    }
}
