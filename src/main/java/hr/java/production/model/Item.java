package hr.java.production.model;

import hr.java.production.entity.NamedEntity;
import hr.java.production.exception.ExtractException;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

public abstract class Item extends NamedEntity {
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

    public Item(String name, Category category, Person createdBy, BigDecimal width, BigDecimal height, BigDecimal length, BigDecimal productionCost, BigDecimal sellingPrice, BigDecimal discount) {
        super(name, createdBy);
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

    public Discount getDiscount(){
        return this.discount;
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

    public void setProperty(String propertyName, Object value, Person person) {
        try {
            Field field = getClass().getDeclaredField(propertyName);
            field.setAccessible(true);
            field.set(this, value);
            super.addItemToChangeHistory(new ChangeHistory(person, propertyName));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            // unknown property or access issues
            e.printStackTrace();
        } catch (Exception e) {
            // all others
            e.printStackTrace();
        }
    }

}
