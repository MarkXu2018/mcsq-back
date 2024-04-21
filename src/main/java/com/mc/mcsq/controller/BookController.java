package com.mc.mcsq.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.LocalDateTimeUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mc.mcsq.common.api.ApiResult;
import com.mc.mcsq.model.entity.Book;
import com.mc.mcsq.model.entity.UmsUser;
import com.mc.mcsq.model.vo.BookVO;
import com.mc.mcsq.service.BookService;
import com.mc.mcsq.service.IUmsUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.mc.mcsq.jwt.JwtUtil.USER_NAME;

@RestController
@RequestMapping("/book")
@Slf4j
public class BookController {
    @Resource
    BookService bookService;
    @Resource
    IUmsUserService umsUserService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ApiResult<String> addBook(
            @RequestHeader(value =USER_NAME ) String userName,
            @RequestBody Book book){
        UmsUser user = umsUserService.getUserByUsername(userName);

        LocalDateTime dateTime = LocalDateTimeUtil.of(book.getBookTime());
        LocalDateTime beginOfDay = LocalDateTimeUtil.beginOfDay(dateTime);
        LocalDateTime endOfDay = LocalDateTimeUtil.endOfDay(dateTime);
        List<Book> books = bookService.selectBooksByUidAndDateRange(user.getId(),
                beginOfDay, endOfDay);
        if(books.isEmpty()){//如果当天没有
            book.setUid(user.getId());
            bookService.save(book);
            return ApiResult.success("预约成功");
        }else{
            return ApiResult.failed("无法预约同一天两次");
        }


    }

    @RequestMapping(value = "/listme", method = RequestMethod.GET)
    public ApiResult<List<Book>> getListMe(

            @RequestHeader(value =USER_NAME ) String userName){

        UmsUser user = umsUserService.getUserByUsername(userName);
        LambdaQueryWrapper<Book> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(Book::getUid,user.getId());
        List<Book> books = bookService.list(queryWrapper);

        return ApiResult.success(books);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ApiResult<List<BookVO>> getList(){

        List<Book> books = bookService.list();
        List<BookVO> bookVOS=books.stream().map(
                book -> {
                    BookVO bookVO=new BookVO();
                    BeanUtil.copyProperties(book,bookVO);
                    UmsUser user=umsUserService.getById(book.getUid());
                    bookVO.setName(user.getUsername());
                    return bookVO;
                }
        ).collect(Collectors.toList());
        return ApiResult.success(bookVOS);
    }
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public ApiResult<String> del(@RequestBody Book book){
        boolean b = bookService.removeById(book.getId());
        if(b){
            return ApiResult.success("办结");
        }else{
            return ApiResult.failed("无法办结");
        }

    }

}
