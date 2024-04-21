package com.mc.mcsq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mc.mcsq.mapper.BmsFollowMapper;
import com.mc.mcsq.model.entity.BmsFollow;
import com.mc.mcsq.service.IBmsFollowService;
import org.springframework.stereotype.Service;


@Service
public class IBmsFollowServiceImpl extends ServiceImpl<BmsFollowMapper, BmsFollow> implements IBmsFollowService {
}
