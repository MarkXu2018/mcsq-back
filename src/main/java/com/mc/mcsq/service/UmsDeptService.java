package com.mc.mcsq.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mc.mcsq.model.dto.UmsDeptDto;
import com.mc.mcsq.model.entity.UmsDept;

import java.util.List;

public interface UmsDeptService extends IService<UmsDept> {
    List<UmsDeptDto> getTree();
}
