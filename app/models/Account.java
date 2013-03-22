package models;
 
import java.util.Date;
 
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
 
import play.db.ebean.Model;
 
import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.validation.NotNull;
 
@Entity
public class Account extends Model {
 
    @Id
    public Long id;
 
    @NotNull
    public String name;
 
    @CreatedTimestamp
    public Date createDate;
 
    @Version
    public Date updateDate;
 
    public String toString() {
        return "Account [id=" + id + ", name=" + name + ", createDate="
                + createDate + ", updateDate=" + updateDate + "]";
    }
}