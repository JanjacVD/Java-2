package hr.java.production.model;

import hr.java.production.entity.NamedEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

public class Item extends NamedEntity {
    private Category category;
    private BigDecimal width;
    private BigDecimal height;
    private BigDecimal length;
    private BigDecimal productionCost;
    private BigDecimal sellingPrice;

    private Discount discount;

    public static Item create(Map<String, Object> data) {
        return BaseModel.create(Item.class, data);
    }

    public Item() {
    }

    public Item(String name, Category category, Person updatedBy, Person createdBy, BigDecimal width, BigDecimal height, BigDecimal length, BigDecimal productionCost, BigDecimal sellingPrice, BigDecimal discount) {
        super(name);
        this.category = category;
        this.width = width;
        this.height = height;
        this.length = length;
        this.productionCost = productionCost;
        this.sellingPrice = sellingPrice;
        this.discount = new Discount(discount);
    }

    public BigDecimal calculateVolume() {
        return this.getWidth().multiply(this.getHeight().multiply(this.getLength()));
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public BigDecimal getProductionCost() {
        return productionCost;
    }

    public void setProductionCost(BigDecimal productionCost) {
        this.productionCost = productionCost;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice.multiply(this.discount.discountAmount().divide(new BigDecimal(100)));
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

}
