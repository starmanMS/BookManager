package book.manager.mapper;

import book.manager.entity.Book;
import book.manager.entity.Borrow;
import book.manager.entity.BorrowDetails;
import org.apache.ibatis.annotations.*;

import javax.annotation.Resource;
import java.util.List;

public interface BookMapper {

    @Select("select * from book")
    List<Book> getAllBooks();

    @Delete("delete from book where bid = #{bid}")
    void deleteBook(int bid);

    @Insert("insert into book(title, description, price) values(#{title}, #{description}, #{price})")
    void addBook(@Param("title") String title, @Param("description") String description, @Param("price") double price);

    @Insert("insert into borrow(bid, sid, `time`) values(#{bid}, #{sid}, NOW())")
    void addBorrow(@Param("bid") int bid, @Param("sid") int sid);

    @Select("select * from borrow")
    List<Borrow> borrowList();

    @Select("select * from borrow where sid = #{sid}")
    List<Borrow> borrowListBySid(int sid);

    @Select("select * from book where bid = #{bid}")
    Book getBookById(int bid);

    @Delete("delete from borrow where bid = #{bid} and sid = #{sid}")
    void deleteBorrow(@Param("bid") int bid, @Param("sid") int sid);

    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "title", property = "book_title"),
            @Result(column = "username", property = "user_name"),
            @Result(column = "time", property = "time")
    })
    @Select("SELECT * FROM borrow \n" +
            "LEFT JOIN book ON book.bid = borrow.bid\n" +
            "LEFT JOIN student ON borrow.sid = student.sid")
    List<BorrowDetails> borrowDetailsList();

    @Select("select count(*) from book")
    int getBookCount();

    @Select("select count(*) from borrow")
    int getBorrowCount();

}
