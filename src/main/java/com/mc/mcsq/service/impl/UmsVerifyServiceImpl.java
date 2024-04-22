package com.mc.mcsq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mc.mcsq.mapper.UmsVerifyMapper;
import com.mc.mcsq.model.entity.UmsUser;
import com.mc.mcsq.model.entity.UmsVerify;
import com.mc.mcsq.service.UmsVerifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UmsVerifyServiceImpl extends ServiceImpl<UmsVerifyMapper, UmsVerify>
        implements UmsVerifyService {
    @Override
    public List<UmsVerify> getByTypeAndLeader(String verifyType, UmsUser leader) {
        log.info(verifyType,leader.getId());
        return baseMapper.getByTypeAndLeader(verifyType,leader.getId());
    }
}
