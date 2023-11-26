package hr.java.production.model;

import hr.java.production.auth.Auth;
import hr.java.production.exception.ExtractException;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Map;

@SuppressWarnings("ALL")

public abstract class BaseModel<T extends BaseModel> implements BaseModelInterface, Extractable {
    private ChangeHistory[] changeHistory = new ChangeHistory[0];
    private LocalDateTime createdAt;

    private LocalDateTime lastUpdatedAT;
    private Person updatedBy;
    private Person createdBy;

    public void setChangeHistory(ChangeHistory[] changeHistory) {
        this.changeHistory = changeHistory;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getLastUpdatedAT() {
        return lastUpdatedAT;
    }

    public void setLastUpdatedAT(LocalDateTime lastUpdatedAT) {
        this.lastUpdatedAT = lastUpdatedAT;
    }

    public Person getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Person updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Person getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Person createdBy) {
        this.createdBy = createdBy;
    }

    public BaseModel(Person createdBy) {
        this.createdAt = LocalDateTime.now();
        this.lastUpdatedAT = LocalDateTime.now();
        this.updatedBy = createdBy;
        this.createdBy = createdBy;
    }

    protected void addItemToChangeHistory(ChangeHistory changeItem) {
        this.lastUpdatedAT = changeItem.getChanged();
        this.updatedBy = changeItem.getChangedBy();
        ChangeHistory[] newChangeHistory = new ChangeHistory[this.changeHistory.length + 1];
        for (int i = 0; i < this.changeHistory.length; i++) {
            newChangeHistory[i] = this.changeHistory[i];
        }
        newChangeHistory[this.changeHistory.length] = changeItem;
        this.changeHistory = newChangeHistory;
    }

    /**
     *
     */
    public BaseModel() {
        this.createdBy = Auth.getInstance().getUser();
        this.createdAt = LocalDateTime.now();
        this.lastUpdatedAT = this.getCreatedAt();
        this.updatedBy = this.getUpdatedBy();
    }

    public static <T extends BaseModel> T create(Class<T> clazz, Map<String, Object> data) {
        try {
            T instance = clazz.getDeclaredConstructor().newInstance();
            for (Map.Entry<String, Object> entry : data.entrySet()) {


                if (entry.getKey().equals("name")) {
                    Method setNameMethod = instance.getClass().getDeclaredMethod("setName", String.class);
                    setNameMethod.invoke(instance, (String) entry.getValue());
                } else {
                    Field field = instance.getClass().getDeclaredField(entry.getKey());
                    field.setAccessible(true);
                    field.set(instance, entry.getValue());
                }
            }
            return instance;
        } catch (NoSuchMethodException e) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ChangeHistory[] getChangeHistory() {
        return changeHistory;
    }

    @Override
    public Object extract(String fieldName) throws ExtractException {

        try {
            Field field = this.getClass().getField(fieldName);
            field.setAccessible(true); // To access private fields if necessary
            return field.get(this);
        } catch (NoSuchFieldException | IllegalAccessException ex) {
            throw new ExtractException("Error extracting field: " + fieldName);
        }
    }
}

