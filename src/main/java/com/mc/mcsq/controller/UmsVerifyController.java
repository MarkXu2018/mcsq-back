package com.mc.mcsq.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mc.mcsq.common.api.ApiResult;
import com.mc.mcsq.model.entity.UmsUser;
import com.mc.mcsq.model.entity.UmsVerify;
import com.mc.mcsq.service.IUmsUserService;
import com.mc.mcsq.service.UmsVerifyService;
import com.mc.mcsq.jwt.JwtUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.util.List;

@RestController
@RequestMapping("/verify")
public class UmsVerifyController {
    @Resource
    UmsVerifyService umsVerifyService;
    @Resource
    IUmsUserService umsUserService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ApiResult<UmsVerify> addVerify(
            @RequestHeader(value = JwtUtil.USER_NAME ) String userName,
            @RequestBody UmsVerify umsVerify){
        UmsUser user = umsUserService.getUserByUsername(userName);
        LambdaQueryWrapper<UmsVerify> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(UmsVerify::getUid,user.getId());
        queryWrapper.eq(UmsVerify::getVerifyType,umsVerify.getVerifyType());
        UmsVerify verify = umsVerifyService.getOne(queryWrapper);
        if(verify==null){//如果没有添加过认证
            umsVerify.setUid(user.getId());
            umsVerifyService.save(umsVerify);
            return ApiResult.success(umsVerify);
        }else{//添加过
            if (verify.getActive() != 1) {//待审核或者已拒绝时更新
                umsVerify.setUid(user.getId());
                umsVerify.setActive(0);
                umsVerifyService.updateById(umsVerify);
                return ApiResult.success(umsVerify);
            }
        }
        return null;

    }
    @RequestMapping(value = "/get/{verifyType}",method = RequestMethod.GET)
    public ApiResult<UmsVerify> getVerify(
            @RequestHeader(value = JwtUtil.USER_NAME ) String userName,
            @PathVariable("verifyType") String verifyType){
        UmsUser user = umsUserService.getUserByUsername(userName);
        LambdaQueryWrapper<UmsVerify> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(UmsVerify::getUid,user.getId());
        queryWrapper.eq(UmsVerify::getVerifyType,verifyType);
        UmsVerify verify = umsVerifyService.getOne(queryWrapper);
        return ApiResult.success(verify);
    }
    @RequestMapping(value = "/list/{verifyType}",method = RequestMethod.GET)
    public ApiResult<List<UmsVerify>> list(

            @RequestHeader(value = JwtUtil.USER_NAME ) String userName,
            @PathVariable("verifyType") String verifyType){

        LambdaQueryWrapper<UmsVerify> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(UmsVerify::getVerifyType,verifyType);
        List<UmsVerify> verifys = umsVerifyService.list(queryWrapper);
        return ApiResult.success(verifys);
    }

    @RequestMapping(value = "/shenhe",method = RequestMethod.POST)
    public ApiResult<String> shenhe(@RequestBody UmsVerify umsVerify){
        boolean b = umsVerifyService.updateById(umsVerify);
        if(b){
            return ApiResult.success("审核成功");
        }else{
            return ApiResult.success("审核失败");
        }

    }

}
