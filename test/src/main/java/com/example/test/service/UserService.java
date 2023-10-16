package com.example.test.service;

import com.example.test.bean.UserBean;
import org.apache.ibatis.annotations.Param;

public interface UserService {

    UserBean loginIn(String name, String password);

}