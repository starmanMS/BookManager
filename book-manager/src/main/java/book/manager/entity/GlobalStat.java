package book.manager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class GlobalStat {
    private int userCount;
    private int bookCount;
    private int borrowCount;
}
