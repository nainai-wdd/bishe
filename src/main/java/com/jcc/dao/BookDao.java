package com.jcc.dao;

import com.jcc.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BookDao {

    List<Map<String,Object>> selectBookFrom_reader_book_record(String rname);

    //书,条件查询
    List<Book> selectBooks(Book book);

    //查找一本
    Book selectOne(String bname);

    List<Book> selectAll();

    //查找书本章节
    List<Map<String,Object>> selectChapter(String bname);

    //查找书本的作者
    String selectByAuthor(String bname);

    //查找用户书架的书
    List<Book> selectFromLib(String rname);

    //查找用户是否度过某书并读到第几话
    Map<String,Object> isRead(Map<String,Object> requestMap);

    //查找某书第一话地址
    String selectfst(String bname);

    //查找用户书架的指定书名的书
    String selectFromLibByBname(Map<String,Object> requestMap);

    //按书名模糊查询
    List<Book> selectBooks_vague(String name);

    //按作者名查询书名
    List<Book> selectBooksByAuthor(String aname);

    //插入新章节
    void insertChapter(Map<String,Object> requestMap);

}
