package com.mc.mcsq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mc.mcsq.model.entity.BmsTip;
import org.springframework.stereotype.Repository;

@Repository
public interface BmsTipMapper extends BaseMapper<BmsTip> {
    BmsTip getRandomTip();
}
