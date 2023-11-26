package hr.java.production.model;

import hr.java.production.database.Data;
import hr.java.production.entity.NamedEntity;
import hr.java.production.exception.DuplicateItemException;

import java.util.ArrayList;
import java.util.Map;

public class Store<T extends Item> extends NamedEntity {

    private String webAddress;
    private ArrayList<T> items;

    public Store() {
    }

    public static Store create(Map<String, Object> data){
        return BaseModel.create(Store.class, data);
    }

    public Store(String name, String webAddress, ArrayList<T> items) {
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

    public ArrayList<T> getItems() {
        return (ArrayList<T>) items;
    }

    public void setItems(ArrayList<T> items) {
        this.items = items;
    }

    public void addItem(T item) throws DuplicateItemException {
        if (items.contains((T)item)) {
            throw new DuplicateItemException("Artikl već odabran. Molimo odaberite drugi.");
        }
        items.add(item);
    }



}
