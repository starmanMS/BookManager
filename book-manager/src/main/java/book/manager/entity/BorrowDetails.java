package book.manager.entity;

import lombok.Data;
import java.util.Date;

@Data
public class BorrowDetails {
    private int id;
    private String book_title;
    private String user_name;
    private Date time;

}
