package com.mc.mcsq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mc.mcsq.model.entity.UmsUser;
import com.mc.mcsq.model.entity.UmsVerify;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UmsVerifyMapper extends BaseMapper<UmsVerify> {
    List<UmsVerify> getByTypeAndLeader(String verifyType, String leaderId);
}
