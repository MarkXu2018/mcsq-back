package com.mc.mcsq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mc.mcsq.model.entity.Book;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookMapper extends BaseMapper<Book> {
    List<Book> selectBooksByUidAndDateRange(String uid,
                                           LocalDateTime startDate,
                                           LocalDateTime endDate);
}
