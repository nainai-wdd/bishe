package com.jcc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jcc.entity.Book;
import com.jcc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;



    //同步查询
    @RequestMapping("/books")
    public String showBooks(Integer pageNum, Book book, Model model){
        //预处理参数
        if (pageNum == null) pageNum = 1;
        if (book.getTag() == null || book.getTag() == "")  book.setTag(null);

        String bname = book.getBname();
        if (bname == "") book.setBname(null);
        else  if (bname != null) book.setBname("%"+bname+"%");

        // 开启分页,第N页 每页查询10条数据,
        PageHelper.startPage(pageNum, 4);
        List<Book> books = bookService.selectBooks(book);
        // 将用户信息放入PageInfo对象里,并设置导航页码数量(拿来设置导航的页码数量)
        PageInfo<Book> pageInfo = new PageInfo<Book>(books, 5);

        String bnameFinal = book.getBname();
        if (bnameFinal != null) book.setBname(bnameFinal.replaceAll("%",""));
        model.addAttribute("searchInfo",book);//存入查询信息
        model.addAttribute("pageInfo", pageInfo);//存入查询结果
        return "ajax_success";
    }

    //异步查询
    @RequestMapping("/books_ajax")
    @ResponseBody
    public PageInfo<Book> showBooks_ajax(Integer pageNum, Book book, Model model){
        //预处理参数
        if (pageNum == null) pageNum = 1;
        if (book.getTag() == null || book.getTag() == "")  book.setTag(null);

        String bname = book.getBname();
        if (bname == "") book.setBname(null);
        else  if (bname != null) book.setBname("%"+bname+"%");

        // 开启分页,第N页 每页查询10条数据,
        PageHelper.startPage(pageNum, 2);
        List<Book> books = bookService.selectBooks(book);
        // 将用户信息放入PageInfo对象里,并设置导航页码数量(拿来设置导航的页码数量)
        PageInfo<Book> page = new PageInfo<Book>(books, 5);
        return page;
    }
    @RequestMapping("/test")
    public String test(){
        return "test";
    }

}
