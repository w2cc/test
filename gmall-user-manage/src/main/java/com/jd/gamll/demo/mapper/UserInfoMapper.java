package com.jd.gamll.demo.mapper;

import com.jd.gamll.demo.bean.UserInfo;
import tk.mybatis.mapper.common.Mapper;

// 相当于我们数据库访问层 dao,dao.impl
public interface UserInfoMapper extends Mapper<UserInfo> {
}
