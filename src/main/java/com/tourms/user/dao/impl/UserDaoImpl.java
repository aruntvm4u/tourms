package com.tourms.user.dao.impl;
import com.tourms.user.vo.UserVO;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * Created by aruntvmu on //.
 */
@Repository
public class UserDaoImpl implements com.tourms.user.dao.UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Add user
     *
     * @param userVO user
     */
    @Override
    public void addUser(UserVO userVO) {
        this.sessionFactory.getCurrentSession().save(userVO);
    }
    /**
     * Delete user
     *
     * @param userVO user
     */
    @Override
    public void deleteUser(UserVO userVO) {
        this.sessionFactory.getCurrentSession().delete(userVO);
    }
    /**
     * Update user
     *
     * @param userVO user
     */
    @Override
    public void updateUser(UserVO userVO) {
        this.sessionFactory.getCurrentSession().update(userVO);
    }
    /**
     * Get user
     *
     * @param id int
     * @return user
     */
    @Override
    public UserVO getUserById(int id) {
        return (UserVO)this.sessionFactory.getCurrentSession()
                .createCriteria(UserVO.class).add(Restrictions.eq("id", id)).uniqueResult();
    }
    /**
     * Get user List
     *
     * @return List - user list
     */
    @Override
    public List<UserVO> getUsers() {
        return this.sessionFactory.getCurrentSession().createCriteria(UserVO.class).list();
    }

}