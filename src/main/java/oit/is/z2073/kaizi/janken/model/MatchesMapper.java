package oit.is.z2073.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MatchesMapper {

  @Select("SELECT id,userName,from users where id = #{id}")
  Matches selectById(int id);

  /**
   * #{userName}などはinsertの引数にあるChamberクラスのフィールドを表しています 引数に直接String
   * userNameなどと書いてもいけるはず
   * 下記のOptionsを指定すると，insert実行時にAuto incrementされたIDの情報を取得できるようになる useGeneratedKeys
   * = true -> Keyは自動生成されることを表す keyColumn : keyになるテーブルのカラム名 keyProperty :
   * keyになるJavaクラスのフィールド名
   *
   * @param Match
   */
  @Insert("INSERT INTO Matches (user1, user2, user1Hand, user2Hand) VALUES (#{user1},#{user2},#{user1Hand},#{user2Hand});")
  @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
  void insertMatch(Matches Match);

  @Insert("INSERT INTO Matches (user1, user2, user1Hand, user2Hand) VALUES (#{use1},#{use2},#{use1Hand},#{use2Hand});")
  @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
  void inputMatch(int use1, int use2, String use1Hnad, String use2Hand);

  @Select("SELECT * from Matches")
  ArrayList<Matches> SelectAllMatch();

}
