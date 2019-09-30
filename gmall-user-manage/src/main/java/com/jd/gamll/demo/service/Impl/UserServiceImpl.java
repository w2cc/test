package com.jd.gamll.demo.service.Impl;

import com.jd.gamll.demo.bean.UserInfo;
import com.jd.gamll.demo.mapper.UserInfoMapper;
import com.jd.gamll.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    // 调用mapper 层 注意将UserInfoMapper 注入到容器！
    @Autowired
    private UserInfoMapper userInfoMapper;


    @Override
    public List<UserInfo> findAll() {
        return userInfoMapper.selectAll();
    }

    @Override
    public List<UserInfo> findByUserInfo(UserInfo userInfo) {
        //        return userInfoMapper.selectByExample();
        return userInfoMapper.select(userInfo);
    }

    @Override
    public List<UserInfo> findByLoginName(String loginName) {
        // select * from userInfo where loginName like  %loginName%;
        // 构建查询条件
        Example example = new Example(UserInfo.class);
        // 创建查询器
        // 第一个参数表示：实体类的属性 ，不是数据库表的字段名！
        // 第二个参数表示：具体的值
        example.createCriteria().andLike("loginName","%"+loginName+"%");

        return userInfoMapper.selectByExample(example);

    }

    @Override
    public void addUser(UserInfo userInfo) {
        // 添加数据
        userInfoMapper.insertSelective(userInfo);

    }

    @Override
    public void updUser(UserInfo userInfo) {
        // 根据Id 主键修改
        // userInfoMapper.updateByPrimaryKeySelective(userInfo);

        // 根据name 更新
        // update userInfo set loginName=? where name = ?
        // 第一个参数userInfo 表示更新的数据
        // 第二个参数表示更新的条件
        // where name = ?
        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("name",userInfo.getName());

        userInfoMapper.updateByExampleSelective(userInfo,example);
    }

    @Override
    public void delUser(UserInfo userInfo) {
        // 根据主键：delete from userInfo where id = ?
        // userInfoMapper.deleteByPrimaryKey(userInfo);

        // 根据name 删除 delete from userInfo where name = ?
        userInfoMapper.delete(userInfo);

        // 根据id的范围删除 delete from userInfo where id in ?
//        Example example = new Example(UserInfo.class);
//        example.createCriteria().andIn("id",);
//        userInfoMapper.deleteByExample(example);

    }
}
