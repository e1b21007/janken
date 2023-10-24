package oit.is.z2073.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MatchInfoMapper {

  @Select("SELECT id,userName,from users where id = #{id}")
  MatchInfo selectById(int id);

  /**

   * @param Matchinfo
   */
  @Insert("INSERT INTO Matchinfo (user1, user2, user1Hand, isActive) VALUES (#{user1},#{user2},#{user1Hand},#{isActive});")
  @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
  void insertMatchInfo(MatchInfo Matchinfo);

  @Insert("INSERT INTO Matchinfo (user1, user2, user1Hand,isActive) VALUES (#{use1},#{use2},#{use1Hand},#{isActive});")
  @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
  void inputMatchInfo(int use1, int use2, String use1Hnad, Boolean isActive);

  @Select("SELECT * from MatchInfo")
  ArrayList<MatchInfo> SelectAllMatchInfo();


  @Select("SELECT * from MatchInfo where isActive = true")
  ArrayList<MatchInfo> SelecttrueMatchInfo();
}
