package book.manager.mapper;

import book.manager.entity.AuthUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from users where username = #{username}")
    AuthUser getPasswordByUsername(String username);

    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    @Insert("insert into users(username, role, password) values(#{username}, #{role}, #{password})")
    int registerUser(AuthUser user);

    @Insert("insert into student(uid, username, grade, gender) values(#{uid}, #{username}, #{grade}, #{gender})")
    int addStudentInfo(@Param("uid") int uid, @Param("username") String username, @Param("grade") String grade,  @Param("gender") String gender);

    @Select("select sid from student where uid = #{uid}")
    Integer getSidByUserId(int uid);

    @Select("select count(*) from student")
    int getStudentCount();
}
