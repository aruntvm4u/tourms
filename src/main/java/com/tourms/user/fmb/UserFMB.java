package com.tourms.user.fmb;
import com.tourms.user.service.UserService;
import com.tourms.user.vo.UserVO;
import com.tourms.utils.MappingResultEnum;
import org.springframework.dao.DataAccessException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by aruntvmu on //.
 */
@ManagedBean(name = "userFMB")
@RequestScoped
public class UserFMB implements Serializable {

    private static final long serialVersionUID = 396119487006343628L;
    //Spring User Service is injected...
    @ManagedProperty(value = "#{UserService}")
    UserService userService;
    List<UserVO> customerList;
    private int id;
    private String name;
    private String surname;
    /**
     * Add User
     *
     * @return String - Response Message
     */
    public String addUser() {
        try {
            UserVO customer = new UserVO();
            customer.setId(getId());
            customer.setName(getName());
            customer.setSurname(getSurname());
            //getUserService().addUser(customer);
            getUserService().addUser(customer);
            return MappingResultEnum.SUCCESS.toString();

        } catch (DataAccessException
                e) {
            e.printStackTrace();

        }
        return MappingResultEnum.ERROR.toString();

    }
    /**
     * Reset Fields
     */
    public void reset() {
        this.setId(0);
        this.setName("");
        this.setSurname("");

    }
    /**
     * Get User List
     *
     * @return List - User List
     */
    public List<UserVO> getUserList() {
        customerList = new ArrayList<UserVO>();
        customerList.addAll(getUserService().getUsers());
        return customerList;

    }
    /**
     * Get User Service
     *
     * @return IUserService - User Service
     */
    public UserService getUserService() {
        return userService;

    }
    /**
     * Set User Service
     *
     * @param userService IUserService - User Service
     */
    public void setUserService(UserService userService) {
        this.userService = userService;

    }
    /**
     * Set User List
     *
     * @param customerList List - User List
     */
    public void setUserList(List<UserVO> customerList) {
        this.customerList = customerList;

    }
    /**
     * Get User Id
     *
     * @return int - User Id
     */
    public int getId() {
        return id;

    }
    /**
     * Set User Id
     *
     * @param id int - User Id
     */
    public void setId(int id) {
        this.id = id;

    }
    /**
     * Get User Name
     *
     * @return String - User Name
     */
    public String getName() {
        return name;

    }
    /**
     * Set User Name
     *
     * @param name String - User Name
     */
    public void setName(String name) {
        this.name = name;

    }
    /**
     * Get User Surname
     *
     * @return String - User Surname
     */
    public String getSurname() {
        return surname;

    }
    /**
     * Set User Surname
     *
     * @param surname String - User Surname
     */
    public void setSurname(String surname) {
        this.surname = surname;

    }

}


