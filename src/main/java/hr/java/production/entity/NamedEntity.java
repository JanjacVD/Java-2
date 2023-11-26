package hr.java.production.entity;

import hr.java.production.exception.ExtractException;
import hr.java.production.model.BaseModel;
import hr.java.production.model.Person;

import java.util.Map;

public abstract class NamedEntity<T extends NamedEntity> extends BaseModel<T> {
    public String name;
    public NamedEntity() {}
    public NamedEntity(String name, Person created_by) {
        super(created_by);
        this.name = name;
    }
    public NamedEntity(String name) {
        super(null);
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
