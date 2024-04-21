package com.mc.mcsq.controller;

import com.mc.mcsq.common.api.ApiResult;
import com.mc.mcsq.model.dto.UmsDeptDto;
import com.mc.mcsq.service.UmsDeptService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class UmsDeptController {
    @Resource
    UmsDeptService umsDeptService;

    @RequestMapping(value = "/getTree",method = RequestMethod.GET)
    public ApiResult<List<UmsDeptDto>> getSq(){
        List<UmsDeptDto> tree = umsDeptService.getTree();
        return ApiResult.success(tree);
    }
}
