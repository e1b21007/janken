package oit.is.z2073.kaizi.janken.controller;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.deser.DataFormatReaders.Match;

import oit.is.z2073.kaizi.janken.model.Entry;
import oit.is.z2073.kaizi.janken.model.Matches;
import oit.is.z2073.kaizi.janken.model.MatchInfo;
import oit.is.z2073.kaizi.janken.model.User;
import oit.is.z2073.kaizi.janken.model.UserMapper;
import oit.is.z2073.kaizi.janken.model.MatchesMapper;
import oit.is.z2073.kaizi.janken.model.MatchInfoMapper;
/**
 * Sample21Controller
 *
 * クラスの前に@Controllerをつけていると，HTTPリクエスト（GET/POSTなど）があったときに，このクラスが呼び出される
 */
@Controller
public class JankenController {


  @Autowired
  private Entry entry;
  @Autowired
  UserMapper UserMapper;
  @Autowired
  MatchesMapper MatchMapper;
  @Autowired
  MatchInfoMapper MatchInfoMapper;
  /**
   * POSTを受け付ける場合は@PostMappingを利用する /sample25へのPOSTを受け付けて，FormParamで指定された変数(input
   * name)をsample25()メソッドの引数として受け取ることができる
   *
   * @param name1
   * @param model
   * @return
   */
  @PostMapping("/Janken")
  public String Janken(@RequestParam String name1, ModelMap model) {
    //model.addAttribute("Name", name1);
    return "janken.html";
  }

    /**
   * @param prin  ログインユーザ情報が保持されるオブジェクト
   * @param model
   * @return
   */
  @GetMapping("/janken")
  public String Janken(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    //this.entry.addUser(loginUser);
    //model.addAttribute("room", this.entry);
    model.addAttribute("Name", loginUser);
    ArrayList<User> users5 = UserMapper.SelectAll();
    model.addAttribute("users5", users5);
    ArrayList<Matches> match5 = MatchMapper.SelectAllMatch();
    model.addAttribute("match5", match5);
    return "janken.html";
  }

  /**
   * @param prin
   * @param model
   * @param id
   * @return
   */
  @GetMapping("/match")
  public String match(@RequestParam Integer id, Principal prin, ModelMap model) {
    User teki;
    String loginUser = prin.getName();
    model.addAttribute("name", loginUser);
    teki = UserMapper.selectById(id);
    model.addAttribute("teki", teki);
    model.addAttribute("id", id);
    return "match.html";
  }

  /**
   * @param prin
   * @param model
   * @param id
   * @param te
   * @return
   */
  @GetMapping("/fight")
  @Transactional
  public String Gu(@RequestParam Integer id, Principal prin, ModelMap model, @RequestParam Integer te) {
//   User teki;
    String my;
//    String cpu;
//    String ke;
    boolean flag = true;
    String loginUser = prin.getName();
    MatchInfo nowmatch = new MatchInfo();
    int myid;
    int cpuid = id;
    model.addAttribute("name", loginUser);
//    teki = UserMapper.selectById(id);
//    model.addAttribute("teki", teki);
//    model.addAttribute("id", id);
    if (te == 1) {
      my = "Gu";
//      cpu = "Pa";
//      ke = "結果 You Lose";

    } else if (te == 2) {
      my = "Cho";
//      cpu = "Cho";
//      ke = "結果 引き分け";
    } else{
      my = "Pa";
//      cpu = "Cho";
//      ke = "結果 You Win";
    }
//      model.addAttribute("Myte", my);
//      model.addAttribute("Cpute", cpu);
//      model.addAttribute("kek", ke);
    //model.addAttribute("room", this.entry);(
    //model.addAttribute("Name", prin.getName());
    myid = UserMapper.selectIdByname(loginUser);
    nowmatch.setUser1(myid);
    nowmatch.setUser2(cpuid);
    nowmatch.setUser1Hand(my);
    nowmatch.setIsActive(flag);
    MatchInfoMapper.insertMatchInfo(nowmatch);
//    Matches ma = new Matches();
//    ma.setUser1(myid);
//    ma.setUser2(cpuid);
//    ma.setUser1Hand(my);
//    ma.setUser2Hand(cpu);
//    MatchMapper.insertMatch(ma);
//    return "match.html";
    return "wait.html";
  }


  /**
   *
   * @param model Thymeleafにわたすデータを保持するオブジェクト
   * @param prin  ログインユーザ情報が保持されるオブジェクト
   * @return
   */
  @GetMapping("step8")
  public String sample38(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    this.entry.addUser(loginUser);
    model.addAttribute("room", this.entry);

    return "janken.html";
  }


}
