package com.jcc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jcc.entity.Book;
import com.jcc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    //支持查询所有
    @RequestMapping(value = "/books",method = RequestMethod.POST)
    @ResponseBody
    public String showBooks(@RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum,
                            @RequestParam(value = "book",required = false) Book book,
                          Model model){
        // 开启分页,第N页 每页查询10条数据,
        PageHelper.startPage(pageNum, 10);
        List<Book> books = bookService.selectBooks(book);
        // 将用户信息放入PageInfo对象里,并设置导航页码数量(拿来设置导航的页码数量)
        PageInfo<Book> page = new PageInfo<Book>(books, 5);
        model.addAttribute("pageInfo", page);
        return "success";
    }
    @RequestMapping("/test")
    public String test(){
        return "test";
    }

}
