package com.mc.mcsq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mc.mcsq.mapper.BookMapper;
import com.mc.mcsq.model.entity.Book;
import com.mc.mcsq.service.BookService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book>
        implements BookService {
    @Override
    public List<Book> selectBooksByUidAndDateRange(String uid, LocalDateTime startDate, LocalDateTime endDate) {

        return baseMapper.selectBooksByUidAndDateRange(uid,startDate,endDate);
    }
}
