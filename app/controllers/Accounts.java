package controllers;
 
import java.util.List;
 
import play.db.ebean.Model.Finder;
import play.mvc.Controller;
import play.mvc.Result;

import models.Account;
 
public class Accounts extends Controller {

  public static Result list() {
    // 現在のAccountを全検索して表示
    Finder<Long, Account> finder = new Finder<Long, Account>(Long.class, Account.class);
    List<Account> accounts = finder.all();

    StringBuilder msg = new StringBuilder();
    msg.append("test");
    for (Account account : accounts) {
      msg.append(account.toString()).append("\n");
    }
    return ok(msg.toString());
  }
}