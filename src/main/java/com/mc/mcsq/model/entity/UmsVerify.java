package com.mc.mcsq.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@TableName("ums_verify")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UmsVerify implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @TableField("uid")
    private String uid;

    @TableField("verify_type")
    private String verifyType;

    @TableField("phone")
    private String phone;

    @TableField("name")
    private String name;

    @TableField("community")
    private String community;

    @TableField("residential_area")
    private String residentialArea;

    @TableField("door_number")
    private String doorNumber;

    @TableField("organization_code")
    private String organizationCode;

    @TableField("organization_name")
    private String organizationName;

    @TableField("id_card_number")
    private String idCardNumber;

    @TableField("address")
    private String address;

    @TableField("active")
    private int active;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "modify_time", fill = FieldFill.INSERT_UPDATE)
    private Date modifyTime;
}

