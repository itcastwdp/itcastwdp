package cn.itcast.dao;

import cn.itcast.domain.User;
import cn.itcast.domain.Users;

import java.util.List;

public interface IUserDao {
    //查询所有用户
    List<User> findAll();
    List<Users> findAllUsers();
    User findById(int id);
    void addUser(User user);
    List<User> findByCondition(User user);
}
