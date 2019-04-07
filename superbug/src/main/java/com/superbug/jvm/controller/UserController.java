package com.superbug.jvm.controller;

import com.alibaba.fastjson.JSON;
import com.superbug.jvm.mapper.UserMapper;
import com.superbug.jvm.mq.Sender;
import com.superbug.jvm.po.UserBean;
import com.superbug.jvm.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("/api/")
public class UserController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private Sender sender;

    private static int index = 1;
    //用户列表
    @RequestMapping("getUserList")
    public String getUserList(Integer id,Integer open,@RequestParam(value = "size",defaultValue = "10")Integer size,@RequestParam(value = "no",defaultValue = "1")Integer no) {
        Map<String,Object> param = new HashMap<>();
        param.put("id",id);
        param.put("size",size);
        param.put("no",no);
        PageUtil.pageMap(param);
        List<UserBean> list = null;
        if (open == null) {
            list = new ArrayList<>();
        }else {
            list = userMapper.getUserList(param);
        }
        return JSON.toJSONString(list);
    }
    //创建用户
    @RequestMapping("createUser")
    public void createUser(@RequestParam(value = "size",defaultValue = "1")Integer size) {
        Date date = new Date();
        for (int i= 0; i<size;i++){
            UserBean userBean = new UserBean();
            userBean.setName("name" + i);
            userBean.setDel(0);
            userBean.setCreateAt(date);
            userBean.setPassWord("123456");
            userBean.setUserName("userName" + i);
            userBean.setIdCard("545678978978457896");
            userBean.setPhone("12345678968");
            userBean.setAddress("成都市高新区");
            userBean.setSex(1);
            userMapper.insert(userBean);
        }
    }

    //更新缓存
    @RequestMapping("updateCache")
    public void updateCache(HttpServletRequest request,Integer size) {
        Map<String,Object> param = new HashMap<>();
        param.put("size",size);
        param.put("no",1);
        PageUtil.pageMap(param);
        List<UserBean> list = userMapper.getUserList(param);
        request.getSession().getServletContext().setAttribute("userList",list);
    }

    //获取缓存
    @RequestMapping("getCache")
    public String getCache(HttpServletRequest request) {
        //List<UserBean> list = (List<UserBean>)request.getSession().getServletContext().getAttribute("userList");
        return "你好的撒发放沙匪哈佛安徽佛奥哈佛爱上覅好if好烦好烦哈佛好ID是啊的厚爱都好好的大厦电话哦啊或达到红红的红黑殴打和大多数 + " + index++;//JSON.toJSONString(list);
    }

    //使用rabbitmq
    @RequestMapping("testMq")
    public void testMq() {
        /*Map<String,Object> param = new HashMap<>();
        param.put("size",2000);
        param.put("no",1);
        PageUtil.pageMap(param);
        List<UserBean> list = userMapper.getUserList(param);
        for (UserBean userBean : list) {
            sender.send(userBean);
        }*/
        for (int i=0;i<100000;i++) {
            sender.send("aaa " + i);
        }
    }
}
