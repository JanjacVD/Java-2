package hr.java.production.model;

import hr.java.production.entity.NamedEntity;

import java.util.ArrayList;

public class Person extends NamedEntity {

    private String surname;
    private String OIB;

    public Person(String name, String surname, String OIB) {
        super(name);
        this.surname = surname;
        this.OIB = OIB;
    }

    public String getName() {
        return super.getName();
    }

    public void setName(String name) {
        super.setName(name);
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getOIB() {
        return OIB;
    }

    public void setOIB(String OIB) {
        this.OIB = OIB;
    }

    public void printItemsCreatedByPerson(ArrayList<Item> items) {
        System.out.println(super.getName());
        for (int i = 0; i<items.size(); i++) {
            if(items.get(i).getCreatedBy().equals(this)){
                System.out.println(items.get(i));
            }
        }
    }
}
