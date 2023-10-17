package oit.is.z2073.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

  @Select("SELECT * from users where id = #{id}")
  User selectById(int id);

  @Select("SELECT id from users where username = #{name}")
  int selectIdByname(String name);

  /**
   * #{userName}などはinsertの引数にあるChamberクラスのフィールドを表しています 引数に直接String
   * userNameなどと書いてもいけるはず
   * 下記のOptionsを指定すると，insert実行時にAuto incrementされたIDの情報を取得できるようになる useGeneratedKeys
   * = true -> Keyは自動生成されることを表す keyColumn : keyになるテーブルのカラム名 keyProperty :
   * keyになるJavaクラスのフィールド名
   *
   * @param user
   */
  @Insert("INSERT INTO users (username) VALUES (#{username});")
  @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
  void insertChamber(User user);

  @Select("SELECT * from users where username = #{userName}")
  ArrayList<User> selectAllByUserName(String username);

  @Select("SELECT * from users")
  ArrayList<User> SelectAll();

}
