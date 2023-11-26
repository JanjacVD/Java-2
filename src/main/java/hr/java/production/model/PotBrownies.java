package hr.java.production.model;

import java.math.BigDecimal;
import java.util.Map;

public class PotBrownies extends Item implements Edible {
    private static final int CALORIES_PER_KG = 826;
    private BigDecimal weight;

    public PotBrownies() {
        super();
    }

    public PotBrownies(String name, Category category, Person updatedBy, Person createdBy, BigDecimal width, BigDecimal height, BigDecimal length, BigDecimal productionCost, BigDecimal sellingPrice, BigDecimal weight, BigDecimal discount) {
        super(name, category, createdBy, width, height, length, productionCost, sellingPrice, discount);
        this.weight = weight;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal calculateKilocalories() {
        return this.weight.multiply(new BigDecimal(CALORIES_PER_KG));
    }

    public BigDecimal calculatePrice() {
        return this.weight.multiply(super.getSellingPrice());
    }

    public BigDecimal calculatePriceRatio(){
        return  this.calculatePrice().divide(this.weight);
    }
    public static WeedCookies create(Map<String, Object> data) {
        return BaseModel.create(WeedCookies.class, data);
    }
}