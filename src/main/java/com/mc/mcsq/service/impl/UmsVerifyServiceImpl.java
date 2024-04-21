package com.mc.mcsq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mc.mcsq.mapper.UmsVerifyMapper;
import com.mc.mcsq.model.entity.UmsVerify;
import com.mc.mcsq.service.UmsVerifyService;
import org.springframework.stereotype.Service;

@Service
public class UmsVerifyServiceImpl extends ServiceImpl<UmsVerifyMapper, UmsVerify>
        implements UmsVerifyService {
}
