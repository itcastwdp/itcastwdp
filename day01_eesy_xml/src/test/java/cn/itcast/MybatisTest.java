package cn.itcast;


import cn.itcast.dao.IUserDao;
import cn.itcast.domain.User;
import cn.itcast.domain.Users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;


public class MybatisTest {

    private InputStream is;
    private SqlSessionFactoryBuilder builder;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before
    public void init() throws IOException {
        //1.读取配置文件
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory的构建者对象
        builder = new SqlSessionFactoryBuilder();
        //3.使用构建者创建SqlSessionFactory对象
        factory = builder.build(is);
        //4.使用SqlSessionFactory生产SqlSession
        sqlSession = factory.openSession();
        //5.使用SqlSession创建dao接口的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destory() throws IOException {
        //提交事务
        sqlSession.commit();
        //7.释放资源
        sqlSession.close();
        is.close();
    }

    @Test
    public void testFindAll() {
        //6.使用代理对象执行查询方法
        List<User> userList = userDao.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindById() {
        User user = userDao.findById(41);
        System.out.println(user);
    }

    @Test
    public void testAddUser() {
        User user=new User();
        user.setUsername("测试");
        user.setBirthday(new Date());
        user.setAddress("武汉");
        user.setSex('男');
        userDao.addUser(user);

    }

    @Test
    public void testFindAllUsers() {
        //6.使用代理对象执行查询方法
        List<Users> userList = userDao.findAllUsers();
        for (Users user : userList) {
            System.out.println(user);
        }
    }
}
