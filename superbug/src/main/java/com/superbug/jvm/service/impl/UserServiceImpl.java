package com.superbug.jvm.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.superbug.jvm.mapper.UserMapper;
import com.superbug.jvm.service.UserService;
 /**
 * user
 * UserService
 * @author
 */
@Service
public class UserServiceImpl implements UserService
{
    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
    private UserMapper mapper;


}
