package com.demo.service.impl;

import com.demo.dao.UserMapper;
import com.demo.model.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.apache.ibatis.session.SqlSessionFactory;
import java.util.List;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService{
    private SqlSessionFactory sqlSessionFactory;
    @Autowired
    @Qualifier("userMapper")
    private UserMapper userDAO;
     
    public int insertUser(User user) {
        // TODO Auto-generated method stub
        return 0;
    }

    public List<User> userList() {
        return userDAO.selectList();
    }

    public void deleteById(int id) {

    }
   /* public List<User> userList(){
        return userDAO.list();
    }

    public void deleteById(int id) {
        userDAO.deleteById(id);
    }*/

    public User findById(int id) {
        return  userDAO.selectByPrimaryKey(id);
    }

    public void updateUser(User user) {
        userDAO.updateByPrimaryKeySelective(user);
    }

    public User findByAccount(String account) {
        return userDAO.getUserByAccount(account);
    }

    public Set<String> getRolesName() {
        return userDAO.getRoleName();
    }

/*
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }*/

}