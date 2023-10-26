package hr.java.production.entity;

import hr.java.production.model.BaseModel;

import java.util.Map;

public abstract class NamedEntity<T extends NamedEntity> extends BaseModel<T> {
    private String name;
    public NamedEntity() {}
    public NamedEntity(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
