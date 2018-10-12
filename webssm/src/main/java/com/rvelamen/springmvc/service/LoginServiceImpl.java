package com.rvelamen.springmvc.service;

import com.rvelamen.springmvc.mapper.AdminMapper;
import com.rvelamen.springmvc.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 林继锐 on 2018/10/12.
 */
@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public boolean check(Admin admin) {
        int num = this.adminMapper.countByAdmin(admin);
        System.out.println(num);
        if(num==1){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 异步查看是否存在用户
     */
    @Override
    public boolean check1(String adminName){
        int num = this.adminMapper.countByAdminName(adminName);
        if(num>0){
            return true;
        }else{
            return false;
        }
    }
}
