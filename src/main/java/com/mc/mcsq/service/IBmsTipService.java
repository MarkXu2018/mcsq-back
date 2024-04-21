package com.mc.mcsq.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mc.mcsq.model.entity.BmsTip;

public interface IBmsTipService extends IService<BmsTip> {
    BmsTip getRandomTip();
}
