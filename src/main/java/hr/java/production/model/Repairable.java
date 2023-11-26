package hr.java.production.model;

import java.math.BigDecimal;

public interface Repairable {
    BigDecimal maxHelth = new BigDecimal(100);
    public void repair(Part[] parts);
    public boolean isDamaged();
}
