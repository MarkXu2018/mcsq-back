package com.mc.mcsq.model.dto;

import com.mc.mcsq.model.entity.UmsDept;
import lombok.Data;

import java.util.List;

@Data
public class UmsDeptDto extends UmsDept {
    private List<UmsDeptDto> children;
}
