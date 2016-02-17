package com.tourms.user.vo;
import javax.persistence.*;
import java.io.Serializable;
/**
 * Created by aruntvmu on //.
 */
@Entity
@Table(name = "users")
public class UserVO implements Serializable {

    private static final long serialVersionUID = -9124674840419228816L;
    private Integer id;
    private String name;
    private String surname;
    private String role;
    /**
     * Get User Id
     *
     * @return int - User Id
     */
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;

    }
    /**
     * Set User Id
     *
     * @param id int - User Id
     */
    public void setId(Integer id) {
        this.id = id;

    }
    /**
     * Get User Name
     *
     * @return String - User Name
     */
    @Column(name = "name", unique = true, nullable = false)
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
    @Column(name = "surname", unique = true, nullable = false)
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
    @Transient
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    @Override
    public String toString() {
        StringBuffer strBuff = new StringBuffer();
        strBuff.append("id : ").append(getId());
        strBuff.append(", name : ").append(getName());
        strBuff.append(", surname : ").append(getSurname());
        return strBuff.toString();

    }

}
