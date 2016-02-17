package com.tourms.user.dao;
import com.tourms.user.vo.UserVO;

import java.util.List;
/**
 * Created by aruntvm4u on 2/7/2016.
 */
public interface UserDAO {
    void addUser(UserVO customer);
    void deleteUser(UserVO customer);
    void updateUser(UserVO customer);
    UserVO getUserById(int id);
    List<UserVO> getUsers();
}
