package hr.java.production.model;

import java.time.LocalDateTime;

public class ChangeHistory {

    private LocalDateTime changed;
    private Person changedBy;

    private String fieldName;

    public ChangeHistory(Person changedBy, String fieldName) {
        this.changed = LocalDateTime.now();
        this.changedBy = changedBy;
        this.fieldName = fieldName;
    }

    public LocalDateTime getChanged() {
        return changed;
    }

    public void setChanged(LocalDateTime changed) {
        this.changed = changed;
    }

    public Person getChangedBy() {
        return changedBy;
    }

    public void setChangedBy(Person changedBy) {
        this.changedBy = changedBy;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}
