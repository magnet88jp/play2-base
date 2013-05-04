package controllers;
 
import java.util.List;
 
import play.db.ebean.Model.Finder;
import play.data.Form;
import static play.data.Form.*;
import play.mvc.Controller;
import play.mvc.Result;

import models.Account;
 
public class Accounts extends Controller {

  public static Result GO_HOME = redirect(
    routes.Accounts.list(0, 0, "")
  );

//  public static Result list() {
  public static Result list(Integer page, Integer orderBy, String filter) {
    // 現在のAccountを全検索して表示
    Finder<Long, Account> finder = new Finder<Long, Account>(Long.class, Account.class);
    List<Account> accounts = finder.all();

    StringBuilder msg = new StringBuilder();
    msg.append("test");
    msg.append(filter);
//    for (Account account : accounts) {
//      msg.append(account.toString()).append("\n");
//    }
//    return ok(msg.toString());
    return ok(views.html.Account.list.render(msg.toString(), accounts));
  }

  public static Result create() {
    Form<Account> accountForm = new Form(Account.class);
    return ok(views.html.Account.createForm.render(accountForm));
  }

  public static Result save() {
//    return ok("It works!3");
    Form<Account> accountForm = form(Account.class).bindFromRequest();
    if(accountForm.hasErrors()) {
      return badRequest(views.html.Account.createForm.render(accountForm));
    }
    accountForm.get().save();
    flash("success", "Account " + accountForm.get().name + " has been created");
    return GO_HOME;
  }

}