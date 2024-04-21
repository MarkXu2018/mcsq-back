package com.mc.mcsq.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mc.mcsq.mapper.UmsDeptMapper;
import com.mc.mcsq.model.dto.UmsDeptDto;
import com.mc.mcsq.model.entity.UmsDept;
import com.mc.mcsq.service.UmsDeptService;
import com.mc.mcsq.utils.DeptTreeUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UmsDeptServiceImpl extends ServiceImpl<UmsDeptMapper, UmsDept>
        implements UmsDeptService {
    @Override
    public List<UmsDeptDto> getTree() {
        LambdaQueryWrapper<UmsDept> queryWrapper=new LambdaQueryWrapper<>();
        //获取当前开放的小区
        queryWrapper.eq(UmsDept::getStatus,'1');
        List<UmsDept> list = this.list(queryWrapper);
        List<UmsDeptDto> treeList = DeptTreeUtils.convertToTree(list, 100L);
        return treeList;

    }
}
