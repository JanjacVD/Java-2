package hr.java.production.model;

import hr.java.production.entity.NamedEntity;
import hr.java.production.exception.DuplicateItemException;

import java.util.ArrayList;
import java.util.Map;

public class Factory extends NamedEntity {

    private Address address;
    private ArrayList<Item> items;

    public Factory() {
        super();
    }

    public Factory(String name, Address address, ArrayList<Item> items, Person created_by) {
        super(name, created_by);
        this.address = address;
        this.items = items;
    }
    public static Factory create(Map<String, Object> data){
        return BaseModel.create(Factory.class, data);
    }

    public String getName() {
        return super.getName();
    }

    public void setName(String name) {
        super.setName(name);
    }
    @Override
    public String toString() {
        return super.getName();
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) throws DuplicateItemException {
        if (items.contains(item)) {
            throw new DuplicateItemException("Artikl već odabran. Molimo odaberite drugi.");
        }
        items.add(item);
    }

}
