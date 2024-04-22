package com.mc.mcsq.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mc.mcsq.model.entity.UmsUser;
import com.mc.mcsq.model.entity.UmsVerify;

import java.util.List;

public interface UmsVerifyService extends IService<UmsVerify> {
    List<UmsVerify> getByTypeAndLeader(String verifyType, UmsUser leader);
}
