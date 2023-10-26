package hr.java.production.model;

import hr.java.production.entity.NamedEntity;

import java.util.ArrayList;
import java.util.Map;

public class Store extends NamedEntity {

    private String webAddress;
    private ArrayList<Item> items;

    public Store() {
    }

    public static Store create(Map<String, Object> data){
        return BaseModel.create(Store.class, data);
    }

    public Store(String name, String webAddress, ArrayList<Item> items) {
        super(name);
        this.webAddress = webAddress;
        this.items = items;
    }

    public String getName() {
        return super.getName();
    }
    @Override
    public String toString() {
        return super.getName();
    }

    public void setName(String name) {
        super.setName(name);
    }

    public String getWebAddress() {
        return webAddress;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
