package hr.java.production.model;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface Edible extends BaseModelInterface{
    static final int CALORIES_PER_KG = 0;
    public BigDecimal calculateKilocalories();
    public BigDecimal calculatePrice();

    public BigDecimal calculatePriceRatio();

}
