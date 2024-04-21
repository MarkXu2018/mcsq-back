package com.mc.mcsq.model.vo;

import com.mc.mcsq.model.entity.Book;
import lombok.Data;

@Data
public class BookVO extends Book {
    private String name;
}
