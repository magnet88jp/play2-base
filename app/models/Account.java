package models;
 
import java.util.Date;
 
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
 
import play.db.ebean.Model;
 
import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;
import com.avaje.ebean.validation.NotNull;
 
@Entity
public class Account extends Model {
 
  @Id
  public Long id;

  @NotNull
  public String name;

  @CreatedTimestamp
  public Date createDate;

  @UpdatedTimestamp
  public Date updateDate;
//  @Version
//  public Date update_date;

//  @Version
//  public Date version;

  public String toString() {
    return "Account [id=" + id + ", name=" + name + ", createDate="
      + createDate + ", updateDate=" + updateDate + "]";
  }

  public static Finder<Long,Account> find = new Finder<Long,Account>(Long.class, Account.class); 

}