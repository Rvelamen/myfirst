package com.rvelamen.springmvc.service;

import com.rvelamen.springmvc.pojo.Admin;

/**
 * Created by 林继锐 on 2018/10/12.
 */
public interface LoginService {
    /**
     * 登录检测
     * @param admin
     * @return
     */
    boolean check(Admin admin);

    /**
     * 查看用户名是否存在
     */
    boolean check1(String adminName);
}
