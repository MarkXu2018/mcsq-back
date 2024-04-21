package com.mc.mcsq.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mc.mcsq.model.entity.Book;

import java.time.LocalDateTime;
import java.util.List;

public interface BookService extends IService<Book> {
    List<Book> selectBooksByUidAndDateRange(String uid,
                                            LocalDateTime startDate,
                                            LocalDateTime endDate);
}
