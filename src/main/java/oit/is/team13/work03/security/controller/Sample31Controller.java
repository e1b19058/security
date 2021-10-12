package oit.is.team13.work03.security.controller;

import oit.is.team13.work03.security.model.Room;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/sample3")
public class Sample31Controller {

  @Autowired
  private Room room;

  @GetMapping("step1")
  public String sample31() {
    return "sample31.html";
  }

  @GetMapping("step2")
  public String sample32(ModelMap model, Principal prin) {
    String loginUser = prin.getName(); // ログインユーザ情報
    model.addAttribute("login_user", loginUser);
    return "sample31.html";
  }
  @GetMapping("step3")
  public String sample33(){
    return "sample33.html";
  }
  @PostMapping("step6")
  public String sample36(@RequestParam Integer hiku1, @RequestParam Integer hiku2, ModelMap model){
    int hikukekka;
    hikukekka = hiku1-hiku2;
    model.addAttribute("hikukekka", hikukekka);
    return "sample33.html";
  }
  @GetMapping("step7")
  public String sample37(){
    return "sample37.html";
  }
  @GetMapping("step8")
  public String sample38(Principal prin, ModelMap model){
    String login_user = prin.getName();
    this.room.addUser(login_user);
    model.addAttribute("room", this.room);
    return "sample37.html";
  }

  @GetMapping("step9")
  public String sample39(Principal prin, ModelMap model){
    Room newRoom = new Room();
    String login_user = prin.getName();
    newRoom.addUser(login_user);
    model.addAttribute("new_room", newRoom);
    return "sample37.html";
  }
}
