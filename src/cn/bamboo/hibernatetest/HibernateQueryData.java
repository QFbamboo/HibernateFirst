package cn.bamboo.hibernatetest;

import cn.bamboo.entity.User;
import cn.bamboo.utils.HibernateUtils;
import org.hibernate.*;
import org.junit.Test;

import java.util.List;

/**
 * Created by p1411 on 2016/12/27.
 * 查询测试类
 */
public class HibernateQueryData {

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
            Query query = session.createQuery("from User");
            //2、调用Query对象里面的方法得到结果
            List<User> list = query.list();
            for (User user : list) {
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

            //1、创建Criteria对象,方法里面的参数是实体类class
            Criteria criteria = session.createCriteria(User.class);
            //2、调用Criteria对象里面的方法得到结果
            List<User> list = criteria.list();
            for (User user : list) {
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

    //使用SqlQuery
    @Test
    public void testSqlQuery() {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        try {
            //获取与本地绑定的session
            sessionFactory = HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            //开启事务
            transaction = session.beginTransaction();

            //1,创建对象
            SQLQuery sqlQuery = session.createSQLQuery("select * from t_user");
            //调用sqlQuery里面的方法，返回list集合，默认里面拿到的每部分是数组结构
//            List<Object[]> list = sqlQuery.list();
//            for (Object[] object : list) {
//                System.out.println(Arrays.toString(object));
//            }

            //返回中的每部分都是对象的形式
            sqlQuery.addEntity(User.class);
            List<User> list = sqlQuery.list();
            for (User user : list) {
                System.out.println(user);
            }

            //提交事务
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
            sessionFactory.close();

        }
    }
}
