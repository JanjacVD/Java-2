package hr.java.production.model;

import java.math.BigDecimal;

public record Discount(BigDecimal discountAmount) implements Comparable<Discount> {
    @Override
    public int compareTo(Discount otherDiscount) {
        return this.discountAmount.compareTo(otherDiscount.discountAmount);
    }

}