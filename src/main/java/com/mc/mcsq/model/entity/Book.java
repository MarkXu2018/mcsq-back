package com.mc.mcsq.model.entity;


import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@TableName("book")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @TableField("uid")
    private String uid;

    @TableField("book_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date bookTime;

    @TableField("book_subject")
    private String bookSubject;

    @TableField("phone")
    private String phone;

    @TableField("address")
    private String address;

    @TableField("community")
    private String community;
}

