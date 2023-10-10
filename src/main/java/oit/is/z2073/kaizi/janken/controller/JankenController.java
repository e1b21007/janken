package oit.is.z2073.kaizi.janken.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z2073.kaizi.janken.model.Entry;

/**
 * Sample21Controller
 *
 * クラスの前に@Controllerをつけていると，HTTPリクエスト（GET/POSTなど）があったときに，このクラスが呼び出される
 */
@Controller
public class JankenController {


  @Autowired
  private Entry entry;
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
    model.addAttribute("Name", name1);
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
    this.entry.addUser(loginUser);
    model.addAttribute("room", this.entry);
    model.addAttribute("Name", loginUser);
    return "janken.html";
  }


  /**
   * @param prin
   * @param model
   * @return
   */
  @GetMapping("/Gu")
  public String Gu(Principal prin, ModelMap model) {
    String my = "Gu";
    String cpu = "Pa";
    String   ke = "結果 You Lose";
    model.addAttribute("Myte", my);
    model.addAttribute("Cpute", cpu);
    model.addAttribute("kek", ke);
    model.addAttribute("room", this.entry);
    model.addAttribute("Name", prin.getName());
    return "janken.html";
  }

  /**
   * @param prin
   * @param model
   * @return
   */
  @GetMapping("/Cho")
  public String Cho(Principal prin, ModelMap model) {
    String my = "Cho";
    String cpu = "Cho";
    String   ke = "結果 Drow";
    model.addAttribute("Myte", my);
    model.addAttribute("Cpute", cpu);
    model.addAttribute("kek", ke);
    model.addAttribute("room", this.entry);
    model.addAttribute("Name", prin.getName());
    return "janken.html";
  }

  /**
   * @param prin
   * @param model
   * @return
   */
  @GetMapping("/Pa")
  public String Pa(Principal prin, ModelMap model) {
    String my = "Pa";
    String cpu = "Cho";
    String ke = "結果 You Win!";
    model.addAttribute("Myte", my);
    model.addAttribute("Cpute", cpu);
    model.addAttribute("kek", ke);
    model.addAttribute("room", this.entry);
    model.addAttribute("Name", prin.getName());
    return "janken.html";
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
