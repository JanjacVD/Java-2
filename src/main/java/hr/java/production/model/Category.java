package hr.java.production.model;

import hr.java.production.entity.NamedEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Category extends NamedEntity {
    public String description;
    public Category(){
        super();
    }

    public Category(String name, String description) {
        super(name);
        this.description = description;
    }

    public String getName() {
        return super.getName();
    }
    @Override
    public String toString() {
        return super.getName();
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        super.setName(name);
    }
    public static Category create(Map<String, Object> data){
        return BaseModel.create(Category.class, data);
    }
}
