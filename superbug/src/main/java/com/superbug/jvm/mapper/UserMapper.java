package com.superbug.jvm.mapper;

import com.superbug.jvm.po.UserBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * user
 * UserMapper
 * @author 
 *
 */
 @Mapper
public interface UserMapper
{
    void insert(UserBean userBean);
	List<UserBean> getUserList(Map<String,Object> param);
}
