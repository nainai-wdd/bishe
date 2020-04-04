package com.jcc.service;

import com.jcc.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface BookService {
    List<Book> selectBookFrom_reader_book_record(Map<String,Object> qmap);

    //查询所有
    List<Book> selectAll();
    //条件查询
    List<Book> selectBooks(Book book);

    Book selectOne(String bname);

    //查找书本章节
    List<Map<String,Object>> selectChapter(String bname);

    //查找书本作者
    String selectByAuthor(String bname);


}
