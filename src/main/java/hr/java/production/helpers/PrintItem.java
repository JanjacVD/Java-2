package hr.java.production.helpers;

import hr.java.production.enums.Priority;
import hr.java.production.model.Item;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PrintItem {
    private static int nextId = 10000;
    String printId;
    LocalDateTime creationDateTime;
    Item item;

    private Priority priority;

    public PrintItem(LocalDateTime creationDateTime, Item item, Priority priority) {
        this.printId = ""+nextId++;
        this.creationDateTime = creationDateTime;
        this.item = item;
        this.priority = priority;
    }
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    public String getPrintId() {
        return printId;
    }

    public void setPrintId(String printId) {
        this.printId = printId;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public Priority getPriority(){return this.priority;}
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "- Print id: "+this.printId+", Creation Datetime: " + this.creationDateTime.format(dateTimeFormatter) + ", Item: "+ this.item;
    }
}
