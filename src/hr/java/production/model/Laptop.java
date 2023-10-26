package hr.java.production.model;

import java.math.BigDecimal;
import java.util.Map;

public final class Laptop extends Item implements Technical {
    private int warrantyMonths;
    public int getWarrantyMonths() {
        return this.warrantyMonths;
    }
    public Laptop() {
        super();
    }

    public Laptop(String name, Category category, Person updatedBy, Person createdBy, BigDecimal width, BigDecimal height, BigDecimal length, BigDecimal productionCost, BigDecimal sellingPrice, BigDecimal discount, int warantyMonths) {
        super(name, category, updatedBy, createdBy, width, height, length, productionCost, sellingPrice, discount);
        this.warrantyMonths = warantyMonths;
    }

    public static Laptop create(Map<String, Object> data) {
        return BaseModel.create(Laptop.class, data);
    }
}
