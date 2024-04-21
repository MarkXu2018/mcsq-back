package com.mc.mcsq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mc.mcsq.mapper.BmsBillboardMapper;
import com.mc.mcsq.model.entity.BmsBillboard;
import com.mc.mcsq.service.IBmsBillboardService;
import org.springframework.stereotype.Service;

@Service
public class IBmsBillboardServiceImpl extends ServiceImpl<BmsBillboardMapper
        , BmsBillboard> implements IBmsBillboardService {

}
