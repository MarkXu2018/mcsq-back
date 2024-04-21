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
@TableName("ums_dept")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UmsDept implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "dept_id", type = IdType.AUTO)
    private Long deptId;

    @TableField("parent_id")
    private Long parentId;

    @TableField("ancestors")
    private String ancestors;

    @TableField("dept_name")
    private String deptName;

    @TableField("order_num")
    private Integer orderNum;

    @TableField("leader")
    private String leader;

    @TableField("phone")
    private String phone;

    @TableField("email")
    private String email;

    @TableField("status")
    private String status;

    @TableField("del_flag")
    private String delFlag;

    @TableField("create_by")
    private String createBy;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField("update_by")
    private String updateBy;

    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Date updateTime;
}

