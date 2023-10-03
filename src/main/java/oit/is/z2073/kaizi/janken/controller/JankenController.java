package oit.is.z2073.kaizi.janken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Sample21Controller
 *
 * クラスの前に@Controllerをつけていると，HTTPリクエスト（GET/POSTなど）があったときに，このクラスが呼び出される
 */
@Controller
public class JankenController {

  /**
   * sample21というGETリクエストがあったら sample21()を呼び出し，sample21.htmlを返す
   */
  @GetMapping("/sample21")
  public String sample21() {
    return "sample21.html";
  }

  @GetMapping("/sample24")
  public String sample24() {
    return "sample24.html";
  }

  /**
   * パスパラメータ2つをGETで受け付ける 1つ目の変数をparam1という名前で，2つ目の変数をparam2という名前で受け取る
   * GETで受け取った2つの変数とsample22()の引数の名前が同じなため， 引数の前に @PathVariable と付けるだけで，パスパラメータの値を
   * javaで処理できるようになる ModelMapはthymeleafに渡すためのMapと呼ばれるデータ構造を持つ変数
   * Mapはkeyとvalueの組み合わせで値を保持する
   *
   * @param param1
   * @param param2
   * @param model
   * @return
   */
  @GetMapping("/sample22/{param1}/{param2}")
  public String sample22(@PathVariable String param1, @PathVariable String param2, ModelMap model) {
    int tasu = Integer.parseInt(param1);// param1が文字列なので，parseIntでint型の数値に変換する
    int tasareru = Integer.parseInt(param2);
    int tasuResult = tasu + tasareru;

    // ModelMap型変数のmodelにtasuResult1という名前の変数で，tasuResultの値を登録する．
    // ここで値を登録するとthymeleafが受け取り，htmlで処理することができるようになる
    model.addAttribute("tasuResult1", tasuResult);
    return "sample21.html";

  }

  /**
   * クエリパラメータの引数2つを受け付ける URLでの?のあとのパラメータ名とjavaメソッドの引数名は同じであることが望ましい(別にする方法は一応ある)
   * 引数をStringとして受け取ってparseIntする以外にもInteger(intのラッパークラス)クラスの変数として受け取ってそのまま加算する方法もある
   *
   * @param tasu1
   * @param tasu2
   * @param model
   * @return
   */
  @GetMapping("/sample23")
  public String sample23(@RequestParam Integer tasu1, @RequestParam Integer tasu2, ModelMap model) {
    int tasuResult = tasu1 + tasu2;
    model.addAttribute("tasuResult2", tasuResult);
    // ModelMap型変数のmodelにtasuResult2という名前の変数で，tasuResultの値を登録する．
    // ここで値を登録するとthymeleafが受け取り，htmlで処理することができるようになる
    return "sample21.html";

  }

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
   *
   * @param model
   * @return
   */
  @GetMapping("/Gu")
  public String Gu(ModelMap model) {
    String my = "Gu";
    String cpu = "Pa";
    String   ke = "結果 You Lose";
    model.addAttribute("Myte", my);
    model.addAttribute("Cpute", cpu);
    model.addAttribute("kek", ke);
    return "janken.html";
  }

  /**
   *
   * @param model
   * @return
   */
  @GetMapping("/Cho")
  public String Cho(ModelMap model) {
    String my = "Cho";
    String cpu = "Cho";
    String   ke = "結果 Drow";
    model.addAttribute("Myte", my);
    model.addAttribute("Cpute", cpu);
    model.addAttribute("kek", ke);
    return "janken.html";
  }

  /**
   *
   * @param model
   * @return
   */
  @GetMapping("/Pa")
  public String Pa(ModelMap model) {
    String my = "Pa";
    String cpu = "Cho";
    String   ke = "結果 You Win!";
    model.addAttribute("Myte", my);
    model.addAttribute("Cpute", cpu);
    model.addAttribute("kek", ke);
    return "janken.html";
  }
}
