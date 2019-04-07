package com.superbug.jvm.po;

import java.io.Serializable;
import java.util.Date;

/**
 * user
 * UserHolder
 * @author
 */
public class UserBean implements Serializable
{

	//fields
    private Integer id;
    private String name;
    private Integer sex;
    private String phone;
    private String userName;
    private String passWord;
    private String idCard;
    private String address;
    private Integer del;
    private java.util.Date createAt;
    private java.util.Date updateAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public String getName() {
        return name;
    }

    public Integer getSex() {
        return sex;
    }

    public String getPhone() {
        return phone;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getIdCard() {
        return idCard;
    }

    public String getAddress() {
        return address;
    }

    public Integer getDel() {
        return del;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", idCard='" + idCard + '\'' +
                ", address='" + address + '\'' +
                ", del=" + del +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
