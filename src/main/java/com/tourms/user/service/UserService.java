package com.tourms.user.service;
import com.tourms.user.dao.UserDAO;
import com.tourms.user.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * Created by aruntvmu on //.
 */
@Service("UserService")
@Transactional(readOnly = true)
public class UserService {
    // UserDAO is injected...
    @Autowired
    UserDAO userDao;
    /**
     * Add User
     *
     * @param customer User
     */
    @Transactional(readOnly = false)
    public void addUser(UserVO customer) {
        getUserDAO().addUser(customer);

    }
    /**
     * Delete User
     *
     * @param customer User
     */
    @Transactional(readOnly = false)
    public void deleteUser(UserVO customer) {
        getUserDAO().deleteUser(customer);

    }
    /**
     * Update User
     *
     * @param customer User
     */
    @Transactional(readOnly = false)
    public void updateUser(UserVO customer) {
        getUserDAO().updateUser(customer);

    }
    /**
     * Get User
     *
     * @param id int User Id
     */
    public UserVO getUserById(int id) {
        return getUserDAO().getUserById(id);

    }
    /**
     * Get User List
     */
    public List<UserVO> getUsers() {
        return getUserDAO().getUsers();

    }
    /**
     * Get User DAO
     *
     * @return userDao - User DAO
     */
    public UserDAO getUserDAO() {
        return userDao;

    }
    /**
     * Set User DAO
     *
     * @param userDao - UserDAO
     */
    public void setUserDAO(UserDAO userDao) {
        this.userDao = userDao;

    }

}

