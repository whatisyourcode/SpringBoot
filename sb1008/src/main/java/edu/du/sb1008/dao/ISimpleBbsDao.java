package edu.du.sb1008.dao;



import edu.du.sb1008.dto.SimpleBbsDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ISimpleBbsDao {
    @Select(" select * from simple_bbs order by id desc")
    public List<SimpleBbsDto> listDao();
    @Select("select * from simple_bbs where id = #{id}")
    public SimpleBbsDto viewDao(@Param("id") String id);
    @Insert("insert into simple_bbs(writer,title,content) values(#{param1},#{param2},#{param3})")
    public int writeDao( String writer,String title,@Param("content") String content);
    @Delete(" delete from simple_bbs where id = #{id}")
    public int deleteDao(@Param("id") String id);
    @Update("update simple_bbs set writer = #{writer}, title = #{title}, content = #{content} where id = #{id}")
    public int updateDao(@Param("id") String id,@Param("writer") String writer,@Param("title") String title,@Param("content") String content);
}