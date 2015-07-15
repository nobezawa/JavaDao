package models.entity;

import javax.persistence.*;

import com.avaje.ebean.Model;

import java.util.Date;

/**
 * Check entity bean.
 */
@Entity
@Table(name="checks")
public class Check extends Model{

    public static final Find<Long,Check> finder = new Find<Long, Check>(){};

    @Id
    Long id;

    String name;

    String result;

    Date created;

    Date modified;

    public Check setId(Long id) {
        this.id = id;
        return this;
    }

    public Check setName(String name) {
        this.name = name;
        return this;
    }

    public Check setCreted(Date created) {
        this.created = created;
        return this;
    }

    public Check setModified(Date modified) {
        this.modified = modified;
        return this;
    }

}
