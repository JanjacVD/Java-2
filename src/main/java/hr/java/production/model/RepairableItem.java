package hr.java.production.model;

import java.math.BigDecimal;
import java.util.Random;

public abstract class RepairableItem extends Item implements Repairable {
    protected BigDecimal health;

    public RepairableItem(String name, Category category, Person createdBy, BigDecimal width, BigDecimal height, BigDecimal length, BigDecimal productionCost, BigDecimal sellingPrice, BigDecimal discount) {
        super(name, category,createdBy, width, height, length, productionCost, sellingPrice, discount);
        this.health = maxHelth;
    }

    public RepairableItem() {
        this.health = maxHelth;
    }

    void handlePropertyChange() {
        Random random = new Random();
        // Generate a random number between 1 and 10 (inclusive)
        int randomNumber = random.nextInt(10) + 1;
        BigDecimal newHp = this.health.subtract(new BigDecimal(randomNumber));
        this.health = newHp.compareTo(BigDecimal.ZERO) < 0 ? BigDecimal.ZERO : newHp;
    }

    @Override
    public void repair(Part[] parts) {
        if(!isDamaged()){
            System.out.println("Device is not damaged");
            return;
        };
        System.out.println("Repairing");
        Random random = new Random();
        int randomNumber;
        for (Part part : parts) {
            if (part.used()) {
                // Generate a random number between 1 and 10 (inclusive)
                randomNumber = random.nextInt(10) + 1;
            } else {
                randomNumber = random.nextInt(50 - 30) + 1;
            }
            this.health = this.health.add(new BigDecimal(randomNumber));
            if (this.health.compareTo(new BigDecimal(100)) > 0) {
                this.health = maxHelth;
                return;
            }
            ;
        }
    }

    @Override
    public boolean isDamaged() {
        return this.health.compareTo(new BigDecimal(50)) < 0;
    }

    @Override
    public void setProperty(String propertyName, Object value, Person person) {
        super.setProperty(propertyName, value, person);
    }
}
