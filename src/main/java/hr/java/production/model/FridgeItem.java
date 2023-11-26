package hr.java.production.model;

import hr.java.production.enums.Priority;
import hr.java.production.helpers.PrintItemQueue;
import hr.java.production.helpers.PrintSupported;

public class FridgeItem extends RepairableItem implements PrintSupported {

    @Override
    public String toString() {
        return super.getName();
    }

    @Override
    public void setProperty(String propertyName, Object value, Person person) {
        super.setProperty(propertyName, value, person);
        super.handlePropertyChange();
    }

    @Override
    public void print(Priority priority) {
        PrintItemQueue.addToQueue(this, priority);
    }
}
