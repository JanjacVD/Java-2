package hr.java.production.model;

import hr.java.production.enums.Priority;
import hr.java.production.exception.ExtractException;
import hr.java.production.helpers.PrintItemQueue;
import hr.java.production.helpers.PrintSupported;

import java.math.BigDecimal;

public class MobileItem extends RepairableItem implements PrintSupported {

    private int battery;
    @Override
    public String toString() {
        return super.getName() + " Health: " + super.health;
    }
    @Override
    public void setProperty(String propertyName, Object value, Person person) {
        super.setProperty(propertyName, value, person);
        super.handlePropertyChange();
    }

    public MobileItem(String name, Category category,Person createdBy, BigDecimal width, BigDecimal height, BigDecimal length, BigDecimal productionCost, BigDecimal sellingPrice, BigDecimal discount) {
        super(name, category, createdBy, width, height, length, productionCost, sellingPrice, discount);
        this.battery = 100;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        super.handlePropertyChange();
        this.battery = battery;
    }
    @Override
    public void print(Priority priority) {
        PrintItemQueue.addToQueue(this, priority);
    }


}
